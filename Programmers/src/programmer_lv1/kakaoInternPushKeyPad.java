package programmer_lv1;

import java.util.Arrays;

public class kakaoInternPushKeyPad {
	public static void main(String[] args) {
        System.out.print(1 / 3);
        // number-1 
        // 0, 0, 0
        // 1, 1, 1
        // 2, 2, 2

        System.out.print(6 % 3);
        // number-1
        // 0 ,1, 2
        // 0 ,1, 2
	}
    public String solution(int[] numbers, String hand) {
    }
    // number = 1이면 1,1
    // number = 4이면 2,1
    // number = 7이면 3,1
    public int[][] showArray(int number){
        number = number-1;
        int i = 0;
        int j = 0;

        i = number / 3;
        j = number % 3;
        return int[i][j];
    }
    public int showArrayi(int number){
        return number / 3;
    }
    public int showArrayJ(int number){
        return number % 3;
    }
    public int calculateDistance(){

    }
}
