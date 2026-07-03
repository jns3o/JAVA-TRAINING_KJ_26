package chapter4;

import java.util.Scanner;

public class exam02 {

	public static void main(String[] args) {
		System.out.println("메뉴를 선택해주세요(1~4 선택)");
		System.out.println("---------------");
		System.out.println("1. 아메리카노(Hot)");
		System.out.println("2. 아메리카노(Ice)");
		System.out.println("3. 콜드브루(Ice)");
		System.out.println("4. 화이트 뱅쇼(Ice)");
		System.out.println("---------------");
		
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();
		
		if (menu == 1) {
			System.out.println("아메리카노(Hot)을 선택하셨습니다");
		}else if (menu == 2) {
			System.out.println("아메리카노(Ice)를 선택하셨습니다");
		}else if (menu == 3) {
			System.out.println("콜드브루(Ice)를 선택하셨습니다.");
		}else if (menu == 4) {
			System.out.println("화이트 뱅쇼(Ice)를 선택하셨습니다");
		}else {
			System.out.println("메뉴가 아닌 다른 번호를 선택하셨습니다");			
		}
		
		/*
		 * switch문
		 * switch (변수) {
		 * case ~ :
		 *      //case에 해당되면 실행할 문장
		 * }
		 * 
		 *  *case 에 입력해주는 값은 변수의 자료형과 맞춰서 작성해 주어야 한다!
		 *  *각 case 틀의 마지막에 break;를 넣어주지 않는다면 중단하지 않고 계속 진행된다.
		 *  (즉 모든 것이 다 출력이 되어버림)
		 *  *switch문은 단순 동등 비교밖에 못함.(대소비교 x)
		 *  반복문에서 for과 while은 자주 쓰임
		 */
		
//		switch(menu) {
//		case 1:
//			System.out.println("아메리카노(Hot)을 선택하셨습니다");
//			break;
//		case 2:
//			System.out.println("아메리카노(Ice)를 선택하셨습니다");
//			break;
//		case 3:
//			System.out.println("콜드브루(Ice)를 선택하셨습니다.");
//			break;
//		case 4:
//			System.out.println("화이트 뱅쇼(Ice)를 선택하셨습니다");
//			break;
//		default:
//				System.out.println("메뉴가 아닌 다른 번호를 선택하셨습니다");	
//			
			
		

		
		
		}
		
	}
	
	


