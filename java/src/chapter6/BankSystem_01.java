package chapter6;

import java.lang.reflect.Array;
import java.util.Scanner;

public class BankSystem_01 {
//
	public static void main(String[] array) {
		Scanner sc = new Scanner(System.in); // 값을 입력받기 위해 scanner를 사용
		String[][] info = new String[100][3]; // 조건 2번 힌트,//정보담을 변수
		String select = null;
		System.out.println("InterNational PUBLIC BANK에 오신걸 환영합니다\n");
		printMsg();
		System.out.print("\n원하시는 업무를 선택해주세요 : ");
		while (!"6".equals(select)) { // (!select.equals("6")) 가 오류가 나서 "6"와 select의 위치를 바꿨습니다
			select = sc.nextLine();

			switch (select) {
			case "1":
				System.out.println("\n계좌를 생성합니다\n");
				createAccount(info);
				break;
			case "2":
				System.out.println("\n계좌목록을 조회합니다\n");
				accList(info);
				break;
			case "3":
				System.out.println("\n입금합니다\n");
				deposit(info);
				break;
			case "4":
				System.out.println("\n출금합니다\n");
				withDrawal(info);
				break;
			case "5":
				System.out.println("\n잔액을 조회합니다\n");
				checkBalance(info);
				break;
			case "6":
				System.out.println("\n프로그램을 종료합니다\n");
				return;

			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주십시오\n");
				break;
			}
			printMsg();
			System.out.print("\n원하시는 업무를 선택해주세요 : ");

		}

	}

	static void printMsg() { // 은행 엄부 시스템과 각 목록에 알맞은 번호를 사용자에게 출력 하는 메소드
		System.out.println(
				">======은행 업무 시스템======<\n1. 계좌 생성\n2. 계좌 목록 조회\n3. 입금\n4. 출금\n5. 잔액조회\n6. 종료\n>========================<");
	}

	static void createAccount(String[][] array) { // 계좌목록을 생성하기 위해 계좌번호와 예금주 명을 입력받는 메소드
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(">=========계좌 생성=========<");
			System.out.println("계좌를 생성하기 위해 원하시는 계좌 번호 6자리와 예금주 명을 입력하시오(번호만 입력)");
			System.out.print("\n-계좌번호 : ");
			String account = sc.nextLine();

			boolean overLap = false; // boolean을 false로 선언하면서 중복확인 전 중복이 없다고 선언
			for (int i = 0; i < array.length; i++) {
				if (array[i][0] != null) {
					if (array[i][0].equals(account)) {
						overLap = true;
						break;
						/*
						 * if문 안 array[i][0].equals(account)는 첫 계좌를 생성하고 한 바퀴를 돌았을때 위에서 사용자가 account에
						 * 원하는 계좌번호를 다시 입력하였는데 칸은 달라도 번호가 같아 버리면 (예: array[0][0] 하고 array[1][0]이 계좌번호
						 * 11자리가 모두 동일할 경우 위에서 boolean의 변수명이였던 overLap이 false에서 true가 되면서 중복되는 계좌번호이기에
						 * 다른 번호를 입력해주라는 문구를 출력
						 */

					}
				}
			}
			if (overLap == true) {
				System.out.println("입력하신 계좌번호는 중복되는 번호입니다. 다른 번호를 입력해주세요\n");
				continue;
			}
			if (account.length() == 6) {
				int num = -1; // 만약 info가[99][0~3]까지 다 차버렸을경우에 사용자가 값을 하나 더 입력해버리면 인덱스가 초과되어버리기에 초과되면
				// 프로그램이 꺼지게 만들기 위해 num = -1
				for (int i = 0; i < array.length; i++) {
					if (array[i][0] == null) {
						num = i;
						break;
					}
				}
				if (num == -1) {
					System.out.println("[!] 현재 Int.Public Bank의 온라인 계좌가 모두 가득찼습니다. 죄송합니다.\n");
					continue;
				}
				System.out.print("-예금주 명 : ");
				String name = sc.nextLine();
				System.out.print("\n-최초 계좌 개설 시 초기 금액 입금이 필요합니다\n 입금하고자 하는 금액을 입력해주세요 : ");
				String money = sc.nextLine();
				System.out.println();
				try {
					int Firmoney = Integer.parseInt(money);
					if (money.length() != String.valueOf(Firmoney).length()) {
						System.out.println(" [!]금액의 첫 번째 자리에는 0이 올 수 없습니다\n" + " 다시 입력해주시기 바랍니다\n");
						continue;
					}
				} catch (Exception e) {
					System.out.println(" 입금액은 숫자만 입력가능합니다\n" + " 다시 입력해주세요\n");
					continue;
				}
				if (Integer.parseInt(money) == 0) {
					System.out.println(" 초기 금액은 0원으로 할 수 없습니다\n" + " 다시 입력해주세요\n");
					continue;
				}
				System.out.print(money + "원 입금확인되었습니다");
				if (name.length() <= 6) {
					System.out.println("\n>=========================<");
					System.out.println();

					array[num][0] = account; // return을 쓰지 않고 info에 account와 name의 정보를 올리기 위해 createAccount메소드의 변환형은 없이
					array[num][1] = name; // void로 만들고 array[num][0,1,2] = account / name / "0" ; 등으로 입력받게 해서
					array[num][2] = money; // main 메소드에서 값을 바로 받아쓸 수 있게 하기 위해 입력
					System.out.println("계좌번호: " + account + " | 예금주 명: " + name + " | 계좌 잔액: " + money + "\n");
					System.out.println("으로 저장되었습니다");
					System.out.println();
					break;

				} else {
					System.out.println("[!]예금주 명은 6자까지 입력가능합니다, 메인 메뉴로 돌아갑니다");
					continue;
				}

			} else {
				System.out.println("입력된 계좌번호는 " + account.length() + " 자리입니다. 양식에 맞게 다시 입력해주세요\n");
				continue;
			}
		}
	}

	static void accList(String[][] array) { // AccList [AccountList] => 입력된 계좌 목록을 보여주기 위한 메소드
		Scanner sc = new Scanner(System.in);
		boolean say = true;// 논리 타입인 boolean을 true로 먼저 선언을 해줘서 for문안에서 for가 false일 경우 실행되게 하기 위해 선언
		System.out.println(">=====현재 입력된 계좌 목록=====<\n");
		System.out.println("계좌번호\t\t예금주 명\t\t계좌잔액\n");
		for (int i = 0; i < array.length; i++) {// 세로칸 기준 아래로 내려가면서 각 계좌의 3가지 정보를 보여주기 위해 설정
			if (array[i][0] != null) { // 입력된 계좌 목록 중에 아무것도 입력되지 칸들을 전부 null(없음)이라 했을 때 null이 아닐 경우에만 목록이 출력되도록 설정
				say = false;
				System.out.println(array[i][0] + "\t\t" + array[i][1] + "\t\t" + array[i][2] + "원" + "\n");
			}
		}
		if (say == true) {// 처음 boolean을 true로 선언하고 for문 안에서 false로 실행되게 했을때
			// if(say == true)는 "만약 boolean say가 true(참)일 경우 밑에 문장 출력되게 하기 위해 입력
			// 세미콜론(;)으로 하게 되면 if(say==true)에서 끝나버리기 때문에 중괄호로 묶음
			System.out.println("현재 입력된 계좌가 없습니다\n");
		}
	}

	static void deposit(String[][] array) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			boolean check = false;
			System.out.println(">===========입금===========<\n");
			System.out.print("입금하시고자 하는 계좌의 계좌번호를 입력해주세요 : ");
			String account2 = sc.nextLine();
			for (int i = 0; i < array.length; i++) {
				if (array[i][0] != null && array[i][0].equals(account2)) {
					check = true;
					System.out.println("-이 계좌가 당신의 계좌가 맞습니까?\n");
					System.out.println("<계좌 번호> " + array[i][0] + "\t <예금주 명> " + array[i][1] + "\t <계좌 잔액> "
							+ array[i][2] + "\n");
					System.out.print("이 계좌가 당신의 계좌가 맞다면 1, 아니라면 2를 입력해주세요 : ");
					String account3 = sc.nextLine();
					System.out.println();
					try {
						int temAccount = Integer.parseInt(account3);
						if (temAccount == 1) {
							System.out.println("확인되었습니다. 입금하고자 하는 금액을 입력해주세요");
							System.out.println(
									"[숫자로만 입력가능하며 입금액에 -(마이너스)는 들어갈 수 없고 입금액 앞에 0이 붙는 경우 시스템이 자동으로 빼고 계산합니다. 금액의 기준은 원화입니다]");
							System.out.print("입금액 : ");
							String pay = sc.nextLine();
							try {
								int tempay = Integer.parseInt(pay);
								if (tempay <= 0) {
									System.out.println("입금액에 오류가 생겼습니다. 입금액에 - 또는 0은 입력 불가합니다, 재입력 해주세요");
									continue;
								} else {
									array[i][2] = String.valueOf(Integer.parseInt(array[i][2]) + tempay);
								}

								System.out.println("\n입금되었습니다\n" + "\n-현재 고객님의 계좌 내역입니다-\n<계좌번호>" + array[i][0]
										+ " <예금자 명> " + array[i][1] + " <현재 계좌액> " + array[i][2] + "\n");
								return;
							} catch (Exception e) {
								System.out.println("입금액은 숫자로만 입력가능하며, 한글 또는 영어로 입력불가능 합니다. 재입력 하시오\n");
								continue;
							}
						} else {
							System.out.println("계좌를 다시 확인해주세요.\n");
							continue;
						}
					} catch (Exception e) {
						System.out.println("잘못입력하였습니다, 재입력 바랍니다\n");
						continue;
					}

				}
			}
			if (check == false) {
				System.out.println("현재 일치하는 계좌가 없습니다 \n");
				System.out.println("처음으로 되돌아가시려면 1, 입금화면으로 돌아가시려면 2 또는 아무 키나 입력해주세요 : ");
				String back = sc.nextLine();
				if ("1".equals(back)) {
					return;
				}
				if ("2".equals(back)) {
					continue;
				}
			}

		}

	}
	static void withDrawal(String[][] array) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			boolean check = false;
			System.out.println(">===========출금===========<\n");
			System.out.print("출금하시고자 하는 계좌의 계좌번호를 입력해주세요 : ");
			String account2 = sc.nextLine();
			for (int i = 0; i < array.length; i++) {
				if (array[i][0] != null && array[i][0].equals(account2)) {
					check = true;
					System.out.println("-이 계좌가 당신의 계좌가 맞습니까?\n");
					System.out.println("<계좌 번호> " + array[i][0] + "\t <예금주 명> " + array[i][1] + "\t <계좌 잔액> "
							+ array[i][2] + "\n");
					System.out.print("이 계좌가 당신의 계좌가 맞다면 1, 아니라면 2를 입력해주세요 : ");
					String account3 = sc.nextLine();
					System.out.println();
					try {
						int temAccount = Integer.parseInt(account3);
						if (temAccount == 1) {
							System.out.println("확인되었습니다. 출금하고자 하는 금액을 입력해주세요");
							System.out.println(
									"[숫자로만 입력가능하며 입금액에 -(마이너스)는 들어갈 수 없고 출금액 앞에 0이 붙는 경우 시스템이 자동으로 빼고 계산합니다. 금액의 기준은 원화입니다](");
							System.out.print("출금액 : ");
							String pay = sc.nextLine();
							try {
								int tempay = Integer.parseInt(pay);
								int vrmoney = Integer.parseInt(array[i][2]);
								if (tempay <= 0) {
									
									System.out.println("출금액에 오류가 생겼습니다. 출금액에 - 또는 0은 입력 불가합니다, 재입력 해주세요");
									continue;
								} else {
									if(vrmoney - tempay < 0) {
										System.out.println("[!]경고 - 출금하시려는 액수가 현재 잔액보다 많습니다 | " + "<현재 잔액> : " + array[i][2] + "  | 출금화면으로 되돌아갑니다");
										continue;
									}
									
									
									array[i][2] = String.valueOf(Integer.parseInt(array[i][2]) - tempay);	
								}
								System.out.println("\n출금되었습니다\n" + "\n-현재 고객님의 계좌 내역입니다-\n<계좌번호>" + array[i][0]
										+ " <예금자 명> " + array[i][1] + " <현재 계좌액> " + array[i][2] + "\n");
								return;
							} catch (Exception e) {
								System.out.println("출금액은 숫자로만 입력가능하며, 한글 또는 영어로 입력불가능 합니다. 재입력 하시오\n");
								continue;
							}
						} else {
							System.out.println("계좌를 다시 확인해주세요.\n");
							continue;
						}
					} catch (Exception e) {
						System.out.println("잘못입력하였습니다, 재입력 바랍니다\n");
						continue;
					}
				}
			}
			if (check == false) {
				System.out.println("현재 일치하는 계좌가 없습니다 \n");
				System.out.println("처음으로 되돌아가시려면 1, 출금화면으로 돌아가시려면 2 또는 아무 키나 입력해주세요 : ");
				String back = sc.nextLine();
				if ("1".equals(back)) {
					return;
				}
				if ("2".equals(back)) {
					continue;
				}
			}

		}

	}
	static void checkBalance(String[][] array) {
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println(">==========잔액 조회=========<\n");
		System.out.print("잔액 조회하고자 하는 계좌의 계좌번호를 입력해주세요 : ");
		String accountNum = sc.nextLine();
		boolean a = false;
		try {int AccountNum = Integer.parseInt(accountNum);
			for (int i = 0; i < array.length; i++) {
				if (array[i][0] != null && array[i][0].equals(accountNum)) {
					a = true;
					System.out.println("-<계좌번호> " + array[i][0] + " | <예금자 명> " + array[i][1] + "\n");
					System.out.print("-이 계좌가 당신의 계좌가 맞습니까? 맞다면 1, 아니라면 2를 눌러주세요 : ");
					String choiceNum = sc.nextLine();
					System.out.println();
					try {int ChoiceNum2 = Integer.parseInt(choiceNum);
						if (ChoiceNum2 == 1) {
							System.out.println("확인되었습니다. 현재 [" + array[i][1] + "] 고객님의 계좌 잔액은 " + array[i][2] + "원 입니다\n 메인화면으로 돌아갑니다...\n");
							return;
						}else if (ChoiceNum2 == 2) {
							System.out.println("계좌를 다시 확인해주세요\n");
							continue;
						}else {
							System.out.println("잘못된 값이 입력되었습니다. 잔액 조회 화면으로 되돌아갑니다");
							continue;
						}
					} catch (Exception e) {
						System.out.println("잘못된 값이 입력되었습니다. 잔액 조회 화면으로 되돌아갑니다\n");
						continue;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("[!]잘못된 계좌번호입니다. 재입력 바랍니다\n");
			continue;
		}if (a == false) {
			System.out.println("현재 일치하는 계좌가 없습니다\n");
			System.out.print("처음으로 되돌아가시려면 1, 잔액 조회 화면으로 되돌아가시려면 2 또는 아무 키나 입력해주세요 : ");
			String back = sc.nextLine();
			if ("1".equals(back)) {
				return;
			}else if ("2".equals(back)) {
				continue;
			}else {
				return;
			}
		
			
		}
	}

	}
	}

//	static void AccList(String[][] array) { // AccList [AccountList] => 입력된 계좌 목록을 보여주기 위한 메소드
//		Scanner sc = new Scanner(System.in);
//		System.out.print(">========================<\n\n조회하시고자 하는 계좌의 계좌번호를 입력해주세요 : ");
//		String AccNum = sc.nextLine();
//
//		for (int i = 0; i < array.length; i++) {// 세로칸 기준 아래로 내려가면서 각 계좌의 3가지 정보를 보여주기 위해 설정
//			if (array[i][0] != null) { // 입력된 계좌 목록 중에 아무것도 입력되지 칸들을 전부 null(없음)이라 했을 때 null이 아닐 경우에만 목록이 출력되도록 설정
//				if (AccNum.equals(array[i][0])) {
//					System.out.println("계좌번호 : " + array[i][0] + " | 예금자 명 : " + array[i][1] + " | 계좌 잔액 : " + array[i][2] + "\n");
//				}
//				
//
//			
//
//			}
//
//		}
//	}