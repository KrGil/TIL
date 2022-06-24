# [pattern]Decorator pattern

_이 블로그 글은 [[Design Pattern] 데코레이터 패턴이란](https://gmlwjd9405.github.io/2018/07/09/decorator-pattern.html) 글을 나름대로 간략하게 간추려서 정리한 글입니다. 자세한 사항이 궁금하신 분들은 위의 링크 혹은 하단의 References를 확인해 주시길 바랍니다._

# Decorator Pattern

- 객체의 결합 을 통해 기능을 동적으로 유연하게 확장 할 수 있게 해주는 패턴으로 기본 기능에 추가할 수 있는 기능의 종류가 많은 경우에 각 추가 기능을 Decorator 클래스로 정의 한 후 필요한 Decorator 객체를 조합함으로써 추가 기능의 조합을 설계 하는 방식입니다.
- 데코레이터 패턴을 활용하면 필요 추가 기능의 조합을 동적으로 생성할 수 있습니다.

![image-20220515093333995](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/Decorator_pattern.assets/image-20220515093333995.png)



## 일반적인 구조(Decorator를 사용하지 않을 시)

아래와 같은 구조를 설계한다고 가정을 해봅니다.

![image-20220515093640117](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/Decorator_pattern.assets/image-20220515093640117.png)

### 구현 코드 

```java
// 기본 도로 표시
public class RoadDisplay {
    public void draw() {
        System.out.println("기본 도로 표시");
    }
}
```

```java
// 기본 도로 표시 + 차선 표시 클래스
public class RoadDisplayWithLane extends RoadDisplay {
  public void draw() {
      super.draw(); // 상위 클래스, 즉 RoadDisplay 클래스의 draw 메서드를 호출해서 기본 도로 표시
      drawLane(); // 추가적으로 차선 표시
  }
  private void drawLane() { System.out.println("차선 표시"); }
}
```

호출

```java
public class Client {
  public static void main(String[] args) {
      RoadDisplay road = new RoadDisplay();
      road.draw(); // 기본 도로만 표시

      RoadDisplay roadWithLane = new RoadDisplayWithLane();
      roadWithLane.draw(); // 기본 도로 표시 + 차선 표시
  }
}
```



차선 표시에 이에 교통량 표시 기능을 추가해 봅니다.

![image-20220515094156687](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/Decorator_pattern.assets/image-20220515094156687.png)

```java
// 기본 도로 표시 + 교통량 표시 클래스
public class RoadDisplayWithTraffic extends RoadDisplay {
   public void draw() {
     super.draw(); // 상위 클래스, 즉 RoadDisplay 클래스의 draw 메서드를 호출해서 기본 도로 표시
     drawTraffic(); // 추가적으로 교통량 표시
   }
   private void drawTraffic() { System.out.println("교통량 표시"); }
}
```

위와 같이 추가 기능만 적게 존재한다면 큰 문제가 생기지 않습니다. 

여기에 더해 교차로 관련 기능을 하나 더 추가해 봅니다.

```java
// 기본 도로 표시 + 교차로 표시 클래스
public class RoadDisplayWithCrossing extends RoadDisplay {
   public void draw() {
     super.draw(); // 상위 클래스, 즉 RoadDisplay 클래스의 draw 메서드를 호출해서 기본 도로 표시
     drawCrossing(); // 추가적으로 교차로 표시
   }
   private void drawCrossing() { System.out.println("교차로 표시"); }
}
```

이 때 `기본도로+ 교차로 + 교통량`을 구현하고 싶다면 해당하는 기능을 아에 추가해야 합니다.



### 문제점

- 여러가지 추가 기능을 조합해야 하는 경우

![image-20220515094645112](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/Decorator_pattern.assets/image-20220515094645112.png)

![image-20220515094948393](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/Decorator_pattern.assets/image-20220515094948393.png)

위의 그림과 같이 조합되는 기능마다 새롭게 클래스를 작성, 구현해야 합니다.



## Decorator Pattern

### 해결책

위의 문제를 해결하기 위해 각 추가 기능별로 개별적인 클래스를 설계, 기능을 조합할 때 각 클래스이 객체 조합을 이용하면 됩니다.

![image-20220515095151283](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/Decorator_pattern.assets/image-20220515095151283.png)



최상단에 `Display`란 추상 클래스를 두고 기본(RoadDisplay)기능을 구현한 기본 클래스와 추가(DisplayDecorator) 기능을 구현한 추상화 클래스를 구현합니다.

- 기본기능(도로표시)만 필요한 경우 RoadDisplay 객체를 사용합니다.
- 차선을 표시하는 추가 기능이 필요한 경우 RoadDisplay와 LaneDecorator 객체를 이용합니다.
  - LaneDecorator에서는 차선 표시 기능만 직접 제공: drawLane()
  - 도로 표시 가능은 RoadDisplay 클래스의 draw 메서드를 호출: super.draw()
    (DisplayDecorator 클래스에서 Display 클래스로의 합성(composition) 관계를 통해 RoadDisplay 객체에 대한 참조)

### 코드

최상단에 `Display` 추상 클래스를 생성합니다.

```java
public abstract class Display { public abstract void draw(); }
```

기본기능인 기본 도로 표시 기능인 `RoadDisplay`를 생성합니다.

```java
/* 기본 도로 표시 클래스 */
public class RoadDisplay extends Display {
  @Override
  public void draw() { System.out.println("기본 도로 표시"); }
}
```

추가기능들을 작성할 수 있는 `DisplayDecorator`를 생성합니다.

```java
/* 다양한 추가 기능에 대한 공통 클래스 */
public abstract class DisplayDecorator extends Display {
  private Display decoratedDisplay;
  // '합성(composition) 관계'를 통해 RoadDisplay 객체에 대한 참조
  public DisplayDecorator(Display decoratedDisplay) {
      this.decoratedDisplay = decoratedDisplay;
  }
  @Override
  public void draw() { decoratedDisplay.draw(); }
}
```



`DisplayDecorator`를 구현하는 `LaneDecorator`와 `TrafficDecorator`를 생성합니다. 

```java
/* 차선 표시를 추가하는 클래스 */
public class LaneDecorator extends DisplayDecorator {
  // 기존 표시 클래스의 설정
  public LaneDecorator(Display decoratedDisplay) { super(decoratedDisplay); }
  @Override
  public void draw() {
      super.draw(); // 설정된 기존 표시 기능을 수행
      drawLane(); // 추가적으로 차선을 표시
  }
  // 차선 표시 기능만 직접 제공
  private void drawLane() { System.out.println("\t차선 표시"); }
}

/* 교통량 표시를 추가하는 클래스 */
public class TrafficDecorator extends DisplayDecorator {
  // 기존 표시 클래스의 설정
  public TrafficDecorator(Display decoratedDisplay) { super(decoratedDisplay); }
  @Override
  public void draw() {
      super.draw(); // 설정된 기존 표시 기능을 수행
      drawTraffic(); // 추가적으로 교통량을 표시
  }
  // 교통량 표시 기능만 직접 제공
  private void drawTraffic() { System.out.println("\t교통량 표시"); }
}
```

- 기본 도로표시
- 기본 도로 표시 + 차선 표시
- 기본 도록 표시 + 교통량 표시

```java
public class Client {
  public static void main(String[] args) {
      Display road = new RoadDisplay();
      road.draw(); // 기본 도로 표시
      Display roadWithLane = new LaneDecorator(new RoadDisplay());
      roadWithLane.draw(); // 기본 도로 표시 + 차선 표시
      Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
      roadWithTraffic.draw(); // 기본 도로 표시 + 교통량 표시
  }
}
```

- 기본 도로표시 + 차선 표시 + 교통량 표시

~~~~java
public class Client {
  public static void main(String[] args) {
  // 기본 도로 표시 + 차선 표시 + 교통량 표시
	Display roadWithLaneAndTraffic =
      new TrafficDecorator(
      new LaneDecorator(
      new RoadDisplay()));
	roadWithLaneAndTraffic.draw();
  }
}
~~~~

이렇게 기능이 추가 될 때마다 하나의 클래스를 생성할 필요 없이 필요한 기능들을 추가, 조합하여 사용하는 Decorator pattern을 활용하면 좋을 듯 합니다. 긴글 읽느라 고생 많으셨습니다. 감사합니다.



### References

https://gmlwjd9405.github.io/2018/07/09/decorator-pattern.html

https://velog.io/@ymsection/%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4-%EC%A0%95%EB%A6%AC-GOF-Decorator-Pattern