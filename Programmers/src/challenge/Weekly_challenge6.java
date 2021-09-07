package challenge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Weekly_challenge6 {
    public static void main(String[] args) {
//        String[] head2head= {"NLWL", "WNLL", "LWNW", "WWLN"};
//        int[] weights = {50, 82, 75, 120};
//        String[] head2head= {"NLW", "WNL", "LWN"};
//        int[] weights = {145, 92, 86};
        String[] head2head= {"NNN", "NNN", "NNN"};
        int[] weights = {60, 70, 60};



        System.out.println(Arrays.toString(sol(weights, head2head)));
    }

    public static int[] sol(int[] weights, String[] head2head){
        int[] winRateList = new int[weights.length];
        int[] winCountHeavierList = new int[weights.length];
        int[][] boxerInfo = new int[weights.length][5];


        for (int i=0; i < weights.length; i++){
            calculateBoxerInfo(winRateList, head2head, i,winCountHeavierList, weights);
            createBoxerInfo(boxerInfo, weights, winRateList, winCountHeavierList, i);
        }
        return showRank(boxerInfo);
}

    private static void calculateBoxerInfo(int[] winRateList, String[] head2head, int i,int[] winCountHeavierList, int[] weights ) {
        winRateList[i] = winRate(head2head[i], 'W');
        winCountHeavierList[i] = calHavyWinCount(locationsOfCharW(head2head[i], 'W'), weights, weights[i]);
    }

    private static void createBoxerInfo(int[][] boxerInfo, int[] weights, int[] winRateList, int[] winCountHeavierList,int i) {
        boxerInfo[i][0] = weights[i];
        boxerInfo[i][1] = winRateList[i];
        boxerInfo[i][2] = winCountHeavierList[i];
        boxerInfo[i][3] = 1;
        boxerInfo[i][4] = i+1;
    }

    public static int[] showRank(int[][] boxerInfo){
        int[] rank = new int[boxerInfo.length];
        boxerInfo = sort(boxerInfo);

        for(int i =0; i< boxerInfo.length; i++){
            rank[i] = boxerInfo[i][4];
        }

        return rank;
    }
    public static int[][] sort(int[][] boxerInfo){
        for(int i=0; i < boxerInfo.length-1; i++) {
            for (int j = i + 1; j < boxerInfo.length; j++) {

                // 승률이 다를 때
                if (boxerInfo[i][1] != boxerInfo[j][1]) {
                    System.out.println("승률 : 다름");
                    if (boxerInfo[i][1] < boxerInfo[j][1]) {
                        System.out.println("**승률 비교");
                        changePositionItoJ(boxerInfo, i, j);
                    }
                } else {
                    System.out.println("승률 : 같음");
                    // 자신보다 무거운사람과의 승리 횟수 비교
                    if (boxerInfo[i][2] != boxerInfo[j][2]) {
                        System.out.println("승리 횟수 : 다름");
                        if (boxerInfo[i][2] < boxerInfo[j][2]) {
                            System.out.println("**승리 횟수 비교");
                            changePositionItoJ(boxerInfo, i, j);
                        }
                        System.out.println("\n");
                    } else {
                        // 승률도 같고 승리 횟수도 같을 때
                        System.out.println("승리 횟수 : 같음");
                        System.out.println("몸무게 : 다름");
                        if (boxerInfo[i][0] != boxerInfo[j][0]) {
                            // 몸무게 비교
                            System.out.println("**몸무게 비교");
                            if (boxerInfo[i][0] < boxerInfo[j][0]) {
                                changePositionItoJ(boxerInfo, i, j);
                            }
                            System.out.println("\n");
                        } else {
                            System.out.println("몸무게 : 같음");
                            System.out.println("**선수번호 비교");
                            System.out.println(Arrays.toString(boxerInfo[i]));
                            System.out.println(Arrays.toString(boxerInfo[j]));
                            if (boxerInfo[i][4] > boxerInfo[j][4]) {
                                changePositionItoJ(boxerInfo, j, i);
                            }
                            System.out.println("\n");
                        }
                    }
                }
            }
        }
        return boxerInfo;
    }

    private static void changePositionItoJ(int[][] boxerInfo, int i, int j) {
        System.out.println("변경 전 ");
        for(int[] where : boxerInfo){
            System.out.print(where[4]+"\t");
        }

        int[] temp = new int[5];
        temp = boxerInfo[i];
        boxerInfo[i] = boxerInfo[j];
        boxerInfo[j] = temp;

        System.out.println("\n변경 후 ");
        for(int[] where : boxerInfo){
            System.out.print(where[4]+"\t");
        }
        System.out.println("\n");
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
    public static int winRate(String str, char ch){
        if(str.chars().filter(x -> x == ch).count() != 0){
            return (int) (((str.chars().filter(x -> x == ch).count())*100) /(str.length()-1));
        }
        else{
            return 0;
        }
    }
}
