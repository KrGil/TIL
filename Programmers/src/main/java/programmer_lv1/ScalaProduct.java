package programmer_lv1;

public class ScalaProduct {
    public static void main(String[] args) {
//        [1,2,3,4]	[-3,-1,0,2]	 3
//        [-1,0,1]	[1,0,-1]	-2
//        int[] a = {1,2,3,4};
//        int[] b = {-3,-1,0,2};
        int[] a = {-1, 0, 1};
        int[] b = {1, 0,-1};
        int result = new ScalaProduct().solution(a, b);
        System.out.println("result = " + result);
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer+=a[i]*b[i];
        }

        return answer;
    }


}
