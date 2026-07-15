package chapter7.parenttest;

public class Example {

	public static void main(String[] args) {
		//Child c = new Child();
		Parent p1 = new Parent();
		Parent p2 = new Child();
		
		
		
		
		boolean r = p2 instanceof Child;//p2의 타입이 Child인지 묻는 연산자
		
		System.out.println("r : " +r);
		
		
		
		
	}

}
