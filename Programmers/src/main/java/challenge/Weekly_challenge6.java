package challenge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Weekly_challenge6 {
    public static void main(String[] args) {
        String[] head2head= {"NLWL", "WNLL", "LWNW", "WWLN"};
        int[] weights = {50, 82, 75, 120};
//        String[] head2head= {"NLW", "WNL", "LWN"};
//        int[] weights = {145, 92, 86};
//        String[] head2head= {"NNN", "NNN", "NNN"};
//        int[] weights = {60, 70, 60};
        System.out.println(Arrays.toString(sol(weights, head2head)));
    }

    public static int[] sol(int[] weights, String[] head2head){
        double[] winRateList = new double[weights.length];
        int[] winCountHeavierList = new int[weights.length];
        double[][] boxerInfo = new double[weights.length][5];


        for (int i=0; i < weights.length; i++){
            calculateBoxerInfo(winRateList, head2head, i,winCountHeavierList, weights);
            createBoxerInfo(boxerInfo, weights, winRateList, winCountHeavierList, i);
        }
        return showBoxerNum(boxerInfo);
}

    private static void calculateBoxerInfo(double[] winRateList, String[] head2head, int i,int[] winCountHeavierList, int[] weights ) {
        winRateList[i] = winRate(head2head[i], 'W', 'L');
        winCountHeavierList[i] = calHavyWinCount(locationsOfCharW(head2head[i], 'W'), weights, weights[i]);
    }

    private static void createBoxerInfo(double[][] boxerInfo, int[] weights, double[] winRateList, int[] winCountHeavierList,int i) {
        boxerInfo[i][0] = weights[i];
        boxerInfo[i][1] = winRateList[i];
        boxerInfo[i][2] = winCountHeavierList[i];
        boxerInfo[i][3] = 1;
        boxerInfo[i][4] = i+1;
        System.out.printf("weight : %s, winrate : %s, wincount : %s, boxernum : %s\n", weights[i], winRateList[i], winCountHeavierList[i], i+1);
    }

    public static int[] showBoxerNum(double[][] boxerInfo){
        int[] rank = new int[boxerInfo.length];
        sort(boxerInfo);

        for(int i =0; i< boxerInfo.length; i++){
            rank[i] = (int) boxerInfo[i][4];
        }

        return rank;
    }
    public static void sort(double[][] boxerInfo){
        for(int i=0; i < boxerInfo.length-1; i++) {
            for (int j = i + 1; j < boxerInfo.length; j++) {

                // 승률이 다를 때
                if (boxerInfo[i][1] != boxerInfo[j][1]) {
                    if (boxerInfo[i][1] < boxerInfo[j][1]) {
                        changePositionItoJ(boxerInfo, i, j);
                    }
                } else {
                    // 자신보다 무거운사람과의 승리 횟수 비교
                    if (boxerInfo[i][2] != boxerInfo[j][2]) {
                        if (boxerInfo[i][2] < boxerInfo[j][2]) {
                            changePositionItoJ(boxerInfo, i, j);
                        }
                    } else {
                        // 승률도 같고 승리 횟수도 같을 때
                        if (boxerInfo[i][0] != boxerInfo[j][0]) {
                            // 몸무게 비교
                            if (boxerInfo[i][0] < boxerInfo[j][0]) {
                                changePositionItoJ(boxerInfo, i, j);
                            }
                        } else {
                            // 번호 비교
                            if (boxerInfo[i][4] > boxerInfo[j][4]) {
                                changePositionItoJ(boxerInfo, j, i);
                            }
                        }
                    }
                }
            }
        }
    }
    // 버블정렬
    private static void changePositionItoJ(double[][] boxerInfo, int i, int j) {
        double[] temp = new double[5];
        temp = boxerInfo[i];
        boxerInfo[i] = boxerInfo[j];
        boxerInfo[j] = temp;
    }

    // 자신보다 무거운 복서 이긴 횟수
    public static int calHavyWinCount(ArrayList<Integer> locationsOfCharW, int[] weights, int myWeights){
        int havyWinCount =0;
        for(int i : locationsOfCharW){
            if(myWeights < weights[i]){
                havyWinCount++;
            }
        }
        return havyWinCount;
    }
    // W 위치
    public static ArrayList locationsOfCharW(String str, char ch){
        char[] charList= str.toCharArray();
        int charListIndex = 0;
        ArrayList indices_array = new ArrayList();
        for(char cha : charList){
            if(cha == ch){
                indices_array.add(charListIndex);
            }
            charListIndex++;
        }
        return indices_array;
    }

    // 승률
    public static double winRate(String str, char win, char lose){
        if(str.chars().filter(x -> x == win).count() != 0){
            double numberOfMatches = (double) (str.chars().filter(x -> x == win).count() + str.chars().filter(x -> x == lose).count());
            return ((str.chars().filter(x -> x == win).count())*100) / numberOfMatches;
        }else{
            return 0;
        }
    }
}
