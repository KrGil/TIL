package patterns.creational_design_patterns.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * packageName :  patterns.creational_design_patterns.builder
 * fileName : BuilderHouse
 * author :  eisen
 * date : 2022/04/22
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/22                eisen             최초 생성
 */
@AllArgsConstructor
@Builder
public class BuilderHouse {
    private int windows;
    private int doors;
    private int rooms;
    private boolean hasGarage;
    private boolean hasSwimPool;
    private boolean hasStatue;
    private boolean hasGarden;
}
