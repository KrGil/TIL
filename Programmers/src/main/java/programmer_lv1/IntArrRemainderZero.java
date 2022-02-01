package programmer_lv1;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntArrRemainderZero {
    public static void main(String[] args) {
        IntArrRemainderZero v = new IntArrRemainderZero();
        int[] arr = {3,2,6};
        int divisor = 10;

    //  arr     	    divisor 	return
    //  [5, 9, 7, 10]	5	        [5, 10]
    //  [2, 36, 1, 3]	1	        [1, 2, 3, 36]
    //  [3,2,6]	        10	        [-1]
        System.out.println(Arrays.toString(v.solution(arr, divisor)));
    }
    public int[] solution(int[] arr, int divisor) {
        return Arrays.stream(arr).sorted().filter(value -> value % divisor == 0).toArray().length > 0 ?
                Arrays.stream(arr).sorted().filter(value -> value % divisor == 0).toArray() : new int[]{-1};
    }
}
