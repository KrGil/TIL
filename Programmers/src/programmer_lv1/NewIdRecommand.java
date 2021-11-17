package programmer_lv1;

import java.util.regex.Pattern;

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
        Solution2.
    }
    public class Solution2{
        public String solution(String new_id){
            // 3<=id.length<=15
            // 소문자, 숫자빼기밑줄마침표까지.만
            // 마침표는처음 과끝 에사용불,가 연 속사 용불1가

            //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
            //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
            //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
            //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
            //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
            //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
            //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

//            String pattern = "^[0-9]*$"; // 숫자 만
//            String val = "123456789"; // 대상문자열

            String val = "ADBD";


//            boolean regex = Pattern.matches(pattern, val);
            System.out.println(val.toLowerCase());

            String answer="";


            return answer;
        }
    }
}
