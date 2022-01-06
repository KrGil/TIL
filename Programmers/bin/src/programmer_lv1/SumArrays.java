package programmer_lv1;

import java.util.Arrays;

public class SumArrays {
    public static void main(String[] args) {
//                제한 조건
//        행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
//                입출력 예
//        arr1	        arr2	        return
//      [[1,2],[2,3]}   [[3,4],[5,6]]	[[4,6],[7,9]]
//      [[1],[2]]   	[[3],[4]]	    [[4],[6]]
        int [][] arr1 = {{1,2}, {2,3}};
        int [][] arr2 = {{3,4}, {5,6}};
        SumArrays arr = new SumArrays();
        for (int[] result : arr.solution(arr1, arr2)) {
            System.out.println(Arrays.toString(result));
        }
    }

    public int[][] solution(int[][] arr1, int[][] arr2){
        for (int i =0; i < arr1.length; i++) {
            for (int j=0; j < arr1[i].length; j++) {
                System.out.println("arr1[i][j] : "+arr1[i][j] + " arr2[i][j] : "+arr2[i][j]);
                arr1[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return arr1;
    }
}

