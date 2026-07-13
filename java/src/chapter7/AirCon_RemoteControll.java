package chapter7;

import java.util.Scanner;

public class AirCon_RemoteControll extends RemoteControll {

	int[] tempeature = { 24 };

	@Override
	void powerOn() {
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("에어컨 전원을 켭니다");
			System.out.println("현재 설정된 온도는 " + tempeature[0] + " 도 입니다.\n");
			System.out.println("+ : 설정 온도 상승, - : 설정 온도 하강 | [설정 가능 온도: 영상 18~30도]");
			System.out.print(" +(온도상승) , -(온도하강) : ");
			String UpDown = sc.nextLine();
			if ("+".equals(UpDown)) {
				System.out.println("\n희망 온도로 설정 중...");
				tempeature[0] += 1;
				if (tempeature[0] > 30) {
					System.out.println("[!]경고, 설정 온도는 30도를 넘길 수 없습니다. 메뉴로 되돌아갑니다");
					tempeature[0] -= 1;
					return;
				}
				System.out.println(tempeature[0] + " 도로 설정되었습니다\n");
				return;
			} else if ("-".equals(UpDown)) {
				System.out.println("\n희망 온도로 설정 중...");
				tempeature[0] -= 1;
				if (tempeature[0] < 18) {
					System.out.println("[!]경고, 설정 온도는 18도 이하로는 설정 불가능합니다. 메뉴로 되돌아갑니다.");
					tempeature[0] -= 1;
					return;
				}
				System.out.println(tempeature[0] + " 도로 설정되었습니다\n");
				return;
			} else {
				System.out.println("\n[!] 잘못된 입력감지. 메뉴로 돌아갑니다");
				return;
			}

		}

	}

	@Override
	void powerOff() {
		System.out.println("에어컨 작동을 종료합니다...");

		return;
	}

}
