package programmer_lv1;

import java.util.*;

public class FailureRate {
    public static void main(String[] args) {
//        5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
//        4	[4,4,4,4,4]	[4,1,2,3]
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        int n = 5;
        solution(n, stages);
    }
    static public int[] solution(int n, int[] stages) {
        int[] stageFailureCnt = new int[n];
        double[] stageFailureRate = new double[n];

        // 실패한 스테이지 개수 저장 배열 생성.
        // 실패율 구하기.
        // desc로 정렬하기.
        for(int i=0; i < stages.length; i++){
            if(stages[i] > n){
                continue;
            }else{
                stageFailureCnt[stages[i]-1]++;
            }
        }
        int total = stages.length;
        for(int i=0; i < stageFailureCnt.length; i++){
            stageFailureRate[i] = failureRate(stageFailureCnt[i],total);
            total -= stageFailureCnt[i];
            System.out.println(total);
        }
        System.out.println(Arrays.toString(stageFailureCnt));
        System.out.println(Arrays.toString(stageFailureRate));

        ArrayList<Double> arrayList = new ArrayList();
        for (double a: stageFailureRate){
            arrayList.add(a);
        }
        System.out.println(arrayList.toString());
        Collections.sort(arrayList, Collections.reverseOrder());
        System.out.println(arrayList.toString());

        return stages;
    }
    static double failureRate(int n1, int n2){
        System.out.println("n1: "+n1+" n2: "+n2);
        return ((double)n1) / (double)n2;
    }

}
