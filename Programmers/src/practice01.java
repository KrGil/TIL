
/**
 * @author Eisen
 * @since Jul 1, 2021
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * Date         Modifier     Modification
 * --------     --------    ----------------------
 * Jul 1, 2021  Eisen    Initial Commit
 * Copyright (c) 2021 by Team Gaia All right reserved
 * </pre>
 */
public class practice01 {
	public static void main(String[] args) {
		System.out.println("test");
		
		int[][] v = { {1, 4}, {3,4}, {3,10} };
		
		int[] result = solution(v);
		for(int a : result) {
			System.out.println(a);
		}
	}

	public static int[] solution(int[][] v) {
		// result = 1,10
		int[] arrx = new int[3];
		int[] arry = new int[3];
		int cnt =0;
		int x =0;
		int y =0;
		// v = [3][2]
		for(int j=0; j<v.length;j++) {
			// v[] =  {1, 3}, arr = {3, 4} ... 
			for(int i =0; i < v[j].length; i++) {
				cnt++;
				System.out.println("("+i+", "+j+") : "+v[j][i]);
				if(cnt%2== 0) {
					arry[j] = v[j][i];
				}else {
					arrx[j] = v[j][i];
				}
			}
		}
		// 각 배열에 동일한 숫자가 없는 숫자 출력하기
		int temp =arrx[0];
		System.out.println(arrx[0]);
		for(int i=1; i < arrx.length; i++) {
			System.out.println("arrx["+i+"] : "+arrx[i]);
			if(arrx[i] == temp) {
				if(i+1 <arrx.length) {
					temp = arrx[i+1];
				}else {
					temp = arrx[i-1];
				}
				break;
			}
		}
		x =  temp;
		System.out.println("x  : "+temp);
		
		temp =arry[0];
		System.out.println(arry[0]);
		for(int i=1; i < arry.length; i++) {
			System.out.println("arry["+i+"] : "+arry[i]);
			if(arry[i] == temp) {
				if(i+1 < arry.length) {
					System.out.println("less");
					temp = arry[i+1];
				}else {
					temp = arry[i-1];
				}
				break;
			}
		}
		System.out.println("y : " +temp);
		y = temp;
		int[] result = {x,y};
		return result;
	}
}
