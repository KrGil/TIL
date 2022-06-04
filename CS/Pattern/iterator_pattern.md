# [pattern] Iterator Pattern

> 해당 글은 여러 블로그에서 보고 정리한 글입니다. 아래 Refences란에 참조한 블로그 주소들이 존재합니다. 

# 이터레이터 패턴

기본표현을 노출시키지 않고 컬렉션 객체들(리스트, 큐, 스택, 트리 ...)의 요소를 순회할 수 있는 행동 디자인패턴입니다.

아래와 같이 이터레이터 내에도 여러 종류가 있습니다.

![image-20220604105832105](/Users/eisen/Documents/Github/TIL/CS/Pattern/iterator_pattern.assets/image-20220604105832105.png)

## When?

- 다른 자료구조(컬렉션)를 하나씩 조회해보고 싶을 시 각자 다른 루프를 돌려야 합니다.
- 이터레이터 패턴을 적용할 시 반복되는 자료구조는 다형적으로 사용 가능합니다.
- ~~사실 이렇게 작성했지만 여전히 어쩔 때 쓰이는지 잘 모르겠네요... ㅠㅠ~~

```java
int[] arr = {1,2,3,4,5};

List list = Arrays.stream(arr).boxed().collect(Collectors.toList());
for (int i = 0; i < arr.length; i++) {
  System.out.println(arr[i]);
}
for (int i = 0; i < arr.length; i++) {
  System.out.println(list.get(i));
}
```



## Iterator 패턴 구조

![image-20220604231337363](/Users/eisen/Documents/Github/TIL/CS/Pattern/iterator_pattern.assets/image-20220604231337363.png)

- Aggregate: Iterator 역할을 만들어내는 인터페이스 정의
- Iterator: 요소를 순서대로 검색해가는 인터페이스 정의
- ConcreateAggregate: Aggregate가 정의한 인터페이스를 구현
- ConcreateIterator: Iterator가 정의한 인터페이스를 구현



## 사용 예제

> 치킨과 피자 두가지 음식의 종류들에 대해 Iterator 패턴을 적용시킨 예제를 구현해 보겠습니다.



![image-20220604231200252](/Users/eisen/Documents/Github/TIL/CS/Pattern/iterator_pattern.assets/image-20220604231200252.png)



### Aggregate

~~~java
public interface Aggregate {
    public abstract Iterator iterator();
}
~~~

### Menu

```java
public class Menu implements Aggregate {
    private Food[] foods;
    private int last = 0 ;

    public Menu(int maxsize) {
        this.foods = new Food[maxsize];
    }

    public Food getFoodAt(int index) {
        return foods[index];
    }

    public void addFood(Food food) {
        this.foods[last] = food;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new MenuIterator(this);
    }
}
```



### Food

```java
public abstract class Food {
    public abstract String getName();
    public abstract long getPrice();
}

```

### Chicken

```java
public class Chicken extends Food {
    private String name;
    private long price;
    public Chicken(String name, long price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getPrice() {
        return price;
    }
}
```

### Pizza

```java
public class Pizza extends Food {
    private String name;
    private long price;
    public Pizza(String name, long price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getPrice() {
        return price;
    }
}

```





### Iterator

```java
public interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
}
```

### MenuIterator

```java
public class MenuIterator implements Iterator {

    private Menu menu;
    private int index;

    public MenuIterator(Menu menu) {
        this.menu = menu;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < menu.getLength();
    }

    @Override
    public Object next() {
        Food food = menu.getFoodAt(index);
        index++;
        return food;
    }
}
```



## Test

```java
class IteratorTest {
    @Test
    public void 치킨_피자_메뉴_확인 () {
        Menu menuByChicken = new Menu(5);
        menuByChicken.addFood(new Chicken("후라이드치킨", 16000));
        menuByChicken.addFood(new Chicken("양념치킨", 17000));
        menuByChicken.addFood(new Chicken("간장치킨", 17000));
        menuByChicken.addFood(new Chicken("고추바사삭", 17000));
        menuByChicken.addFood(new Chicken("뿌링클", 17000));

        Menu menuByPizza = new Menu(3);
        menuByPizza.addFood(new Pizza("불고기피자", 23000));
        menuByPizza.addFood(new Pizza("슈퍼슈프림피자", 24000));
        menuByPizza.addFood(new Pizza("페퍼로니피자", 19000));

        Iterator it = menuByChicken.iterator();
//        Iterator it = menuByPizza.iterator();
        while(it.hasNext()) {
            Food food = (Food)it.next();
            System.out.println("메뉴명 : " + food.getName() + " | 가격 : " + food.getPrice());
        }
    }
```

![image-20220605000301690](/Users/eisen/Documents/Github/TIL/CS/Pattern/iterator_pattern.assets/image-20220605000301690.png)

이렇게 Iterator 패턴을 구현할 수 있습니다. 실제 코드의 경우 아래의 링크를 참조해 주시기 바랍니다.





## 번외

### Iterator vs Enumeration

Iterator는 remove() 메소드가 존재합니다.

삭제할 일이 없이 안전하게 구현하고 싶다면 Enumeration을 사용하지만 보통 프로그램의 요구사항이 어떻게 변할 지 예측하기 힘들기에 Iterator를 선호하는 듯 합니다.









## References

https://yiyj1030.tistory.com/402

https://blog.naver.com/bluenara/221685287446

https://jjjayyy.tistory.com/106