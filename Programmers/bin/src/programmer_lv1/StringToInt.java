package programmer_lv1;

public class StringToInt {
    public static void main(String[] args) {

//                제한 조건
//        s의 길이는 1 이상 5이하입니다.
//        s의 맨앞에는 부호(+, -)가 올 수 있습니다.
//        s는 부호와 숫자로만 이루어져있습니다.
//        s는 "0"으로 시작하지 않습니다.
//                입출력 예
//        예를들어 str이 "1234"이면 1234를 반환하고, "-1234"이면 -1234를 반환하면 됩니다.
//                str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없습니다.
        StringToInt st = new StringToInt();
        String s = "1a23";
        System.out.println("st = " + st.solution(s));
    }
    public int solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            System.out.println("s.length() = " + s.length());
            System.out.println(s.matches("[0-9]+"));
        }
        return 0;
    }
}
