package chapter13;

import java.util.HashSet;
import java.util.Set;

public class HaseSetExample {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<>();
		
		set.add(new Member(new String("홍길동"),30));
		set.add(new Member("홍길동",30));
		
		System.out.println("총 개체 수 : " + set.size());
	}
}
