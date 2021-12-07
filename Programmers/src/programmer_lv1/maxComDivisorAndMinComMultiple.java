package programmer_lv1;

import java.util.ArrayList;
import java.util.Set;

public class maxComDivisorAndMinComMultiple {
    public static void main(String[] args) {
        maxComDivisorAndMinComMultiple result = new maxComDivisorAndMinComMultiple();
        System.out.println(result.greatComDivisor(12));
    }
    public int[] solution(int n, int m) {
        int[] answer = {};
        return answer;
    }
    ArrayList<Integer> greatComDivisor(int num){
        ArrayList<Integer> divisorList = new ArrayList<>();
        for(int i=1; i<=num/2; i++){
            System.out.println(i);
            if(num%i == 0){
                if(!divisorList.contains(i))
                    divisorList.add(i);
                if(!divisorList.contains(num / i))
                    divisorList.add(num / i);
            }
        }
        return divisorList;
    }



}
