package baeckjoon;

import java.util.Scanner;

public class DeliverSalt {
    public static void main(String[] args) {
        DeliverSalt deliverSalt = new DeliverSalt();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("deliverSalt = " + deliverSalt.solution(scanner.nextInt()));
        System.out.println("deliverSalt = " + deliverSalt.solution(11));
    }
    // 6 일 때
    private int solution(int n) {
        if (n % 5 == 3 || n % 5 == 0) {

            int temp = n / 5;
            return temp += (n % 5) / 3;
        } else if (n % 3 == 0) {
            return n / 3;
        } else {
            return -1;
        }

    }
}
