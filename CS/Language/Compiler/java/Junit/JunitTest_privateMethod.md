# [Junit] private Method 테스트하기 

> 사실 private Method가 test가 되지 않은 이유는 기본적으로 테스트할 필요가 없게끔 구현하라는 의도가 깔려 있다고 생각합니다. 하지만 가끔 private Method를 테스트 해야할 때가 존재합니다. 
>
> 저 같은 경우 중간에 인수인계받은 작업이 존재하는데 spec이 변경되면서 해당 Method만을 테스트 해야 하는 상황이 존재했습니다.
>
> 검색하고 나름의 방법을 찾은 후 해당 방법에 대해 정리해 보겠습니다.



## Method와 ReflectionTestUtils

테스트 방법에는 여러가지 방법이 있지만 여기서는 두가지 방법을 다뤄보겠습니다.

1. ### java.lang.reflect.Method

2. ### org.springframework.test.util.ReflectionTestUtils

### TestCode

- 아래와 같이 `PrivateMehtodClass`에 `convertToEntity()` 라는 private Mehtod를 테스트 할 경우를 상정해 보겠습니다.

```java
public class PrivateMethodClass {

    ServiceObj serviceObj;

    public PrivateMethodClass(ServiceObj serviceObj){
        this.serviceObj = serviceObj;
    }

    private EntityObj convertToEntity(DTOObj dto){
        System.out.println("entity = " + serviceObj.someObject(3));
        return new EntityObj();
    }   
}
public class ServiceObj{
   public String someObject(Integer num){
       System.out.println("num = " + num);
       return "hello World!";
   }
}
public class EntityObj{

}
public  class DTOObj{

}
```

### java.lang.reflect.Method

java의 기본 패키지에 포함되어있는 Method를 활용한 방법입니다.

`Method target = Target.class.getDeclaredMethod("MethodName", argClasses);` 형태로 작성하면 됩니다.

```java

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;

@ExtendWith(MockitoExtension.class)
class JunitTestTest {

    @Mock
    private PrivateMethodClass.ServiceObj service;

    @Mock
    private PrivateMethodClass.EntityObj entity;

    @Mock
    private PrivateMethodClass.DTOObj dto;
  
    @InjectMocks
    private PrivateMethodClass junitTest;

    @Test
    @DisplayName("private Method 검증하기")
    public void convertToDTOTest() throws Exception{
        /* Reflection */
        Method target = PrivateMethodClass.class.getDeclaredMethod("convertToEntity", PrivateMethodClass.DTOObj.class);
        target.setAccessible(true);

        // given
        String str = "Hello Eisen!";
        Mockito.when(service.someObject(Mockito.anyInt())).thenReturn(str);

        // when
        target.invoke(junitTest, dto);

        // then
        Mockito.verify(service, Mockito.atLeastOnce()).someObject(3);
    }
}
```

아래의 이미지와 같이 해당 결과가 잘 나오는 것을 볼 수 있습니다.

![image-20220904213146452](https://raw.githubusercontent.com/KrGil/TIL/e2bbff7a04bf6d573c5116ae351c8b964623909c/CS/Language/Compiler/java/Junit/JunitTest_privateMethod.assets/image-20220904213146452.png)



### org.springframework.test.util.ReflectionTestUtils

`ReflectionTestUtils.invokeMethod(target, targetMethod, argClass);` 와 같은 형태로 작성하면 됩니다.

```java
 @Test
    @DisplayName("private Method 검증하기")
    public void convertToDTOTest() throws Exception{
        // given
        String str = "Hello Eisen!";
        Mockito.when(service.someObject(Mockito.anyInt())).thenReturn(str);

        // when
        ReflectionTestUtils.invokeMethod(junitTest, "convertToEntity", dto);

        // then
        Mockito.verify(service, Mockito.atLeastOnce()).someObject(3);
    }
```

아래와 같이`Spring`에서  `DEBUG`도 따로 찍어 주는 것을 확인 할 수 있습니다.

![image-20220904213103309](https://raw.githubusercontent.com/KrGil/TIL/e2bbff7a04bf6d573c5116ae351c8b964623909c/CS/Language/Compiler/java/Junit/JunitTest_privateMethod.assets/image-20220904213103309.png)

위의 `reflect.Method`를 활용한 방법보다 조금 더 깔끔하게 사용할 수 있습니니다만 `Spring`을 사용하지 않는 프로젝트이거나 버전이 `2.5`보다 낮은 경우 해당 방법을 사용할 수 없습니다.

### TO-DO

지금은 `private Method`를 테스트 하는 중 `CustomException`을 확인 할 수 있는 방법을 알아보고 있습니다. 방법을 찾게 된다면 관련된 글 역시 정리해 보도록 하겠습니다.

긴 글 읽느라 고생하셨습니다. 이상으로 `private Method`에서 `jUnit` 테스트 하기를 살펴 보았습니다.

### References

https://shanepark.tistory.com/367

https://stackoverflow.com/questions/8799439/testing-private-method-using-mockito

https://yearnlune.github.io/java/java-private-method-test/#