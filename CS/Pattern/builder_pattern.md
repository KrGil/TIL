# [pattern]Builder pattern

> builder 패턴을 예전에도 몇번 들어보긴 했지만 관심있게 살펴 본 것은 한두달? 전으로 오래되지 않았네요. 저는 builder 패턴이란 개념이 익숙해지기까지 한달 정도의 시간이 걸린 듯 합니데ㅠㅠ(~~바보...~~) 시간날때 짬짬이 검색해 보고 모르는 부분을 주변에 물어가면서 조금씩 익숙해 진 듯 합니다. 처음에는 전혀 이해가 되지 않아 참 고생을 많이 했었는데 말이죠!! 회사에서도 직접 써보고 (~~builder 패턴 작성을 회사에서 오늘 처음 해본건 비밀ㅎㅎ~~) 몇번 보다보니 슬슬 익숙해 져서 글을 작성해서 정리해 보려고 합니다. 부족한 부분이 있다면 바로바로 수정 반영하도록 하겠습니다~

# 발단

![image-20220422222218145](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/builder_pattern.assets/image-20220422222218145.png)

*출처: https://refactoring.guru/design-patterns/builder*

위의 이미지와 같이 하나의 클래스(House)로 다양한 객체(HouseWithGrage, HouseWithSwimmingPool...)들을 생성한다고 생각해 봅니다.



## 일반적인 객체 생성

![image-20220422221143405](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/builder_pattern.assets/image-20220422221143405-0633113.png)

*출처: https://refactoring.guru/design-patterns/builder*

위의 이미지처럼 조건(창문, 문, 방,,,)들이 많이질 수록 먼가 길어지면서 알아보기 힘들어지네요. 한번 코드로 작성해 보았습니다.

### 코드

```java
@AllArgsConstructor
public class House {
    private int windows;
    private int doors;
    private int rooms;
    private boolean hasGarage;
    private boolean hasSwimPool;
    private boolean hasStatue;
    private boolean hasGarden;
}

```

````java
// 창문 4개, 문 2개, 방 4개 기본적인 집
House house = new House(4, 2, 4,false, false, false, false);
	
// 창문 4개, 문 2개, 방 4개 차고가 있는 집
House houseWithGarage = new House(4, 2, 4, true, false, false, false);

````

매개변수(조건)들이 추가될 때마다 코드가 흉측하게 변해갑니다. 이 흉측한 코드를 bulider패턴을 활용하여 간결하게 바꿔 봅니다.



## Builder 패턴 객체 생성

![image-20220422224225322](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/builder_pattern.assets/image-20220422224225322.png)

이미지와 같이 파트들을 하나씩 나눠서 객채 생성(호출) 시 조립하는 방법입니다.



### builder패턴 적용 후 코드(lombok)

````java
@Builder
@AllArgsConstructor
public class House {
    private int windows;
    private int doors;
    private int rooms;
    private boolean hasGarage;
    private boolean hasSwimPool;
    private boolean hasStatue;
    private boolean hasGarden;
}
````

```java
// 창문 0개, 문 4개, 방 0개 차고만 존재하는 집
BuilderHouse house = BuilderHouse.builder()
        .doors(4)
        .hasGarage(true)
        .build();
```

![image-20220422223856792](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/builder_pattern.assets/image-20220422223856792.png)

*lombok을 사용하지 않는 코드는 아래에 작성하도록 하겠습니다.*



## 장점

> 1. 필요한 데이터만 설정 가능
>
> 2. 가독성이 높음
>
> 3. 스펙 변경에 대처가 용이
>
> 4. 변경 가능성을 최소화할 수 있음

### 1, 2

```java
// 창문 4개, 문 2개, 방 4개 기본적인 집
House house = new House(4, 2, 4,false, false, false, false);
```

```java
// 창문 4개, 문 2개, 방 4개 기본적인 집
BuilderHouse house = BuilderHouse.builder()
        .windows(4)
  			.doors(2)
  			.rooms(4)
        .build();
```



### 3. 스펙 변경에 대처가 용이

물론 이런 일이 발생하면 안되지만 사실 종종 발생하는 경우입니다.

아래와 같이 기존 방법으로 개발을 완료했는데 조금 화나지만 클라이언트가 갑자기 화장실 개수가 표시되는 객체가 있으면 좋겠으니 화장실 개수 조건을 추가하고 싶다고 이야기 합니다.

```java
// asis
House house = new House(4, 2, 4,false, false, false, false);

// tobe
House house = new House(4, 2, 4, 2, false, false, false, false);
```

이럴 경우 하나의 구현 객체가 존재하면 다행입니다만... 만약 이미 구현해 놓은 코드가 100여개가 된다면 어떻게 될까요??

```java
public void t1(){
	// tode asis -> tobe
	House house = new House(4, 2, 4,false, false, false, false);
}
public void t2(){
	// tode asis -> tobe
	House houseWithGarden = new House(4, 2, 4,false, false, false, true);
}
...
public void t128(){
	// tode asis -> tobe
	House house = new House(4, 2, 4,false, false, false, false);
}

```

하나하나 찾아가며 수정을 해야겠지요.

**But** 이럴 경우 `builder 패턴`으로 구현된 객체들은 따로 손을 댈 필요가 없으니 스펙 변경에 대처하기 좋다고 할 수 있습니다.



### 4. 변경 가능성을 최소화 할 수 있습니다. 

setter를 사용하지 않고 객체를 생성하게 되여 객체 생성 이후 객체 내부의 값을 임의로 변경하기 어렵습니다. 

불변 갸능성이 낮은 객체를 사용해야 하는 이유에 대해선 [여기](https://mangkyu.tistory.com/131) 해당 블로그를 참고해 주세요.



## 빌더 패턴을 사용하지 않아도 되는 경우

- 객체의 생명주기를 개발자가 관리하지 않을 경우(MapStruct)
- 변수의 개수가 2개 이하이며, 변경 가능성이 없는 경우



## *참고

### lombok을 사용하지 않고 builder 패턴 객체 생성.

### 코드

```java
public class BuilderHoustWithNoLombok {
    private int windows;
    private boolean hasGarden;

    public static class Builder{
        private int windows;
        private boolean hasGarden;

        public Builder windows(int windows) {
            this.windows = windows;
            return this;
        }

        public Builder hasGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }
        public BuilderHoustWithNoLombok build(){
            return new BuilderHoustWithNoLombok(this);
        }

    }
   private BuilderHoustWithNoLombok(Builder builder){
        this.windows = builder.windows;
        this.hasGarden = builder.hasGarden;
   }

   public void updateWindows(int windows){
        this.windows = windows;
   }

```





### References

https://refactoring.guru/design-patterns/builder

 https://mangkyu.tistory.com/163 [MangKyu's Diary]

불변 객체

https://mangkyu.tistory.com/131

