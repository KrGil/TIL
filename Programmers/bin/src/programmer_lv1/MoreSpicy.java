package programmer_lv1;

import java.util.Arrays;

public class MoreSpicy {
    public static void main(String[] args) {
//    [1, 2, 3, 9, 10, 12]	7	2
        int[] scoville = {2, 1, 3, 9, 10, 12};
        int result = new MoreSpicy().solution(scoville, 7);
        System.out.println("result = " + result);
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        for(int i=0; i < scoville.length; i++){

            scoville[i] += scoville[i+1]*2;
            Arrays.sort(scoville);
            if(i == 0) break;
        }
        System.out.println(Arrays.toString(scoville));
        return answer;
    }
}
