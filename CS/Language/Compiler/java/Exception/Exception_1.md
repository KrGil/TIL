# [Java] Exception(checked, Unchecked Exception

> 현재 개발중인 프로젝트에서 Exception 처리에 대한 error를 다루다 Exception 관련해서 자료를 찾아보게 되었습니다. 그런데 지금으로부터 1년 전, 국비수업을 정리했던 글 중 Exception을 다룬 글이 있더군요.
>
> [링크](https://jjam89.tistory.com/20) 예전에 한번 정리했던 내용인데 어느덧 다시 잊어먹게 되어 한번 더 정리를 해 봅니다.



# 예외(Exception)

> 프로그래밍에서의 예외(Exception)은 프로그램 실행 중 개발자의 의도와는 다르게 정상적인 프로그램 흐름을 어긋나는 것을 말합니다. 그리고 자바의 경우 개발자가 직접 예외 상황을 처리할 수 있습니다.
>
> *에러(Error)는 시스템에서 발생한 비정상적인 상황으로 개발자가 처리할 수 없습니다.(에러를 상황을 잡아도 처리할 방법이 없습니다.)*

Exception에는 Checked Exception과 Unchecked Exception으로 구분할 수 있습니다. 

![exceptions](C:\Users\Eisen\Desktop\2019-03-02-java-checked-unchecked-exceptions-1.png)

*참조: https://madplay.github.io/post/java-checked-unchecked-exceptions*

## 구분

### Checked Exception

>  RuntimeException을 상속하지 않습니다.

위의 그림과 같이 Exception을 직접 상속받는 경우 throws 혹은 try/catch 로 직접 처리를 해 주어야합니다.

#### 종류

 `SQLException`, `IOException` ...



### Unchecked Exception

>  RuntimeException을 상속합니다.

자바에서의 unchecked Exception은 명시적으로 예외 처리를 하지 않아도 됩니다.

#### 종류

`NullPointerException`, `ClassNotFoundException` ...



## 예외 처리

**[링크](https://madplay.github.io/post/java-checked-unchecked-exceptions ) 글을 읽고 개인적으로 정리한 글입니다. 문제 발생 시 수정하겠습니다.*

> 처리 방법에는 `복구`, `회피`, `전환` 이 존재합니다.

### 예외 처리 복구

- 예외를 잡아서 처리. 

```java
final int MAX_RETRY = 100;
public Object someMethod() {
    int maxRetry = MAX_RETRY;
    while(maxRetry > 0) {
        try {
            ...
            maxRetry--;
        } catch(SomeException e) {
            // 로그 출력. 정해진 시간만큼 대기한다.
        } finally {
            // 리소스 반납 및 정리 작업
        }
    }
    // 최대 재시도 횟수를 넘기면 직접 예외를 발생시킨다.
    throw new RetryFailedException();
}
```



### 예외처리 회피

- 예외 처리를 직접 담당하지 않고 호출한 쪽으로 던져 회피하는 방법입니다.

```java
// 예시 1
public void add() throws SQLException {
    // ...생략
}

// 예시 2 
public void add() throws SQLException {
    try {
        // ... 생략
    } catch(SQLException e) {
        // 로그를 출력하고 다시 날린다!
        throw e;
    }
}
```



## 예외 전환

- `예외 회피`와 같이 호출한 쪽으로 예외를 던지지만 다른 예외로 전환해서 넘기는 방법입니다.

```java
// 조금 더 명확한 예외로 던진다.
public void add(User user) throws DuplicateUserIdException, SQLException {
    try {
        // ...생략
    } catch(SQLException e) {
        if(e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
            // 좀 더 명확한 exception으로 전환 후 던집니다.
            throw DuplicateUserIdException();
        }
        else throw e;
    }
}

// 예외를 단순하게 포장한다.
public void someMethod() {
    try {
        // ...생략
    }
    catch(NamingException ne) {
        throw new EJBException(ne);
        }
    catch(SQLException se) {
        throw new EJBException(se);
        }
    catch(RemoteException re) {
        throw new EJBException(re);
        }
}
```



## Result

`오류(Error)`와 `예외(Exception)`이 존재합니다.

`예외(Exception)`에는 `unchecked`와 `checked` 두 `예외(Exception)`이 존재합니다.

`unchecked`는 `runtimeException`을 상속하며 명시적으로 처리하지 않아도 됩니다.(`NullPointerException`)

`checked`는 `Exception`을 상속하며 **꼭** 명시적으로 처리해야합니다.(`IOException`)



긴 글 읽느라 고생 많으셨습니다. 아래의 Refences에 참조된 블로그를 방문하시면 좀 더 자세한 내용을 알 수 있습니다. 감사합니다.

### References

https://madplay.github.io/post/java-checked-unchecked-exceptions 

