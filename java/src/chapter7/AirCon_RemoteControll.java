package chapter7;

import java.util.Scanner;

public class AirCon_RemoteControll extends RemoteControll{
	
	@Override
	void powerOn() {
		
		
		Scanner sc = new Scanner(System.in);
		int tempeature = 24;
		System.out.println("에어컨 전원을 켭니다");
		System.out.println("현재 설정된 온도는 " + tempeature + " 도 입니다.\n");
		System.out.println("+ : 설정 온도 상승, - : 설정 온도 하강 | [설정 가능 온도: 영상 18~30도]");
		System.out.println(" +(온도상승) , -(온도하강) : ");
		String UpDown = sc.nextLine();
		System.out.println("희망 온도로 설정 중...");
		switch(UpDown) {
		case "+" :
			System.out.println(tempeature + 1 + " 도로 설정되었습니다.");
			break;
		case "-" :
			System.out.println(tempeature - 1 + " 도로 설정되었습니다.");
			break;
		}
		System.out.println("희망온도 " + tempeature + " 도로 설정되었습니다.");
	}
}
