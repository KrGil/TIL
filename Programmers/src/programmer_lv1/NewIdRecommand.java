package programmer_lv1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * packageName : programmer_lv1
 * fileName : NewIdRecommand
 * author : eisen
 * date : 21. 11. 17.
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 21. 11. 17.              eisen             최초 생성
 */
public class NewIdRecommand {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        sol.solution("...!@BaT#*..y.abcdefghijklm");
//        1단계 대문자 'B'와 'T'가 소문자 'b'와 't'로 바뀌었습니다.
//        "...!@BaT#*..y.abcdefghijklm" → "...!@bat#*..y.abcdefghijklm"
//
//        2단계 '!', '@', '#', '*' 문자가 제거되었습니다.
//        "...!@bat#*..y.abcdefghijklm" → "...bat..y.abcdefghijklm"
//
//        3단계 '...'와 '..' 가 '.'로 바뀌었습니다.
//        "...bat..y.abcdefghijklm" → ".bat.y.abcdefghijklm"
//
//        4단계 아이디의 처음에 위치한 '.'가 제거되었습니다.
//        ".bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"
//
//        5단계 아이디가 빈 문자열이 아니므로 변화가 없습니다.
//        "bat.y.abcdefghijklm" → "bat.y.abcdefghijklm"
//
//        6단계 아이디의 길이가 16자 이상이므로, 처음 15자를 제외한 나머지 문자들이 제거되었습니다.
//        "bat.y.abcdefghijklm" → "bat.y.abcdefghi"
//
//        7단계 아이디의 길이가 2자 이하가 아니므로 변화가 없습니다.
//        "bat.y.abcdefghi" → "bat.y.abcdefghi"
    }
    static public class Solution2{
        public String solution(String new_id){
            // 3<=id.length<=15
            // 소문자, 숫자빼기밑줄마침표까지.만
            // 마침표는처음 과끝 에사용불,가 연 속사 용불1가

            //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
            new_id = new_id.toLowerCase();
            System.out.printf("1단계: %s %n", new_id);
            //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            String pattern = "([^a-z0-9\\-_.])*";
            new_id = new_id.replaceAll(pattern, "");
//                Arraysffer sb = new StringBuffer();
//                Arrays.stream(arr).forEach(a -> sb.append(a));r
            System.out.printf("2단계: %s %n", new_id);

            //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
            
            //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
            String patternDot = "[.](.*)[.]";
            if(new_id.startsWith("."))
                new_id = new_id.substring(1);
            if(new_id.endsWith("."))
                new_id = new_id.substring(0, new_id.length()-1);
            System.out.printf("4단계: %s %n", new_id);
            //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
            if("".equals(new_id)){
                new_id = "a";
            }
            System.out.printf("5단계: %s %n", new_id);
            //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
            if(new_id.length() >= 16){
                new_id = new_id.substring(0, 15);
            }
            System.out.printf("6단계: %s %n", new_id);
            //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
            if(new_id.length() <= 2){
                System.out.printf("here : %s %n",new_id.length());
                while(new_id.length() < 3){
                    new_id += new_id.substring(new_id.length()-1, new_id.length());
                    System.out.println("aa : "+new_id.substring(new_id.length()-1, new_id.length()));
                };
            }
            new_id = new_id.trim();
            System.out.printf("7단계: %s %n", new_id);
            new_id = new_id.trim();

//            String pattern = "^[0-9]*$"; // 숫자 만
//            String val = "123456789"; // 대상문자열

//            boolean regex = Pattern.matches(pattern, val);
            String answer="";
            return new_id;
        }
    }
}
