package programmer_lv1;

/**
 * packageName : programmer_lv1
 * fileName : numAndSumOfdivisor
 * author : eisen
 * date : 21. 12. 20.
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 21. 12. 20.              eisen             최초 생성
 */
public class numAndSumOfdivisor {
    public static void main(String[] args) {
        int left = 1;
        int right = 2;
        numAndSumOfdivisor sol = new numAndSumOfdivisor();
        sol.solution(left, right);

    }
    public int solution(int left, int right){
        int result = 0;
        for(int i = left; i <= right; i++){
            int divisorCnt = 1;
            for (int j = 1; j <= left; j++) {
                if (i % j == 0) {
                    divisorCnt++;
                }
            }
            if (divisorCnt % 2 == 0) {
                result += i;
                System.out.println("result : +"+result);
            } else {
                result -= i;
                System.out.println("result : -"+result);
            }

            System.out.println("left : "+i+" divisorCnt : "+divisorCnt);
        }
        return left;
    }
}
