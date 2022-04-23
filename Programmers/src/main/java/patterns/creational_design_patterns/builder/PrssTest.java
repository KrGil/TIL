package patterns.creational_design_patterns.builder;

/**
 * packageName :  patterns.creational_design_patterns.builder
 * fileName : ProccessTest
 * author :  eisen
 * date : 2022/04/22
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/22                eisen             최초 생성
 */
public class PrssTest {
    public static void main(String[] args) {
        TestInputDTO1 inputDTO = new TestInputDTO1();
        inputDTO.setDoors(4);
        inputDTO.setHasGarden(true);

        TestEnitity1 entity = TestEnitity1.builder()
                .doors(inputDTO.getDoors())
                .hasGarden(inputDTO.isHasGarden())
                .build();

        TestRepository repo = new TestRepository();

        repo.save(entity);

        BuilderHoustWithNoLombok b = new BuilderHoustWithNoLombok.Builder()
                .build() ;
        System.out.println(b.toString());

        TT tt = new TT();
        tt.getA();


        System.out.println(tt.getA());
    }
    public static class TT{
        int a;
        public int getA(){
            return a;
        }
    }
}
