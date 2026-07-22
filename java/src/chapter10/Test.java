package chapter10;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		while(true) {
		System.out.println("숫자를 입력해 주세요.");
		System.out.println("끝내시려면 0를 입력하세요.");
		int a = 0;
		try {
			 a = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다. 처음으로 되돌아갑니다.");
			continue;
		}

		if(a==0) break;
		System.out.println("입력된 값은 " + a + "입니다.");
		
	}
	}
}
