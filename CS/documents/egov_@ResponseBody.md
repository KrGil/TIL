# Egov(전자정부프레임)에서 ajax로 data 요청하기

### Before we go

현재 egov 전자정부 프레임 워크 프로젝트를 진행중에 있습니다. 그러다 ajax로 data를 요청하여 값을 받기로 했는데 @ResponseBody를 주어 request를 보내면 String을 제외한 나머지 data들은 500error, 404error를 내보내더군요.

그래서 저처럼 삽질하지 말고 egov에서 보통 @ResponseBody  대신 사용하는 방법에 대해 간략하게 알아보려고 합니다.



### Egov(jsonView)

결과적으로 egov에서 지원하는 data return 방식은 type을 String으로 통일하고 return 값을 "jsonView"로 작성하면 ajax의 success에서 값을 성공적으로 받게 됩니다.

#### Controller

```
@Controller
@RequestMapping("/test")
public class testController(){
	...
	
	@GetMapping(value = "/test.do")
	public String testList(ModelMap model){
		model.addAttribute("test", "123");
		return "jsonView"
	}
}
```

#### javascript

```
$.ajax({
	url : "/test/test.do"
	success : function(data){
		console.log(data);
	} 
})
```



###  Spring

#### Controller

```
@Controller
// @RestController --> 사용하면 @ResponseBody가 자동으로 붙는것과 같은 효과를 가집니다.
@RequestMapping("/test")
public class testController(){
	...
	// return ResponseEntity<?>
	@ResponseBody
	@GetMapping(value = "/test.do")
	public ResponseEntity<List<Test>> testList(){
		List<Test> testList = service.findAll();
		return new ResponseEntity(testList, HttpStatus.OK);
	}
	
	// return Map<?,?>
	@ResponseBody
	@GetMapping(value = "/test.do")
	public Map<String, Object> testList(){
		List<Test> testList = service.findAll();
		Map<String, Object> result = new HashMap<>();
        result.put("testList", testList)
		return result;
	}
}
```

보시는바와 같이 기존의 Spring으로 데이터를 요청하는 방법과 Egov에서 data를 요청하는 방법에 차이가 있습니다.

만약 본인이 다른 프로젝트 중간에 들어가게 된다면 위의 사항을 확인해 보시길 바랍니다.(한참을 헤맸네요.)

jsonView는 ```dispatcher-servlet.xml``` 에  아래와 같이 설정할 수 있습니다.

```
<bean class="org.springframework.web.servlet.view.BeanNameViewResolver"> 
	<property name="order" value="0"/> 
</bean> 
<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"> 
	<property name="contentType" value="application/json;charset=UTF-8"> </property> 
</bean>
```



### Reference

- jsonView

https://needjarvis.tistory.com/591







