# [javaScript] 기존 jQuery의 ajax를 fetch로 바꿔 사용하기

### Before

항상 jQuery의 ajax를 사용하여 비동기 요청을 주고 받았는데 요즘에는 대부분의 브라우저에서 fetch()를 지원한다는 글을 보았습니다. 그래서 저도 기본에 사용하던 $.ajax()를 fetch를 사용하여 바꿔 보기로 하였습니다.



### $.ajax | GET 기존 코드

```
$.ajax({
			url: getContextPath() +"/restapi/member/memberList" ,
			type: 'get',
			success: function(res) {
				console.log("성공");
				console.log(res);
			},
			error: function(xhr, error, msg) {
				console.log(xhr);
				console.log(error);
				console.log(msg);
			},
			dataType: 'json'
		})
```

아주 간단한 ```get``` 방식의 메서드 입니다. ```getContextPath()```의 경우 따로 선언했습니다. 필요하신 분들은 본문 하단을 참고하시길 바랍니다.



### fetch | GET 변경 코드

```
fetch(getContextPath()+"/restapi/member/memberList", {
	method: "get",  // default값이 GET이어서 생략이 가능합니다. 
})
.then((response) => response.json())	 // response객체로부터 json포멧 응답 받기 
.then((data) => console.log(data));		// json포멧 응답 javascript 객체로 변한하기
```

응답(response) 객체로 부터 JSON 포멧의 응답 전문을 자바스크립트 객체로 변환하여 얻을 수 있습니다.



### Controller

```
@GetMapping("restapi/member/memberList")
public ResponseEntity<String> memberList(HttpServletRequest req){
   ResponseEntity result = null;

   result = ResponseEntity.status(HttpStatus.OK).body("admin");
   HashMap<String, String> saveResult = new HashMap<>();
   saveResult.put("member1", "admin");
   saveResult.put("member2", "admin");
   saveResult.put("member3", "admin");

   return new ResponseEntity(saveResult, HttpStatus.OK);
}
```

위와 같이 간단하게 map에 추가한 데이터를 ResponseEntity로 반환하였습니다.

만약 post로 요청을 원하신다면 get 방식에 몇가지만 추가해 주시면 됩니다.

### fetch | post 방식

```
fetch(getContextPath()+"/restapi/member/memberList", {
	method: "post",  // default값이 GET이어서 생략이 가능합니다. 
	headers: {
		"Content-Type": "application/json", // 보내는 데이터가 json이라 알려줍니다.
	},
	body: JSON.stringfy({	// 보내는 데이터들을 json 직렬화 하여 body에 넣어 보냅니다.
		titile: "TEST",
		body: "testing...",
        userId: 1,
	}),
})
.then((response) => response.json())	 // response객체로부터 json포멧 응답 받기 
.then((data) => console.log(data));		// json포멧 응답 javascript 객체로 변한하기
```

나머지 값을 받아오는 방법은 같습니다. 

### getContextPath()

```
const getContextPath = function () {
	let hostIndex = location.href.indexOf(location.host) + location.host.length;
	let contextPath = location.href.substring(hostIndex, location.href.indexOf('/', hostIndex + 1));
	return contextPath;
};
```



### Result

생각보다 fetch 방식이 많이 간결하여 jQuery의 ajax방식보다 자주 사용하게 될 듯 합니다.

앞으로도 javascript만을 사용하여 코드들을 작성해볼 생각입니다.



### References

https://www.daleseo.com/js-window-fetch/

- async와 await

https://joshua1988.github.io/web-development/javascript/js-async-await/#async--await%EB%8A%94-%EB%AD%94%EA%B0%80%EC%9A%94