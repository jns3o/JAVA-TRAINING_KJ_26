package practice.test260715;
//
import java.util.Scanner;

public class mainPlay extends rollingDice {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		rollingDice d = new rollingDice();// rollingDice클래스에 있었던 메소드들을 쓰기 위해서 객체 생성을 함
		score scr = new score();
		int round = 1; // while문이 돌때마다 라운드가 진행되는 것이므로 round변수를 선언(처음 시작하는 라운드는 1라운드이기에 0이 아닌 1을 선언

		System.out.println("* 랜덤 주사위 게임에 오신 걸 환영합니다! *\n* 이 게임은 컴퓨터와 주사위 대결을 하는 게임 입니다! *");
		System.out.println("* 주사위 대결을 위해서는 각기 다른 6개의 숫자가 들어있는 4개의 주사위 중 3개를 선택합니다! *\n\n <주사위 종류>\n");
		System.out.println("1). [1,2,3,4,5,6] (일반 주사위, defaultDice) | 2). [1,1,1,1,6,6] (역배 주사위, underDogDice)");
		System.out.println("3). [3,3,3,4,4,4] (정배 주사위, normalDice) | 4). [2,2,2,5,5,5] (에매한 주사위, unnervingDice)");
		System.out.println("ㄴ각 주사위에 알맞은 번호를 입력해주시면 됩니다!\nㄴ플레이 예시) 1번 주사위를 골라주세요: 1 => 일반 주사위를 선택하셨습니다\n");
		System.out.println("* 선택한 3개의 주사위를 컴퓨터와 번갈아가면서 던집니다! ([!]컴퓨터는 1번 주사위만 이용합니다)");
		System.out.println("* 던져서 나온 주사위 각각의 값을 총점에 더합니다 *\n-> 라운드마다 컴퓨터와 나의 점수를 공개합니다");
		System.out.println("* 컴퓨터와 유저 양측 모두 총점 1000점이 나오면 게임이 끝납니다 *\n* 둘 중 누가 적게 던졌는지 확인해서 적게 던진 사람이 우승합니다 *\n");
		System.out.println("* 그럼 게임을 시작하겠습니다! *");

		player user = new player("유저");// player클래스를 'user'라는 주소지에다가 new player를 만들어서 게임 때 유저의 카운트,점수를 저장하고 구하기 위해 객체생성
		player com = new player("컴퓨터");// user와 동일
		
		int[] userChoiceDice = dice.inputDice(sc, round);//주사위를 고르는 로직을 따로 분리 후 
		

		while (true) {// 게임이 끝나는 조건이 만족하기 전까지 소스가 반복재생되어야 하므로 while(true)문을 작성
			System.out.println("================================");
			System.out.println(round + "라운드가 시작되었습니다.");// 맨위에서 초기에 round를 1로 선언하였으므로 1라운드부터 시작
			System.out.println("현재 유저 던진 횟수: " + user.getCount() + " | 컴퓨터 던진 횟수: " + com.getCount());

			score.playUserScore(user, d, userChoiceDice);
			score.playComScore(com, d);
			/*
			 * 유저가 고른 주사위와 1번 주사위만 사용하는 컴퓨터의 주사위의 랜덤값과 더하는 로직을 클래스로 따로 분리해서 구한 다음 해당 클래스에서
			 * 각각 주사위 3개를 더한 값을 player클래스의 user와 com에 각각 저장을 하고 각 라운드마다의 결과값을 출력하도록 설정
			 */

			// 라운드가 종료될때마다 몇라운드가 종료됐는지 알려주고 각 플레이어의 점수를 출력
			System.out.println(round + "라운드 종료! 유저 총점: " + user.getScore() + " | 컴퓨터 총점: " + com.getScore() + "\n");

			if (score.scoreJudgment(user, com)){//게임판정 메서드를 호출해서 점수판정이 false일 경우 break를 하지 않고 while문 반복
				break;							   //만약 true가 반환될경우 if가 참이므로 break;가 실행되서 while문이 끝나고 메인도 끝나므로
			}									   //게임이 끝나게 됨

			round++;// 메인에서의 모든 로직이 끝난 후 스코어판정 메서드가 거짓일 경우 게임 자체가 끝나지 않고 라운드가 끝난 것이니 라운드가 끝날 때마다 라운드가 진행되고 있다는걸 알려주기 위해
					// round++;를 작성
		}
		
	}

}
