package programmer_lv1;

import java.util.Arrays;

public class Moeuigosa {
	public static void main(String[] args) {
		System.out.println("hello");
		int[] answer = {1,3,2,4,2};
		System.out.println(Arrays.toString(new Moeuigosa().solution(answer)));
	}
    public int[] solution(int[] answers) {
//        int[] answer = {1,2,3,4,5};
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        int num_1=0;
        int num_2=0;
        int num_3=0;
        int cnt1=0;
        int cnt2=0;
        int cnt3=0;
        for(int i = 0; i < answers.length; i ++){
//            answer[i] = (int)(Math.random()*5)+1;
//            System.out.println(answer[i]);
            num_1++;
            num_2++;
            num_3++;
            if(num1[num_1-1] ==  answers[i]){
                cnt1++;
            }
            if(num2[num_2-1] == answers[i]){
                cnt2++;
            }
            if(num3[num_3-1] == answers[i]){
                cnt3++;
            }
  
            if(num_1%5 == 0) {   
                num_1 = 0;
            }if(num_2%8 == 0){
                num_2 = 0;
            }if(num_3%10 == 0){
                num_3 = 0;
            }                
//            cnt1
        }
        System.out.println(cnt1 +" "+ cnt2 +" "+ cnt3);
        if(cnt1 > cnt2 && cnt1 > cnt3){
            int[] result = {1};
            return result;
        }else if(cnt1 == cnt2 && cnt1 > cnt3){
        	int[] result = {1,2};
            return result;
        }else if(cnt1 > cnt2 && cnt1 == cnt3){
        	int[] result = {1,3};
            return result;
        }
        else if (cnt2 > cnt1 && cnt2 > cnt3){
        	int[] result = {2};
            return result;
        }else if(cnt2 == cnt3 && cnt2 > cnt1){

        	int[] result = {2,3};
            return result;
        }else if(cnt1 == cnt2 && cnt2 == cnt3) {
        	int[] result = {1,2,3};
        	return result;
        }
        else{
        	int[] result = {3};
            return result;
        }
    }
}
