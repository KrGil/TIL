package programmer_lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class IntSortAsc {
    public static void main(String[] args) {
        System.out.println(new IntSortAsc().solution(1231));
    }
    public long solution(int n) {
        String[] a = String.valueOf(n).split("");
        Arrays.sort(a, Collections.reverseOrder());
        String c = Arrays.toString(a);
        return Long.parseLong(c.replaceAll("[^0-9]", ""));
    }
}
