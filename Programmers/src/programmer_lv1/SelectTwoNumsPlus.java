package programmer_lv1;

public class SelectTwoNumsPlus {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        // 2,3,4,5,6,7
//        int[] numbers = {5,0,2,7};
        // 2,5,7,9,12
        Solution sol = new Solution();
        sol.solution(numbers);
    }
}
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int sum = 0;
        for(int i=0; i< numbers.length; i++ ){
            for(int j=0; j<numbers.length-(i+1); j++ ){
                sum = i+j;
                if(sum != 1){

                }
            }
        }
        return answer;
    }
}