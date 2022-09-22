# [Junit] private Method 테스트하기2(Exception 검증)



> 얼마전 Junit 중 privateMethod를 테스트 하는 중에 실패했을 경우에 대해 test를 하려다 의도한 대로 풀리지 않아 해당 테스트를 진행하지 못하고 있었습니다.
>
> 그러던 중 `토비의 spring` 책에서 해당 관련된 exception 확인하는 방법을 찾았습니다.ㅎㅎ 생각보다 쉬운 방법이었지만 그때 당시에는 떠오르지 않더군요!ㅎㅎ(분명 해당 exception 내부를 확인하면 될것 같았지만 그 내부를 확인하는 방법을 몰라서 못했었었네요ㅠㅠ) 그래서 관련된 해결법을 작성해 보도록 하겠습니다.

## Before we go further

이 글은 `private method`를 `junit`으로 `Exception `테스트를 어떻게 하는지에 관해 작성되었습니다.

만약 `private method`를 `junit`으로 어떻게 테스트 할 것인지에 대한 글은 [[JUnit] private Method 테스트하기!](https://jjam89.tistory.com/247) 를 참고해 주세요!

> [JUnit] private Method 테스트하기!
>
> https://jjam89.tistory.com/247

## 코드

```java
package com.Eisen.daily.testCoding;

import java.util.Optional;

public class PrivateMethodClass {

    ServiceObj serviceObj;

    public PrivateMethodClass(ServiceObj serviceObj){
        this.serviceObj = serviceObj;
    }

    private EntityObj convertToEntity(DTOObj dto){
        Optional.ofNullable(serviceObj.someObject(3)).orElseThrow(() -> new IllegalArgumentException());
        System.out.println("entity = " + serviceObj.someObject(3));
        return new EntityObj();
    }

    public class ServiceObj{
        public String someObject(Integer num){
            System.out.println("num = " + num);
            return "hello World!";
        }
    }
    public class EntityObj{

    }
    public class DTOObj {

    }
}
```

위와 같이 예시 코드를 작성해 보았습니다. 보통 클래스의 경우 이너클래스로 생성하지 않지만 해당 여기서는 간단한 테스트를 위해 위와 같이 `Inner Class`로 적성해 보았습니다.



## 검증

이제 `private method`인 `convertToEntity()` 메서드를 Junit으로 테스트 해 보겠습니다.

```java
    private EntityObj convertToEntity(DTOObj dto){
        Optional.ofNullable(serviceObj.someObject(3)).orElseThrow(() -> new IllegalArgumentException());
        System.out.println("entity = " + serviceObj.someObject(3));
        return new EntityObj();
    }
```

내용에서 보는 것처럼 `serviceObj.someObject(3)`가 `null`이거나 빈 값이라면 `IllegalArgumentException`을 던지도록 해 놓았습니다.



## jUnit 코드

```java
package com.Eisen.daily.testCoding;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@Slf4j
@ExtendWith(MockitoExtension.class)
class JunitTestTest {

    @InjectMocks
    private PrivateMethodClass junitTest;

    @Mock
    private PrivateMethodClass.ServiceObj service;

    @Mock
    private PrivateMethodClass.EntityObj entity;

    @Mock
    private PrivateMethodClass.DTOObj dto;

    @Test
    @DisplayName("private Method 실패 검증")
    public void convertFailTest() throws Exception{
        /* Reflection */
        Method target = PrivateMethodClass.class.getDeclaredMethod("convertToEntity", PrivateMethodClass.DTOObj.class);
        target.setAccessible(true);

        //given
        BDDMockito.given(service.someObject(Mockito.anyInt())).willReturn(null);

        //when
        try{
            target.invoke(junitTest, dto);
        }catch(InvocationTargetException e){
            log.debug("InvcationException {}", e);
            Assertions.assertEquals(IllegalArgumentException.class, e.getTargetException().getClass());
        }
        Assertions.assertThrows(InvocationTargetException.class, () -> target.invoke(junitTest, dto));

    }
}
```

이번 테스트는 `serviceObj.someObject(3)` 가 만약 `null`을 return 했을 시 `IllegalArgumentException`을 제대로 던지는지 확인해 보는 테스트 입니다.



저번에는 딱 여기까지 작성하고 더이상 진행을 못했었는데요, 

```java
Assertions.assertThrows(InvocationTargetException.class, () -> target.invoke(junitTest, dto));
```

![KakaoTalk_20220922_130648110](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\Junit\JunitTest_privateMethod_Exception.assets\KakaoTalk_20220922_130648110.jpg)

위의 이미지는 지인이 몇일 전에 보내주었던 `토비의 Spring` 의 한 페이지 입니다. 바로 `getTargetException()`을 사용하는 것인데요

`try catch`로 감싼 후 해당 매서드를 사용하면 `InvocationTargetException`으로 감싸져 있는 `IllegalArgumentException` 을 조회하여 비교 할 수 있습니다.

```java
try{
    target.invoke(junitTest, dto);
}catch(InvocationTargetException e){
    Assertions.assertEquals(IllegalArgumentException.class, e.getTargetException().getClass());
}
```

위와 같이  `assertEquals()`를 사용하여 확인할 수 있습니다.

다만 `Exception`은  `getTargetException()` 메서드를 가지고 있지 않으니 유의해 주시길 바랍니다!



### 느낀점

되돌아 보면 조금만 차분히 고민을 해 보았더라면 충분히 문제를 해결할 수 있었을 듯 합니다. 구글링 실력이 떨어지는지 관련된 포스트를 찾을 수 없어 헤맸었는데 이미 잘 정리된 책에는 이런 경우들에 대해 많이 작성되어 있는 듯 합니다.

지금은 `modern java in action`을 읽고 있는 중이지만 다음 책은 `토비의 Spring`을 읽지 않을 까 싶습니다. 감사합니다.

참고로 `호돌맨의 요절복통 개발쇼`도 참 재밌는 듯 합니다.ㅎㅎ





 

