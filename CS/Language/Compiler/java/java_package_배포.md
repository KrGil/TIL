# JitPack을 활용하여 라이브러리 생성하기(maven, gradle)



### Before we go further

> 본인만의 custom library를 가져보자!

얼마전(불과 몇시간 전) [지인](https://shanepark.tistory.com/227)분이 참고하라고 본인이 만든 라이브러리를 알려주더군요!! 그래서 저 역시 한번 해보자는 생각으로 프로젝트를 만들어 작성해 보았습니다. 

본 게시글에서는 array를 출력할 때 항상 Arrays.toString을 사용해야 함에 있어 조금 더 편하게 사용해 보고자 아래의 상황을 다루도록 하겠습니다.

#### given

```
System.out.println(Arrays.toString(arr))
```

#### goal

```
Eisen.printArray(arr);
```



### Create Project

> 아래와 같이 일반 프로젝트를 생성합니다
>
> "일반" 프로젝트 입니다. springboot를 사용하면 jitpack에서 build 시 오류가 납니다.

![image-20220130152451541](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130152451541.png)

_maven이나 gradle이나 상관없이 만드시면 됩니다._ 



생성 후 아래와 같이 java파일을 만들어 줍니다. package 생성 후 하단에 java 파일을 생성하시길 바랍니다.

![image-20220130152655058](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130152655058.png)



### Github 등록하기

> 해당 프로젝트를 다른 프로젝트에서 import 후 참조 시키는 방법 역시 존재하지만... 그렇게 사용하는것은 해당 프로젝트를 항상 local에 들고다닌다는 뜻과 같기 때문에 github을 활용하여 사용하도록 하겠습니다.

Github의 Repository 생성 및 연동에 관해서는 이곳에서 다루지 않겠습니다.(필요하다면 추후에 작성하도록 하겠습니다.)



### JitPack

>  https://jitpack.io/

위의 링크에 접속 후 아래의 이미지와 같이 본인의 repo 주소를 기입합니다.

![image-20220130140931993](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130140931993.png)

그 후 "Look up" 을 클릭하게 되면 아래와 같이 초록색 글씨로 여러 탭들이 나옵니다.

만약 아래와 같이 Releases 따로 설정하지 않으면 Branch 탭의 master-SNAPSHOT을 선택하시면 됩니다.

![image-20220130153709843](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130153709843.png)



본인의 commit에 따른 버전을 적용시키고 싶다면 ```Commit``` 에 들어가시고 원하는 commit의 ```Get it``` 버튼을 클릭하시면 됩니다.

![image-20220130141012169](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130141012169.png)

만약 build가 성공적으로 작동된다면 아래와 같이 초록색 문서 아이콘이 생겨나고 실패한다면 붉은색 문서 아이콘이 생성됩니다. 이때 _SNAPSHOT_의 경우 따로 아이콘이 생겨나지 않습니다.

![image-20220130154055111](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130154055111.png)



### 주의

****__<u>JItPack은 jdk 8만 지원하니 이점 참고 바랍니다.</u>__****

jdk가 8이 아니라면 jitpack의 maven이 jdk를 찾지 못합니다.

_저는 jdk11로 시도를 했다 아래와 같은 오류를 받았습니다_

![image-20220130154329498](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130154329498.png)

jdk가 다른 버전이라면 아래와 같이 pom.xml을 수정해 주시면 됩니다.

```
<properties>
    <java.version>8</java.version>
    <maven.compiler.source>8</maven.compiler.source>
    <maven.compiler.target>8</maven.compiler.target>
</properties>
```



### 적용방법

#### gradle

![image-20220130141039279](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130141039279.png)



```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```xml
	dependencies {
	        implementation 'com.github.KrGil:eisenUtils:master-SNAPSHOT'
	}
```



#### maven

![image-20220130141145371](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130141145371.png)



```markup
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

```markup
<dependency>
	    <groupId>com.github.KrGil</groupId>
	    <artifactId>eisenUtils</artifactId>
	    <version>master-SNAPSHOT</version>
	</dependency>
```

### 실제 적용시키기

> 저는 gradle 프로젝트에 한번 적용시켜 보았습니다.
>
> 위의 방법을 통해 repositories, dependencies를 추가해 주고 코끼리아이콘을 눌러 rebuild를 시켜 주었습니다.

![image-20220130141515375](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130141515375.png)

#### 함수 사용하기

아래와 같이 잘 나오는 것을 확인할 수 있습니다.

![image-20220130150037679](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/java_package_%EB%B0%B0%ED%8F%AC.assets/image-20220130150037679.png)

긴 글 읽으시느라 고생 많으셨습니다. 위의 방법을 알려준 [지인](https://shanepark.tistory.com/227)에게 감사의 말을 전합니다.

혹시 모르는 방법이나 궁금한 사항이 있다면 아래 댓글 달아주시면 할 수 있는 한 도와드리도록 하겠습니다. 

앞으로도 본인의 입맛에 맞는 library를 작성하여 편하게 사용하실 수 있기 ㄹ바ㄹ

### References

https://shanepark.tistory.com/227

