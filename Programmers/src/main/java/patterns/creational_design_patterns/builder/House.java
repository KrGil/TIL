package patterns.creational_design_patterns.builder;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;

/**
 * packageName :  patterns.creational_design_patterns.builder
 * fileName : House
 * author :  eisen
 * date : 2022/04/22
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/22                eisen             최초 생성
 */
@AllArgsConstructor
public class House {
    private int windows;
    private int doors;
    private int rooms;
    private boolean hasGarage;
    private boolean hasSwimPool;
    private boolean hasStatue;
    private boolean hasGarden;
}
