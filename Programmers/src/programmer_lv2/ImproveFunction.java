package programmer_lv2;

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

        int[] progresses = {93, 30, 55};
        int[] speeds = {1,30, 5};

        int[] s  = new ImproveFunction().solution(progresses, speeds);

    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] temp = new int[progresses.length];
        int[] period = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            temp[i] = 100 -progresses[i];
            System.out.println("tempI: "+temp[i] +" speeds: "+speeds[i]);
            System.out.println("%: "+temp[i] % speeds[i]);

            if(temp[i] % speeds[i] != 0 ){
                period[i]=(temp[i] / speeds[i]) +1;
            }else{
                period[i]=temp[i] / speeds[i];
            }
            System.out.println("tempI/speeds: "+period[i]);
        }

        for (int i = 0; i < progresses.length; i++) {
            if(i+1 < progresses.length && period[i] > period[i+1]){
                System.out.println(":");
                period[i+1] = period[i];
            }
            System.out.println("tempI/speeds: "+period[i]);
        }
        int cnt = 0;
        for(int i =0; i < period.length; i++){
            if(i != 0){
                cnt = period[i] == period[i-1] ? +1 : cnt;
            }
            System.out.println("cnt: "+cnt);

        }

        return answer;
    }


}
