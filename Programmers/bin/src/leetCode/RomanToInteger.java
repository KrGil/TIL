package leetCode;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger rti = new RomanToInteger();
        String str = "MCMXCIV";
        System.out.println("rti.solution(str) = " + rti.solution(str));
    }
//    I can be placed before V (5) and X (10) to make 4 and 9.
//    X can be placed before L (50) and C (100) to make 40 and 90.
//    C can be placed before D (500) and M (1000) to make 400 and 900.
    private int solution(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = str.toCharArray();
        int result = map.get(chars[0]);
        for (int i = 1; i < chars.length-1; i++) {
            if (map.get(chars[i]) < map.get(chars[i + 1])) {
                result -= map.get(chars[i]);
            } else {
                result += result;
            }
        }
        return result+map.get(chars[chars.length-1]);
    }
}
