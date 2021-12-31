package programmer_lv2;

import java.util.Arrays;

public class StockRate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3};
        // return [4,3,1,1,0]
        StockRate stockRate = new StockRate();
        System.out.println(Arrays.toString(stockRate.solution(arr)));
    }
    public int[] solution(int[] arr) {
        int totalFor = arr.length;
        for (int i = 0; i < arr.length; i++) {
            totalFor--;
            int cnt =0;
            for (int j = i+1; j < arr.length; j++) {
                cnt++;
                if (arr[i] > arr[j]) {
                    arr[i] = cnt;
                    break;
                }
            }
            if (totalFor == cnt) {
                arr[i] = cnt;
            }
        }
        return arr;
    }
}
