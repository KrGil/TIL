import java.util.Arrays;
import java.util.Collections;

/**
 * @author Eisen
 * @since Jul 4, 2021
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * <pre>
 * [[개정이력(Modification Information)]]
 * Date         Modifier     Modification
 * --------     --------    ----------------------
 * Jul 4, 2021  Eisen    Initial Commit
 * Copyright (c) 2021 by Team Gaia All right reserved
 * </pre>
 */
public class naver01 {
	public static void main(String[] args) {
//		int[] prices = {13000, 88000, 10000};
//		int[] discounts = {30, 20};
		
		int[] prices = {32000, 18000, 42500};
		int[] discounts = {50, 20, 65};
		
		int answer = solution(prices, discounts);
		System.out.println(answer);
		
	}
	public static int solution(int[] prices, int[] discounts) {
		int answer = 0;
		int disIndex = 0;
		// 가장 큰 수부터 정렬
		Arrays.sort(prices);
		Arrays.sort(discounts);
		for(int i = prices.length-1; i >=0; i--) {
			System.out.println("price : "+prices[i]);
			
			//price와 discount 배열 길이만큼 빼기.
			if (discounts.length < prices.length) {
				System.out.println("i-disIndex : "+(i-disIndex));
				if(i-disIndex >= 0) {
					disIndex = prices.length - discounts.length;
					System.out.println("dis : "+discounts[i-disIndex]/100.0);
					System.out.println("discount price : "+ prices[i] * (discounts[i-disIndex]/100.0));
					answer += prices[i] - (prices[i] * discounts[i-disIndex])/100.0;
					System.out.println("answer : "+answer);
				}else {
					answer += prices[i];
				}
			}else {
				System.out.println("dis : "+discounts[i]/100.0);
				System.out.println("discount price : "+ prices[i] * (discounts[i]/100.0));
				answer += prices[i] - (prices[i] * discounts[i])/100.0;
				System.out.println("answer : "+answer);
			}
		}
		
		return answer;
	}
}
