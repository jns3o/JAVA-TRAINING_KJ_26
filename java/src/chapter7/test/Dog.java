package chapter7.test;

public class Dog extends Animal{
	public Dog() {
		this.kind = "포유류";
	}
	
	@Override
	public void sound() {
		System.out.println("멍멍");
		
	}
	@Override
	public void breathe() {
		System.out.println("헥헥");
	}
}
