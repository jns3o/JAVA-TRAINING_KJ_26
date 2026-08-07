package soloPractice;

import java.util.Scanner;

public class Practice_20260807_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("======N진수 게임======");
		while(true) { 
		/*
		 게임에서 각 조건들을 입력받았을때 int형으로 받게 될 경우 로직이 더 길어지기 때문에 조건들은 String형으로 받고
		 진법을 선택하는 jinsu변수를 switch문으로 돌려서 맞게 입력하면 해당 진법 메서드로 이동하고 다른걸 잘못입력하면
		 다시 위로 올라와서 선택할 수 있게 최상단에 while문을 사용하여 반복되게 해주고, boolean을 써서
		 각 케이스에 맞게 입력하면 break;를 통해 switch문을 탈출하고 탈출하면 flag는 계속 true로 유지되고 있어서
		 if문이 참 이어서 break;를 통해 본인이 호출한 메서드로 이동하고 그렇지 아니할 경우 while문 반복
		 */ 
		System.out.print("몇진수로 진행하시겠습니까 : ");
		String jinsu = sc.nextLine();
		System.out.print("미리 구할 숫자의 갯수 : ");
		String num = sc.nextLine();
		System.out.print("게임 참가 인원 : ");
		String member = sc.nextLine();
		System.out.print("튜브의 게임 순서 :");
		String count = sc.nextLine();
		boolean flag = true;
		switch(jinsu) {
		
		case "2": {
			int Num = Integer.parseInt(num);//오류가 나지 않게 최초에 string형으로 입력받은 값들을 Integer를 통해 int형 변수에 다시 담아줌
			int Member = Integer.parseInt(member);
			int Count = Integer.parseInt(count);
			two_jin(Num, Member, Count); //2진수 메서드에 "갯수,참가인원,튜브의 게임순서"가 입력된 int값들을 넘겨줌
			break;
		}
		case "8": {
			int Num = Integer.parseInt(num);
			int Member = Integer.parseInt(member);
			int Count = Integer.parseInt(count);
			eight_jin(Num, Member, Count);
			break;
		}
		case "10": {
			int Num = Integer.parseInt(num);
			int Member = Integer.parseInt(member);
			int Count = Integer.parseInt(count);
			ten_jin(Num, Member, Count);
			break;
		}
		case "16": {
			int Num = Integer.parseInt(num);
			int Member = Integer.parseInt(member);
			int Count = Integer.parseInt(count);
			sixteen_jin(Num, Member, Count);
			break;
		}
		default:
			System.out.println("\n[!]다시 입력해주세요");
			flag = false;
			break;
			
		}
		if(flag) { //switch문에서 default가 아닌 경우 if가 참이 되고 if에서 break;로 나가게 되면 while문도 나가게되어 각 메서드로 이동함
			break;
		}
		}
	}
	public static void two_jin(int num, int member, int count) {
		System.out.println("\n[2진수를 선택하셨습니다]");
		int[] array = new int[num];
		
	}
	public static void eight_jin(int num, int member, int count) {
		
	}
	public static void ten_jin(int num, int member, int count) {
		
	}
	public static void sixteen_jin(int num, int member, int count) {
		
	}

}
