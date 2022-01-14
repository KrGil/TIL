package leetCode;

import java.lang.invoke.DelegatingMethodHandle$Holder;
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
        }
        return nums;
    }
}
