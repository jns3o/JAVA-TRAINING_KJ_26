package chapter13;

import java.util.*;
import java.util.Map.Entry;

public class ExampelMap {
	public static void main(String[] args) {
		Map<String, Member> testMap = new HashMap<>();
		testMap.put("홍길동 객체", new Member("홍길동", 30));
		testMap.put("김영희 객체", new Member("김영희", 25));
		testMap.put("박철수 객체", new Member("박철수", 32));
		
		
		//System.out.println(testMap.get("김영희 객체").age);
		
		Map<String, Integer> memberList = new HashMap<>();
		memberList.put("홍길동", 30);
		memberList.put("김영희", 25);
		memberList.put("박철수", 32);
		memberList.put("신용권", 47);
		memberList.put("얄코", 30);
		
		//System.err.println("memberList 크기 : " + memberList.size());
		//System.out.println(memberList.get("박철수"));
		
		memberList.put("박철수", 45);
		
		System.out.println(memberList.get("박철수"));
		//System.err.println("memberList 크기 : " + memberList.size());
//		Iterator<Entry<String, Integer>> ir = memberList.entrySet().iterator();
//		while(ir.hasNext()) {
//			Entry<String, Integer> temp = ir.next();
//			if(temp.getKey().indexOf("김") > -1) {
//				System.out.println("이사람은 김씨다! 이름 : " + temp.getKey());
//			}
		
	}
}
