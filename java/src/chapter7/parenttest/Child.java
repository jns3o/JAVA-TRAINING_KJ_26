package chapter7.parenttest;

public class Child extends Parent{
	@Override
	void test2() {
		System.out.println("자식 테스트 2번입니다");
	}
	
	void test3() {
		System.out.println("자식 테스트 3번입니다");
	}
}
