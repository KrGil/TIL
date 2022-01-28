package baeckjoon;

import java.util.Scanner;

public class Pibonachi {
    public static void main(String[] args) {
        Pibonachi pibonachi = new Pibonachi();
        System.out.println("pibonachi.solution(17) = " + pibonachi.solution(50));
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
    }
    public int solution(int n){
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = (result[i - 1] + result[i - 2])%123456;
        }
        return result[n]*123456;
    }
}
