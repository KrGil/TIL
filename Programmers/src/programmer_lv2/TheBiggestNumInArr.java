package programmer_lv2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TheBiggestNumInArr {
    public static void main(String[] args) {
        TheBiggestNumInArr theBiggestNumInArr = new TheBiggestNumInArr();
//        int[] arr = {6, 10, 2};
        // return "6210"
        int[] arr = {3,30,34,5,9};
//        return "9534330"
        System.out.println(theBiggestNumInArr.solution(arr));
    }
    public String solution(int[] numbers) {
        StringBuffer sb = new StringBuffer();

        for (int j = 0; j < numbers.length; j++) {
            char firstNum = (char)String.valueOf(numbers[j]).charAt(0);
            System.out.println("firstNum = " + firstNum);
            int temp = 0;
            for (int i = j+1; i < numbers.length; i++) {
                if (firstNum > numbers[i]) {
                    temp = numbers[j];
                }else if(firstNum < numbers[i]){
                    temp = numbers[i];
                }else{
                    for (int a = 1; a < String.valueOf(numbers[j]).length(); a++) {
                        if (String.valueOf(numbers[j]).charAt(a) > String.valueOf(numbers[i]).charAt(a)) {
                            temp = numbers[j];
                            break;
                        }else if(String.valueOf(numbers[j]).charAt(a) > String.valueOf(numbers[i]).charAt(a)){
                            temp = numbers[i];
                            break;
                        }
                    }
                }
            }
            System.out.println("temp = " + temp);
            sb.append(temp);
        }
        return sb.toString();
    }
}
