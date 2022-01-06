package programmer_lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

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
        ArrayList<Integer> temp = (ArrayList<Integer>) Arrays.stream(numbers).boxed().collect(Collectors.toList());

        int sum = 0;
        for(int i=0; i< numbers.length; i++ ){
            for(int j=0; j<numbers.length-(i+1); j++ ){
                sum = i+j;
                if(sum != 1){
                    int finalSum = sum;
                    if(Arrays.stream(numbers).anyMatch(a -> a != finalSum)){
                        temp.add(sum);
                    }
                }
            }
        }
        Integer[] temp1 = temp.stream().toArray(Integer[]::new);
        int answer[] = Arrays.stream(temp1).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}