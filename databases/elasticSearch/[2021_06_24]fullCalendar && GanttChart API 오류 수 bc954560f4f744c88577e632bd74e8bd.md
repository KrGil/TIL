# [2021_06_24]fullCalendar && GanttChart API 오류 수정 및 ElasticSearch를 이용한 통합검색 연결하기.

# preview

---

> GanttChart API 적용하기.

- 데이터 불러올 때 원하는 방식으로 불러오지 않고 각자 null milestone을 새로 생성해서 하위로 받아옴.

![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/Untitled.png?raw=true)

> why?

- 본인은 mac을 사용.
- slack에서 보내준 코드를 그대로 복사해서 붙여넣었음.
- ‘ 와  ' 게 다르게 생긴듯이 서로 다른 문자임.
- mybatis에서 제대로 인식을 못함.
- 지우고 직접 작성하니 잘 됨.
- json 관련 사이트

[https://www.json.org/json-en.html](https://www.json.org/json-en.html)

# fullCalendar 오류 수정

---

> Milestone 이동 시  update 오류

- update 시 dao 객체 잘못 불러옴.
- ganttchart 에 start date만 줄 수 있음.  isStart 데이터를 집어넣어서 기준점을 잡고 후처리

```jsx
self_status: name.milest_status,
borderColor: "#d83737",
title: name.milest_title,
start: name.milest_end_date,
isStart : 0,

```

> Milestone close 시 하나만 remove되는 현상 수정

```jsx
id : name.milest_sid
```

- id를 추가해서 close 시 해당 id를 가지고 있는 milestone 도 같이 닫게함.
- calendar 객체를 param으로 넘겨서 처리

```jsx
if(!CheckNullUndefined(isShowAll)){
	for(i=0; i<2; i++){
		calendar.getEventById(arg.event.id).remove()
	}
}
```

- 추후 리펙토링 할 예정.

# jsGantt 오류 수정

---

> 오류 현상.

![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/Untitled.png?raw=true)

실제 화면
![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/Untitled1.png?raw=true)


- 이렇게 동일한 이슈들이(담당자들만 다름) 다 따로따로 잡혀서 출력됨.

> 오류해결

### why?

---

<**resultMap** type="best.gaia.vo.MilestoneVO" id="milestoneMap" autoMapping="true">

<**id** column="MILEST_SID" property="milest_sid"/>

- mybatis에서 공통으로 들어갈 녀석인지 판단하는 기준이 milest_sid로 잡아놓았음.
- 그런데 milest_sid가 null이어서 null이면 null끼리 묶을 줄 알았는데
- null은 null임. 그래서 기준을 잡지 못하고 따로따로 만들어 주는 것.

### solve

---

```jsx
NVL(D.MILEST_SID, 0)
```

nvl을 사용하여 임의로 sid 를 0 으로 지정해 줌.

> 또다른 오류.

- 쿼리문은 nvl 덕분에 잘 해결됨.
![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/Untitled2.png?raw=true)


![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/Untitled3.png?raw=true)

- view에서 제대로 출력이 안됨.
- js를 수정해야함.

> view에서 출력 이상하게 나는 현상 해결

- milestone과 issue들의 id 때문에 발생하는 현상인듯 함.
- milest_sid와 issue_sid가 겹칠 경우가 발생. 그래서 상위 하위 계층 구조가 깨져버린 듯함.
- 각각의 each문에 mile_cnt, issue_cnt를 따로따로 주고
- issue_cnt의 첫 값은 milestoneList.length로 줌.

![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/Untitled4.png?raw=true)

# 통합검색(elasticSearch)를 위한 검색 ui 생성하기

---

> 상단의 검색창 생성 및 크기 조절. input tag에 fucus 갈 시 modal 띄우기.

```jsx
<div class="header-left header-left-custom">
			<div class="input-group icons">
				<div class="input-group-prepend">
					<span class="input-group-text bg-transparent border-0 pr-2 pr-sm-3"
						id="basic-addon1"><i class="mdi mdi-magnify"></i></span>
				</div>
				<input type="search" class="form-control dropdown-toggle total-search" placeholder="Search"
					aria-label="Search Dashboard" id="dropdownMenuSearchInput"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onkeyup="">
				<div class="dropdown">
				  <div class="dropdown-menu total-search-dropdown" aria-labelledby="dropdownMenuSearchInput">
				    <a class="dropdown-item" href="#">Action</a>
				    <a class="dropdown-item" href="#">Another action</a>
				    <a class="dropdown-item" href="#">Something else here</a>
				  </div>
				</div>
			</div>
		</div>
```

- css가 덕지덕지 붙어있음.
![alt text](https://github.com/KrGil/TIL/blob/main/elasticSearch/2021_06_24/Untitled5.png?raw=true)


> input 태그에 글 작성 시 검색 결과 비동기로 쏴주기

- on input과 keyup 이벤트의 차이를 검색.
- on input은 input태그의 내용이 변경하면 실행됨(eg. ctrl을 눌렀을 때는 변동이 없음)
- keyUp은 무슨 키를 누르건 작동.
- on input 을 사용해 보려했지만 먹히지 않아서 keyup을 사용

```jsx
$(function(){
	$('body').on("keyup", "#dropdownMenuSearchInput",function(e){
		console.log($(this).val())
	})
});
```

- ajax로 넘겨주기만 하면 됨.

> ElasticSearch에서 특정 데이터 받아오기.

[https://www.elastic.co/guide/en/elasticsearch/client/java-rest/master/java-rest-high-search.html](https://www.elastic.co/guide/en/elasticsearch/client/java-rest/master/java-rest-high-search.html)

```jsx
public List<Map<String,Object>> totalSearch(
			Map<String,Object> query
			, Map<String,SortOrder> sort
			, Integer size
			){
		/*
		 * search API 참고 주소
		 * https://www.elastic.co/guide/en/elasticsearch/client/java-rest/master/java-rest-high-search.html
		 */
		
		// search에 index 조건 걸기
		SearchRequest searchRequest = new SearchRequest();
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		
		// query에 있는 셋 쿼리 조건으로 걸기
			searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		
		// sort 에 있는 셋을 정렬 조건으로 걸기
		for(String key : sort.keySet()) {
			searchSourceBuilder.sort(new FieldSortBuilder(key).order(sort.get(key)));
		}
		
		if(size != null) {
			searchSourceBuilder.size(size);
		}else {
			searchSourceBuilder.size(20);
		}
		
		searchRequest.source(searchSourceBuilder);
		
		List<Map<String,Object>> list = new ArrayList<>();
		try(RestHighLevelClient client = new RestHighLevelClient(restClientBuilder)) {
			SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
			SearchHits searchHits = response.getHits();
			for(SearchHit hit : searchHits) {
				Map<String, Object> sourceMap = hit.getSourceAsMap();
				list.add(sourceMap);
			}
		} catch (IOException e) {}
		
		return list;
		
	}
```

- 전체 목록은 받아오는데... 전체 목록에서 특정 쿼리만 받아오게 하고싶음.
- 쿼리 하나만을 파라미터로 받는 메소드를 아직 찾지 못함.

# SUMMARY

---

1. 역시 하나의 페이지가 끝나면 반드시 타인의 점검이 필요하다.
2. 많은 예외를 고려하고 프로그래밍을 해도 결국엔 오류가 존재한다.
3. 시간에 쫓기니 코드가 점점 개판이 되어간다.
4. 추후 시간날때마다 코드 리팩토링을 진행해야할 듯 하다.
5. 점점 코드 보는 눈과 실력이 조금씩 상승하는 듯 한 기분이 든다.
6. 좀 더 코드를 깔끔하게 짤 수 있게 다양한 시도를 해 보아야 할 것 같다.
7. 좀 더 발전하고 싶다.

# TOMORROW

---

1. CHATTING 점검
2. GanttChart 점검
3. Calendar 점검
4. 통합검색 구현
5. 시나리오 토의
6. 더 수정 사항 있는지 확인.