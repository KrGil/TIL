package programmer_lv1;

import java.util.Locale;

public class NumsOfPnY {
    public static void main(String[] args) {
//        s	answer
//        "pPoooyY"	true
//        "Pyy"	false
        String s = "pPooyY";

        NumsOfPnY n = new NumsOfPnY();
        System.out.println(n.solution(s));

    }
    public boolean solution(String s) {
//        StringBuffer asb = new StringBuffer();
//        asb.append(n.toUpperCase());
//        int pCnt = 0;
//        int yCnt = 0;
//        for (int i = 0; i < asb.length(); i++) {
//            int temp = asb.charAt(i)=='P' ? pCnt++ : asb.charAt(i)=='Y'  ? yCnt++ : 0 ;
//        }
//        return pCnt == yCnt ? true : false;
        s = s.toUpperCase();
//        return s.chars().filter(v -> 'Y' == v).count() == s.chars().filter(v -> 'P' == v).count();
        return s.replaceAll("[^Pp]", "").length() - s.replaceAll("[^Yy]", "").length()==0 ? true : false;
    }
}
