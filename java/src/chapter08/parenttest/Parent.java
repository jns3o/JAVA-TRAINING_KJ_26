package chapter7.parenttest;

public class Parent {
	
	
	
	
	
	
	
	void test1() {
		System.out.println("부모 테스트 1번입니다");
	}
	
	void test2() {
		System.out.println("부모 테스트 2번입니다");
	}
	
	void test10(Parent p) {
		p.test2();
	}
	
}
