

# [intellij] Intellij Tomcat 설정하기

> 이번 이직으로 10년 이상 고도화가 이루어지지 않고 지속되어 오고 있던 프로그램 유지보수를 맡게 되었습니다.
>
> 사용하던 IDE 툴도 eclipse hellios 버전으로 2010년도에 release 되던 버전이더군요. 그래서 intellij로 바꿔서 사용 해보려고 합니다.
>
> 예전에도 한번 했던것 같습니다만 intellij 버전이 올라가면서 톰캣 설정하는 방법들이 조금씩 바뀌는 듯 합니다. 이번에 환경을 세팅하는 과정을 포스팅 해보도록 하겠습니다.



## Application Servers 설정

- `settings` -> `Build, Execution, Deployment` -> `Application Servers` 에서 `tomcat server`를 추가해 줍니다.

![image-20221213170529805](https://raw.githubusercontent.com/KrGil/TIL/c21b74ea5717f2ccc7d4e105b08f6365fefc2267/CS/IDETools/Intellij/Intellij_tomcat.assets/image-20221213170529805.png)

- 아래와 같이 받은 tomcat 폴더 경로를 설정해 줍니다.

![image-20221213164021911](https://raw.githubusercontent.com/KrGil/TIL/c21b74ea5717f2ccc7d4e105b08f6365fefc2267/CS/IDETools/Intellij/Intellij_tomcat.assets/image-20221213164021911.png)

- 그럼 아래의 이미지와 같이 server가 잡히게 됩니다.

![image-20221213163825521](https://raw.githubusercontent.com/KrGil/TIL/c21b74ea5717f2ccc7d4e105b08f6365fefc2267/CS/IDETools/Intellij/Intellij_tomcat.assets/image-20221213163825521.png)



## Run/Debug Configurations 설정

> shift 두번 클릭 후 `edit configuration`을 타입하면 들어가실 수 있습니다.
>
> 혹은 상단에 망치(build) 옆에서 들어가실 수 있습니다.



- `configurations`에 들어간 후 `+` 버튼 클릭 -> Tomcat Server의 Local을 클릭해 줍니다.	

![image-20221213171503806](https://raw.githubusercontent.com/KrGil/TIL/c21b74ea5717f2ccc7d4e105b08f6365fefc2267/CS/IDETools/Intellij/Intellij_tomcat.assets/image-20221213171503806.png)



- 이후 아래이미지와 같이 기본적인 tomcat이 설정되는 것을 볼 수 있습니다.
- 이때 주의해야할 점이 이미지 하단을 보시면 Warning 이 뜨는 것을 볼 수 있습니다. `fix` 버튼을 눌러 봅니다.

![image-20221213164812107](https://raw.githubusercontent.com/KrGil/TIL/c21b74ea5717f2ccc7d4e105b08f6365fefc2267/CS/IDETools/Intellij/Intellij_tomcat.assets/image-20221213164812107.png)

- `fix` 버튼을 클릭하게 되면 아래와 같은 이미지가 나타나게 됩니다.  `+`를 눌러 Artifact를 추가해 줍니다.

![image-20221213164923493](https://raw.githubusercontent.com/KrGil/TIL/c21b74ea5717f2ccc7d4e105b08f6365fefc2267/CS/IDETools/Intellij/Intellij_tomcat.assets/image-20221213164923493.png)



## 기타

### class build skip 후 배포하기

- class가 build 되지 않아도 배포할 수 있게끔  설정하는 법은 아래와 같이 Build, no error check를 클릭하게 되면 자동으로 넘어가게 됩니다.
- 저 같은 경우 운영환경에서만 import 되는 라이브러리가 존재해 아래와 같은 설정을 해주고 배포를 했습니다. 
- 혹시 비슷한 경우가 있다면 아래와 같은 방법을 활용하시면 됩니다.

![image-20221213171732260](https://raw.githubusercontent.com/KrGil/TIL/c21b74ea5717f2ccc7d4e105b08f6365fefc2267/CS/IDETools/Intellij/Intellij_tomcat.assets/image-20221213171732260.png)

### context path 설정하기

- `configure` 에서 `Deployment` 에 들어가게 되시면 이미지의 하단에 Application context를 설정하는 란이 있습니다. 이 값을 변경해 주시면 원하는 context path가 설정됩니다.

![image-20221213171649052](https://raw.githubusercontent.com/KrGil/TIL/c21b74ea5717f2ccc7d4e105b08f6365fefc2267/CS/IDETools/Intellij/Intellij_tomcat.assets/image-20221213171649052.png)







![image-20221213164955957](https://raw.githubusercontent.com/KrGil/TIL/c21b74ea5717f2ccc7d4e105b08f6365fefc2267/CS/IDETools/Intellij/Intellij_tomcat.assets/image-20221213164955957.png)





### Error

- 만약 tomcat 10 버전을 사용하시게 되면 아래와 같은 오류가 나오는 것을 볼 수 있습니다.

```log
java.lang.NoClassDefFoundError: javax/servlet/ServletContextListener
```



- stackoverflow 에서 두가지의 해결책을 제시해 주고 있습니다.

> https://stackoverflow.com/questions/66711660/tomcat-10-x-throws-java-lang-noclassdeffounderror-on-javax-servlet
>
> 1. Downgrade Tomcat to version 9.x. This is the latest available version which still uses the `javax.*` package.
> 2. Or, upgrade the deployed web application to target Jakarta EE 9 instead. I.e. adjust the project's dependencies (e.g. `pom.xml`) to reference JEE 9+ based versions instead, and perform a project-wide Find & Replace of `javax.*` to `jakarta.*` (of course except for `javax.naming.*` and `javax.xml.*` and probably a few others, but the Java compiler will quickly point out them for you).

- 저는 10버전을 고집할 이유가 없어 8.5 버전으로 다운그래드 해서 사용했습니다만 만약 10버전을 써야할 이유가 있다면 위의 2번 방법을 시도해 보시면 되겠습니다.



긴 글 읽느라 고생 많으셨습니다. 감사합니다.



### References

https://jackpang.tistory.com/105