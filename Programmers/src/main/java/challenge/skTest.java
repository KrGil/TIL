package challenge;

import com.tistory.eisen.Eisen;

import java.util.*;

/**
 * packageName :  challenge
 * fileName : skTest
 * author :  eisen
 * date : 2022/03/12
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022/03/12                eisen             최초 생성
 */
public class skTest {
//      4578	[1, 4, 99, 35, 50, 1000]	2308
//      1999	[2, 11, 20, 100, 200, 600]	2798
    public static void main(String[] args) {
        skTest skTest = new skTest();
        int[] coins = {1, 5, 10, 50, 100, 500};
//        int[] costs = {1, 4, 99, 35, 50, 1000};
        int[] costs = {2, 11, 20, 100, 200, 600};
//        int money = 4578;
        int money = 1999;
        System.out.println(skTest.sol(money, coins, costs));
    }
    public int sol(int money, int[]coins, int[]costs){
        // 1. coins과 costs를 비교
        int[] tempArr = new int[coins.length];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = coins[i] - costs[i];
        }
        // 2. 이득이 큰 순서대로 정렬.
        // 2-1 {index : value} 형식으로 값 저장.
        Map<Integer, Integer> tag = new HashMap<>();
        for (int i = 0; i < tempArr.length; i++) {
            tag.put(i, tempArr[i]);
        }
        // 2-2 value를 기준으로 sorting
        tag = sortMapByValue(tag);
        for (Integer key : tag.keySet()) {
            System.out.println("key = " + key + " value: " + tag.get(key));
        }
        // 2-3 sorting한 {index : value}의 index값으로 int[] 생성
        int[] order = tag.keySet().stream().mapToInt(e -> e).toArray();

        // 3 나눈 값 return
        int[] countArr = new int[order.length];
        for (int i = 0; i < order.length; i++) {
            countArr[order[i]] = money / coins[order[i]];
            money -= coins[order[i]] * countArr[order[i]];
        }
        Eisen.printArray(order);
        Eisen.printArray(countArr);
        // 4. 남은 값들을 더해서 return
        int result = 0;
        for (int i = 0; i < countArr.length; i++) {
            result += countArr[i]*costs[i];
        }
        return result;
    }

    public static LinkedHashMap<Integer, Integer> sortMapByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}
