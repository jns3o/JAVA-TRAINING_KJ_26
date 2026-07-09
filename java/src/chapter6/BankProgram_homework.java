package chapter6;

import java.util.Scanner;

public class BankProgram_homework {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 값을 입력받기 위해 scanner를 사용
		String[][] info = new String[100][3]; // 조건 2번 힌트,//정보담을 변수
		String select = null;
		System.out.println("InterNational PUBLIC BANK에 오신걸 환영합니다");
		printMsg();
		System.out.print("원하시는 업무를 선택해주세요 : ");
		while (!"6".equals(select)) { // (!select.equals("6")) 가 오류가 나서 "6"와 select의 위치를 바꿨습니다
			select = sc.nextLine();

			switch (select) {
			case "1":
				System.out.println("계좌를 생성합니다");
				createAccount();
				break;
			case "2":
				System.out.println("계좌목록을 조회합니다");
				break;
			case "3":
				System.out.println("입금합니다");
				break;
			case "4":
				System.out.println("출금합니다");
				break;
			case "5":
				System.out.println("잔액을 조회합니다");
				break;
			case "6":
				System.out.println("프로그램을 종료합니다");
				return;

			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주십시오");
				break;
			}
			printMsg();
			System.out.println("원하시는 업무를 선택해주세요 : ");

		}

	}

	static void printMsg() {
		System.out.println("======은행 업무 시스템======");
		System.out.println("1. 계좌 생성");
		System.out.println("2. 계좌 목록 조회");
		System.out.println("3. 입금");
		System.out.println("4. 출금");
		System.out.println("5. 잔액조회");
		System.out.println("6. 종료");
		System.out.println("=========================");
	}

	static String[] createAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======계좌 생성======");
		System.out.println("계좌를 생성하기 위해 원하시는 계좌 번호 11자리와 예금주 명을 입력하시오(번호만 입력)");
		System.out.print("계좌번호 : ");
		String account = sc.nextLine();
		System.out.print("예금주 명 : ");
		String name = sc.nextLine();
		System.out.println();

		if (account.length() == 11) {
			System.out.println("계좌번호: " + account + " / 예금주 명: " + name);
			System.out.println("으로 저장되었습니다");
			System.out.println();

		} else {
			System.out.println("입력된 계좌번호는 " + account.length() + " 자리입니다. 양식에 맞게 다시 입력해주세요");
		}

		String[] upload = new String[2];
		upload[0] = account;
		upload[1] = name;

		return upload;

	}

}
