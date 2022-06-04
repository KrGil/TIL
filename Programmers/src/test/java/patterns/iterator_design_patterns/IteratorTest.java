package patterns.iterator_design_patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName :  patterns.iterator_design_patterns
 * fileName : PizzaTest
 * author :  eisen
 * date : 2022/06/04
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/06/04                eisen             최초 생성
 */

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
}