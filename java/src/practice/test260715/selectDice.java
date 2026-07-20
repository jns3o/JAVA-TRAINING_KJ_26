package practice.test260715;

import java.util.Scanner;

public class selectDice {
	static int selectDice(Scanner sc, int diceNum) {// 주사위를 고르는 메서드 분리 + 메인에서의 스캐너 기능을 파라미터로 받고 selectDice메서드안에서
		// 사용자가 몇번주사위를 고르는지
		while (true) { // 입력을 받은 int형태의 diceNum을 선언 + 파라미터에서 쓴 이유는 diceNum을 주사위고르기 메서드 안 while문 내부에서
			try {     // 선언을 하게 된다면 diceNum에 값이 고정되기때문에 플레이어가 주사위를 잡을 수 없고 selectDice메서드를 호출하는 곳에서
				 	 // for문으로 1번~3번 주사위고르는것을 반복하고 있기 때문에 주사위를 고르기 위해 호출되는걸 반복하는 순간마다 번호를 추가하기 위해 파라미터에 선언
				System.out.print(diceNum + "번 주사위를 골라주세요 : "); 										
				int choice = sc.nextInt();
				if (choice >= 1 && choice <= 4)
					return choice; // 플레이어가 고를 주사위를 choice라는 그릇에 받고있고 if문에선 1~4번 주사위를 옳게 선택하면 입력받은 값인 choice를 메서드
									// 호출한곳에 반환하기 위해 return choice를 실행
				System.out.println("[!] 1~4번 사이의 주사위를 골라주세요.");// 만약 choice의 값이 1 부터 4사이에 값이 아닐 경우 문장 출력(어차피 if문이 거짓일 경우
										// choice를 반환하는 return을 스킵하고 내려오기 때문에 else 미작성(else작성시 코드가 조금 더 길어지고 복잡해지기 때문)
			} catch (Exception e) { 
				System.out.println("[!] 잘못된 입력입니다. 숫자만 입력하세요.");
				sc.nextLine(); // 숫자말고 다른게 입력됐을 경우 오류로 강제종료 되는걸 방지하기 위해 catch(Exception e)를 작성 후 문장 출력
			}
		}
	}
}
