# 2021.06.21 [FullCalendar] 적용시키기

# Goal : FullCalendar 완성하기

---

> 기존 issueList select문에 labelVO 함께 검색하는 query 추가하기

```jsx
<resultMap type="best.gaia.vo.IssueVO" id="issueMap" autoMapping="true">
		<id property="issue_sid" column="ISSUE_SID"/>
		<association property="label" javaType="best.gaia.vo.LabelVO" autoMapping="false">
			<id property="label_no" column="LABEL_NO"/>
			<id property="label_nm" column="LABEL_NM"/>
			<id property="label_icon" column="LABEL_ICON"/>
			<id property="label_color" column="LABEL_COLOR"/>
		</association>
	</resultMap>
	<select id="selectIssuesByProj_no" parameterType="int" resultMap="issueMap">
		SELECT  ISSUE_SID, ISSUE_NO, MEM_NO, ISSUE.LABEL_NO
			, MILEST_SID, ISSUE.PROJ_NO, ISSUE_TITLE, ISSUE_CREATE_DATE
			, ISSUE_START_DATE, ISSUE_END_DATE, ISSUE_STATUS
			, ISSUE_PRIORITY, PROGRESS
			, LABEL.PROJ_NO, LABEL_NM, LABEL_ICON, LABEL_COLOR
		FROM ISSUE
			LEFT OUTER JOIN LABEL ON (ISSUE.LABEL_NO = LABEL.LABEL_NO)
		WHERE ISSUE.PROJ_NO = ${proj_no}
	</select>
```

> junit 으로 수정한 xml 점검하기

```jsx
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:webapp/WEB-INF/spring/*-context.xml")
@WebAppConfiguration
public class CalendarDaoTest {
	private static final Logger logger = LoggerFactory.getLogger(ChatServiceImplTest.class);
	@Inject
	CalendarDao dao;
	
	@Inject
	CalendarService service;
	@Inject
	WebApplicationContext container;

	@Test
	public void testSelectIssuesByProj_no() {
		service.selectMilestoneIssuesByProj_no(1);
	}
}
```

> Fullcalendar 페이지에서 날짜 변경(드래깅) 이벤트 발생안하는 현상

```jsx
{
 title: 'All Day Event',
 start: formTime,
 end: '2021-09-10'
}
```

- start 혹은 end Date format을 "2021-09-10"에 맞춰서 넣어주니 해결.
- let currentTime = new Date(); 로 받아온 날짜 데이터를 바로 쓰면 끝날에 드래깅 이벤트가 발생하지 않음.
- momentJs를 사용해서 Dateform을 맞춰서 해결.

```jsx
let formTime = moment(currentTime).format('YYYY-MM-DD')
```

> issue or milestone (open/close/all) 상태에 따라 클릭 이벤트 주기

```jsx
{
  status : status,
	title: name.milest_title,
	start: name.milest_start_date
}
```

1.  해당 상태를 알 수 있어야 하기 때문에 각 태그들에 status라는 데이터를 넘김.

![2021%2006%2021%20%5BFullCalendar%5D%20%E1%84%8C%E1%85%A5%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC%E1%84%89%E1%85%B5%E1%84%8F%E1%85%B5%E1%84%80%E1%85%B5%203ed8cde921264bea89ce913bcd24e7b2/Untitled.png](2021%2006%2021%20%5BFullCalendar%5D%20%E1%84%8C%E1%85%A5%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC%E1%84%89%E1%85%B5%E1%84%8F%E1%85%B5%E1%84%80%E1%85%B5%203ed8cde921264bea89ce913bcd24e7b2/Untitled.png)

- 아래의 extendedProps에 status가 데이터가 담김.(all은 값을 넘겨주지 않기 때문에 undefined)

```jsx
eventClick: function(arg) {
		console.log(arg)
		if(arg.event.status == 0){
	        if (confirm('Are you sure you want to close this event?')) {
	          arg.event.remove()
	        }
		}
},
```

> SweetAlert2 적용 시키기

```jsx
const closeOrOpenAlert = function(arg, isShowAll){
	let status = "CLOSE";
	arg.event.extendedProps.status == 0 ? status : status="OPEN"; 
	  
	swalWithBootstrapButtons = Swal.mixin({
		customClass: {
			confirmButton: 'btn btn-success',
			cancelButton: 'btn btn-danger'
		},
		buttonsStyling: false
	})
	swalWithBootstrapButtons.fire({
		title: status,
		text: "해당 "+ arg.event.extendedProps.menu + "를 "+status+" 하시겠습니까?",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonText: '네',
		cancelButtonText: '아니오',
		reverseButtons: false
	}).then((result) => {
		if (result.isConfirmed) {
			// update
			
			// false면 값이존재한다.  true는 undefined
			CheckNullUndefined(isShowAll) ?  null : arg.event.remove();
			swal.success();
		}
	})
}
```

도중에 update function이 들어갈 수 있게끔.

```jsx
eventClick: function(arg, status) {
		console.log(arg)
		if(arg.event.extendedProps.status == 0){
			closeOrOpenAlert(arg);
		}else if(arg.event.extendedProps.status == 1){
			closeOrOpenAlert(arg);
		}
		// status 가 공백이면 (모두 보여주기)
		if(CheckNullUndefined(isShowAll)){
			if(arg.event.extendedProps.status == 0){
        		closeOrOpenAlert(arg, status);
			}else if(ar.event.extendedProps.status == 1){
				if (confirm('Are you sure you want to open this event?')) {
				// todo update
				}
			}
		}
},
```

- 이슈와 마일스톤에는  close와 open 의 상태가 존재.
- view 페이지에서 closed, open, all 버튼이 존재.
- 클릭 시 해당 상태의 것들만 표시
- 이 상태를 isShowAll param으로 넘김.
- isShowAll이 undefined 거나 null일 경우 닫거나 지워도 view페이지에서 사라지면 안됨.
- open만 보고 있는 페이지 일 시 close 시키면 viewPage에서 사라져야함.

> RestController에  PUT으로 넘겨주기.

```jsx
$.ajax({
		url : getContextPath()+"/restapi/project/calendar",
		method : "post",
		data : {
			"_method" : "put",
			"need" : menu,
			"sid" : sid,
			"status" : status
		},
		success : function(res) {
			console.log(res);
		},
		async : false
		, error : function(xhr, error, msg) {
			ajaxError(xhr, error, msg)
		},
		dataType : 'json'
	})
```

- method : "post"로 넘기고 data의 _method : "put"으로 넘겨야 함.
- mehtod: "put", data의 _method:"put" 둘다 put으로 넘기면 controller에서 requestParam으로 value를 받아오지 못함.

> 상단에 open, closed, all 버튼 생성하기

```jsx
customButtons: {
	    openBtn: {
	      text: 'open',
	      click: function() 
			// 값이 변경 했을 경우만 ajax 호출 변경하지 않을 경우 기존의 결과로출력(퍼포먼스)
			isChanged ? issueMilestoneInfoForCalendar(1) : reCal(res, 1);
	      }
	    },
	    closedBtn: {
	      text: 'closed',
	      click: function() {
			isChanged ? issueMilestoneInfoForCalendar(0) : reCal(res, 0);
	      }
	    },
	    allBtn: {
	      text: 'all',
	      click: function() {
	        isChanged ? issueMilestoneInfoForCalendar() : reCal(res, );
	      }
	    }
	  },
```

![2021%2006%2021%20%5BFullCalendar%5D%20%E1%84%8C%E1%85%A5%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC%E1%84%89%E1%85%B5%E1%84%8F%E1%85%B5%E1%84%80%E1%85%B5%203ed8cde921264bea89ce913bcd24e7b2/Untitled%201.png](2021%2006%2021%20%5BFullCalendar%5D%20%E1%84%8C%E1%85%A5%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%BC%E1%84%89%E1%85%B5%E1%84%8F%E1%85%B5%E1%84%80%E1%85%B5%203ed8cde921264bea89ce913bcd24e7b2/Untitled%201.png)

- 각각의 버튼에 이벤트 걸기( 값 변경  시에만 ajax를 새로 불러오기)

```jsx
headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'openBtn,closedBtn,allBtn dayGridMonth,timeGridWeek,timeGridDay'
      },
```

위치도 상단, 하단, 우측, 좌측 등 설정 가능.

> 값 변경 시 db에 업데이트 시키기

```jsx
// update
const updateStatus = function(arg, toBeStatus, isChangeDate){
	console.log(arg);
	let data = {};
	data["_method"] = "put";
	data["need"] =  arg.event.extendedProps.menu.toLowerCase();
	data["sid"] = arg.event.extendedProps.sid;
	CheckNullUndefined(isChangeDate) ?  
			(data["status"]=toBeStatus) : (data["isChangeDate"]=isChangeDate, dateCal(arg));
	
	console.log(data)
	$.ajax({
		url : getContextPath()+"/restapi/project/calendar",
		method : "post",
		data : data,
		success : function(res) {
			console.log(res);
		},
		async : false
		, error : function(xhr, error, msg) {
			ajaxError(xhr, error, msg)
		},
		dataType : 'json'
	})
}
```

- open /  close 는 현재 구현 완료.

```jsx
@PutMapping
	public int updateStatus(
			@RequestParam(required=false) String need
			, @RequestParam Map<String, Object> dataMap
			){
		int result = 0;
		logger.info("Put in");
		logger.info("need : {}", need);
		logger.info("dataMap : {}", dataMap);
		if("yes".equals(dataMap.get("isChangeDate"))) {
			result = 3;
		}else {
			if("issue".equals(need)) {
				result = dao.updateIssueStatus(dataMap);
			}else if("milestone".equals(need)) {
				result = dao.updateMilestoneStatus(dataMap);
			}
		}
		return result;
	}
```

> 기존 dao에 label 검색하는 abstract 생성하기.

- serviceimpl에 dao .labeList 추가(transaction)

> 일정 변경(Drop & Drag) 시 날짜 받아오기

```jsx
eventDrop: function (arg) {
		isChanged = true;
		updateStatus(arg,null, "yes");
		toastr.success('Update에 성공했습니다.')
},
eventResize: function (arg) {
		isChanged = true;
		console.log(arg.endDelta);
		toastr.success('Update에 성공했습니다.')
}

```

# Summary

---

1. '2021-09-10' 로 찍어주지 않으면 resizeEvent가 작동하지 않는다.
2. ajax로 put 방식으로 요청할 시 data를 옮기고 싶다면 method='post'로, _method="put"으로 지정.
3. customBtn을 생성하고 위치선정 어느정도 임의로 할 수 있다.
4. 일정 변경 시 eventDrop, eventResize로 해당 이벤트 발생 시 값들을 가지고 올 수 있다.
5. data["_method"] = "put"; 리스트에 맵 형식으로 값을 담는 방법.

# Tomorrow

---

> calendar 페이지에서 일정 변경 시 비동기로 update 시켜주기.

- db 연동(query 확인하기.)
- 날짜계산하는 function 구현하기