package chapter7;

import java.util.Scanner;

public class Light_RemoteControll extends RemoteControll{
	
	int[] led = {20};
	
	@Override
	void powerOn() {
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("전등을 작동합니다...");
			System.out.println("현재 설정된 전등의 밝기는 " + led[0] + " 입니다.\n");
			System.out.println("+ : 설정 밝기 상승, - : 설정 밝기 하강 | [설정 가능 밝기: 0~40]");
			System.out.print(" +(밝기 올리기) , -(밝기 내리기) : ");
			String UpDown = sc.nextLine();
			if ("+".equals(UpDown)) {
				System.out.println("\n설정 밝기로 올리는 중...");
				led[0] += 1;
				if (led[0] > 40) {
					System.out.println("[!]경고, 밝기는 40을 넘길 수 없습니다. 메뉴로 되돌아갑니다");
					led[0] -= 1;
					return;
				}
				System.out.println(led[0] + " 밝기로 설정되었습니다\n");
				return;
			} else if ("-".equals(UpDown)) {
				System.out.println("\n설정 밝기로 내리는 중...");
				led[0] -= 1;
				if (led[0] < 18) {
					System.out.println("[!]경고, 밝기는 0이하로 내려갈 수 없습니다. 메뉴로 되돌아갑니다.");
					led[0] -= 1;
					return;
				}
				System.out.println(led[0] + " 밝기로 설정되었습니다\n");
				return;
			} else {
				System.out.println("\n[!] 잘못된 입력감지. 메뉴로 돌아갑니다");
				return;
			}

		}
	}
	@Override
	void powerOff() {
		System.out.println("전등의 전원을 종료합니다...");

		return;
	}
	
}
