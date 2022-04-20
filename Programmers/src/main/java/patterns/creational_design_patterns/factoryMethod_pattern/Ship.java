package patterns.creational_design_patterns.factoryMethod_pattern;

/**
 * packageName :  patterns.creational_design_patterns.factoryMethod_pattern
 * fileName : Ship
 * author :  eisen
 * date : 2022/04/17
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/17                eisen             최초 생성
 */
public class Ship implements Transport{
    @Override
    public void deliver() {
        System.out.println("ship");
    }
}
