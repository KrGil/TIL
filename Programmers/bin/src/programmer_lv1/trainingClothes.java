package programmer_lv1;

import java.util.HashMap;
import java.util.Map;

public class trainingClothes {
	public static void main(String[] args) {
		
		int n = 3;
		int[] lost = {1,2};
		int[] reserve = {3};
		System.out.println(new trainingClothes().solution(n, lost, reserve));
	}
	
	
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] total  = new int[n];
		Map<Integer, Integer> totalHash = new HashMap<>();
		Map<Integer, Integer> lostHash = new HashMap<>();
		Map<Integer, Integer> reserveHash = new HashMap<>();
		
		for(int i =0; i < n; i ++) { //total {1,2,3,4,5} 
			total[i] = i+1;
			totalHash.put(total[i], 1);
			
			System.out.print(total[i] + "\t");
		}
		for(int i : totalHash.keySet()){
			System.out.println("default  total : "+i+"   "+totalHash.get(i));
		}
		for(int i =0; i < lost.length; i ++){
			System.out.println("lost : "+i+"   "+lostHash.get(i));
			lostHash.put(lost[i], 0);
			totalHash.put(lost[i], 0);
		}
		for(int i : totalHash.keySet()){
			System.out.println("lost빼고 total : "+i+"   "+totalHash.get(i));
		}
		
		for(int i =0; i < reserve.length; i ++){ 
			reserveHash.put(reserve[i], 2);
			System.out.println("reserve["+i+"] = " + reserve[i]);
		}
		
		int j =0;//lost = {2,4} reserve = {1,3,5}
		for(int i =0; i <= total.length; i ++){ //1, 3, 5
			System.out.println("시작시 reserveHash : "+i+"   "+reserveHash.get(i));
			System.out.println("시작시 lostHash : "+i+"   "+lostHash.get(i));
			try{
			if(reserveHash.get(i) == 2){
				System.out.println("1");
				if(lostHash.containsKey(i)){ 				
					if(lostHash.get(i) ==0){
						reserveHash.put(i, 1);
						lostHash.put(i, 1);
						totalHash.put(i, 1);
						System.out.println("i reserveHash : "+i+"   "+reserveHash.get(i));
						continue;						
					}
				} if(lostHash.containsKey(i-1)){
					System.out.println("2_1");
					if(lostHash.get(i-1) ==0){
						System.out.println("3_1");
						reserveHash.put(i-1, 1);
						lostHash.put(i-1, 1);
						totalHash.put(i-1, 1);
						System.out.println("i-1 reserveHash : "+(i-1)+"   "+reserveHash.get(i-1));
						continue;
					}
					System.out.println("2_2");
				}if(lostHash.containsKey(i+1)){
					System.out.println("2");
					if(lostHash.get(i+1) == 0){
						System.out.println("3");
						reserveHash.put(i+1, 1);
						totalHash.put(i+1, 1);
						lostHash.put(i+1, 1);
						System.out.println("i+1 reserveHash : "+(i+1)+"   "+reserveHash.get(i+1));
						continue;
					}
				}
			}
			}catch(Exception e){
				
			}
		}
		for(int i : totalHash.keySet()){
			System.out.println("계산 다 끝나고 total : "+i+"   "+totalHash.get(i));
			if(totalHash.get(i) > 0){
				System.out.println("totalHash : "+i+" = "+totalHash.get(i));
				answer++;
			}
		}
		
		return answer;
	}
}
