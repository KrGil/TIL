package namgung;

import java.util.Arrays;

public class printNumbers {
    public static void main(String[] args) {
        for(int i=0; i<=10; i++){
            int k = i;
            for(int j=i+1; j<=10+i; j++){
                System.out.print(j <= 10 ? j : k);
            }
            System.out.println();
        }


        int value=0;
        for(int i=0; i< 10; i++){
            value=i;
            System.out.println(--value);
            System.out.println(i);
            for(int j=i; j<10+i; j++){
                System.out.print((j<10) ? ++value:--value);
            }
            System.out.println();
        }
    }

}
