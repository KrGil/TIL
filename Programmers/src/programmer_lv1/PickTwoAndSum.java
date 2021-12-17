package programmer_lv1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PickTwoAndSum {
    public static void main(String[] args) {
        PickTwoAndSum result = new PickTwoAndSum();
//        [2,1,3,4,1]	[2,3,4,5,6,7]
//        [5,0,2,7]	[2,5,7,9,12]
        int[] numbers = {2,1,3,4,1};
        System.out.println("result = " + Arrays.toString(result.solution(numbers)));
    }
    public int[] solution(int[] numbers) {
        TreeSet<Integer> answer = new TreeSet();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }
//        Collections.sort(answer);
        return answer.stream().mapToInt(v -> (int)v).toArray();
    }

    public int sumArr(){
        return 0;
    }
}
