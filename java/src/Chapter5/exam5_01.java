package Chapter5;

import java.util.Random;

public class exam5_01 {

	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Hello World";
		
		String[] str3 = str2.split(" ");
//		System.out.println("str1 : " + str1);
//		System.out.println("str3[0] : " + str3[0]);
//		
//		System.out.println(str1 == str3[0]);
		
		/*
		 * 배열 : 같은 타입의 변수를 여러개 선언하고 싶을때 사용
		 *   -> 같은 타입의 변수 여러개를 묶은 데이터 뭉텅이
		 * 
		 * 배열 선언 :
		 *  자료형 변수명[] = {초기화 할 값};
		 *  자료형[] 변수명 = {초기화 할 값};
		 *  자료형 변수명[] = new 자료형[개수]; //비어있는 배열 만들기
		 * 
		 * */
		//int num1 = 1, num2 = 2, num3 = 3, num4 = 4, num5 = 5, num6 = 5, 
		//		num7 = 7, num8 = 8, num9 = 9, num10 = 10;
		int num[] = {1605, 122, 12133, 5674, 7845, 6546, 777, 658, 1219, 121210}; 
		
		for(int i = 0; i < 10; i++)
			System.out.println("num[" + i +"] : " + num[i] );
		
		String strarr[] = {"Hello","Apple","Computer","Java"};
		for(int i = 0; i < 4; i++) {
			System.out.println("strarr[" + i + "] : " + strarr[i]);
		}
		
		
		
		
		Random r = new Random(); // 랜덤 숫자 뽑기 위한 셋팅
		
		// 야구게임 숫자 4개 (아직 중복제거 없음)
		int numarr[] = new int[4]; // 4칸짜리 빈 배열
		
		for (int i = 0; i < 4; i++) {
			numarr[i] = r.nextInt(0,9);
			System.out.println("numarr[" + i + "] : " + numarr[i]);
		}
		
		
		// 빙고게임 숫자 25개 뽑아서 숫자판 만드는 것 (아직 중복제거 없음) 
		String bingo[][] = new String[5][5];
		
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				bingo[i][j] = String.valueOf(r.nextInt(1,25));
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.printf("%3s ", bingo[i][j]);
			}
			System.out.println();
		}
		
		
		// 영화관 좌석 모두 예약가능 상태로 셋팅
		char sitArr[][] = new char[2][5];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				sitArr[i][j] = 'O';
			}
		}
		
		for (int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.printf("%3c ", sitArr[i][j]);
			}
			System.out.println();
		}
	}

}
