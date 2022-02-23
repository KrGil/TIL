package leetCode;

import com.tistory.eisen.Eisen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * packageName :  leetCode
 * fileName : AddBinary
 * author :  eisen
 * date : 2022/02/20
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/02/20                eisen             최초 생성
 */
public class AddBinary {
    public static void main(String[] args) {

        String a = "110010";
        String b = "10111";
        // a + b = 10;
        // if x + y = 2 ---> 10

        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        StringBuffer longSb = new StringBuffer();
        StringBuffer shortSb = new StringBuffer();
        if (aArray.length >= bArray.length) {
            for (char c : aArray) {
                longSb.append(c);
            }
            for (char c : bArray) {
                shortSb.append(c);
            }
        } else {
            for (char c : aArray) {
                shortSb.append(c);
            }
            for (char c : bArray) {
                longSb.append(c);
            }
        }
        System.out.println("shortSb = " + shortSb);
        // 항상 1의 자리가 index = 0
        longSb = longSb.reverse();
        shortSb = shortSb.reverse();

        // for문 길이 구하기
        String[] result = new String[longSb.length()+1];
        for (String s : result) {
            s = "";
        }

        int temp = 0;
        String first = "";
        String second = "";
        for (int i = 0; i < longSb.length(); i++) {
            System.out.println("i = " + i);
            first = String.valueOf(longSb.charAt(i));
            if (i >= shortSb.length()) {
                second = "";
            }else {
                first = String.valueOf(longSb.charAt(i));
                second =  String.valueOf(shortSb.charAt(i));
            }

            // sum == 111/
            if (temp == 1) {
                System.out.println(" temp == 1");

                if ("".equals(second)) {
                    System.out.println("second = " + second);
                    System.out.println("first = " + first);
                    if("11".equals(first + String.valueOf(temp))){
                        result[i] = String.valueOf(0);
                        result[i + 1] = "1";
                        temp = 1;
                    }else{
                        result[i] = String.valueOf(1);
                        temp = 0;
                    }
                } else {
                    // temp == 1, second == "something"
                    System.out.println("second = " + second);
                    System.out.println("first = " + first);
                    // sum == 11
                    if ("11".equals(first + second)) {
                        temp = 1;
                        result[i] = String.valueOf(1);
                        result[i + 1] = "1";
                    }else if ("00".equals(first + second)){
                        result[i] = String.valueOf(1);
                        temp = 0;
                    } else {
                        result[i] = String.valueOf(0);
                        temp = 1;
                    }
                }
            }else{
                System.out.println(" temp == 0");

                if("".equals(second)){
                    System.out.println("second = " + second);
                     if("1".equals(first)){
                         result[i] = String.valueOf(1);
                     }else{
                         result[i] = String.valueOf(0);
                     }
                }else{
                    System.out.println("second = " + second);
                    // sum == 11
                    if ("11".equals(first + second)) {
                        result[i+1] = "1";
                        result[i] = String.valueOf(0);
                        temp = 1;
                    } else if ("00".equals(first + second)){
                        result[i] = String.valueOf(0);
                        temp = 0;
                    } else {
                        // sum == 10
                        System.out.println("sum=====10");
                        result[i] = String.valueOf(1);
                        temp = 0;
                    }
                }


            }
            System.out.println("*******************result[i] = " + result[i]);
        }
        Eisen.printArray(result);

        for (int i = result.length-1; i >= 0 ; i--) {
            if(result[i] != null){
                System.out.print(result[i]);
            }
        }
    }
}
