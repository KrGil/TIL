package leetCode;

import java.util.HashMap;

public class Two_sum {
    public static void main(String[] args) {
        Two_sum two_sum = new Two_sum();
        int[] nums = {3, 2, 4};

        two_sum.twoSum(nums, 6);
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            int result = target - nums[i];
            System.out.println("nums[i] = " + nums[i]);
            for (int key : resultMap.keySet()) {
                System.out.println("key = " + key);
                System.out.println("resultMap.get(key) = " + resultMap.get(key));
                System.out.println();
            }
            if (resultMap.containsKey(result)) {
                System.out.println("true");
                return new int[]{resultMap.get(result), i};
            }
            resultMap.put(nums[i], i);
        }
        return null;

    }
}
