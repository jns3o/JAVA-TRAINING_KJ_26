package practice.test260715;

import java.util.Scanner;

public class play extends rollingDice {
	public static void main(String[] args) {
		rollingDice d = new rollingDice();//rollingDice클래스에 있었던 메소드들을 쓰기 위해서 객체 생성을 함
		System.out.println("* 랜덤 주사위 게임에 오신 걸 환영합니다! *\n* 이 게임은 컴퓨터와 주사위 대결을 하는 게임 입니다! *");
		System.out.println("* 주사위 대결을 위해서는 각기 다른 6개의 숫자가 들어있는 4개의 주사위 중 3개를 선택합니다! *\n\n <주사위 종류>\n");
		System.out.println("1). [1,2,3,4,5,6] (일반 주사위, defaultDice) | 2). [1,1,1,1,6,6] (역배 주사위, underDogDice)");
		System.out.println("3). [3,3,3,4,4,4] (정배 주사위, normalDice) | 4). [2,2,2,5,5,5] (에매한 주사위, unnervingDice)");
		System.out.println("ㄴ각 주사위에 알맞은 번호를 입력해주시면 됩니다!\nㄴ플레이 예시) 1번 주사위를 골라주세요: 1 => 일반 주사위를 선택하셨습니다\n");
		System.out.println("* 선택한 3개의 주사위를 컴퓨터와 번갈아가면서 던집니다! ([!]컴퓨터는 1번 주사위만 이용합니다)");
		System.out.println("* 던져서 나온 주사위 각각의 값을 총점에 더합니다 *\n-> 라운드마다 컴퓨터와 나의 점수를 공개합니다");
		System.out.println("* 컴퓨터와 유저 양측 모두 총점 1000점이 나오면 게임이 끝납니다 *\n* 둘 중 누가 적게 던졌는지 확인해서 적게 던진 사람이 우승합니다 *\n");
		System.out.println("* 그럼 게임을 시작하겠습니다! *");
		
		int userScore = 0;
		int comScore = 0;
		int round = 1;
		int userCount = 0;
		int comCount = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {//추후 유저와 컴퓨터 주사위 값이 정해진 스코어가 되기 전까지 계속 반복되어야 하므로 while(true)사용
			int score1 = 0;
			int cmscore1 = 0;
			int score2 = 0;
			int cmscore2 = 0;
			int score3 = 0;
			int cmscore3 = 0;
			System.out.println("================================");
			System.out.println(round + "라운드가 시작되었습니다\n");
			System.out.println("현재 유저(님)의 던진 횟수 : "+userCount + " 컴퓨터(님)의 던진 횟수 :" + comCount);
			try { System.out.print("1번 주사위를 골라주세요 : ");
				int firstDice = sc.nextInt();
				if (firstDice == 1) {
					score1 = d.rollingDefaultDice();
					System.out.println("-일반 주사위를 고르셨습니다, 돌려서 나온 값 [" + score1 + "]\n");
				} else if (firstDice == 2) {
					score1 = d.rollingUnderDogDice();
					System.out.println("-역배 주사위를 고르셨습니다, 돌려서 나온 값 [" + score1 + "]\n");
				} else if (firstDice == 3) {
					score1 = d.rollingNormalDice();
					System.out.println("-정배 주사위를 고르셨습니다, 돌려서 나온 값 [" + score1 + "]\n");
				} else if (firstDice == 4) {
					score1 = d.rollingUnnervingDice();
					System.out.println("-에매한 주사위를 고르셨습니다, 돌려서 나온 값 [" + score1 + "]\n");
				} else {
					System.out.println("\n[!]주사위가 아닌 다른 것을 입력 또는 고르셨습니다. 다시 선택해주세요");
					continue;
				}
			} catch (Exception e) {
				System.out.println("\n[!]주사위가 아닌 다른 것을 입력 또는 고르셨습니다. 다시 선택해주세요");
				continue;
			}
			try { System.out.print("2번 주사위를 골라주세요 : ");
				int secondDice = sc.nextInt();
				if (secondDice == 1) {
					score2 = d.rollingDefaultDice();
					System.out.println("-일반 주사위를 고르셨습니다, 돌려서 나온 값 [" + score2 + "]\n");
				} else if (secondDice == 2) {
					score2 = d.rollingUnderDogDice();
					System.out.println("-역배 주사위를 고르셨습니다, 돌려서 나온 값 [" + score2 + "]\n");
				} else if (secondDice == 3) {
					score2 = d.rollingNormalDice();
					System.out.println("-정배 주사위를 고르셨습니다, 돌려서 나온 값 [" + score2 + "]\n");
				} else if (secondDice == 4) {
					score2 = d.rollingUnnervingDice();
					System.out.println("-에매한 주사위를 고르셨습니다, 돌려서 나온 값 [" + score2 + "]\n");
				} else {
					System.out.println("\n[!]주사위가 아닌 다른 것을 입력 또는 고르셨습니다. 다시 선택해주세요");
					continue;
				}
			} catch (Exception e) {
				System.out.println("\n[!]주사위가 아닌 다른 것을 입력 또는 고르셨습니다. 다시 선택해주세요");
				continue;
			}
			try { System.out.print("3번 주사위를 골라주세요 : ");
				int thirthdDice = sc.nextInt();
				if (thirthdDice == 1) {
					score3 = d.rollingDefaultDice();
					System.out.println("-일반 주사위를 고르셨습니다, 돌려서 나온 값 [" + score3 + "]\n");
				} else if (thirthdDice == 2) {
					score3 = d.rollingUnderDogDice();
					System.out.println("-역배 주사위를 고르셨습니다, 돌려서 나온 값 [" + score3 + "]\n");
				} else if (thirthdDice == 3) {
					score3 = d.rollingNormalDice();
					System.out.println("-정배 주사위를 고르셨습니다, 돌려서 나온 값 [" + score3 + "]\n");
				} else if (thirthdDice == 4) {
					score3 = d.rollingUnnervingDice();
					System.out.println("-에매한 주사위를 고르셨습니다, 돌려서 나온 값 [" + score3 + "]\n");
				} else {
					System.out.println("\n[!]주사위가 아닌 다른 것을 입력 또는 고르셨습니다. 다시 선택헤주세요");
					continue;
				}
			} catch (Exception e) {
				System.out.println("\n[!]주사위가 아닌 다른 것을 입력 또는 고르셨습니다. 다시 선택해주세요");
				continue;
			}
			int scoreBoard = 0;
			scoreBoard += score1 + score2 + score3;
			userScore += scoreBoard;
			System.out.println("\nplayer(유저)가 고른 주사위의 합은 " + scoreBoard + "입니다");
	
			int scoreBoard2 = 0;
			cmscore1 = d.rollingDefaultDice(); cmscore2 = d.rollingDefaultDice(); cmscore3 = d.rollingDefaultDice();
			scoreBoard2 += cmscore1 + cmscore2 + cmscore3;
			comScore += scoreBoard2;
			
			System.out.println("player(컴퓨터)가 고른 주사위의 합은 " + scoreBoard2 + "입니다\n");
			System.out.println(
					round + "라운드가 종료되었습니다. 현재 유저(님)의 스코어는 '" + userScore + "' 이고 컴퓨터(님)의 스코어는 '" + comScore + "' 입니다\n");
				++round; 
			if (userCount < 100) {
				++userCount;
			}
			if (comCount < 100) {
				++comCount;
			}
			if (comScore >= 100 && userScore >= 100) {
				if(userCount > comCount) {
					System.out.println("컴퓨터(님)의 승리입니다, 유저(님)께서 패배하셨습니다. 게임을 종료합니다");
					return;
				}
				if(userCount < comCount) {
					System.out.println("유저(님)의 승리입니다, 컴퓨터(님)께서 패배하셨습니다. 게임을 종료합니다");
					return;
				}
				if(userCount == comCount) {
					System.out.println("유저(님)과 컴퓨터(님)이 1000점을 돌파하였으나 던진 횟수가 동일 해 무승부입니다");
					return;
				}
			}
			

		}

	}
}
