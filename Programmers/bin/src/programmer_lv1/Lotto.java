package programmer_lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
//        int[] lottos = {0, 0, 0, 0, 0, 0};
//        int[] win_nums = {38, 19, 20, 40, 15, 25};
//        int[] lottos = {45, 4, 35, 20, 3, 9};
//        int[] win_nums = {20, 9, 3, 45, 4, 35};

        int[] result = sol.solution(lottos, win_nums);
        Arrays.stream(result).forEach(System.out::println);
    }

    static class Solution2 {
        public int[] solution(int[] lottos, int[] win_nums) {
            int zeroCnt = 0;
            int cnt = 0;
            for(int lotto : lottos ){
                if(lotto==0){
                    zeroCnt++;
                    continue;
                }
                for (int win_num : win_nums){
                    if(lotto == win_num){
                        cnt++;
                    }
                }
            }
            int[] answer = {getGrade(cnt+zeroCnt), getGrade(cnt)};
            return answer;
        }
        public int getGrade(int n){
            switch (n){
                default:
                    return 6;
                case 2:
                    return 5;
                case 3:
                    return 4;
                case 4:
                    return 3;
                case 5:
                    return 2;
                case 6:
                    return 1;
            }
        }
    }
}


