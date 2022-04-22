package patterns.creational_design_patterns.builder;

/**
 * packageName :  patterns.creational_design_patterns.builder
 * fileName : BuildingHouse
 * author :  eisen
 * date : 2022/04/22
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/22                eisen             최초 생성
 */
public class BuildingHouse {
    public static void main(String[] args) {

        // 창문 4개, 문 2개, 방 4개 기본적인 집
//        House house = new House(4,2, 4,
//                false, false, false, false);
//
//        // 창문 4개, 문 2개, 방 4개 차고가 있는 집
//        House houseWithGarage = new House(4,2, 4,
//                true, false, false, false);

        BuilderHouse house = BuilderHouse.builder()
                .doors(4)
                .hasGarage(true)
                .build();


        System.out.println(house.toString());
    }
}
