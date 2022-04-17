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
    public Animal FactoryMethod(String str){
        if(str.equals("cat")){
            return new Cat();
        } else if (str.equals("dog")) {
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
        run.FactoryMethod("cat").speak();
        run.FactoryMethod("dog").speak();
        run.FactoryMethod("none").speak();
    }
}
