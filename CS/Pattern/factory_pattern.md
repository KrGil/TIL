# [pattern]Factory pattern

> 프로그래밍을 시작한지 어느덧 1년이 넘었네요. 그렇지만 제대로된 디자인 패턴에 대한 공부를 해본 적이 없다는 생각이 들어 스터디를 시작하게 되었습니다. 그 중 첫주제인 factoryMethod pattern을 공부하려다 보니 factory pattern이 다양한 pattern(Singleton, Builder)의 base가 되더군요. 그래서 factory pattern에 대해 우선적으로 정리를 하려고 합니다.

들어가기에 앞서 추상클래스와 추상메서드에 대해 알고 가면 이해하기 조금 더 편할 듯 합니다.

정리한 코드가 보고싶으신 분은 아래 링크를 확인해 주세요.

> GitHub: [Factory pattern 패키지](https://github.com/KrGil/TIL/tree/main/Programmers/src/main/java/patterns/factory_pattern)

# Factory pattern

> Client 측에서 factory를 통해 간단하게 원하는 Object(Cat, Dog)를 생성할 수 있습니다. 뒤의 Object(Cat, Dog)와 같은 객체들의 생성 과정을 알지 못해도 되죠.

![image-20220417133824314](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/factory_pattern.assets/image-20220417133824314.png)

*출처: [Design pattern, Factory Pattern, 디자인패턴, 팩토리패턴: 코드없는 프로그래밍](https://www.youtube.com/watch?v=AmwEIt0vhxA)*

위의 이미지와 같이 고양이(Cat), 개(Dog)를 호출하는 프로그램을 구현한다고 가정했을 때 factory 객체를 사용해 client에서 어떻게 고양이와 개와 같은 객체를 구현하는지 알 필요 없게 캡슐화 시킵니다. 따라서 client는 factory 객체에게 `고양이를 생성하라`,`개를 생성하라` 라는 메시지만 던져주면 됩니다. (`what`만 넘기고 `how`는 전달하지 않게 되죠.)



## Code

### Tree Structure

````
Factory
 - Animal
 - Cat
 - Dog
 - Main
````

![image-20220417140227121](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/factory_pattern.assets/image-20220417140227121.png)

### Animal.java

abstract class를 생성해서 개(Dog), 고양이(Cat)이 상속(extends) 할 수 있도록 구현해 보았습니다.

```java
public abstract class Animal {
    public void speak() {
        System.out.println("짖는다.");
    }
}
```

### Dog.java, Cat.java

Animal이라는 abstract class를 상속받는 두 class를 구현했습니다.

```java
public class Dog extends Animal{
    @Override
    public void speak() {
        System.out.println("Bark");
    }
}

```

```java
public class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Meow");
    }
}
```

### AnimalType.java

```java
public enum AnimalType{
  CAT("cat"), DOG("dog"), NONE("none");

  private final String value;
  animalType(String value) {
    this.value = value;
  }
  public String getValue(){
    return value;
  }

}
```



## ClassObject

> AnimalFactory class를 생성 후 factory 객체를 호출해서 사용합니다.

### AnimalFactory.java

```java
public class AnimalFactory {
    public Animal create(AnimalType type){
        if("cat".equals(type.getValue())){
            return new Cat();
        }else if("dog".equals(type.getValue())){
            return new Dog();
        }else {
            return new Animal() {
                @Override
                public void speak() {
                    super.speak();
                }
            };
        }
    }
}
```

### Main.java

```java
 AnimalFactory animalFactory = new AnimalFactory();
        Animal cat = animalFactory.create(AnimalType.CAT);
        cat.speak();
        Animal dog = animalFactory.create(AnimalType.DOG);
        dog.speak();
        Animal animal = animalFactory.create(AnimalType.NONE);
        animal.speak();
```

이렇게 client는 factory 내부에 어떻게 구현되어 있는지 알 필요 없이 `cat 객체를 생성하라`는 `message`만을 넘기면 됩니다.



## Function

> 함수형으로 구현을 해 보았습니다. java에서는 Class로 대부분 표현합니다만... class와 fn형태가 있다고 해서 억지스럽게라도 한번 구현해 보았습니다.(호출 부분에 FactoryFn이라는 메소드를 생성한 것 뿐입니다...)

### Main.java 

해당 부분에서 호출과 FactoryMethod()라는 메소드를 생성해서 함수처럼 구현해 보았습니다.

input을 String으로 받을 경우와 enum으로 받을 경우로 나누어 보았습니다. 보통 구현 시 enum으로 구현하는것을 권장합니다.

```java
public class Main {
  /*
  	input을 String으로 받았을 경우
  */
    public Animal FactoryFn(String str){
        if("cat".equals(str)){
            new Cat().speak();
        } else if ("dog".equals(str)) {
            new Dog().speak();
        } else{
            return new Animal() {
                @Override
                public void speak() {
                    super.speak();
                }
        		};
        }
    }
    public static void main(String[] args) {
				Main run = new Main();
        Animal cat = run.FactoryFn("cat");
        cat.speak();
        Animal dog = run.FactoryFn("dog");
        dog.speak();
        Animal animal = run.FactoryFn("none");
        animal.speak();
    }
  
  /*
  	input을 enum으로 받았을 경우(prefer)
  */
   public Animal FactoryFn(AnimalType type){
        if(("cat").equals(type.getValue())){
            return new Cat();
        } else if (("dog").equals(type.getValue())) {
            return new Dog();
        } else{
            return new Animal() {
                @Override
                public void speak() {
                    super.speak();
                }
            };
        }
    }

    public static void main(String[] args) {
        Main run = new Main();

        Animal cat = run.FactoryFn(AnimalType.CAT);
        cat.speak();
        Animal dog = run.FactoryFn(AnimalType.DOG);
        dog.speak();
        Animal animal = run.FactoryFn(AnimalType.NONE);
        animal.speak();
    }
}
```

## Result

![image-20220417143035911](https://raw.githubusercontent.com/KrGil/TIL/main/CS/Pattern/factory_pattern.assets/image-20220417143035911.png)

결과가 잘 출력되는 것을 알 수 있습니다. 

factory 패턴은 `factory methood`, `singleton`, `builder`등 다양한 패턴에서 기본적으로 사용된다고 하여 한번 정리해 보았습니다.

긴 글 읽어 주셔서 감사합니다. 혹여 해당 글이 저작권 문제가 된다면 바로 조치하도록 하겠습니다.



### References

추상클래스, 추상메서드

https://limkydev.tistory.com/188

factory pattern

https://www.youtube.com/watch?v=AmwEIt0vhxA