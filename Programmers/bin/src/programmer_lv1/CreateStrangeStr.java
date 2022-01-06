package programmer_lv1;

public class CreateStrangeStr {
    public static void main(String[] args) {
    String s = "try   hel  lo    world   ";
        CreateStrangeStr css = new CreateStrangeStr();
        System.out.println(css.solution(s));
    }
    public String solution(String s){
        String[] temp = s.split("");
        int cnt =0;
        StringBuffer sn = new StringBuffer();
        for (String a : temp) {
            cnt = a.contains(" ") ? 0 : cnt +1;
            sn.append(cnt % 2 == 0 ? a.toLowerCase() : a.toUpperCase());
        }
        return sn.toString();
    }
}
