package chapter6;

import java.lang.reflect.Array;
import java.util.Scanner;

public class BankProgram_homework {

	public static void main(String[] array) {
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
				createAccount(info);
				break;
			case "2":
				System.out.println("계좌목록을 조회합니다");
				AccList(info);
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

	static void printMsg() { //은행 엄부 시스템과 각 목록에 알맞은 번호를 사용자에게 출력 하는 메소드
		System.out.println("======은행 업무 시스템======\n1. 계좌 생성\n2. 계좌 목록 조회\n3. 입금\n4. 출금\n5. 잔액조회\n6. 종료\n==============");
	}
	static void createAccount(String[][] array) { //계좌목록을 생성하기 위해 계좌번호와 예금주 명을 입력받는 메소드
		Scanner sc = new Scanner(System.in);
		System.out.println("======계좌 생성======");
		System.out.println("계좌를 생성하기 위해 원하시는 계좌 번호 11자리와 예금주 명을 입력하시오(번호만 입력)");
		System.out.print("계좌번호 : ");
		String account = sc.nextLine();
		System.out.print("예금주 명 : ");
		String name = sc.nextLine();
		System.out.println();
		
		boolean overLap = false; //boolean을 false로 선언하면서 중복확인 전 중복이 없다고 선언
		for(int i = 0; i < array.length; i++) {
			if(array[i][0] != null) {
				if(array[i][0].equals(account)) {
					overLap = true; /*if문 안 array[i][0].equals(account)는 첫 계좌를 생성하고 한 바퀴를 돌았을때 위에서 사용자가
					account에 원하는 계좌번호를 다시 입력하였는데 칸은 달라도 번호가 같아 버리면 (예: array[0][0] 하고 array[1][0]이
					계좌번호 11자리가 모두 동일할 경우 위에서 boolean의 변수명이였던 overLap이 false에서 true가 되면서 중복되는 계좌번호이기에
					다른 번호를 입력해주라는 문구를 출력*/
					if(overLap = true) {
						System.out.println("입력하신 계좌번호는 중복되는 번호입니다. 다른 번호를 입력해주세요\n");
					}
					return; //중복이 발생하였을 경우 뒤로 되돌아가서 값을 재입력하기 위해 return;을 사용
					
				}
			}
		}	
		if (account.length() == 11) { 
			int num = -1; //만약 info가[99][0~3]까지 다 차버렸을경우에 사용자가 값을 하나 더 입력해버리면 인덱스가 초과되어버리기에 초과되면
			// 프로그램이 꺼지게 만들기 위해 num = -1
			for(int i = 0; i < array.length; i++) {
				if(array[i][0] == null) {
					num = i;
					break;
				}
			}
			array[num][0] = account; //return을 쓰지 않고 info에 account와 name의 정보를 올리기 위해 createAccount메소드의 변환형은 없이
			array[num][1] = name;	 //void로 만들고 array[num][0,1,2] = account / name / "0" ; 등으로 입력받게 해서 
			array[num][2] = "0";	 //main 메소드에서 값을 바로 받아쓸 수 있게 하기 위해 입력
			
			
			System.out.println("계좌번호: " + account + " / 예금주 명: " + name);
			System.out.println("으로 저장되었습니다");
			System.out.println();
						
		} else {
			System.out.println("입력된 계좌번호는 " + account.length() + " 자리입니다. 양식에 맞게 다시 입력해주세요");
		}
		

	}
	static void AccList(String[][] array) { //AccList [AccountList] => 입력된 계좌 목록을 보여주기 위한 메소드
		Scanner sc = new Scanner(System.in);
		System.out.println("====현재 입력된 계좌 목록====");
		for(int i = 0; i < array.length; i++) {//세로칸 기준 아래로 내려가면서 각 계좌의 3가지 정보를 보여주기 위해 설정
			if(array[i][0] != null) { // 입력된 계좌 목록 중에 아무것도 입력되지 칸들을 전부 null(없음)이라 했을 때 null이 아닐 경우에만 목록이 출력되도록 설정
			System.out.println("계좌번호 : " + array[i][0] + " | 예금주 명 : " + array[i][1] + " | 잔액 : " + array[i][2]);
			}
		}
	
	

	

	}

}
