package programmer_lv2;

public class FibonacciCal {
    public static void main(String[] args) {
         int n = 100000;
        FibonacciCal fibonacciCal = new FibonacciCal();
        System.out.println(fibonacciCal.solution(n));
    }
    public int solution(int n) {
        int answer = 0;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = (memo[i-1] + memo[i-2]) % 1234567;
        }
        return memo[n];
    }
//    public int solution(int n) {
//        int[] arr = new int[n+1];
//        arr[0] = 0;
//        arr[1] = 1;
//        for(int i = 2; i <= n; i ++){
//            arr[i] = arr[i-1] + arr[i-2];
//        }
//        return arr[n] % 1234567;
//    }
}
