# [IntelliJ] class 생성 시 자동 주석 달기(Comment template)

> 이직 + MacBook의 구입으로 모든 설정들을 다시 해 주고 있습니다. 기본 설정들에 추가적인 기능들을 설정했었나 봅니다. 보니 예전에 설정했던 방법들이 생각나지 않아 이번에는 하나씩 정리하면서 해나갈 생각입니다.

## Preference

> `Command + ,` 로 설정창으로 들어갑니다.
>
> 그 후 `Editor` -> `File and Code Templates` 의 `class`를 확인합니다.



![image-20220213145932012](https://raw.githubusercontent.com/KrGil/TIL/6fc32d8966f2057bb377ad396b0ae24695de1cdf/CS/IDETools/Intellij/Comment_Template.assets/image-20220213145932012.png)

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
public class ${NAME} {
}
```

`#parse()` 부분의 `File Header.java`의 파일에 수정을 해주면 파일 생성 시 Custom_Comment를 남길 수 있습니다.

아래 이미지와 같이 comment를 기입한 후 `apply`를 눌러줍니다.

![image-20220213150852614](https://raw.githubusercontent.com/KrGil/TIL/6fc32d8966f2057bb377ad396b0ae24695de1cdf/CS/IDETools/Intellij/Comment_Template.assets/image-20220213150852614.png)

```
/**
 * packageName :  ${PACKAGE_NAME}
 * fileName : ${NAME}
 * author :  ${USER}
 * date : ${DATE} 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * ${DATE}                ${USER}             최초 생성
 */
```



아래와 같이 잘 출력되는것을 확인할 수 있습니다.

![image-20220213151946115](https://raw.githubusercontent.com/KrGil/TIL/6fc32d8966f2057bb377ad396b0ae24695de1cdf/CS/IDETools/Intellij/Comment_Template.assets/image-20220213151946115.png)





### Method Comment

Method 주석의 경우 `javaDoc`이라는 plugin을 활용하여 작성할 수 있습니다.

[Method Comment 설정에 대해 궁금하시다면 여기 링크를 잠고해 주세요](https://ifuwanna.tistory.com/312)



### References

https://ifuwanna.tistory.com/312

