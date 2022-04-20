package patterns.creational_design_patterns.factory_pattern;

/**
 * packageName :  patterns.factory_pattern.after
 * fileName : AnimalFactory
 * author :  eisen
 * date : 2022/04/17
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/17                eisen             최초 생성
 */
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
