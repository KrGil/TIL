import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int answer = 0;
        int[] fullNums = {1,2,3,4,5,6,7,8,9,10};
        int[] numbers = {1,2,3,4,6,7,8,0};        
        Arrays.sort(numbers);

        for(int item : fullNums){
            boolean flag = false;
            for(int i=0; i< numbers.length; i++){
                if(item == numbers[i]){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                answer += item;
            }
        }
        System.out.println(answer);
    }
}
