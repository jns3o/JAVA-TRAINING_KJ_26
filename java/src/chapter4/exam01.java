package chapter4;

import java.util.Scanner;

public class exam01 {

	public static void main(String[] args) {
		// 조건문 : 조건을 만족하거나 만족하지 않을 때 실행
		// if ( 조건식 ) { 조건 만족시 실행 할 문장들 }
		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요 : ");
//		int x = Integer.parseInt(sc.nextLine());
//		
//		if(x % 2 == 0 ) {
//			System.out.println("이 숫자는 짝수입니다");
//		}else {
//			System.out.println(("이 숫자는 홀수입니다."));
//		}
//		
		System.out.println("가위, 바위, 보 중 하나를 입력해주세요 : ");
		String s = sc.nextLine();
		int result = 0;
		
		System.out.println("입력한 값 :" + s);
		
		//가위 : 1
		//바위 : 2
		//보 : 3
		//System.out.println("가위".equals(s));
		//System.out.println(s.equals("가위"));
		// 1>3
		// 3<1
		if ( s.equals("가위")) {
			result = 1;
		}else if ( s.equals("바위")) {
			result = 2;
		}else if ( s.equals("보")) {
			result = 3;
		}else {
			System.out.println("잘못된 값이 입력되었습니다.");
		}
		System.out.println("result :" + result);
		
		
		
		
		
//		if (x >= 100) {
//			System.out.println("이 숫자는 100 이상입니다");
		}
	}


