# Functional Interface





## Supplier

> 인자를 받지 않고 Type T 객체를 리턴하는 함수형 인터페이스

```
/**
 * Represents a supplier of results.
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #get()}.
 *
 * @param <T> the type of results supplied by this supplier
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();
}
```

### Example

```
import java.util.function.Supplier;

public class SupplierExample1 {

    public static void main(String[] args) {

        Supplier<String> supplier= ()-> "HelloWorld";

        String result = supplier.get();

        System.out.println(result);
    }
}
```

```
import java.util.function.Supplier;

public class SupplierExample2 {

    public static void main(String[] args) {

        Supplier<Item> supplier= ()-> new Item(10, "Hello");

        Item result = supplier.get();

        System.out.println(result.getId() + ", " + result.getValue());
    }
}
```

## Consumer

> 1개의 Type T 인자를 받고 리턴 값이 없는 함수형 인터페이스

```java

/**
 * Represents an operation that accepts a single input argument and returns no
 * result. Unlike most other functional interfaces, {@code Consumer} is expected
 * to operate via side-effects.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #accept(Object)}.
 *
 * @param <T> the type of the input to the operation
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t);

    /**
     * Returns a composed {@code Consumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code Consumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
```

## Predicate

> Predicate는 한 개의 Type T 인자를 받고 boolean을 리턴하는 함수형 인터페이스

```
/**
 * Represents a predicate (boolean-valued function) of one argument.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #test(Object)}.
 *
 * @param <T> the type of the input to the predicate
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Predicate<T> {

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    boolean test(T t);
    ...
}
```

## Function

> Function은 한 개의 Type T 인자를 받고 1개의 객체(Type R)를 리턴하는 함수형 인터페이스입니다.

```java

/**
 * Represents a function that accepts one argument and produces a result.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object)}.
 *
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Function<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);
    ...
}
```







### References

https://medium.com/swlh/understanding-java-8s-consumer-supplier-predicate-and-function-c1889b9423d

https://www.baeldung.com/java-8-functional-interfaces

- Supplier

https://codechacha.com/ko/java8-supplier-example/

- Predicate

https://codechacha.com/ko/java8-predicate-example/

- Function

https://codechacha.com/ko/java8-function-example/

- Consumer

https://codechacha.com/ko/java8-consumer-example/