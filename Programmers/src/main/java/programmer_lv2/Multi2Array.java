package programmer_lv2;

import java.util.Arrays;

public class Multi2Array {
    public static void main(String[] args) {
        Multi2Array multi2Array = new Multi2Array();
        int[][] arr1 = {{1,4},{3,2},{4,1}};
        int[][] arr2 = {{1,2},{3,4}};
        multi2Array.solution(arr1, arr2);
    }
    public int[][] solution(int[][] arr1, int[][] arr2) {
        for (int j = 0; j < arr2.length; j++) {

        }
        int cnt = 0;
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i][0]);
        }
        cnt++;



        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
//                System.out.println(arr1[i][j]);
            }
            System.out.println();
        }

        return new int[1][1];
    }
}
