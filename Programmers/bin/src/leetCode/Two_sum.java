package leetCode;

public class Two_sum {
    public static void main(String[] args) {
        Two_sum two_sum = new Two_sum();
        int[] nums = {3, 2, 4};

        two_sum.twoSum(nums, 6);
    }
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i< nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                System.out.println("i = " + j);
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }
}
