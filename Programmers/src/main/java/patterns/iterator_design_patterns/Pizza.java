package patterns.iterator_design_patterns;

/**
 * packageName :  patterns.iterator_design_patterns
 * fileName : Pizza
 * author :  eisen
 * date : 2022/06/04
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/06/04                eisen             최초 생성
 */
public class Pizza extends Food {
    private String name;
    private long price;
    public Pizza(String name, long price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getPrice() {
        return price;
    }
}
