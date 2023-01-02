# [Maven] http repositories blocking 해결

> maven 3.8.1 버전이 나오면서 http 에 대한 외부 연결을 막는 설정이 default로 변경되었습니다.
>
> https://maven.apache.org/docs/3.8.1/release-notes.html
>
> 이로 인해 폐쇄망에서 특정 모듈을 nexus에 모아 사용할 경우 생기는 문제를 다뤄 보겠습니다.



### Problem

> 프로젝트 배포를 위해 ```mvn clean package``` 명령 실행 시 maven이 http uri를 block하기에 내부망에 존재하는 http에 접속할 수 없어 ```failed to collect dependencies ... [maven-default-http-blocker]...``` 라는 error 뱉으며 build에 실패하게 됩니다.  
>
> 이를 해결하기 위해 해당 http repository의 내부망에 ssl 인증서를 등록하여 https 로 변경시켜 주는 방법과 maven의 settings.xml을 수정하여 http를 무력화 시키는 방법이 있습니다. 여기에선 두번째 방법인 settings.xml을 수정하는 방법에 대해 알아보도록 하겠습니다.

#### pom.xml

```
<repositories>
		<repository>
			<id>project public</id>
			<url>http://host/nexus/.../</url>
			<releases>
				<enabled>true</enabled>
			</releases>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>project thirdparty</id>
			<url>http://host/nexus/content/repositories/thirdparty/</url>
			<releases>
				<enabled>true</enabled>
			</releases>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
	</repositories>
```

####  error

>  Failed to read artifact descriptor for egovframework.rte:egovframework.rte.ptl.mvc:jar:3.8.0: Could not transfer artifact egovframework.rte:egovframework.rte.ptl.mvc:pom:3.8.0 from/to maven-default-http-blocker (http://0.0.0.0/): Blocked mirror for repositories: [project public (http://host/nexus/content/groups/public/, default, releases+snapshots), project thirdparty (http://host/nexus/content/repositories/thirdparty/, default, releases+snapshots)]

### Solution

https://stackoverflow.com/questions/67001968/how-to-disable-maven-blocking-external-http-repositores

위의 링크에 나와있듯 ```${maven.home}/conf/settings.xml``` 혹은 ```${user.home}/.m2/settings.xml``` 파일을 수정해 줍니다.

저는 ```C:\data\apache-maven-3.8.4\conf``` 여기에 있는 ```settings.xml```파일을 수정해 주었습니다.

1. ```settings.xml``` 파일을 엽니다.

파일을 열고 ```<mirror>```를 검색하면 아래와 같이 ```maven-default-http-blocker``` 설정을 볼 수 있습니다.

```
...
<mirror>
  <id>maven-default-http-blocker</id>
  <mirrorOf>external:http:*</mirrorOf>
  <name>Pseudo repository to mirror external repositories initially using HTTP.</name>
  <url>http://0.0.0.0/</url>
</mirror>
...
```

2. ```maven-default-http-blocker``` 부분을 주석처리 혹은 삭제 후 저장합니다.

```
...
<!-- <mirror>
  <id>maven-default-http-blocker</id>
  <mirrorOf>external:http:*</mirrorOf>
  <name>Pseudo repository to mirror external repositories initially using HTTP.</name>
  <url>http://0.0.0.0/</url>
</mirror> -->
...
```

3. ``` mvn clean package ``` 명령어를 실행시켜 줍니다.

```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  37.416 s
[INFO] Finished at: 2021-12-17T11:13:13+09:00
[INFO] ------------------------------------------------------------------------
```

위와 같이 build가 성공하는 것을 볼 수 있습니다.



### try

위에 설명드린 maven의 settings.xml 파일 수정의 경우 본인의 local 컴퓨터에서밖에 build가 되지 않습니다. 따라서 다른 분들의 요청이 있을 경우 그 컴퓨터의 maven의 settings.xml 파일을 수정해야하는 번거로움이 있습니다. 아래의 링크에서는 이에 해당하는 해결방법을 제시해 놓았습니다.

https://stackoverflow.com/questions/67001968/how-to-disable-maven-blocking-external-http-repositores

위의 링크에 나와있듯 프로젝트 내에 ```.mvn``` 폴더 생성, 폴더 내에 ```local-settings.xml``` 파일 설정 후 실행을 시도해 보았지만 저는 성공하지 못했습니다. maven이 프로젝트 내의 local-settings.xml 파일을 읽지 못하는 것으로 보입니다. 만약 성공하신다면 댓글로 알려주세요!



### References

- 해결방법

https://stackoverflow.com/questions/67001968/how-to-disable-maven-blocking-external-http-repositores

- github의 maven 3.8.1 버전에 http repo block 시키는 code 추가되는 commit 

https://github.com/apache/maven/commit/907d53ad3264718f66ff15e1363d76b07dd0c05f

- maven 내부용 리포 만들고 설정하기

https://javacan.tistory.com/entry/%EA%B8%B0%EC%96%B5%EC%9A%A9-Maven-%EC%A4%91%EC%95%99-%EB%A6%AC%ED%8F%AC%EC%A7%80%ED%86%A0%EB%A6%AC-%EB%A7%8C%EB%93%A4%EA%B3%A0-Maven-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0