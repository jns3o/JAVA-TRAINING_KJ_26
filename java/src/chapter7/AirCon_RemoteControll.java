package chapter7;

import java.util.Scanner;

public class AirCon_RemoteControll extends RemoteControll {
	
	int tempeature = 24 ;
	
	
	@Override
	void powerOn() {
		if(!power) {
			System.out.println("\n에어컨 전원을 켭니다");
			System.out.println("현재 설정되어있는 온도는 " + tempeature + " 도 입니다.\n[설정 가능 온도: 영상 18~30도]\n");
			power = true;
		}else {
			System.out.println("\n에어컨이 이미 켜져있습니다");
			System.out.println("현재 설정되어있는 온도는 " + tempeature + " 도 입니다.\n[설정 가능 온도: 영상 18~30도]\n");
			
			}
		}
	void airTempeatureUp() {		
		while (true) {
				System.out.println("\n희망 온도로 설정 중...");
				tempeature += 1;
				if (tempeature > 30) {
					System.out.println("[!]경고, 설정 온도는 30도를 넘길 수 없습니다. 메뉴로 되돌아갑니다");
					tempeature -= 1;
					return;
				}
				System.out.println(tempeature + " 도로 설정되었습니다\n");
				return;
			} 
	}
	void airTempeatureDown() {
		while (true) {
			System.out.println("\n희망 온도로 설정 중...");
			tempeature -= 1;
			if (tempeature < 18) {
				System.out.println("[!]경고, 설정 온도는 18도 이하로 설정 불가능 합니다. 메뉴로 되돌아갑니다");
				tempeature += 1;
				return;
			}
			System.out.println(tempeature + " 도로 설정되었습니다\n");
			return;
		}

	}
}
	


	
