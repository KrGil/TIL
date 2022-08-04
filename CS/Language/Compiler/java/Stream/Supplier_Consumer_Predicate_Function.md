# [Java]  함수형 인터페이스(Functional Interface)

> 요즘 프로그램을 짤 때 Stream API를 사용하고 있습니다. 하지만 Stream에서 주로 사용되는 여러가지 Class Type들이 너무 낯설더군요.  Stream을 사용하기 위해선 lambda를 사용해야하고 lambda를 사용하기 위해선 함수형 인터페이스(Functional Interface)를 사용해야 하더군요. 그래서 함수형 인터페이스(Functional Interface)에 대해 알아보았습니다. 
>
> 검색을 해 보니 Stream, lambda 그리고 Functional Interface 세가지를 활용한 프로그래밍을 `Functional programming`이라고 하더군요. 다음에는 `Functional programming`을 알아보겠습니다. 

아래에 정리한 코드들은 모두 `gitHub`에 올려 놓았습니다. 필요하시다면 편하게 가져다 쓰셔도 됩니다.

> [Eisen's GitHub](https://github.com/KrGil/daily/tree/main/src/main/java/com/Eisen/daily/functionalInterface) 

# Functional Interface

> 함수형 인터페이스(Functional Interface)는 1개의 추상 메서드를 갖고 있는 인터페이스를 말합니다. Single Abstract Method(SAM)라고 불리우고 아래와 같은 구조를 가지고 있습니다.
>
> 자바의 람다식이 함수형 인터페이스로만 접근 되기에 사용됩니다.

```java
public interface FunctionalInterface {
    public abstract void someMethod(String text);
}
```
## Overview

### How?

위에 언급한 코드와 같이 추상 메서드가 오직 하나인 인터페이스를 함수형 인터페이스(Functional Interface)라고 합니다.

따라서 `default method`나 `static method`가 여러개 존재할 수 있습니다.

`@FunctionalInterface` 어노테이션을 사용하는데 이는 해당 인터페이스가 함수형 인터페이스인지 검증해 주는 어노테이션입니다. 굳이 `@FunctionalInterface`가 없어도 함수형 인터페이스로 동작하는데 무리는 없습니다만 사용하는것이 훨씬 좋다고 생각합니다.

```java

@FunctionalInterface
public interface CustomFuntionalInterface<T> {
    T myTest();

    // default method 는 존재해도 상관없습니다.
    default void defalutMethod() {
        System.out.println("Hello Default");
    }

    // static method 는 존재해도 상관없습니다.
    static void staticMethod() {
        System.out.println("Hello Static");
    }
}

```

### Use

> Functional Interface는 두가지 방법으로 사용할 수 있습니다.
>
> - 익명클래스(anonymous class)
> - lambda

#### 1. 익명클래스(Anonymous class)

```java
CustomFuntionalInterface test = new CustomFuntionalInterface() {
    @Override
    public String myTest() {
	    return "Hello Abstract";
    }
};

System.out.println(lambdaTest.myTest());
```

#### 2. Lambda

```java

CustomFuntionalInterface lambdaTest = () -> "Hello Abstract";

System.out.println(lambdaTest.myTest());
```

### Result

![image-20220804093256002](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Language/Compiler/java/Stream/Supplier_Consumer_Predicate_Function.assets/image-20220804093256002.png)



## 기본 함수형 인터페이스

> - Runnable
>
> - Supplier
>
> - Customer
>
> - Predicate
>
> - Function
>
>   ...

자바에서 제공하는 기본 함수로 대부분의 lambda을 만들 수 있어 매번 직접 Functional Interface를 만들 필요는 없습니다.


| Functional Interface | Descriptor | Method |
|:--|---|---|
| Runnable | () -> void | void run() |
| Supplier | () -> T | T get() |
| Consumer | T -> void | void accept(T t) |
| Predicate | T -> boolean | boolean test(T t) |
| Function<T, R>  | T -> R | R apply(T t) |
| Callable | () -> T | V call() |
| Comparator | (T, T) -> int | int compare(T o1, T o2) |

*출처: 위의 표는 https://bcp0109.tistory.com/313 내용을 참고하여 작성하였습니다. 문제 시 수정하도록 하겠습니다.*

### 1. Runnable

> 인자를 받지 않고 리턴도 하지 않는 함수형 인터페이스입니다.
>
> `() -> void`로 표현할 수 있습니다.
>
> `run()`을 호출하여 사용할 수 있습니다.

```java
@FunctionalInterface
public interface Runnable {
	public abstract void run();
}
```

#### Example

```java

public static void runnableMethod(){}

public static void main(){
    // lambda
    Runnable runnableLambda = () -> runnableMethod() ;
    runnableLambda.run();

    // anonymous
    Runnable runnableAnonymous = new Runnable() {
        @Override
        public void run() {
            runnableMethod();
        }
    };
    runnableAnonymous.run();
}

```



### 2. Supplier

> 인자를 받지 않고 Type T 객체를 리턴하는 함수형 인터페이스
>
> `() -> T`로 표현할 수 있습니다.
>
> `get()`을 호출하여 사용할 수 있습니다.

```java
@FunctionalInterface
public interface Supplier<T> {
    T get();
}

```

#### Example

```java
public static void main(String[] args){
    // lambda
    Supplier<String> supplierLambda = () -> "Hello SupplierLambda";
    System.out.println("supplierLambda = " + supplierLambda.get());

    // annonymous
    Supplier<String> supplierAnnonymous = new Supplier<String>() {
        @Override
        public String get() {
            return "Hello SupplierAnnoymous";
        }
    };
    System.out.println("supplierAnnoymous = " + supplierAnnonymous.get());
}
```



### 3. Consumer

> 1개의 Type T 인자를 받고 리턴 값이 없는 함수형 인터페이스입니다.
>
> `T -> void`로 표현할 수 있습니다.
>
> `accept()`와 `andThen`을 호출하여 사용할 수 있습니다.

```java

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);

    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
```

#### Example

```java
public static void main(String[] args) {
        // lambda
        Consumer<String> consumerLambda = (text) -> consumerMethod(text);
        consumerLambda.accept("Lambda");
    	
        // anonymous
        Consumer<String> consumerAnonymous = new Consumer<String>() {
            @Override
            public void accept(String text) {
                consumerMethod(text);
            }
        };
        consumerAnonymous.accept("Anonymous");
    
     	// andThen
        Consumer<String> consumerAndThen = (text) -> System.out.println(" lambda & anonymous");
        consumerLambda.andThen(consumerAndThen).accept("");
    	// 결과
    	// Hello Consumer
    	// lambda & anonymous
    }
    public static <T>void consumerMethod(T text){
        System.out.println("Hello Consumer" + text);
    }

```



### 4. Predicate

> Predicate는 한 개의 Type T 인자를 받고 boolean을 리턴하는 함수형 인터페이스
>
> `T -> boolean`으로 표현할 수 있습니다.
>
> `test()` 를 호출하여 사용할 수 있습니다.

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
      
    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }

    default Predicate<T> negate() {
        return (t) -> !test(t);
    }

    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }

    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }
    
    @SuppressWarnings("unchecked")
    static <T> Predicate<T> not(Predicate<? super T> target) {
        Objects.requireNonNull(target);
        return (Predicate<T>)target.negate();
    }
}
```

#### Example

```java
 public static void main(String[] args) {
        // lambda
        Predicate<String> predicateLambda = (text) -> predicateMethod(text);
        String text = "Predicate";

        // anonymous
        Predicate<String> predicateAnonymous = new Predicate<String>() {
            @Override
            public boolean test(String text) {
                return predicateMethod(text);
            }
        };

        // test
        System.out.println("[Lambda] testTest: "+predicateLambda.test(text));
        System.out.println("[anonymous] testTest: "+predicateLambda.test(text));

        // negate
        System.out.println("negateTest: "+predicateLambda.negate().test(text));

        Predicate<String> predicateInteger = num -> predicateMethod2(text);
        // and
        System.out.println("andTest: "+predicateLambda.and(predicateInteger).test("Predicate"));
        // or
        System.out.println("orTest: "+predicateLambda.test("Predicate"));

        // isEqual(static method)
        Predicate<String> predicateIsEqual = Predicate.isEqual("isEqual?!");
        System.out.println("isEqualTest: "+predicateIsEqual.test("isEqual?!"));

        // not(static method)
        Predicate<String> predicateNot = Predicate.not(predicateIsEqual);
    	System.out.println("notTest: "+ predicateNot.test("isEqual?!"));
     
         // result
         /*
             [Lambda] testTest: true
             [anonymous] testTest: true
             negateTest: false
             andTest: false
             orTest: true
             isEqualTest: true
             notTest: false
         */
	
    }
    public static <T> boolean predicateMethod(T req) {
        return req.equals("Predicate") ? true : false;
    }
    public static <T> boolean predicateMethod2(T req){
        return req.equals("Predicate2") ? true : false;
    }
	
}
```



### 5. Function

> Function은 한 개의 Type T 인자를 받고 1개의 객체(Type R)를 리턴하는 함수형 인터페이스입니다.
>
> `T -> R`로 표현할 수 있습니다.
>
> `apply`를 호출하여 사용할 수 있습니다.

```java

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);

    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
```

#### Example

```java
public static void main(String[] args) {
    // lambda
    Function<Integer, Integer> functionLambda1 = (num) -> num * 2;
    System.out.println(functionLambda1.apply(3));

    Function<String, String> functionLambda2 = (text) -> String.format("똑바로 읽어도 거꾸로 읽어도 %s", text);
    System.out.println(functionLambda2.apply("우영우"));

    Function<Integer, Integer> functionLambda3 = (num) -> num + 3;

    // compose
    Function<Integer, Integer> functionCompose = functionLambda1.compose(functionLambda3);
    System.out.println("functionCompose: "+functionCompose.apply(3));

    // andThen
    Function<Integer, Integer> functionAndThen = functionLambda1.andThen(functionLambda3);
    System.out.println("functionAndThen: "+functionAndThen.apply(3));

    // anonymous
    Function<Integer, Integer> functionAnonymous = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer integer) {
            return integer * 2;
        }
    };
    // result
    /*
        6
        똑바로 읽어도 거꾸로 읽어도 우영우
        functionCompose: 12
     	functionAndThen: 9
     */
}

```

`compose()`와 `andThen()`의 경우 `apply()` 시 어떤 것을 먼저 실행 시키는 순서의 차이만 있습니다.

위의 예제를 예시로 들면

**Compose()**

`functionCompose.apply(3)`  실행 시 `functionLambda1.apply()`를 실행 시키기 전에 `functionLambda3`를 실행시킵니다.

따라서 `(3 + 3) * 2` 로 result가 12가 됩니다. 

**AndThen()**

`functionCompose.apply(3)` 실행 시 `functionLambda1.apply()`를 실행 후 `functionLambda3`를 실행시킵니다.

따라서 `3 * 2 + 3`으로 result가 9가 됩니다.



### 6. Callable

> `Callable`은 인자를 받지 않고  `Type T` 객체를 리턴하는 함수형 인터페이스입니다.
>
> `() -> T`로 표현할 수 있습니다.
>
> `call()`을 호출하여 사용할 수 있습니다.

`Runnable`과 매우 흡사하다고 생각하면 됩니다.  하지만 아래 글을 보면 알 수 있듯 리턴 객체가 존재하고 checked exception을 던질 수 있습니다. 

> The Callable interface is similar to Runnable, in that both are designed for classes whose instances are potentially executed by another thread. A Runnable, however, does not return a result and cannot throw a checked exception.

```java
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
```

#### Example

```java
public class FunctionalInterfaceCallable {
    public static void main(String[] args) {
        Callable callable = () -> callableMethod();
        try {
            System.out.println(callable.call());
        }catch (Exception e){
            ExceptionUtils.getStackTrace(e);
        }
    }
    public static String callableMethod(){
        return "Hello Callable";
    }
}
```



### 7. Comparator

> `Comparator`은 두 개의 Type T 인자를 받고 `int`를 리턴하는 함수형 인터페이스입니다.
>
> `(T, T) -> int`로 표현할 수 있습니다.
>
> `compare()`을 호출하여 사용할 수 있습니다.

#### Example

```java
public static void main(String[] args) {
        // lambda
        Comparator<Integer> comparatorLambda = (o1, o2) -> o1.compare(o1, o2);
        System.out.println(comparatorLambda.compare(2,4));
		
        // List<Integer> testList = List.of(1, 5, 3); --> immutable
        List<Integer> testList = Arrays.asList(1, 5, 3);

        System.out.println("before: " + testList);
        testList.sort(comparatorLambda);
        System.out.println("after: " + testList);

        // anonymous
        Comparator<Integer> comparatorAnonymous = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
    }
```

### 

긴 글 읽느라 고생하셨습니다. 해당 글이 `Functional Interface`를 이해하는 데 있어 조금이라도 도움이 되길 바랍니다.

감사합니다.



### References

- Functional Interface

https://bcp0109.tistory.com/313

https://sungwoon.tistory.com/58



https://medium.com/@jishnu61/functional-interface-lambdas-and-streams-functional-programming-approach-in-java8-b299cd33ce25

https://medium.com/swlh/understanding-java-8s-consumer-supplier-predicate-and-function-c1889b9423d

https://www.baeldung.com/java-8-functional-interfaces

- 함수형프로그래밍(Functional Programming)

https://mangkyu.tistory.com/111

- Supplier

https://codechacha.com/ko/java8-supplier-example/

- Predicate

https://codechacha.com/ko/java8-predicate-example/

- Function

https://codechacha.com/ko/java8-function-example/

- Consumer

https://codechacha.com/ko/java8-consumer-example/