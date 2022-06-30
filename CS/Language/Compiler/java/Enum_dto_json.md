# [Java] Enum변수를 json으로 변환하여 Enum 값 전달하기

> 회사에서 근무하던 중 DTO를 json으로 변환해 넘겨주는 작업을 했습니다.
>
> 이때 값을 넘기는 도중 발생하였는데 확인해 보니 enum의 값이 제대로 넘어가지 않는 문제였습니다.
>
> 이 문제를 해결한 기록을 남기고자 합니다.



## 발단

> DTO 내부에 Enum 변수를 들고 있는 상황입니다. 
>
> Enum변수에 enum을 전달 한 후 json으로 변환 하였을 때 enum의 값이 출력되는게 아니라 name이 출력되는 현상을 겪었습니다. 

DTO

```java
package com.example.dailyProgramming.enum_test;

import lombok.Data;

@Data
public class Enum_getTest {
    String str;
    TestEnum1 enumTest;

    public enum TestEnum1{
        AA("N/A");
        String value;
        TestEnum1(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }
    }
}
```



Client

```java
package com.example.dailyProgramming.enum_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import com.example.dailyProgramming.enum_test.Enum_getTest.*;

class Enum_getTestTest {

    @Test
    void EnumValue테스트() throws JsonProcessingException {
        Enum_getTest enum1 = new Enum_getTest();
        ObjectMapper jsonMapper = new ObjectMapper();

        enum1.str1 = "테스트 데이터1";
        enum1.enumTest = TestEnum1.AA;

        System.out.println(jsonMapper.writeValueAsString(enum1));
    }
}
```

위와 같이 ObjectMapper를 사용해 `DTO -> json`으로 변환시킨 후 출력해 보았습니다.

![image-20220630182837192](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\Enum_dto_json.assets\image-20220630182837192.png)

결과는 위의 이미지와 같이 `Enum`의 `value`가 아닌 `name`을 출력해 주는 것을 확인 할 수 있습니다.

`{"enumTest":"AA","str1":"테스트 데이터1"}`



## 해결

> 해당 문제는 jackson의 annotation을 사용하여 쉽게 해결할 수 있습니다.

DTO

```java
import com.fasterxml.jackson.annotation.JsonValue;
...
@Data
public class Enum_getTest {
    String str;
    TestEnum1 enumTest;

    public enum TestEnum1{
        AA("N/A");
        String value;
        TestEnum1(String value){
            this.value = value;
        }
        @JsonValue            // ----> 이 부분에 @JsonValue를 추가해 줍니다. 
        public String getValue(){
            return value;
        }
    }
}
```



Client

호출 부분은 처음과 동일하게 작성 후 실행해 봅니다.

```java
@Test
void EnumValue테스트() throws JsonProcessingException {
    Enum_getTest enum1 = new Enum_getTest();
    ObjectMapper jsonMapper = new ObjectMapper();

    enum1.str1 = "테스트 데이터1";
    enum1.enumTest = TestEnum1.AA;

    System.out.println(jsonMapper.writeValueAsString(enum1));
}
```

![image-20220630185018044](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\Enum_dto_json.assets\image-20220630185018044.png)

보시는 바와 같이 `Enum`의 `name`이 아닌 `value`가 json으로 변환되는 것을 알 수 있습니다.

`{"enumTest":"N/A","str1":"테스트 데이터1"}`



앞으로 enum의 값을 json으로 변환하여 값을 전달할 경우 `@JsonValue`를 잘 기억했다가 활용하면 좋을 듯 합니다.

감사합니다.