package patterns.creational_design_patterns.builder;

import lombok.Data;

/**
 * packageName :  patterns.creational_design_patterns.builder
 * fileName : InputDTo
 * author :  eisen
 * date : 2022/04/22
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/22                eisen             최초 생성
 */
@Data
public class TestInputDTO1 {
    private int windows;
    private int doors;
    private int rooms;
    private boolean hasGarage;
    private boolean hasSwimPool;
    private boolean hasStatue;
    private boolean hasGarden;
}
