import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Eisen
 * @since Jul 13, 2021
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * Date         Modifier     Modification
 * --------     --------    ----------------------
 * Jul 13, 2021  Eisen    Initial Commit
 * Copyright (c) 2021 by Team Gaia All right reserved
 * </pre>
 */
public class Lv1_programmers_K_num {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4}; 
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Solution.solution(array, commands).toString());
		
	}
}
class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> temp = new ArrayList();
        ArrayList<Integer> result = new ArrayList();
        for(int n1 = 0; n1 < commands.length; n1++){
        	temp.clear();
        	int i = commands[n1][0];
        	int j = commands[n1][1];
        	int k = commands[n1][2];
//        	System.out.printf("i : %d \nj : %d \nk : %d \n", i, j, k);
        	for(int n2=i-1; n2 < j; n2++) {
//        		System.out.println("n2 : " + array[n2]);
        		temp.add(array[n2]);
        	}
        	temp.sort(null);
//        	for(int tempnum : temp) {
//        		System.out.println("temp : "+tempnum);
//        	}
//        	System.out.println("k : "+ temp.get(k-1));
        	result.add(temp.get(k-1));
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
        	answer[i] = result.get(i);
        }
        
        return answer;
    }
}