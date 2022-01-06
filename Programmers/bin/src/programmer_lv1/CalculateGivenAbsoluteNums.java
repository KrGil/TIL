package programmer_lv1;

import java.util.Arrays;

public class CalculateGivenAbsoluteNums {
    public static void main(String[] args) {
        int[] absolutes = new int[]{4, 7, 12};
        boolean[] signs = new boolean[]{true,false,true}; // 9
        CalculateGivenAbsoluteNums sol = new CalculateGivenAbsoluteNums();
        System.out.println(sol.solution(absolutes, signs));

    }
    int solution(int[] absolutes, boolean[] signs){
        int result = 0;
        calIsMinus(absolutes, signs);
        for(int i=0; i < absolutes.length; i++){
            result += absolutes[i];
        }
        return result;
    }
    private int[] calIsMinus(int[] absolutes, boolean[] signs){
        for (int i=0; i < absolutes.length; i++) {
            if(!signs[i]){
                absolutes[i] *= -1;
            }
        }
        return absolutes;
    }

}
