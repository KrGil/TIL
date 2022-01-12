package programmer_lv1;

import java.util.Arrays;

public class ArrAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.stream(arr).average().getAsDouble());
        String a = "asdf";
        char[] d = a.toCharArray();

        String[] b  =a.split("");
        System.out.println("b = " + d.toString());
    }

}
