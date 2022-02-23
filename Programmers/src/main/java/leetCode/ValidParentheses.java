package leetCode;

import com.tistory.eisen.Eisen;

import java.util.Arrays;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "(]";
        System.out.println("validParentheses = " + validParentheses.solution(s));
    }

    private boolean solution(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char asbracketIn = '(';
        char asbracketOut =')';
        char mBracketIn = '{';
        char mBracketOut ='}';
        char bBracketIn = '[';
        char bBracketOut =']';
        char[] c = s.toCharArray();
        int sCntStart = 0;
        int mCntStart = 0;
        int bCntStart = 0;
        int sCntEnd = 0;
        int mCntEnd = 0;
        int bCntEnd = 0;
        // 반을 나눠야함.
        // 반 나눈 후 나오는 순서에 유의해야함. ({ }),
//        boolean isRight = false;
//        for (int i = 0; i < c.length; i++) {
//            char c1 = c[i];
//            if (c[i] == '(') {
//                if (c[i + 1] != ')') {
//                    return false;
//                } else{
//                    isRight = true;
//                    continue;
//                }
//            }
//            if (c[i] == '{') {
//                if (c[i + 1] != '}') {;
//                    return false;
//                } else {
//                    isRight = true;
//                    continue;
//                }
//            }
//            if (c[i] == '[') {
//                if (c[i + 1] != ']') {;
//                    return false;
//                } else {
//                    isRight = true;
//                    continue;
//                }
//            }
//        }
        // 바로 뒤가 아닌 {[]} 이러한 경우도 넣어 주어야함.
        // reverse. 앞의 반틈과 뒤의 반틈이 서로 같다면 true return.
        StringBuffer asb = new StringBuffer(s);
        System.out.println("asb = " + asb.charAt(0));
        String[] sarrFirst = new String[s.length()/2];
        String[] sarrSecond = new String[s.length()/2];
        System.out.println("s.length() = " + s.length());
        System.out.println("s.length()/2 = " + s.length()/2);
        for (int i = 0; i < s.length()/2; i++) {
            System.out.println("i = " + i);
            System.out.println("String.valueOf(asb.charAt(i)) = " + String.valueOf(asb.charAt(i)));
            sarrFirst[i] = String.valueOf(asb.charAt(i));
            System.out.println("sarrFirst = " + sarrFirst[0]);
            System.out.println("sarrFirst = " + Arrays.toString(sarrFirst));
            sarrSecond[i] = String.valueOf(asb.charAt(s.length()-(i+1)));
        }
        Eisen.printArray(sarrFirst);
        Eisen.printArray(sarrSecond);
        return false;
    }
}
