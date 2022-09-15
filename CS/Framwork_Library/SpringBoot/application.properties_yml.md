# [Spring Boot] application.properties vs application.yml

 

>  이번에 토이 프로젝트 한개를 만들어보기 위해 오랜만에 개인적으로 프로젝트를 생성해 보았습니다.
>
> 평소에도 많이 생각했지만 SI에서 기능개발위주만 하다 보니 확실히 이런 부분에서 아주 취약하다는 사실을 다시 발견했습니다.
>
> 새로움 프로젝트를 아예 생성할 일이 없다보니 처음부터 막혀서 버벅거리는 절 발견했습니다.
>
> 어찌보면 가장 기초적인 부분을 잘 하지 못하는 절 보고 조금씩 정리해야겠다고 깨달았습니다. 프로젝트를 처음 생성했을 때 만드는 application.properties 파일에 관련해서 다시 리마인드 하며 정리해 보겠습니다.

## application.properties

우선 처음 프로젝트를 생성하게 되면 `.properties` 파일이 생성되는것을 확인할 수 있습니다.

`.properties` 파일은 `key-value` 형식의 파일로 Spring Boot의 속성을 정의할 수 있습니다.

```a
spring.datasource.url=jdbc:h2:dev
spring.datasource.username=SA
spring.datasource.password=password
```

위와 같이 `key-value` 형식으로 구현할 수 있습니다.

### 1. Placeholders

```
app.name=MyApp
app.description=${app.name} is a Spring Boot application
```

 위와 같이 `${}`를 사용하여  `app.name` 을  사용할 수 있습니다.



### 2.  List

```
application.servers[0].ip=127.0.0.1
application.servers[0].path=/path1
application.servers[1].ip=127.0.0.2
application.servers[1].path=/path2
application.servers[2].ip=127.0.0.3
application.servers[2].path=/path3
```

 만약 같은 `properties` 에 각기 다른 값들을 설정해야 한다면 위와 같은 List 형식으로 사용할 수 있습니다.



### 3. Multiple Profiles

```
logging.file.name=myapplication.log
bael.property=defaultValue
#---
spring.config.activate.on-profile=dev
spring.datasource.password=password
spring.datasource.url=jdbc:h2:dev
spring.datasource.username=SA
bael.property=devValue
#---
spring.config.activate.on-profile=prod
spring.datasource.password=password
spring.datasource.url=jdbc:h2:prod
spring.datasource.username=prodUser
bael.property=prodValue
```

위와 같이 하나의 `.properties` 파일에 `#---`을 사용하여 여러 개의 document로 구분하여 사용할 수 있습니다.

해당 기능은 `Spring Boot 2.4.0` 부터 지원하니 이전 버전에서는 아쉽게도 사용하실 수 없습니다.



##  YAML

`YAML`은 계층적 구성 데이터를 지정하기 위한 편리한 포맷입니다.

여기서부터는 위의 `.properties` 와 비교하면서 작성해 보도록 하겠습니다.

```
spring:
    datasource:
        password: password
        url: jdbc:h2:dev
        username: SA
```

`.properties`와 다르게 중복적인 구조를 일일이 기입하지 않고 계층적으로 기입하면 되어 개인적으로 가독성이 뛰어나다고 생각합니다.

### 1. List

```
application:
    servers:
    -   ip: '127.0.0.1'
        path: '/path1'
    -   ip: '127.0.0.2'
        path: '/path2'
    -   ip: '127.0.0.3'
        path: '/path3'
```

List 역시`.properties`와는 다르게 `-` 하나로 하나의 `properties`에 각기 다른 값들을 주어 훨씬 보기 편하게 구현할 수 있습니다.



### 2. Multiple Profiles

 ```
 logging:
   file:
     name: myapplication.log
 ---
 spring:
   config:
     activate:
       on-profile: staging
   datasource:
     password: 'password'
     url: jdbc:h2:staging
     username: SA
 bael:
   property: stagingValue
 ```

`YAML` 파일은 설계에 따라 다중 문서 파일을 지원합니다. 따라서 `Spring Boot` 버전과는 상관없이 하나의 파일에 여러 프로필을 저장할 수 있습니다.

하지만 위와 같이 `-`이 세개인 `---`을 사용하여 새 문서의 시작을 표기해야 합니다.

이렇게 `.properties`와 `YAML` 파일의 차이점을 한번 살펴 보았습니다. 아래에는 구성한 파일을 `Spring Boot`에서 어떻게 접근하는지 살펴보겠습니다.



## Spring Boot

> 이후의 `Spring Boot` 에서 설정파일을 활용하는 부분의 설명을 위해
>
> 아래와 같이 `.properties` 혹은 `YAML` 을 설정했다고 하겠습니다.

```
unicorn.google=https:/google.com
unicorn.toss=https://toss.im
unicorn.coupang=https://www.coupang.com
```



### 1. Value Annotation

```java
@Value("${unicorn.toss}")
private String injectedTossUrl;
```

`@Value(${key.something})` annotation을 사용하여  unicorn.toss`속성의 값(https://toss.im)을 주입받을 수 있습니다.



### 2. Environment Abstraction

```java
@Autowired
private Environment env;

public String getGoogleUrl(){
    return env.getProperty("unicorn.google");
}
```

`Envirionment` API를 통해 속성 값을 얻을 수 있습니다.



### 3. ConfigurationProperties Annotation

```java
@ConfigurationProperties(prefix = "unicorn")
public class ConfigProperties {
    String coupang;
    String toss;
    String google;
...
```

위와 같이 `@ConfigurationProperties` annotation을 사용하여 해당 값들을 binding 할 수 있습니다.



긴 글 읽느라 고생하셨습니다. 감사합니다.



### References

https://www.baeldung.com/spring-boot-yaml-vs-properties

https://primetime.tistory.com/entry/Spring-Boot-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-applicationyml%ED%8C%8C%EC%9D%BC-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0-yml-VS-properties

https://recordsoflife.tistory.com/434

https://programmer93.tistory.com/47