package chapter6;

import java.util.Scanner;

public class exam6_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 두개를 입력해 주세요. >> ");
		String input = sc.nextLine();
		int[] number = new int[2];
		int result = 0;
		number[0] = Integer.parseInt(input.split(" ")[0]);
		number[1] = Integer.parseInt(input.split(" ")[1]);
		
		System.out.print("기호를 입력해 주세요. >> ");
		char input2 = sc.nextLine().charAt(0);
		
		Calculation cal = new Calculation(number[0], number[1], input2);
		result = cal.selectFuncion();
		
		System.out.printf("%d %s %d = %d", number[0],input2, number[1], result);
		
	}
}


class Calculation{
	int a;
	int b;
	char c;
	
	public Calculation(int num1, int num2, char gubun) {
		this.a = num1;
		this.b = num2;
		this.c = gubun;
	}
	
	
	int selectFuncion() {
		switch (this.c) {
		case '+':
			return add();
		case '-':
			return minus();
		case '*':
			return sub();
		case '/':
			return div();
		default:
			return 0;
		}
		
	}
	
	int add(){
		return this.a + this.b;
	}
	
	int minus(){
		return this.a - this.b;
	}
	
	int sub(){
		return this.a * this.b;
	}
	
	int div(){
		return this.a / this.b;
	}
	
	
}
