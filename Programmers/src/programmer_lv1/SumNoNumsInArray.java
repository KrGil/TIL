package programmer_lv1;

import java.util.Arrays;

public class SumNoNumsInArray {
    public static void main(String[] args) {
        //[1,2,3,4,6,7,8,0]	14
        //[5,8,4,0,6,7,9]	6
        int[] numbers = new int[]{5,8,4,0,6,7,9};
        int sum = new SumNoNumsInArray().solution(numbers, 9);
        System.out.println(sum);
    }
    int solution(int[] numbers, int num){
        return  totalSum(num) - totalSumByGivenArray(numbers);
    }
    int totalSum(int num){
        int result = 0;
        for(int i=0; i <= num; i++){
            result += i;
        }
        System.out.println("totalSum: "+result);
        return result;
    }
    int totalSumByGivenArray(int[] numbers){
        int result = 0;
        for(int i=0; i < numbers.length; i++){
            result += numbers[i];
        }
        System.out.println("totalSumByGivenArray: "+result);
        return result;
    }
}
