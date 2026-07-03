package chapter4;

import java.util.Scanner;

public class practice1 {

	public static void main(String[] args) {
		/*
		 * <미니 계산기 만들기>
		 * - 조건 -
		 * 1. 계산은 덧셈, 뺄셈, 곱셈, 나눗셈만 잘 동작하면 됨
		 * 2. 숫자 두개는 입력받기
		 * 3. 간단한 설명 출력해주기
		 * 4.코드마다 주석달기
		 * 5.소수로도 계산이 가능해야 한다 
		 * 6.출력 형태는 소숫점 둘째자리 까지만
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("사용설명서: " +"위 계산기는 숫자 두 개를 차례로 입력 후 기호에 알맞은 숫자까지 입력하여 계산할 수"
				+ " 있습니다  ");
		System.out.println("(기호에 알맞은 숫자들:" + "+ = 1," + " - = 2," + " * = 3," + " / = 4)");
		System.out.println("계산하기 위해 숫자 2개와 부호를 차례대로 입력해주세요 ");
		System.out.println("첫 번째 숫자: ");
		double num = Double.parseDouble(sc.nextLine());
		System.out.println("두 번째 숫자: ");
		double num2 = Double.parseDouble(sc.nextLine());
		System.out.println("기호에 알맞은 숫자: ");
		int giho = sc.nextInt();
		
		System.out.println("계산 결과:");
		if (giho == 1) {
			System.out.printf("%.2f", num + num2);
		}else if (giho == 2) {
			System.out.printf("%.2f", num - num2);
		}else if (giho == 3) {
			System.out.printf("%.2f", num * num2);
		}else if (giho == 4) {
			
		    if (num2 == 0) {
		    	System.out.println("0은 입력할 수 없습니다. 다른 값을 입력해주세요");
		    } else {
		    	System.out.printf("%.2f", num / num2);
		    
		    }
		
		
			
			
			
		}
		
//		switch(cal) {
//		case "+"
//			System.out.printf("계산결과: %.2f", num1 + num2);
//			break;
//		case
//			System.out.printf("계산결과: %.2f", num1 - num2);
//			break;
//		
		
		
		
		
		}
		
		
		

	}


