package chapter7;

import java.util.Scanner;

public class RemoteControll {
	
	boolean power = false;
	boolean powerOn2() {
		return this.power;
	}
	Scanner sc = new Scanner(System.in);
	
	void powerOn(){
		System.out.println("전원을 켭니다");
	}
	void powerOff(){
		System.out.println("전원을 끕니다...");
		power = false;
	}
	
}
