package programmer_lv1;

public class FlippingTernary {
    public static void main(String[] args) {
//        n	result
//        45	7
//        125	229
        FlippingTernary flippingTernary = new FlippingTernary();
        System.out.println(flippingTernary.solution(125));
    }

    public int solution(int n) {
        int result = 0;
        int remainder = 0;
        StringBuffer aasb = new StringBuffer();
        // 1. n -> 3진법
        // 2. 3진법 -> reverse
        if(n <3){
            return n;
        }
        while(n >= 3){
            remainder = n%3;
            n = n/3;
            aasb.append(remainder);
            aasb.append(n < 3 ? n : "");
        }
        int multiplier = aasb.length()-1;
        // 3. reverse -> n
        for (int i = 0; i < aasb.length(); i++) {
            result += (int) (Integer.parseInt(String.valueOf(aasb.charAt(i))) * (Math.pow(3,multiplier)));
            multiplier--;
        }
        // exception
        // n < 3

        return result;
    }
}
