package leetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FindTheTownJudge {
    public static void main(String[] args) {
//        Input: n = 2, trust = [[1,2]]
//        Output: 2
//
//        Input: n = 3, trust = [[1,3],[2,3]]
//        Output: 3
//
//        Input: n = 3, trust = [[1,3],[2,3],[3,1]]
//        Output: -1

        FindTheTownJudge findTheTownJudge = new FindTheTownJudge();
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
//        int[][] trust = {{1,3},{2,3}};
        System.out.println(findTheTownJudge.solution(2, trust));
    }
    public int solution( int n, int[][] trust) {
        int result = trust[0][1];
        int resultTemp =0;
        for (int i = 0; i < trust.length-1; i++) {
            System.out.println(1);
            if (trust[i][0] != trust[i][1]) {
                if (i != trust.length) {
//                    System.out.println(2);
//                    System.out.println(trust[i][1]);
//                    System.out.println(trust[i + 1][1]);
                    if (trust[i][1] == trust[i + 1][1]) {
                        System.out.println(3);
                        return trust[i][1];
                    }
                }
            }
        }
        return -1;
    }
}
