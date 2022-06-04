package patterns.iterator_design_patterns;

/**
 * packageName :  patterns.iterator_design_patterns
 * fileName : MenuIterator
 * author :  eisen
 * date : 2022/06/04
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/06/04                eisen             최초 생성
 */
public class MenuIterator implements Iterator {

    private Menu menu;
    private int index;

    public MenuIterator(Menu menu) {
        this.menu = menu;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < menu.getLength();
    }

    @Override
    public Object next() {
        Food food = menu.getFoodAt(index);
        index++;
        return food;
    }
}
