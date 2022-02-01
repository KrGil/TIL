package programmer_lv1;

import java.util.Arrays;

public class xAndN {
    public static void main(String[] args) {
        xAndN xAndN = new xAndN();
        xAndN.solution(-4, 2);
    }
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int cnt =0;
        for (long i = x; cnt < answer.length; i+=x) {
            answer[cnt] = i;
            cnt++;
        }
        return answer;
    }

}
