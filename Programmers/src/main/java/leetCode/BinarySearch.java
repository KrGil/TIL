package leetCode;

/**
 * packageName :  leetCode
 * fileName : BinarySearch
 * author :  eisen
 * date : 2022/04/16
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/04/16                eisen             최초 생성
 */
public class BinarySearch {
    public static void main(String[] args) {
    /*
        nums = [-1,0,3,5,9,12], target = 9
        nums = [-1,0,3,5,9,12], target = 2
     */
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        search(nums, target);

    }
    public static int search(int[] nums, int target) {
        int[] left ;
        int[] right;
        int mid = nums.length / 2;
        System.out.println("mid = " + mid);
//        while(){
//
//        }
        return -1;
    }
    public static int cal(int[] nums, int target, int left, int right) {
        int[] leftArr = new int[left];
        int[] rightArr = new int[right];
        int mid = nums.length / 2;
        System.out.println("mid = " + mid);
        for (int i = 0; i < nums.length; i++) {
            if(i < left)
                leftArr[i] = nums[i];
            else
                rightArr[i] = nums[i];
        }

        return -1;
    }


}

