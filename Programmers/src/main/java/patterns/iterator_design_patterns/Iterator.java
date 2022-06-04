package patterns.iterator_design_patterns;

/**
 * packageName :  patterns.iterator_design_patterns
 * fileName : Iterator
 * author :  eisen
 * date : 2022/06/04
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/06/04                eisen             최초 생성
 */
public interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
}
