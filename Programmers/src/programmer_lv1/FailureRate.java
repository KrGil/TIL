package programmer_lv1;

import java.lang.reflect.Array;
import java.util.*;

public class FailureRate {
    public static void main(String[] args) {
//        5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
//        4	[4,4,4,4,4]	                [4,1,2,3]
//        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
//        int[] stages = new int[]{4,4,4,4,4};
        int[] stages = new int[]{2,1,2,4,2,4,3,3};
        int n = 5;
        solution(n, stages);
    }
    static public int[] solution(int n, int[] stages) {
        int[] stageFailureCnt = new int[n];
        double[] stageFailureRate = new double[n];

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

        ArrayList<Double> arrayList = new ArrayList();
        ArrayList<Double> arrayListOrigin = new ArrayList();
        for (double a: stageFailureRate){
            arrayList.add(a);
            arrayListOrigin.add(a);
        }
        Collections.sort(arrayList, Collections.reverseOrder());
        int[] result = new int[arrayListOrigin.size()];
        for(int i=0; i < arrayList.size(); i++){
            int cnt = 0;
            for(double num : arrayList){
                if(arrayListOrigin.get(i) == num){
                    result[cnt] = i+1;
                    System.out.println("arrayListOrigin.get"+i+": "+arrayListOrigin.get(i)+" num: "+num);
                    System.out.println(Arrays.toString(result));
                    arrayList.set(cnt, -1.0);
                    break;
                }
                cnt++;
            }
        }
        return result;
    }
    static double failureRate(int n1, int n2){
        System.out.println("n1: "+n1+" n2: "+n2);
        return (n1!=0&&n2!=0) ? ((double)n1) / (double)n2 : 0.0;
    }

}
