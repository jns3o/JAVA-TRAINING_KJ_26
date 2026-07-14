package chapter7;

import java.util.Scanner;

public class RemoteControll_Example {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TV_RemoteControll tv_RemoteControll = new TV_RemoteControll();
		AirCon_RemoteControll airCon_RemoteControll = new AirCon_RemoteControll();
		Light_RemoteControll light_RemoteControll = new Light_RemoteControll();
		while(true) {
		System.out.println("======KJ R.Controll======");
		System.out.println("1. TV");
		System.out.println("2. 에어컨 리모콘");
		System.out.println("3. 전등 리모콘");
		System.out.println("0. 종료");
		System.out.println("=========================");
		System.out.print("메뉴 선택 : ");
		String selectMenu = sc.nextLine();
		
		switch(selectMenu) {
		case "1":
			System.out.println("TV를 키려면 1번, 전원을 끄려면 2번, 채널 조작은 3번, 볼륨 조절은 4번을 눌러주세요");
			System.out.print(": ");
			String turn = sc.nextLine();
			if ("1".equals(turn)) {
				tv_RemoteControll.powerOn();		
			}else if ("2".equals(turn)) {
				tv_RemoteControll.powerOff();			
			}else if ("3".equals(turn)) {
				if(tv_RemoteControll.powerOn2()) {//powerOn2는 powerOn이라는 변수값을 반환받기 위해 선언해놓은 변수
					tv_RemoteControll.channel();//즉, powerOn2 => tv리모컨 클래스에서 power의 값이 true면 channel을 불러오도록 하기 위함
				}else {								//다른 case들도 동일 의미
					System.out.println("\n전원이 꺼져있어 작동할 수 없습니다\n");
				}				
			}else if ("4".equals(turn)) {
				if(tv_RemoteControll.powerOn2()) {
					tv_RemoteControll.volume();
				}else {
					System.out.println("\n전원이 꺼져있어 작동할 수 없습니다.\n");
				}
				
			}else {
				System.out.println("[!] 잘못된 입력 감지. 다시 선택해주세요");
				continue;
			}continue;
			
			
		case "2":
			System.out.println("에어컨의 전원은 키려면 1번, 전원을 끄려면 2번, 온도를 올리시려면 3번, 온도를 내리시려면 4번을 눌러주세요 : ");
			System.out.print(": ");
			String choiceNum = sc.nextLine();
			if ("1".equals(choiceNum)) {
				airCon_RemoteControll.powerOn();	
			}else if ("2".equals(choiceNum)) {
				airCon_RemoteControll.powerOff();
			}else if ("3".equals(choiceNum)){
				if (airCon_RemoteControll.powerOn2()) {
		            airCon_RemoteControll.airTempeatureUp();
			}else {
					System.out.println("\n전원이 꺼져있어 작동할 수 없습니다\n");
				}
			}else if ("4".equals(choiceNum)){
				if (airCon_RemoteControll.powerOn2()) {
					airCon_RemoteControll.airTempeatureDown();
				}else {
					System.out.println("\n전원이 꺼져있어 작동할 수 없습니다\n");
				}			
			}else {
				System.out.println("[!] 잘못된 입력 감지. 다시 선택해주세요");
				continue;
			}continue;
		case "3":
			System.out.println("전등을 조작하려면 1번, 전등을 끄려면 2번, 밝기를 올리시려면 3번, 밝기를 내리시려면 4번을 입력해주세요");
			System.out.print(": ");
			String turnOnLed = sc.nextLine();
			if ("1".equals(turnOnLed)) {
				light_RemoteControll.powerOn();
			}else if ("2".equals(turnOnLed)) {
				light_RemoteControll.powerOff();
			}else if ("3".equals(turnOnLed)) {
				if (light_RemoteControll.powerOn2()) {
					light_RemoteControll.lightUp();	
				}else {
					System.out.println("\n전원이 꺼져있어 작동할 수 없습니다\n");
				}
			}else if ("4".equals(turnOnLed)) {
				if (light_RemoteControll.powerOn2()) {
					light_RemoteControll.lightDown();				
				}else {
					System.out.println("\n전원이 꺼져있어 작동할 수 없습니다\n");
				}
			}else {
				System.out.println("[!] 잘못된 입력 감지. 다시 선택해주세요");
				continue;
			}continue;
		case "0":
			System.out.println("[!]시스템을 종료합니다...");
			return;
			
			
			
		}
		
		}
	}
	}

