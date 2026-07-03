package chapter2;

import java.util.Scanner;

public class exam2 {

	public static void main(String[] args) throws Exception {
		/**
		 * 기본 타입 - 정수형 byte : 1byte -> 256가지 > -128~127 short : 2byte -> 65536 >
		 * -32768~32767 int : 4byte -> 2의32제곱 (약 43억개) Long : 8byte -> 2의64제곱 (int범위를
		 * 벗어나는 숫자를 벗어날때 'L' 표시)
		 * 
		 * char(문자형) : 2byte(유니코드) -> 65536가지 > 0~65535
		 * 
		 * 기본 타입 - 실수형 float : 4bte (소숫점 사용시 F 표시) double : 8byte
		 * 
		 * 클래스 타입(기본타입 X) String : 문자열 (크기x)
		 */

		/*
		 * 논리형 boolean : 2가지 종류의 값(true / false)
		 */
		int a = 3, b = 5;
		boolean result = a < b;
		System.out.println(a < b);

		// 타입변환
		int num1;
		short num2 = 10;
		// 자동형변환 (작은타입 > 큰타입 대입)
		num1 = num2;
		// System.out.println(num1);

		num1 = 50;
		// 강제형변환 ( 큰타입>작은타입 대입)
		num2 = (short) num1;

		// 작은타입 _________________ 큰타입
		// byte < short(char) < int < long < float < double
		char ch = 'A';
		int num3 = ch;
		// System.out.println("num3 :" + num3);

		byte bt1 = 10, bt2 = 20;
		// System.out.println("bt1 :" + bt1 + " / bt2 ;" + bt2);

		byte btsum = (byte) (bt1 + bt2);
		// System.out.println(btsum);

		// 100p 예제 생각더하기
		byte value1 = 10;
		int value2 = 100;
		long value3 = 1000L;

		long sum = value1 + value2 + value3;
		System.out.println(sum);

		String str = "result : " + (value1 + value2 + value3);
		System.out.println(Integer.parseInt("1") + 5);

		// print
		// println > in > line(한줄
		// printf > f > format(형식)
		// -> 형식지정자 - %d(정수) %f(실수형) %s(문자열) %c(문자형) ..

		// System.out.printf("printf result : %d + %d + %d = %d", value1, value2,
		// value3, (value1 + value2 + value3));

		String st1 = "My name is";
		String name = "jun Seo";
		String st2 = "and I'm";
		int age = 22;
		String st3 = "years old.";

		// My name is OOO and I'm OO years old
		System.out.printf("%s %s %s %d %s", st1, name, st2, age, st3);
		// String(문자열)=S(문자열) 이기 때문에 "My name is"같은 문자로 쓴 문장은 %s로 해야함
		// age 22는 숫자(정수)이기 때문에 int - %d로 해야함
		// %s를 입력 후 +가 아닌 ,[쉼표]를 입력해줘야함. +을 입력 시 모든게 하나로 합쳐지려 하기 때문에
		// +가 아닌 ,[쉼표]를 입력해주어야함

		int year = 2026;
		
		int month = 6;
		int day = 29;

		/*
		 * System.out.println(year + "년" + month + "월" + day + "일");
		 * System.out.printf("%d년%d월%d일", year, month, day);
		 */

		// _ _ _ _ _ _ _
	    System.out.printf("%10d", 123);
	    
	   // int keyCode = System.in.read();
		//System.out.println("KeyCode : " + keyCode);
		//System.out.printf("KeyCode : %c\n", + keyCode);
		//한글 인식을 못함
		
		Scanner scanner = new Scanner(System.in);
		String inputName = scanner.nextLine();
		System.out.println(inputName);
		
	}

}
