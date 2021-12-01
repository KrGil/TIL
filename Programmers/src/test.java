import java.util.*;

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


        String a = "1";
        a += "0";
//        String c = a+b;
        System.out.println(a);


        List<String> versionNo = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        versionNo.add("test1");
        if(!versionNo.isEmpty()) {
            if(versionNo.get(0) != null) {
                map.put("versionNo", versionNo.get(0).toString());
            }
            else                         map.put("versionNo", "");
        }
        for(String key : map.keySet()){
            System.out.println("key: "+key+"   value: "+map.get(key).toString());
        }
    }
}
