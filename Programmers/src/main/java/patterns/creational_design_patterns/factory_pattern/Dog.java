package patterns.creational_design_patterns.factory_pattern;

/**
 * packageName :  patterns.factoryMethod
 * fileName : Dog
 * author :  eisen
 * date : 2022/04/17
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/17                eisen             최초 생성
 */
public class Dog extends Animal{
    @Override
    public void speak() {
        System.out.println("Bark");
    }
}
