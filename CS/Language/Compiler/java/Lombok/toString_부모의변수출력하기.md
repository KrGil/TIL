# [Java] Lombok의 @ToString(부모의 toString() 함께 출력하기)

> 이번에는 프로젝트를 진행하는 중에 간단하지만 자주 잊어먹는 기능 중 하나인 lombok의 @ToString()에 대해서 작성해 보겠습니다. 예전에 프로젝트를 진행 중에 분명 사용했었는데 @Override를 직접 작성해서 사용하고 있었네요. 그럼 아래에 작성해 보도록 하겠습니다.

## code

```java

@Data
public class ParentDTO {
    private String i;
    private String am;
    private String your;
    private String papa;
}

@Data
public class ChildDTO extends ParentDTO {
    private String scream;
}

@Data
public class LombokClientDTO {
    private ParentDTO parent;
    private String howdi;
}
```

위와 같이 부모클래스(`ParentDTO`)를 가지고 있는 클래스(`LombokClientDTO`)가 있습니다.

```java
public class LombokClient {
    LombokClientDTO dto = new LombokClientDTO();

    public void toStringTest(){
        ChildDTO child = new ChildDTO();
        dto.setHowdi("Hi!!");
        child.setI("i");
        child.setAm("am");
        child.setYour("your");
        child.setPapa("papa?");
        child.setScream("arrrrrrrrrrr~~");

        dto.setParent(child);
        System.out.println("dto = " + dto);
    }
}

class LombokClientTest {
    LombokClient client = new LombokClient();

    @Test
    void toString테스트하기(){
        client.toStringTest();
    }
}
```

위의 상황처럼 클래스 `LombokClientDTO`의 `parent` 값에  `ParentDTO`를 상속한 `ChildDTO`를 넣는 상황에서 제대로 값이 들어갔는지 **log**를 찍어(여기서는 `System.out.println()`을 사용했습니다.) 확인해 봅니다.(~~debug를 사용하면 되지만 log만 확인할 때입니다~~).

![image-20220706164750363](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\Lombok\toString_부모의변수출력하기.assets\image-20220706164750363.png)

위의 이미지와 같이 `dto`를 찍어보게 되면 부모클래스`ParentDTO`의 변수들은 출력되지 않습니다. 이때 보통 toString을 @Override 해서  사용합니다.

```java
@Data
@EqualsAndHashCode(callSuper = true)  
public class ChildDTO extends ParentDTO {
    private String scream;

    @Override
    public String toString() {
        String str = super.toString();
        return "ChildDTO{" +
            "scream='" + scream + '\'' +
            '}'+str;
    }
}
```

![image-20220706165602700](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\Lombok\toString_부모의변수출력하기.assets\image-20220706165602700.png)

출력을 하니 `ParentDTO`도 잘 출력되는 것을 확인할 수 있습니다.

이렇게 직접 toString()을 @Override 해서 사용해도 되지만 lombok의 @ToString을 이용하면 간편하게 부모의 toString까지 함께 출력할 수 있습니다.

## Lombok의 @ToString

![image-20220706165932691](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\Lombok\toString_부모의변수출력하기.assets\image-20220706165932691.png)

callSuper()의 default가 false이니 @ToString(callSuper = true)로 설정해 줍니다.(위에 설명이 되어 있지만 false일 경우 부모의 toString을 출력해주지 않겠다는 설정입니다.)

```java
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChildDTO extends ParentDTO {
    private String scream;
}
```

위와 같이 설정 후 호출하면 아래의 이미지처럼 부모의 변수들도 잘 출력해 주는것을 볼 수 있습니다. 

![image-20220706170054018](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\Lombok\toString_부모의변수출력하기.assets\image-20220706170054018.png)

감사합니다.