# [java] SpringBoot 사용 시 field에 변수 선언 관련 문제

> 어제 저녁 옆 팀의 다른 동료가 위의 문제에 대해서 질문을 해 왔습니다.  Field에 String 변수에 static을 선언하지 않을 시 error가 나는데 그 이유를 모르겠다고 하더군요.
>
> 간단한 문제였는데 '이것 때문이다!' 라고 콕 집어서 이야기 하기가 힘들더군요. 그래서 관련 문제를 해결하면서 제대로 설명 할 수 있을 정도로 정리해 보는것이 이번 글의 목적입니다.

# 문제

>  회사의 코드를 불러올 순 없으니 회사코드와 비슷한 아래의 코드로 진행하도록 하겠습니다.

```java
@Slf4j
@Service
@AllArgsConstructor  // 1. 어노테이션의 기능 파악
public class SpringBootFieldStaticSample {
    private SpringBootFieldStaticSample1 springBootFieldStaticSample1;

    private SpringBootFieldStaticSample2 springBootFieldStaticSample2;

    private String name = "springBoot"; // 2. 여기 위치에 error가 발생

    public void test(){
        springBootFieldStaticSample1.getName();
        springBootFieldStaticSample2.getName();
    }
}
```

위의 코드에서 2번의 자리에서 오류가 발생하고 있었습니다. 코드를 살펴보니 위의 `@AllArgsConstructor`이 보이더군요.

그래서 `name` 변수에 단순히 `static` 을 붙여주게 되면 해결됩니다. 그렇다면 왜 `static`을 추가해 주면 제대로 동작하는지, `static`을 붙여주는 방법 외에 다른 방법으로 해결하는 방법에 대해 작성해 보도록하겠습니다.

*추가로 위와 같이 상수가 아닌 String 변수를 전역변수로 사용하는 방법은 절차지향 프로그래밍 방법이고 객체지향 프로그래밍에서는 상당히 `지양`하는 방법입니다.*



## 테스트

위의 코드가 잘못된 코드라고 언급했는데 실제 실행 시 어떤 오류가 발생하는지 아래의 junit 테스트를 통해서 확인해 보도록 하겠습니다.

```java
@SpringBootTest
class SpringBootFieldStaticSampleTest {
    @Autowired
    SpringBootFieldStaticSample test;

    @Test
    void test(){
        test.test();
    }
}
```

위의 테스트 코드 실행 시 아래와 같은 오류가 제대로 발생하는 것을 알 수 있습니다.

![image-20221129133714831](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\java_static.assets\image-20221129133714831.png)



## 원인

`@AllArgsConstructor`을 사용했기 때문에 bean에 등록되지 않은 String(`name`) 객체를 bean에서 찾을 수 없어 `SpringBootFieldStaticSample`  생성이 안되서 나오는 오류입니다.

*`@AllArgsConstructor`의 경우 field에 존재하는 모든 객체를 파라미터로 받는 생성자를 구현해주는 역할을 합니다*

그렇다면 왜 static을 붙여주면 되는것일까요?

메모리에 적재되는 순서를 확인해 보면 간단하게 알 수 있습니다.

static변수는 application이 실행되지마자 메모리 공간(static)에 적재되기 때문에 spring bean 생성 시 bean으로 등록된 객체가 아닌 static 공간에서 호출해서 사용하게 됩니다.

그러나 static 을 붙여주지 않는 일반 지역 변수일 경우 `@AllArgsConstructor` 로 인해 bean에 등록된 객체를 확인하려고 합니다. 따라서 bean에 등록된 String 객체(`name`)이 존재하지 않기 때문에 오류가 발생한 것입니다.

그럼 static을 사용하지 않고 해결하는 방법에 대해서 알아보겠습니다.



## 다른 방법

> 다양한 방법이 있겠지만 여기에서는 아래와 같은 방법을 사용하도록 하겠습니다.
>
> 1. `@RequireArgsConstructor` 사용
> 2. `lombok`을 사용하지 않고 직접 생성자 생성 

### 1. `@RequireArgsConstructor` 사용

> @RequireArgsConstructor는 field에 final을 명시적으로 적어준 객체들만 파라미터로 받는 생성자를 구현해 줍니다.

```java
@Slf4j
@Service
@RequiredArgsConstructor
public class SpringBootFieldStaticSample {
    private final SpringBootFieldStaticSample1 springBootFieldStaticSample1;

    private final SpringBootFieldStaticSample2 springBootFieldStaticSample2;

    private String name = "springBoot";

    public void test(){
        springBootFieldStaticSample1.getName();
        springBootFieldStaticSample2.getName();
    }
}
```



#### @AllArgsConstructor와 @RequireArgsConstructor 차이점

- `@AllArgsConstructor` 사용 시 field에서 선언된 모든 객체들을 파라미터로 받는 생성자가 만들어 진 것을 볼 수 있습니다.(`SpringBootFieldStaticSample1`, `SpringBootFieldStaticSample2`, `String`)

![image-20221129135140588](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\java_static.assets\image-20221129135140588.png)

- `@RequireArgsConstructor` 사용 시 field에서 final이 명시적으로 붙어서 선언된 모든 객체들을 파라미터로 받는 생성자가 만들어 진 것을 볼 수 있습니다.(`SpringBootFieldStaticSample1`, `SpringBootFieldStaticSample2`)

![image-20221129135042625](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\java_static.assets\image-20221129135042625.png)

#### `@RequireArgsConstructor` 테스트

![image-20221129135259683](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\java_static.assets\image-20221129135259683.png)

문제 없이 잘 돌아가는것을 확인할 수 있습니다.

### 2. 생성자 직접 구현하기

> lombok을 사용하지 않고 아래와 같이 변수들만 제외한 생성자를 직접 구현하는 방법입니다.

```java
@Slf4j
@Service
public class SpringBootFieldStaticSample {
    private final SpringBootFieldStaticSample1 springBootFieldStaticSample1;
    private final SpringBootFieldStaticSample2 springBootFieldStaticSample2;
    public SpringBootFieldStaticSample(SpringBootFieldStaticSample1 springBootFieldStaticSample1, SpringBootFieldStaticSample2 springBootFieldStaticSample2) {
        this.springBootFieldStaticSample1 = springBootFieldStaticSample1;
        this.springBootFieldStaticSample2 = springBootFieldStaticSample2;
    }
    private String name = "test";
    private String name2 = "test";
    public void test(){
        springBootFieldStaticSample1.getName();
        springBootFieldStaticSample2.getName();
        System.out.println("name = " + name);
    }
}
```

### 번외(bean 활용)

> static을 사용하지 않는 방법 중 하나로 String을 bean에 등록해서 사용해 볼 수도 있습니다.

```java
@Configuration
public class SpringBootFieldStaticSampleConfig {
    @Bean(name = "myBean")
    public String myBean(){
        return "SpringBootFieldStaticSampleConfig";
    }
}
```

`@Configuration`으로 직접 bean 객체를 등록해 줍니다.

```java
@Slf4j
@Service
@AllArgsConstructor
public class SpringBootFieldStaticSample {
    private final SpringBootFieldStaticSample1 springBootFieldStaticSample1;
    
    private final SpringBootFieldStaticSample2 springBootFieldStaticSample2;
    
    @Qualifier("myBean")
    private String name = "test";
    
    public void test(){
        System.out.println("name = " + name);
    }
}
```

이와 같은 방법 사용 시 제대로 동작하기는 합니다만 bean에는 하나의 type에 하나의 객체만을 등록할 수 있습니다.

따라서 아래와 같이 같은 타입의 여러 객체를 등록하여 사용하게 되면 오류가 발생하게 됩니다. 

```java
@Configuration
public class SpringBootFieldStaticSampleConfig {
    @Bean(name = "myBean")
    public String myBean(){
        return "SpringBootFieldStaticSampleConfig";
    }
    @Bean(name = "myBean1")
    public String myBean1(){
        return "SpringBootFieldStaticSampleConfig";
    }
}
```

기존에 추가된 빈에 하나의 빈을 더 추가해 주고

```java
@Slf4j
@Service
@AllArgsConstructor
public class SpringBootFieldStaticSample {
    private final SpringBootFieldStaticSample1 springBootFieldStaticSample1;
    private final SpringBootFieldStaticSample2 springBootFieldStaticSample2;
    private final Constants constants;
    @Qualifier("myBean")
    private String name = "test";
    @Qualifier("myBean1")
    private String name2 = "test";
    
    @Value("${test.name}")
    private String who;

    public void test(){
        String test = constants.name;
        springBootFieldStaticSample1.getName();
        springBootFieldStaticSample2.getName();
        System.out.println("name = " + name);
        System.out.println("name2 = " + name2);
    }
}
```

실행시킨다면 아래와 같은 오류가 발생합니다.

![image-20221129153115194](C:\Users\Eisen\Documents\GitHub\TIL\CS\Language\Compiler\java\java_static.assets\image-20221129153115194.png)

하지만 아래처럼 `lombok`을 사용하지 않고 생성자를 아래처럼 직접 구현하면 잘 작동하는 것을 볼 수 있습니다.

```java
@Slf4j
@Service
public class SpringBootFieldStaticSample {
    private final SpringBootFieldStaticSample1 springBootFieldStaticSample1;
    private final SpringBootFieldStaticSample2 springBootFieldStaticSample2;
    public SpringBootFieldStaticSample(SpringBootFieldStaticSample1 springBootFieldStaticSample1, SpringBootFieldStaticSample2 springBootFieldStaticSample2,
                                       @Qualifier("myBean") String name,  @Qualifier("myBean1") String name1
                                       ) {
        this.springBootFieldStaticSample1 = springBootFieldStaticSample1;
        this.springBootFieldStaticSample2 = springBootFieldStaticSample2;
        this.name = name;
        this.name1 = name1;
    }
    private String name = "test";
    private String name1 = "test";
    public void test(){
        springBootFieldStaticSample1.getName();
        springBootFieldStaticSample2.getName();
        System.out.println("name = " + name);
        System.out.println("name2 = " + name1);
    }
}
```



이상으로 static을 사용했을 때와 사용하지 않았을 때의 차이점과 `lombok`과 기본생성자들을 사용해서 객체를 주입받는 방법들을 정리해 보았습니다.

긴 글 읽느라 고생하셨습니다.

감사합니다.

