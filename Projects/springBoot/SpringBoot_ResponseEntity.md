# SpringBoot_ajax_ResponseEntity 사용 시 sussecc가 아니라 error로 return될 때

### ajax

```
$.ajax({
   url: path ,
   type: 'get',
   contentType: "application/json",
   data: {
   },
   success: function(data) {
      resultData = data;
      alert("성공");
   },
   error: function(xhr, error, msg) {
      console.log(xhr);
      console.log(error);
      console.log(msg);
   },
   dataType: 'json'
})
```



### RestController

```
@GetMapping()
public ResponseEntity<String> sample(HttpServletRequest req){
   return new ResponseEntity("admin", HttpStatus.OK);
}
```

ajax 요청 시 httpStatus.OK로 200은 뜨는데 계속 alert창이 뜨지 않고 error로 parseError가 계속 떴습니다.

조금 생각 해 보니 당연한 결과였습니다. 이유는 json으로 값을 받기로 했는데 정작 넘겨주었던 값은 body의 String 하나였기 때문입니다. _**참고 : json은 ```key```와 ```value```로 이루어져 잇습니다.**_



### Solution

해결 방법은 두가지 입니다.

1. ajax의 ```dataType: 'json'```을 삭제합니다. 그렇게 된다면 body에 json이 아닌 String이기 때문에 parseError를 발생시키지 않습니다.
2. RestController의 ResponseEntity의 body부분을 ```key``` ```value```의 값으로 바꿔 return 합니다.

```
@GetMapping()
public ResponseEntity<String> sample(HttpServletRequest req){
	//   return new ResponseEntity("admin", HttpStatus.OK);
	
	HashMap<String, String> saveResult = new HashMap<>();
	saveResult.put("userId", "admin");
	return new ResponseEntity(saveResult, HttpStatus.OK);
}
```

저는 ```HashMap<String, String>```을 활용하여 값을 return 해 주었습니다.

```HashMap``` 뿐만 아니라 객체를  return해도 동일한 결과를 얻을 수 있습니다.



### Result

>  json은 ```key```와 ```value```로 이루어져 있다는 사실.





### References

https://owin2828.github.io/devlog/2019/12/30/spring-16.html

- ObjectMapper 로 json변환

https://juwonkim.tistory.com/m/161?category=848128



