package programmer_lv2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * packageName : programmer_lv2
 * fileName : improveFunction
 * author : eisen
 * date : 21. 12. 14.
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 21. 12. 14.              eisen             최초 생성
 */
public class ImproveFunction {
    public static void main(String[] args) {
//        [93, 30, 55]	[1, 30, 5]	[2, 1]
//        [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] s  = new ImproveFunction().solution(progresses, speeds);

    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] temp = new int[progresses.length];
        Integer[] period = new Integer[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            temp[i] = 100 -progresses[i];
            System.out.println("tempI: "+temp[i] +" speeds: "+speeds[i]);

            if(temp[i] % speeds[i] != 0 ){
                period[i]=(temp[i] / speeds[i]) +1;
            }else{
                period[i]=temp[i] / speeds[i];
            }
            System.out.println("tempI/speeds: "+period[i]);
        }

        for (int i = 0; i < progresses.length; i++) {
            if(i+1 < progresses.length && period[i] > period[i+1]){
                period[i+1] = period[i];
            }
        }
        System.out.println("temp: "+ Arrays.toString(temp));
        System.out.println("period: "+ Arrays.toString(period));

        // 비교해서 같은 날에 햇으면 ++ 아니면 1
        List<Integer> a = new ArrayList<>();
        int index = 0;
        int cnt = 0;
        for(int i =0; i< period.length; i++){
            cnt = 1;
            if(i != 0 && period[i] == period[i-1]){
                System.out.println("period"+i+" : "+period[i]);
                continue;
            }
            a.add(cnt);
            for (int j = i + 1; j < period.length; j++) {

                if (period[i] == period[j]) {
                    cnt++;
                    a.set(index, cnt);
                }
            }
            System.out.println(" index: "+index+" cnt: "+cnt);
            index++;
        }
        System.out.println("a의 값은? : "+a.toString());
        return answer;
    }
    public int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
