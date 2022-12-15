# [Intellij] Tomcat 한글 깨짐

> intellij에서 tomcat을 활용하여 서버를 켜는 작업을 하는 중에 tomcat의 한글이 깨지는 현상이 발생하였습니다. 이를 해결하기 위해 IDE(eclipse, intellij)의 내부 설정을 변경해 보았지만 query 문을 출력하는 부분의 한글이 깨지는 현상을 발견했습니다. 이를 해결하는 과정을 정리해 보았습니다.

## Problem 

아래 이미지와 같이 query 부분에서 한글이 깨지는 현상을 발견했습니다. 이를 해결하기 위해 3가지 파일들을 수정하였습니다. (우선 IDE의 Encoding 설정부터 확인 후 이를 따라해 보시는것을 추천드립니다.)

![image-20221215135410519](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\tomcat_korean.assets\image-20221215135410519.png)



## Solution

> intellij에서는 eclipse와 달리 원본 tomcat을 바라보기 때문에 원본을 수정해 주셔야 합니다.

### 1. server.xml

`../apache-tomcat-8.5.78/conf/server.xml`

![image-20221215140016094](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\tomcat_korean.assets\image-20221215140016094.png)

```xml
URIEncoding="UTF-8"
```

tomcat의 conf 폴더(`tomcat/conf`) 안에서 server.xml 파일내에서 `Connector` 부분(line 69)에 `URIEncoding="UTF-8"` 을 추가해 줍니다.



### 2. logging.properties

`../apache-tomcat-8.5.78/conf/logging.properties`

![image-20221215135716970](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\tomcat_korean.assets\image-20221215135716970.png)

```java
EUC-KR
```

1번과 같이 `tomcat/conf` 폴더에서 `logging.properties` 파일의 encoding 부분(line 28) 을 `UTF-8` -> `EUC-KR`로 변경해 줍니다.



### 3. catalina.bat

`../apache-tomcat-8.5.78/bin/catalina.bat`

![image-20221215141411472](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\tomcat_korean.assets\image-20221215141411472.png)

```java
set JAVA_OPTS=%JAVA_OPTS% %LOGGING_MANAGER% "-Dfile.encoding=utf-8"
```



위의 세단계 과정을 다 거친 후 tomcat을 재실행 시켜 보면 아래와 같이 한글이 잘 출력되는 것을 볼 수 있습니다.

![image-20221215141742957](C:\Users\admin\Documents\GitHub\TIL\CS\IDETools\Intellij\tomcat_korean.assets\image-20221215141742957.png)



감사합니다.



### references

https://inpa.tistory.com/entry/TOMCAT-%F0%9F%90%B1-%ED%86%B0%EC%BA%A3-%EB%A1%9C%EA%B7%B8-%ED%95%9C%EA%B8%80-%EA%B9%A8%EC%A7%90-%ED%95%B4%EA%B2%B0-%EB%B0%A9%EB%B2%95