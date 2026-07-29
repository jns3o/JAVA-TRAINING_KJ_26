package chapter09;

public class ClassExample {
	public static void main(String[] args) {
		Test test = new Test();
		Test.Apple apple = test.new Apple();
		Test.Apple apple2 = test.new Apple();
		
		
		
		apple.appleCnt = 10;
		apple.applePrint();
		
		apple2.appleCnt = 20;
		apple.applePrint();
		apple2.applePrint();
		
		apple.appleTest();
	}
	
	
	
}
