package leetCode;

import java.util.Arrays;

/**
 * packageName :  leetCode
 * fileName : CountingWordsWithAGivenPrefix
 * author :  eisen
 * date : 2022/02/27
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/02/27                eisen             최초 생성
 */
public class CountingWordsWithAGivenPrefix {
    public static void main(String[] args) {
        String[] words = {"pay","attention","practice","attend"};
        String pref = "at";
//        String[] words = {"leetcode","win","loops","success"};
//        String pref = "code";

        //"leetcode","win","loops","success"], pref = "code"
        CountingWordsWithAGivenPrefix cnt = new CountingWordsWithAGivenPrefix();

        System.out.println("cnt = " + cnt.cnt(words, pref));
    }
    public int cnt(String[] words, String pref) {
//        int cnt = 0;
//        for (String s : words) {
//            if (s.startsWith(pref)) {
//                cnt++;
//            }
//        }
        return (int) Arrays.stream(words).filter(v -> v.startsWith(pref)).count();
    }
}
