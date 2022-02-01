package programmer_lv1;

public class sumIndexof {
    public static void main(String[] args) {
        sumIndexof result = new sumIndexof();
        System.out.println(result.solution(123));
    }
    public int solution(int n){
        String[] a = String.valueOf(n).split("");
        int result=0;
        for (String b : a) {
            result += Integer.parseInt(b);
        }
        return result;
    }
}
