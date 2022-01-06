package programmer_lv1;

import java.util.Arrays;
import java.util.Collections;

public class FlipingStr {
    public static void main(String[] args) {
//        s	return
//        "Zbcdefg"	"gfedcbZ"
        FlipingStr flipingStr = new FlipingStr();
        String s = "Zbcdefg";
        System.out.println("flipingStr = " + flipingStr.solution(s));;
    }

    public String solution(String s) {
//        String[] arr = s.split("");
//        Arrays.sort(arr, Collections.reverseOrder());
//        StringBuffer sb = new StringBuffer(Arrays.toString(arr));
//        System.out.println("sb = " + sb.);
//        return new StringBuffer(new String(Arrays.toString(arr))).toString();
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        return new StringBuffer(new String(s1)).reverse().toString();
    }

}
