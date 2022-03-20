package leetCode;

import com.tistory.eisen.Eisen;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * packageName :  leetCode
 * fileName : DivideArrayIntoEqualPairs
 * author :  eisen
 * date : 2022/03/20
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/03/20                eisen             최초 생성
 */
public class DivideArrayIntoEqualPairs {
//    [3,2,3,2,2,2]
//    [1,2,3,4]
    public static void main(String[] args) {
//        int[] num = {3,2,3,2,2,2};
        int[] num = {1,2,3,4};
//        (2, 2), (3, 3), and (2, 2)
        test(num);
    }

    public static boolean test(int[] num){
        List<Integer> a = Arrays.stream(num).boxed().collect(Collectors.toList());
        int leng = num.length / 2;

        List<Integer> b = a;
        List<Integer> c = a.stream().filter(value -> b.stream()
                .anyMatch(Predicate.isEqual(value)))
                .collect(Collectors.toList());
        System.out.println("c.toString() = " + c.toString());

        return true;
    }
}
