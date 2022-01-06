
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
public class naver03{
	public static void main(String[] args) {
		String s = "aabcbcd";
		String t = "abc";
//		String s = "aaaaabbbbb";
//		String t = "ab";
		
		solution(s, t);
		
	}
	public static int solution(String s, String t) {
	    int result = 0;
	    System.out.println(s.contains(t));
	    while(true) {
	    	System.out.println(result++);
	    	s = s.replaceAll(t, "");
	    	if(!s.contains(t)) break;
	    }
	    System.out.println(result);
	    return result;
	}
}