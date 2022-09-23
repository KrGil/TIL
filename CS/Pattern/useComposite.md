# 상속보다는 컴포지션을 사용하라.

> 스터디에서 디자인패턴의 component 패턴에 대해 이야기 하다 `상속보다는 컴포지션을 사용하라`라는 말이 나왔습니다. 이게 무슨말인가 싶어 다른 분의 간단한 설명을 듣긴 했지만 잘 와닿지 않더군요. 그러던 중 본인이 공부했던 링크를 남겨 주셔서 보았습니다. 역시 글로 읽어서도 제대로 와닿지 않아 읽은 내용을 조금 정리하면서 작성해 보았습니다.

## 사용

```java
class Engine {} // The Engine class.

class Automobile {} // Automobile class which is parent to Car class.

class Car extends Automobile { // Car is an Automobile, so Car class extends Automobile class.
  private Engine engine; // Car has an Engine so, Car class has an instance of Engine class as its member.
}
```

상속: Is-A

​	 `Car extends Automobile`

컴포지션: Has-A

​	`private Engine engine`



## 상속과 컴포지션

	- **상속**은 캡슐화를 깨뜨립니다.(상위 클래스의 구현에 따라 동작에 영향을 줄 수 있습니다.)
	- **상속**상위 클래스가 확장을 고려하지 않았다면 상속을 다시 고려해 보아야 합니다. 

```java
public class 스마트폰 extends 전화기 {
    private int callCount;
    @Override
    public boolean call() {
        callCount++;
        super.call();
    }
    @Override
    public boolean callAll(Collection<? extends E> c) {
        callCount += c.size();
        ...super.callAll();
    }
}

public class 전화기 {
    public boolean call() {
        ...
    }
    public boolean callAll(Collection<? extends E> c) {
        ...call(); // iterate c
    }
    public void usePhone() {
        손으로 사용한다. -> 발로 사용해야 한다.
    }
}
```

_참고:  https://smjeon.dev/etc/composite-extends/_

위의 예시에서 전화기의 usePhone() 기능이 `손으로 사용한다.` -> `발로 사용해야 한다.`로 바뀌면 전화기를 상속받은 스마트폰 역시 손으로 사용하다 발로 사용해야 한다로 바뀝니다. 즉 상위 클래스가 변경됨에 따라 하위 클래스의 동작에 영향을 받게 된다는 뜻입니다.

따라서 상속을 구현할 경우

1. 확장하려는 클래스의 API에 아무런 결함이 없는지,
2. 결함이 있다면, 이 결함이 상속받은 클래스이 API까지 전파돼도 괜찮은지 확인을 해 보아야 합니다.

컴포지션으로는 이런 결함을 숨기는 새로운 API를 설계할 수 있지만, 



### References

https://ansohxxn.github.io/design%20pattern/chapter1/

https://smjeon.dev/etc/composite-extends/

https://developer-ping9.tistory.com/326