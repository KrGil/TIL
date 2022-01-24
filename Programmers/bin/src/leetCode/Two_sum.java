package leetCode;

import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;

public class Two_sum {
    public static void main(String[] args) {
        Two_sum two_sum = new Two_sum();
        int[] nums = {3, 2, 4};

        System.out.println("result = " + two_sum.twoSum(nums, 6));
    }

    //    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> resultMap = new HashMap<>();
//        for(int i=0; i< nums.length; i++){
//            int result = target - nums[i];
//            if (resultMap.containsKey(result)) {
//                return new int[]{resultMap.get(result), i};
//            }
//            resultMap.put(nums[i], i);
//        }
//        return null;
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{ map.get(result), i};
            }
            map.put(result, i);
        }
        return null;
    }
}
