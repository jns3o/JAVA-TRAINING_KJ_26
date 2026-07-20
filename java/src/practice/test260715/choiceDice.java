package practice.test260715;

import java.util.Scanner;

public class choiceDice {//주사위를 고르는 클래스와 메서드를 분리, 유저가 고른 3개의 주사위를 choiceDice[0~2]까지 저장 후 choiceDice를 호출한곳에서 각각 활용
	static int[] dice(Scanner sc,int diceNum) {
	int[] choiceDice = new int[3];// 유저에게 게임 시작 전 사용할 주사위 3개를 입력받기 위해 choiceDice라는 이름의 int형 3칸짜리 배열 생성
	System.out.println("\n* 게임 시작 전, 사용할 주사위 3개를 선택해주세요 *\n[1:일반 주사위, 2:역배 주사위, 3:정배 주사위, 4:에매 주사위]");
	for (int i = 0; i < 3; i++) {// 1~3번 주사위를 입력하기 위해 for문을 작성(인덱스는 1번째칸이 0번이므로 0부터 시작하여 3이 되기전에 끝나게 작성)
		choiceDice[i] = selectDice.selectDice(sc, i + 1);
		// selectDice메서드를 호출해서 주사위고르기 메서드에서 플레이어가 고른 주사위를 choiceDice의 i번 배열에 저장(예 i = 0,
		// choiceDice의 0번 즉, 1번째 배열에 n번 주사위를 저장)
		
}return choiceDice;
}
}