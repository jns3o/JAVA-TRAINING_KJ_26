package soloPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Practice02 {
	public static void main(String[] args) {
		cal(); //시작하고 cal메서드 호출
	}
	
	public static int[] cal() {
		int[] arr = new int[8];// 중복이 제거된 수들을 담을 10칸짜리(테스트) 배열을 생성
		Random r = new Random();
		int boxSize = 0;
		Set<Integer> set = new HashSet<>();
		int a = 0;
		
		while(a < arr.length) {
	        int num = r.nextInt(0, 11); // 0부터 9까지 랜덤 수 뽑기
	        
	        if(!set.contains(num)) {
	            set.add(num); 
	            arr[a] = num;             
	            a++;                     
	        }
	       
		
		
		}System.out.println(set);
		return arr;
	}
}
