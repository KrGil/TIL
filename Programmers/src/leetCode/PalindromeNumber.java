package leetCode;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(12221));
    }
    public boolean isPalindrome(int x){
        String[] sarr = String.valueOf(x).split("");
        StringBuffer firstSb = new StringBuffer();
        StringBuffer secondSb = new StringBuffer();
        for (int i = 0; i < sarr.length/2; i++) {
            firstSb.append(sarr[i]);
        }
        for (int i = (sarr.length%2)== 0? (sarr.length/2) : (sarr.length/2)+1 ; i < sarr.length; i++) {
            secondSb.append(sarr[i]);
        }
        secondSb = secondSb.reverse();
        System.out.println("secondSb = " + secondSb.toString());
        for (int i = 0; i < firstSb.length(); i++) {
            if (firstSb.charAt(i) != secondSb.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
