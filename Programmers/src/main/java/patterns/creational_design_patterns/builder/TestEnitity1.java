package patterns.creational_design_patterns.builder;

import lombok.Builder;

/**
 * packageName :  patterns.creational_design_patterns.builder
 * fileName : TestEnitity1
 * author :  eisen
 * date : 2022/04/22
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/22                eisen             최초 생성
 */
@Builder
public class TestEnitity1 {
    private int windows;
    private int doors;
    private int rooms;
    private boolean hasGarage;
    private boolean hasSwimPool;
    private boolean hasStatue;
    private boolean hasGarden;

    @Override
    public String toString() {
        return "TestEnitity1{" +
                "windows=" + windows +
                ", doors=" + doors +
                ", rooms=" + rooms +
                ", hasGarage=" + hasGarage +
                ", hasSwimPool=" + hasSwimPool +
                ", hasStatue=" + hasStatue +
                ", hasGarden=" + hasGarden +
                '}';
    }
}
