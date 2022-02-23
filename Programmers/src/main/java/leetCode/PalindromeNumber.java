package leetCode;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.rpIsPalindrome(-12231));
    }
    public boolean isPalindrome(int x){
        String[] sarr = String.valueOf(x).split("");
        StringBuffer firstasb = new StringBuffer();
        StringBuffer secondasb = new StringBuffer();
        for (int i = 0; i < sarr.length/2; i++) {
            firstasb.append(sarr[i]);
        }
        for (int i = (sarr.length%2)== 0? (sarr.length/2) : (sarr.length/2)+1 ; i < sarr.length; i++) {
            secondasb.append(sarr[i]);
        }
        secondasb = secondasb.reverse();
        System.out.println("secondasb = " + secondasb.toString());
        for (int i = 0; i < firstasb.length(); i++) {
            if (firstasb.charAt(i) != secondasb.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean rpIsPalindrome(int x){
        int lastDigit = 0;
        int tmp = x;
        int reversedNum = 0;
        while (tmp != 0) {
            lastDigit = tmp % 10;
            tmp = tmp / 10;
            reversedNum = (reversedNum * 10) + lastDigit;
        }
        System.out.println("reversedNum = " + reversedNum);
        return reversedNum==x ?true:false;
    }
}
