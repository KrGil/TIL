# [java] If문 제거하기

> 회사에서 기존에 작성되어있는 코드를 보다 하나의 method 내에 십여개의 if문...으로 작성된 파일을 보게 되었습니다. 파악하는게 너무 힘들더군요... 그래서 조금 더 파악하기 쉽고 유지보수에 효과적인 코드는 없을까 고민을 했다 예전에 차장님이 구현해놓으신(~~당시에는 Functional Interface를 몰라 이해하기 무척 어려웠다는 사실은 비밀~~) 코드와 몇일전에 보았던 다른 언어들의 if문 처리 방법에 대해 생각이 나더군요. 그래서 그것과 비슷한 방식으로 전반적인 refactoring을 진행해 보았습니다.
>
> 적용을 다 하고 나니 정리할 필요가 있을 듯 해서 sample 코드를 사용해서 java에서 if문을 제거하는 방법을 정리해 보았습니다.

# Sample

## if 가 '많이' 사용되고 있는 코드

```java
package com.Eisen.tistory.test;

import java.util.HashMap;
import java.util.Map;

public class IfTest {
    public void ifTest(String str){
        if (str.equals("String1")) {
            //...
            System.out.println(boo1(str));
        }
        if (str.equals("String2")) {
            //...
            System.out.println(boo2(str));
        }
        if (str.equals("String3")) {
            //...
            System.out.println(boo3(str));
        }
        if (str.equals("String4")) {
            //...
            System.out.println("덕지덕지");
        }
    }

    public String boo1(String str){
        return str + ": String1 done";
    }
    public String boo2(String str){
        return str + ": String2 done";
    }
    public String boo3(String str){
        return str + ": String3 done";
    }
}
```

### 단점

1. 가독성 입니다.

   위의 sample코드는 몇줄 되지 않아 원하는 메서드나 값들을 찾기 쉽지만 만약 `if`문의 갯수가 많아지고 `if`문 내부의 구현 로직이 길어지게 되면(`Class`의 메서드 호출 등) 필요한 정보를 찾기 어려움이 있더군요.

2. 흐름 입니다.

   `if`문으로 분기가 많이 쳐져 있는 메서드의 경우 한눈에 무엇을 하는 메서드인지 파악하기 어렵습니다. 또한 분기가 많이 적용되어 있어 흐름을 파악하다 길을 잃을 확률이 높습니다.

 위의 단점들로 `Functional Interface`를 활용해 보았습니다.

**단점을 나열했지만 `if`문이 나쁘다는 것은 아닙니다.**

## Functional Interface의 Function을 활용한 코드

```java
package com.Eisen.tistory.test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class IfTest {
    private final Map<String, Function<String, String>> foo = new HashMap<>();

    IfTest() {
        foo.put("String1", this::boo1);
        foo.put("String2", this::boo2);
        foo.put("String3", this::boo3);
        foo.put("String4", this::boo4);
    }

    public String boo1(String str){
        return str + ": String1 done";
    }
    public String boo2(String str){
        return str + ": String2 done";
    }
    public String boo3(String str){
        return str + ": String3 done";
    }
    public String boo4(String str){
        return str + ": String4 done";
    }

    public String run(String str){
        if(!foo.containsKey(str)){
            return "String1,2,3 중 하나만 가능합니다.";
        }
        String bangta = "bangta1";
        return foo.get(str).apply(bangta);
    }
}
```

`Function` 클래스를 활용하여 구현해 보았습니다. 생성자에  `String` 과 매핑되는 `Function`을 담는 `Map<String, Function<T, R>`을 구현하여 클래스를 조금 더 파악하기 쉽게 만들어 보았습니다. 다른 분들이 작성한 코드와 다른 언어의 참고하여 (`python`의 경우 `dictionary` 타입이, javascript에서는 `object` 등) 위와 같이 구현해 보았습니다.

긴 글 읽어주셔서 감사합니다.

