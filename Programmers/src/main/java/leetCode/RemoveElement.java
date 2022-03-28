package leetCode;

import com.tistory.eisen.Eisen;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * packageName :  leetCode
 * fileName : RemoveElement
 * author :  eisen
 * date : 2022/03/25
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/03/25                eisen             최초 생성
 */
public class RemoveElement {
    public static void main(String[] args) {
        int nums[] = {3,2,2,3};
        int val = 3;

//        int a = (int) Arrays.stream(nums).filter(num -> num != val).count();
//        System.out.println(Arrays.stream(nums).filter(num -> num != val).count());
//        nums = Arrays.stream(nums).filter(num -> num != val).toArray();
        Eisen.printArray(nums);
        System.out.println("Nums = " + nums+" Original");
//        RemoveElement.removeElement(nums, val);
        RemoveElement.test(nums);
        System.out.println("Nums = " + nums+" After Original");
        Eisen.printArray(nums);

    }
    public static int removeElement(int[] nums, int val) {
        System.out.println("nums = " + nums+" InMethod1");
//        nums = Arrays.stream(nums).filter(num -> num != val).toArray();

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println("nums = " + nums+" InMethod2");
        return nums.length;
//        return i;


    }
    public static void  test(int[] n){
        System.out.println("n = " + n);
        int[]m = {1,2,3};
        n = m.clone();
        System.out.println("n = " + n);
    }

}
