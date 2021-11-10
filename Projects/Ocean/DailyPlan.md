# Todo

eclipse 데이터 흐름 파악(jsp파일 위치 및 경로 확인)

​	선박검사 -> 검사신청서 -> 통합 선박검사(controller 데이터 흐름 확인.)





### 정리해야할 것

- 연산자
- 프로그램
- ++
- +=
- 추상화
- 객체는 클래스의 한 종류이다.
- 접근제어자
- java의 @, 생성자란?
- egov에서 service를 사용하려면 egovAbstractService를 extends해서 사용해야한다.
- extends의 경우 public과 protected만 가지고 온다.
- static = 클래스 공유 연산자.
- class와 object. class = 여러가지 변수와 메서드 들 정의 집합. object 구체화한것.
- Class.method() 의 Class의 경우 Singletone class일 확률이 높다.
- 변수의 정의는 선언으로 메모리를 할당해 달라는 것을 의미한다.
- 초기화 : 최초의 값을 할당해 주는 것을 이야기한다(실행, invoke)
- Submit의 경우 form 태그 내의 name attribute가 존재하는 태그들의 값들을 전송한다.(특히 input)
- SVN - team -> Syncronize.
- tomcat - time Out 늘려주기, publishing Automatically publish when resources change 체크
- jsp의 경우 server 변수와 client 변수가 따로 존재한다.
- view -> jsp -> jstl
- Ctrl + Shift + R => 파일 검색
- Ctrl + h =>  url 검색
- document.ready() 페이지가 모두 load 된 후 Dom이 Ready로 해당 메서드 호출.
- webApp - web-inf -  보안과 관련된 코드들을 넣는다.
- Spring, dispatcher 설정
- 등록되어 있는 bean들 보기 spring tool, show beans?
- model and view
- 





### 흐름도

​	선박검사 -> 검사신청서 -> 통합 선박검사(controller 데이터 흐름 확인.) -> 검색 버튼 시



Class : ShiSarSeaShiInspctController.java(extends KomsaAbstractController) -> 

Method : ("shiSarSeaShiInspctPage.do") shiSarSeaShiInspctListPage(@RequestParam HashMap<String, Object> param, ModelMap model) -> 





### 참고

#### EgovPropertyService

EgovPropertyService -> /komsa_in/src/main/resources/egovframework/spring/context-properties.xml -> properties -> globa.properties, komsa_in_cmn.properties의 properties를 모두 가지고 옴.

위와 같이 @resource 혹은 생성자로 DI된 클래스 혹은 메서드 들은 context-common.xml 혹은 poperties.xml 등과 같은 파일들에 bean으로 직접 등록시켜 놓았음.



#### RequestContextHolder

RequestContextHolder의 setAttributes()는 login.do와 ssoLogin.do에서 사용.

/komsa_in/src/main/java/kr/or/komsa/cmn/com/service/impl/CmnComLoginServiceImpl.java

login 시 mapper에 있는 selectOfficeInfo부터 시작해서 insert, update 등을 실행시키고, KomsaUserVO와 여타 다른 값들을 받아 온 후 HashMap<> result 에 추가한 후 Map<>으로 return.



### Structure

Controller - web / Controller

Mapper - service / Mapper -> interface만 존재.

Service - service / Service -> Interface, ServiceImpl이 함께 존재

​	bean에 등록할 때는(@Resource) interface를 등록한다.(구현해 놓은 녀석들을 사용할 수 있다.)











---

sql - 연산 순서 정리 ( oracle, mysql)  벤더란?

