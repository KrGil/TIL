# [pattern]Command pattern

> 디자인패턴 스터디의 마지막인 Command pattern 입니다. 총 5분 중 무려 3분이 ~~(저 포함ㅎㅎ)~~ 블로그를 운영했다는(~~었다~~)는 것을 알게 되었습니다. 다른 분들의 블로그를 구독하고 gitHub도 follow를 할 생각입니다. 
>
> 이번 스터디로 디자인패턴의 많은 부분을 배울 수 있어 아주 좋았습니다. 처음 Factory pattern을 보는데 정말 하나도 이해가 되지 않았었거든요. 지금은 그래도 어느정도 pattern에 대한 개념을 받아 들일 준비 정도는 된 듯 해서 많이 뿌듯합니다.
>
> 앞으로도 계속해서 다양한 스터디를 통해 좀 더 발전하고 다양한 분들을 만나 경험들을 공유할 수 있으면 좋겠습니다

# Command 패턴

커맨드 패턴은 특정 기능들을 캡슐화 시키는 패턴입니다. 보통 매개변수를 이용해서 다양한 기능들을 수행 할 수 있도록 합니다.

예를 들어 `전원을킨다`라는 한가지 기능으로 매개변수를 컴퓨터나 전등으로 받아 다양한 기기들(매개변수)들의 전원을 키는 동작이 가능해집니다. 

커맨드 패턴에서는 크게 **Invoker(이하 인보커, 호출자), Receiver(이하 리시버, 수신자), Command(이하 커맨드, 명령) 객체**로 구분됩니다. 인보커는 기능(Command)의 실행을 요청하고 리시버는 명령을 수행하는 객체입니다.



## 패턴 적용

> Command 패턴의 핵심은 Command interface에 있습니다. 
>
> 매개변수로 받을 Command들( ex) lightsOnCommand)을 모두 Command interface를 상속해 구현합니다.

저는 IOT를 사용하고 있습니다. 거실, 테라스, 화장실의 전등들을 shiri에게 켜고 꺼달라고 합니다.

이걸 예시로 들어보도록 하겠습니다.



## 1. Command 객체 구현

### Command.java

> interface

```java
public interface Command {
    public void execute();
}
```



### RoomLightsOnCommand.java

```java
public class LivingRoomLightsOnCommand implements Command{
    private LivingRoomLights livingRoom;

    public LivingRoomLightsOnCommand(LivingRoomLights livingRoom) {
        this.livingRoom = livingRoom;
    }
    
    @Override
    public void execute() {
        livingRoom.turnOn();
    }
}
```

### TerraceLightsOnCommand.java

```java
public class TerraceLightsOnCommand implements Command{
    private TerraceLights terrace;

    public TerraceLightsOnCommand(TerraceLights terrace) {
        this.terrace = terrace;
    }
    
    @Override
    public void execute() {
        terrace.turnOn();
    }
}
```

### BathRoomLightsOnCommand.java

```java
public class BathRoomLightsOnCommand implements Command{
    private BathRoomLights bathRoom;

    public BathRoomLightsOnCommand(BathRoomLights bathRoom) {
        this.bathRoom = bathRoom;
    }
    
    @Override
    public void execute() {
        bathRoom.turnOn();
    }
}
```

이렇게 완전히 동일한 형태의 3가지 매개변수(커맨드 객체)들을 구현해 주었습니다. 

이제 Command을 받고 수행할 Receiver 객체를 생성해 줍니다.



## 2. Receiver 객체 구현

> Receiver, Command를 입력 받고 이를 수행하는 객체입니다.
>
> 현재 예시에서는 총 3가지로 `LivingRoomLights`, `TerraceLights`,` BathRoomLights` 객체를 구현합니다.



### LivingRoomLights

```java
public class LivingRoomLights {
    public void LivingRoomLights() {}

    public void turnOn() {
        System.out.println("거실 불 켜짐");
    }
}
```

### TerraceLights

```java
public class TerraceLights {
    public void TerraceLights() {}

    public void turnOn() {
        System.out.println("테라스 불 켜짐");
    }
}
```

### BathRoomLights

```java
public class BathRoomLights {
    public void BathRoomLights() {}

    public void turnOn() {
        System.out.println("화장실 불 켜짐");
    }
}
```

Command를 받고 구현할 객체를 만들었으니 Command를 사용할(명령할) 객체를 생성해 봅니다.



## 3. Invoker 객체 구현

> Invoker, Command 객체를 호출(사용)할 객체 입니다.
>
> 저는 shiri를 통해 불들을 켜니 현재 상황에서 Shiri가 Command 객체를 사용합니다.(수작업으로 할 시 Button이 되겠지요!)

```java
public class Shiri {
    private Command command;

    public Shiri(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void order() {
        this.command.execute();
    }
}
```

이제 모든 준비는 끝났습니다. 실제 client에서 사용하는 main을 생성해 줍니다.

## Client

```java
public class Client{
    public static void main(String[] args) {
      	// Receiver 객체
        LivingRoomLights livingRoom = new LivingRoomLights();	
      	TerraceLights terrace = new TerraceLights();	
      	BathRoomLights bathRoom = new BathRoomLights();	

				// Command 객체
        LivingRoomLightsOnCommand livingRoomCmd = new LivingRoomLightsOnCommand(livingRoom);
        TerraceLightsOnCommand terraceCmd = new TerraceLightsOnCommand(terrace);
				BathRoomLightsOnCommand bathRoomCmd = new BathRoomLightsOnCommand(bathRoom);
      
      	// Invoker 객체
        Shiri shiri = new Shiri(livingRoomCmd);	
        shiri.order();
        shiri.setCommand(terraceCmd);
        shiri.order();
      	shiri.setCommand(bathRoomCmd);
        shiri.order();
      	
    }
}
```



- 실행 결과: 

![image-20220625011858345](/Users/Eisen/Documents/GitHub/TIL/CS/Pattern/command_pattern.assets/image-20220625011858345.png)



이렇게 Command 패턴을 적용시킨 예시를 한번 구현해 보았습니다.

위의 사례를 Command 패턴을 적용시키지 않고(Invoker, Receiver) 하나의 객체로 사용하게 된다면 매개변수(LivingRoomLights, TerraceLights, BathRoomLights ...)들이 변경 될 때마다 내부 코드를 수정해 주어 OCP를 위반하게 됩니다. 

만약 이처럼 하나의 기능을 공통적으로 사용되게 될 시에 Command 패턴을 고려한 후 사용하는 것이 좋을 듯 합니다

긴 글 읽느라 고생하셨습니다. 감사합니다



### References

https://gmlwjd9405.github.io/2018/07/07/command-pattern.html

https://bamtory29.tistory.com/entry/%EC%BB%A4%EB%A7%A8%EB%93%9C-%ED%8C%A8%ED%84%B4-Command-Pattern