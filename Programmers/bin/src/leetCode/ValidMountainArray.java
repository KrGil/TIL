package leetCode;

import java.util.Arrays;
import java.util.Optional;

public class ValidMountainArray {
    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
//        int[] nums = new int[]{0, 3, 2, 1};
//        int[] nums = new int[]{3,5,5};
//        int[] nums = new int[]{2,1};
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};

        validMountainArray.solution(nums);
        System.out.println("validMountainArray = " + validMountainArray.solution(nums));
    }

    private boolean solution(int[] arr) {
        if(arr.length < 3) return false;
        int max = Arrays.stream(arr).max().getAsInt();
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                maxIndex = i;
                break;
            }
        }
        for (int i = maxIndex; i > 0; i--) {
            if (arr[i] <= arr[i - 1]) {
                return false;
            }
        }
        for (int i = maxIndex; i < arr.length-1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
