package leetCode.fun_with_array;

import java.util.Arrays;

/**
 * packageName :  leetCode.fun_with_array
 * fileName : MaxConsecutiveOnes
 * author :  eisen
 * date : 2022/06/11
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/06/11                eisen             최초 생성
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        return find(nums, 1);
    }
    public int find(int[] nums, int i){
        int cnt = 0;
        int preNum = 0;
        int postNum = 0;

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] == 1 && nums[j] == nums[j+1]){
                cnt++;
            }
        }
        return cnt;
    }

}
