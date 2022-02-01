package programmer_lv1;

import java.util.ArrayList;
import java.util.Arrays;

public class NumsOfPrimeNum {
    public static void main(String[] args) {
//        [1,2,3,4]	1
//        [1,2,7,6,4]	4
//        int[] nums = new int[]{1,2,3,4};
        int[] nums = new int[]{1, 2, 7, 6, 4};
        NumsOfPrimeNum num = new NumsOfPrimeNum();
        System.out.println("sumList: "+ num.sumList(nums).toString());
        System.out.println("solution: "+num.solution(nums));

    }
    public int solution(int[] nums) {
        return primeCnt(sumList(nums));
    }

    public ArrayList<Integer> sumList(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        // 모든 합 경우의 수
        for(int i=0; i< nums.length; i++){
            if (i + 2 >= nums.length) break; // j와 k가 out of bounds exception을 안일으키게하기위해
            for(int j=i+1; j< nums.length; j++){
                for(int k=j+1; k< nums.length; k++){
                    list.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        return list;
    }

    public int primeCnt(ArrayList<Integer> list){
        int answer = 0;
        for (Integer i : list) {
            if(isPrime(i)) answer++;
        }
        return answer;
    }
    public boolean isPrime(int num){
        int cnt =0;
        for(int i=1; i < num; i++){
            if(num % i==0){
                cnt++;
            }
        }
        return cnt <= 1 ? true : false;
    }
}
