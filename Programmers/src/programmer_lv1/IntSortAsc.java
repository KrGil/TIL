package programmer_lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class IntSortAsc {
    public static void main(String[] args) {
        new IntSortAsc().solution(1231);
    }
    public int solution(int n) {
        String[] a = String.valueOf(n).split("");

        Arrays.sort(a, Collections.reverseOrder());
        int[] b = Arrays.stream(a).mapToInt(v -> Integer.parseInt(v)).toArray();
        int c = Arrays.toString(b);
        System.out.println(Arrays.toString(b));

        return n;
    }
}
