package chapter7;

import java.util.Scanner;

public class RemoteControll_Example {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TV_RemoteControll tv_RemoteControll = new TV_RemoteControll();
		AirCon_RemoteControll airCon_RemoteControll = new AirCon_RemoteControll();
		Light_RemoteControll light_RemoteControll = new Light_RemoteControll();
		
		System.out.println("========================");
		System.out.println("1. TV");
		System.out.println("2. 에어컨 리모콘");
		System.out.println("3. 전등 리모콘");
		System.out.println("0. 종료");
		System.out.println("========================");
		System.out.print(" : ");
		String selectMenu = sc.nextLine();
		
		switch(selectMenu) {
		case "1":
			
		}
		

	}

}
