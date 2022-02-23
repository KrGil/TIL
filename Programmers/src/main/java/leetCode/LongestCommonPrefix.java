package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
//        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"a"};
//        String[] strs = {"cir","car"};
        String[] strs = {"caa","","a","acb"};
//        String[] strs = {"dog","racecar","car"};
        System.out.println("strs = " + longestCommonPrefix.solution(strs));
    }

    private String solution(String[] strs) {
        if (strs.length == 1) {
            return strs[0].toString();
        }
        HashMap<String, String> map = new HashMap<>();
        StringBuffer asb = new StringBuffer();
        int strLength = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            int cur = strs[i].length();
            System.out.println("cur = " + cur);
            strLength = Math.min(cur, strLength);
            System.out.println("strLength = " + strLength);
        }
        System.out.println("strs[1].length() = " + strs[1].length());
        if (strLength == 0) {
            return "";
        }

        for (int j = 0; j < strLength; j++) {
            char[] tempChar = new char[strs.length];
            // 배열에 글자 담기.
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                char[] temp= str.toCharArray();
                // 한 글자씩 배열에 담기.
                tempChar[i] = temp[j];
                System.out.println("tempChar = " + tempChar[i]);
            }
            // 한글자씩 비교
            boolean isSame = false;
            for (int i = 1; i < tempChar.length; i++) {
                if (tempChar[i] == tempChar[i - 1]) {
                    isSame = true;
                } else {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                asb.append(tempChar[0]);
            }else{
                break;
            }

        }
        return asb.toString();
    }

}
