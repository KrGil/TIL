package patterns.factory_pattern.after;

/**
 * packageName :  patterns.factoryMethod
 * fileName : Cat
 * author :  eisen
 * date : 2022/04/17
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/17                eisen             최초 생성
 */
public class Cat extends Animal {
    @Override
    public void speak() {
        System.out.println("Meow");
    }
}
