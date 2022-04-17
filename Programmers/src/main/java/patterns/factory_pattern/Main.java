package patterns.factory_pattern;

/**
 * packageName :  patterns.factoryMethod
 * fileName : ProcessRun
 * author :  eisen
 * date : 2022/04/17
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/17                eisen             최초 생성
 */
public class Main {
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
        /*
            Fn으로 구현 시
         */
//        Main run = new Main();
//
//        Animal cat = run.FactoryFn(AnimalType.CAT);
//        cat.speak();
//        Animal dog = run.FactoryFn(AnimalType.DOG);
//        dog.speak();
//        Animal animal = run.FactoryFn(AnimalType.NONE);
//        animal.speak();
        /*
            class object로 구현 시
         */
        AnimalFactory animalFactory = new AnimalFactory();
        Animal cat = animalFactory.create(AnimalType.CAT);
        cat.speak();
        Animal dog = animalFactory.create(AnimalType.DOG);
        dog.speak();
        Animal animal = animalFactory.create(AnimalType.NONE);
        animal.speak();
    }

}
