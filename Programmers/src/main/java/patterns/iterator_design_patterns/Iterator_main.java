package patterns.iterator_design_patterns;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName :  patterns.iterator_design_patterns
 * fileName : Iterator_main
 * author :  eisen
 * date : 2022/06/04
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/06/04                eisen             최초 생성
 */
public class Iterator_main {
    public static void main(String[] args) {

        // Iterator를 쓰지 않은 예
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
        }

        // Iterator가 필요한 상황
        int[] arr = {1,2,3,4,5};

        List list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(list.get(i));
        }


    }
}
