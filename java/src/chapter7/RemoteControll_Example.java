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
			System.out.println("TV를 켜시겠습니까? 예: 1, 아니오: 2");
			System.out.print(": ");
			String turn = sc.nextLine();
			if ("1".equals(turn)) {
				tv_RemoteControll.powerOn();
				break;
			}else if ("2".equals(turn)) {
				tv_RemoteControll.powerOff();
				break;
			}else {
				System.out.println("[!] 잘못된 입력 감지. 다시 선택해주세요");
				continue;
			}
			
			
		case "2":
			System.out.println("에어컨을 작동하시겠습니까? 예: 1 , 아니오: 2");
			System.out.print(": ");
			String choiceNum = sc.nextLine();
			if ("1".equals(choiceNum)) {
				airCon_RemoteControll.powerOn();
				break;
			}else if ("2".equals(choiceNum)) {
				airCon_RemoteControll.powerOff();
				break;
			}else {
				System.out.println("[!] 잘못된 입력 감지. 다시 선택해주세요");
				continue;
			}
		case "3":
			System.out.println("전등을 키시겠습니까? 예: 1, 아니오: 2");
			System.out.print(": ");
			String turnOnLed = sc.nextLine();
			if ("1".equals(turnOnLed)) {
				light_RemoteControll.powerOn();
				break;
			}else if ("2".equals(turnOnLed)) {
				light_RemoteControll.powerOff();
				break;
			}else {
				System.out.println("[!] 잘못된 입력 감지. 다시 선택해주세요");
				continue;
			}
		case "0":
			System.out.println("시스템을 종료합니다...");
			return;
			
			
			
		}
		
		}
	}
	}

