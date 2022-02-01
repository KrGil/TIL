package programmer_lv1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DeleteMinNum {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        DeleteMinNum deleteMinNum = new DeleteMinNum();
        System.out.println(Arrays.toString(deleteMinNum.solution(arr)));
    }
    public int[] solution(int[] arr) {
        return arr.length > 1 ? Arrays.stream(arr).filter(v -> v!=Arrays.stream(arr).min().getAsInt()).toArray() : new int[]{-1};
    }
}
