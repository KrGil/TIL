package baeckjoon;

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println("maximumSubarray.solution() = " + maximumSubarray.solution());

    }

    private int solution() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

}
