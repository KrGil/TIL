package programmer_lv1;

import java.util.Arrays;

public class maraton {
	public static void main(String[] args) {
		
	}
    public String solution(String[] participant, String[] completion) {
        String answer = "";    
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i =0;
        for(String a : completion){
            if(!a.equals(participant[i])){
                answer = participant[i];
                return answer;
            }else{
                answer = participant[i+1];
            }
            i++;
        }
        return answer;
    }
}
