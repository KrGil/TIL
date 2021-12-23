package programmer_lv1;

import java.util.Locale;

public class CreateStrangeStr {
    public static void main(String[] args) {
    String s = "try   hel  lo    world   ";
        CreateStrangeStr css = new CreateStrangeStr();
        System.out.println(css.solution(s));
//        s	return
//  "try hello world"	"TrY HeLlO WoRlD"
    }
    public String solution(String s){
        String[] arr = s.split(" ");
        StringBuffer st = new StringBuffer();

        for (String a : arr) {
            System.out.println("a = " + a);
            for (int i = 0; i < a.length(); i++) {
                if (i % 2 == 0) {
                    st.append(String.valueOf(a.charAt(i)).toUpperCase().trim());
                }else{
                    st.append(String.valueOf(a.charAt(i)).toLowerCase().trim());
                }
            }
            st.append(" ");
        }
        if(String.valueOf(s.charAt(s.length()-1)).equals(" ")){
            System.out.println("is?");

        }
        st.setLength(st.length()-1);
        return st.toString();
    }
}
