package leetCode;

import com.tistory.eisen.Eisen;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "()";
        validParentheses.solution(s);
    }

    private void solution(String s) {
        char sBracketIn = '(';
        char sBracketOut =')';
        char mBracketIn = '{';
        char mBracketOut ='}';
        char bBracketIn = '[';
        char bBracketOut =']';
        char[] c = s.toCharArray();
        for (char o : c) {
            if(o == '('){

            }
        }
    }
}
