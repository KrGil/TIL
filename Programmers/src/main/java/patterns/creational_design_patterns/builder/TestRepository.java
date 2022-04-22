package patterns.creational_design_patterns.builder;

/**
 * packageName :  patterns.creational_design_patterns.builder
 * fileName : TestRepository
 * author :  eisen
 * date : 2022/04/22
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/22                eisen             최초 생성
 */
// interface
//@Repository
public class TestRepository {
    void save(TestEnitity1 entity){
        ;
        System.out.println(String.format("%s 객체가 저장되었습니다.",entity.toString()));
    };
}

