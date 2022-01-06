import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Stream_1 {
    public static void main(String[] args) {
        Integer[] testArr = {1,2,3,4,5};
        ArrayList testList = new ArrayList();


        Stream<Integer> stream = Arrays.stream(testArr);
        stream.forEach(x ->System.out.println(x));

        Collections.addAll(testList, testArr);


    }
}
