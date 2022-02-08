package programmer_lv1;

import java.util.Arrays;

public class SumOfDivisor {
    public static void main(String[] args) {
        SumOfDivisor sd = new SumOfDivisor();
        System.out.println("sd = " + sd.solution(12));
    }
    public int solution(int n){
        int sum = 0;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum+n;
    }
}
