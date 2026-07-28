package chapter13;

import java.util.*;

public class ExampleSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("안녕하세요");
		set.add("여기는");
		set.add("IT06실 입니다");
		
		set.remove("여기는");
		
		set.add("사과");
		set.add("바나나");
		set.add("포도");
		
		// ArrayList같은것도 iterator로 하나하나 다 출력할 수 있으나 최신버전에서는 향상된 for문으로 출력
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {// 일렬로 나열된 iterator의 다음 것이 있으면 true로 계속 나아고 없을 시 false
			String str = iterator.next();
			if(str.equals("포도")) {
				iterator.remove();
			}
		}
		iterator = set.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
		}
		System.out.println(set.contains("바나나"));
	}

}
