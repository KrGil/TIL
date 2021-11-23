# [JPA] jpa 프로젝트 생성 시 유의사항



### intro

> 인프런의 김영한님의 강의를 듣는 중 정리하면서 체크해야할 부분들이 많아 따로 강의 과정 중 필요한 부분들을 정리해 보기로 했습니다.
>
> 잘못된 부분이나 보충할 부분이 있다면 언제든지 댓글로 남겨주시면 최대한 빨리 반영하도록 하겠습니다.



## project 생성하기

> dependency 설정
>
> - hibernate의 어떤 버전을 사용해야할까? 
> - h2 버전은?

###  hibernate 버전 설정

프로젝트를 생성한 후 hibernate의 버전을 설정하려면 본인이 사용하고 있는 spirngBoot의 버전을 알고 있어야 합니다.

![image-20211123084046329](/home/eisen/Documents/GitHub/TIL/Projects/jpa-basic/create-jpa-project.assets/image-20211123084046329.png)

spring.io -> Projects -> 해당하는 버전의 Reference Doc. 를 클릭하여 해당 버전의 document를 확인해 봅니다.

 그 후 __*a single HTML page*__를 클릭해서 한페이지로 본 후 ```org.hibernate``` 를 검색합니다. 

![image-20211123084346371](/home/eisen/Documents/GitHub/TIL/Projects/jpa-basic/create-jpa-project.assets/image-20211123084346371.png)

hibernate-entitymanager의 org.hibernate의 버전을 보면 5.6.1.Final까지 지원한다고 나와 있습니다.

> ### F.1. Managed Dependency Coordinates
>
> The following table provides details of all of the dependency versions that are provided by Spring Boot in its CLI (Command Line Interface), Maven dependency management, and Gradle plugin. When you declare a dependency on one of these artifacts without declaring a version, the version listed in the table is used.

[spring.io](https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/) 사이트에서 적혀있는 말을 가져왔습니다. 만약 버전을 명시하지 않으면 해당 SpringBoot 버전을 사용하면 위의 버전을 자동으로 설정한다고 나와 있습니다.

그러니 버전을 설정할 때 위의 방식과 같이 본인에게 맞는 버전을  검색해 보시길 바랍니다.



### h2 버전 확인하기

> 인강에 따르면 h2의 defendency 버전 설정의 경우 본인이 받은 버전과 같지 않을 경우 오류가 자주 발생한다고 합니다. 그러니 본인이 설치한 h2 버전과 defendency에서 설정할 버전을 똑같이 설정해 주겠습니다.

#### 설치한 h2 버전 확인하기

로컬에서 h2에 접속 한 후 아래의 ```sql```을 실행시킵니다.

```
SELECT H2VERSION() FROM DUAL
```

![image-20211123085129275](/home/eisen/Documents/GitHub/TIL/Projects/jpa-basic/create-jpa-project.assets/image-20211123085129275.png)

위의 이미지와 같이 h2 버전을 return합니다.



### Result

#### defendency 설정 버전

- hibernate 버전은 spring에 따라 맞춰서 사용하면 됩니다.
  - 버전을 명시하지 않을 시 사용하는 spring 버전에 따라 자동으로 설정됩니다.
- h2의 버전은 현재 설치되어있는 버전을 설정하는 편이 오류가 날 확률이 낮습니다.



### References

- 김영한님 강의

https://www.inflearn.com/users/@yh

- spring.io(Springboot 2.6.0) Reference Doc. 

https://docs.spring.io/spring-boot/docs/2.6.0/reference/htmlsingle/

- h2 명령어

https://www.stichlberger.com/software/get-h2-database-version-string/