package programmer_lv1;

import java.util.Arrays;

public class FlipNums {
    public static void main(String[] args) {
        long n = 12345;
//        	[5,4,3,2,1]
        FlipNums flipNums = new FlipNums();
        System.out.println("flipNums = " + Arrays.toString(flipNums.solution(n)));
    }
    public int[] solution(long n) {
        String s = String.valueOf(n);
        int[] result = new int[s.length()];
        int cnt = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            System.out.println(s.charAt(i));
            result[cnt] = Character.getNumericValue(s.charAt(i));
            cnt++;
        }
        return result;
    }
}

