package chapter13;

import java.util.*; //*은 java.util에 있는 걸 전부 import하는 방법

public class ExampleList {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>(); //첫번째 <>는 생략 불가, 두번째 new생성한 괄호는 생략가능
		List<String> list2 = new LinkedList<String>(); 
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 걸린시간: " + (endTime-startTime) + " ns");
		
		startTime = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list2.add(0, String.valueOf(i));
		}
		
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린시간: " + (endTime-startTime) + " ns");
	}

}
