package chapter09.test;

public class CallListener implements Button.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("전화를 겁니다");
	}
}
