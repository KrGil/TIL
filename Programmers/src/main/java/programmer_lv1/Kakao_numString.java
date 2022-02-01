package programmer_lv1;

import java.util.Arrays;

public class Kakao_numString {
    public static void main(String[] args) {
        Kakao_numString result = new Kakao_numString();
//        s             	    result
//        "one4seveneight"	    1478
//        "23four5six7"	        234567
//        "2three45sixseven"	234567
//        "123"	                123
        String s = "2three45sixseven";
        long start = System.currentTimeMillis();
        result.solution(s);
        long end = System.currentTimeMillis();
        System.out.println("start : " + start); //시작시간의 밀리세컨드
        System.out.println("end : " + end);  //종료시간의 밀리케선드
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초"); //최종 실행시간

    }
    public int solution(String s) {
        long[] ints = new long[4];
        s =s.replaceAll("one", "1");
        s =s.replaceAll("two", "2");
        s =s.replaceAll("three", "3");
        s =s.replaceAll("four", "4");
        s =s.replaceAll("five", "5");
        s =s.replaceAll("six", "6");
        s =s.replaceAll("seven", "7");
        s =s.replaceAll("eight", "8");
        s =s.replaceAll("nine", "9");
        s =s.replaceAll("zero", "0");
        System.out.println(s);

        //        0	zero
//        1	one
//        2	two
//        3	three
//        4	four
//        5	five
//        6	six
//        7	seven
//        8	eight
//        9	nine


        return 0;
    }
}
