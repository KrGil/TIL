import java.util.*;

public class test {
    public static void main(String[] args) {
        int[][] trust = {{1,3}, {2,3}};
//        int[][] trust = {{1,3}, {2,3}, {3,1}};
//        int[][] trust = {{1,2}};
        test test = new test();
        System.out.println("test = " + test.solution(3, trust));
//        Input: n = 2, trust = [[1,2]]
//        Output: 2
//
//        Input: n = 3, trust = [[1,3],[2,3]]
//        Output: 3
//
//        Input: n = 3, trust = [[1,3],[2,3],[3,1]]
//        Output: -1
    }
    public int solution(int n, int[][] trust) {
        int originNum = trust[0][1];
        int firstIndex = 1;

        for (int i = 0; i < trust.length; i++) {
            if (firstIndex != trust[i][0]) {
                return -1;
            }
            firstIndex++;
        }

        if (firstIndex-1 == n && trust.length != 1) {
            return -1;
        }
        return originNum;
    }
}
