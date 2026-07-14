package chapter7;

import java.util.Scanner;

public class Light_RemoteControll extends RemoteControll{
	
	int led = 20;
	
	@Override
	public void powerOn() {
		if(!power) {
			System.out.println("\n전등을 작동합니다...");
			System.out.println("현재 설정된 전등의 밝기는 " + led + " 입니다.[설정 가능 밝기: 0~40]\n");
			power = true;
		}else {
			System.out.println("\n전등이 이미 켜져있습니다");
			System.out.println("현재 설정된 전등의 밝기는 " + led + " 입니다.[설정 가능 밝기: 0~40]\n");
		}
	}	
		void lightUp() {	
		while (true) {
				System.out.println("\n설정 밝기로 올리는 중...");
				led += 1;
				if (led > 40) {
					System.out.println("[!]경고, 밝기는 40을 넘길 수 없습니다. 메뉴로 되돌아갑니다");
					led -= 1;
					return;
				}
				System.out.println(led + " 밝기로 설정되었습니다\n");
				return;
		}
		}
		void lightDown() {
			while (true) {
				System.out.println("\n설정 밝기로 내리는 중...");
				led -= 1;
				if (led < 18) {
					System.out.println("[!]경고, 밝기는 0이하로 내려갈 수 없습니다. 메뉴로 되돌아갑니다.");
					led -= 1;
					return;
				}
				System.out.println(led + " 밝기로 설정되었습니다\n");
				return;
			
			}

		}
		@Override
		public void powerOff() {
			this.power = false;
			System.out.println("전등을 끕니다...");
			return;
			
		}
	
	//
	
}
