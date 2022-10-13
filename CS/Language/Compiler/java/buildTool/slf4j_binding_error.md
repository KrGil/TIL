# Class path contains multiple SLF4J bindings. 해결

> 예전 jitpack을 이용하여 간단한 eisenUtils 라이브러리를 생성했었습니다. 지금도 종종 사용하고 있는데 내부에 출력을 System.out.println()으로 되어 있더군요. 해서 해당 로직을 Logger를 사용도록 변경했었습니다만...
>
> 이때부터 slf4j 관련 바인딩 문제가 계속 뜨더군요. 이에 이걸 해결했던 과정에 대해 글을 작성하면서 관련 지식들을 잊어버리지 않도록 작성해 봅니다.

*jitpack이 궁금하시다면 [JitPack을 활용하여 라이브러리 생성하기(maven, gradle)](https://jjam89.tistory.com/216) 아티클을 참고해 주세요!*

## Error

```log
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:{Path}/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-simple/1.7.36/a41f9cfe6faafb2eb83a1c7dd2d0dfd844e2a936/slf4j-simple-1.7.36.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:{Path}/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-classic/1.2.11/4741689214e9d1e8408b206506cbe76d1c6a7d60/logback-classic-1.2.11.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.impl.SimpleLoggerFactory]
[main] INFO com.Eisen.daily.leetCode.easy.NumberOfGoodPairs_1512Test - 123
[main] INFO org.hibernate.validator.internal.util.Version - HV000001: Hibernate Validator 6.2.4.Final
```

![image-20221013104758144](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\buildTool\slf4j_binding_error.assets\image-20221013104758144.png)

위와 같은 에러가 발생했습니다. ~~위의 에러 메시지만 보고 `org.slf4j/slf4j-simple` 혹은 `ch.qos.logback/logback-classic`둘 중 하나를 삭제하면 해결될 줄 알았습니다만... 해결되지 않았습니다 ㅠ~~

그다음 이러한 에러의 원인이 되는 코드를 보여드리겠습니다.

## Source

### daily(적용하는 project) code

```java
@Test
@DisplayName("테스트")
void test(){
    int[] testData = {1, 2, 3, 1, 1, 3};
    logMeasuredExecutionTime(e -> test.numIdenticalPairs(e), testData); // 정상 작동
    Eisen.logMeasuredExecutionTime(e -> test.numIdenticalPairs(e), testData); // multibinding을 유발하는 code
}

public static <T> void logMeasuredExecutionTime(Consumer<T> func, T request) {
    long startTime = System.currentTimeMillis();

    // ...

    System.out.println(String.format("실행시간 => %d mes", elapsedTime));
}
```

위의 코드 `Eisen.logMeasuredExecutionTime(e -> test.numIdenticalPairs(e), testData); `와 같이 외부의 Eisen 라이브러리를 호출 했을 시 `SLF4J: Class path contains multiple SLF4J bindings.`  메시지가 출력된 것을 확인 할 수 있습니다. 

호출한 외부 라이브러리를 확인해 보겠습니다.

### eisenUtils(외부 라이브러리)

![image-20221013105431492](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\buildTool\slf4j_binding_error.assets\image-20221013105431492.png)

위와 같이 `eisenUitls`의 dependency를 들어가 보면 slf4j-simple이 추가되어 있습니다.

## Solution

![image-20221013105627475](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\buildTool\slf4j_binding_error.assets\image-20221013105627475.png)

실제 사용하고 있는 프로젝트의 `build.gradle`에서 불러오고있는 eisenUtils에서 `slf4j-simple`을 제외시켜 주었습니다(comment 처리한 부분입니다.).

```groovy
implementation ('com.github.KrGil:eisenUtils:master-SNAPSHOT') {
    exclude group: 'org.slf4j', module: 'slf4j-simple'
}
```



## Cause

```
SLF4J: Class path contains multiple SLF4J bindings.
```

위의 경고 메시지로 한가지 사실을 알 수 있습니다. 

> `org.slf4j/slf4j-simple`와  `ch.qos.logback/logback-classic` 가 함께 쓰여서 SLF4J가 무엇을 사용할지 못 정하고 있다.

... 하지만 저는 `ch.qos.logback/logback-classic`를 어디서 사용하고 있는지를 모르겠더군요.

또한 `eisenUtils` 라이브러리의 `depedency`에 추가된 `slf4j-simple`의 버전은 출력메시지와는 다르게 `2.0.0` 입니다.

정확히 오류메시지와 같다면 `org.slf4j/slf4j-simple`와  `ch.qos.logback/logback-classic` 둘 중 하나를 지웠으면 해결해져야 할 듯 합니다.(사실 여기서 둘 중 하나도 지워보고 삽질이란 삽질을 다 해보았습니다...)

결국 해당 오류는 `SLF4J`가 여러개 사용(다른버전)으로 인해 발생한 듯 합니다.



혹여나 저와 비슷한 오류가 생긴다면 혹시 외부 라이브러리에 다른 버전의 slf4j를 사용하고 있는지도 함께 생각해 보시는것이 좋을 듯 합니다. 

혹여 잘못된 부분이 있다면 언제든지 알려주시면 수정하도록 하겠습니다. 긴 글 읽어 주셔서 감사합니다.



### References

https://tomgregory.com/how-to-exclude-gradle-dependencies/