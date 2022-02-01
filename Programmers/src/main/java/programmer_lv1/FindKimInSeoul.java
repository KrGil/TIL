package programmer_lv1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindKimInSeoul {
    public static void main(String[] args) {
        String[] seoul = new String[]{"Jane", "Kim"};
        System.out.println(solution(seoul));
    }
    static String solution(String[] seoul){
        int result =0;
//        IntStream
//                .range(0, seoul.length)
//                .mapToObj(index -> String.format("%d -> %s", index, seoul[index]))
//                .filter(v -> v.equals("Kim"))
//                .findAny();
        for(int i=0; i< seoul.length; i++){
            if("Kim".equals(seoul[i])){
                result = i;
                break;
            }
        }
        return "김서방은 "+result+"에 있다.";
    }

}
