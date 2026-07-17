package practice.test260715;

import java.util.Scanner;

public class play extends rollingDice {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		rollingDice d = new rollingDice();// rollingDice클래스에 있었던 메소드들을 쓰기 위해서 객체 생성을 함
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

		player user = new player("유저");//player클래스를 'user'라는 주소지에다가 new player를 만들어서 게임 때 유저의 카운트,점수를 저장하고 구하기 위해 객체생성
		player com = new player("컴퓨터");//user와 동일

		int[] choiceDice = new int[3];//유저에게 게임 시작 전 사용할 주사위 3개를 입력받기 위해 choiceDice라는 이름의 int형 3칸짜리 배열 생성
		System.out.println("\n* 게임 시작 전, 사용할 주사위 3개를 선택해주세요 *");
		for (int i = 0; i < 3; i++) {//1~3번 주사위를 입력하기 위해 for문을 작성(인덱스는 1번째칸이 0번이므로 0부터 시작하여 3이 되기전에 끝나게 작성)
			choiceDice[i] = selectDice(sc, i + 1); 
			//selectDice메서드를 호출해서 주사위고르기 메서드에서 플레이어가 고른 주사위를 choiceDice의 i번 배열에 저장(예 i = 0, choiceDice의 0번 즉, 1번째 배열에 n번 주사위를 저장)
		}

		while (true) {//게임이 끝나는 조건이 만족하기 전까지 소스가 반복재생되어야 하므로 while(true)문을 작성
			System.out.println("================================");
			System.out.println(round + "라운드가 시작되었습니다.");//맨위에서 초기에 round를 1로 선언하였으므로 1라운드부터 시작
			System.out.println("현재 유저 던진 횟수: " + user.getCount() + " | 컴퓨터 던진 횟수: " + com.getCount());

			// 유저가 선택한 주사위들의 값의 합을 구하기 위해 scoreBoard라는 그릇을 생성(초기값 0)
			int scoreBoard = 0; //소스가 반복될때마다 초기화
			
			for (int i = 0; i < 3; i++) {//유저가 고른 1번부터 3번 주사위까지 각각의 값을 구해줄때 n번째 주사위를 출력하기 위해 for문을 작성
				int result = rollDiceChoice(choiceDice[i], d); //메인메서드 밑 rollDiceChoice라는 메서드에서 기존에 유저가 고른 주사위의 랜덤값을 result에 저장
				System.out.println("-" + (i + 1) + "번째 주사위 결과: [" + result + "]");//i는 0~2까지이고 +1이니, 1~3번째 주사위의 값을 보여주고
				scoreBoard += result; //그렇게 해서 나온 result의 값은 이번 라운드 유저가 고른 주사위의 합을 보여주기 위해 scoreBoard의 저장 //그 주사위의 값은 result이다
			}

			user.addScore(scoreBoard);//computerScore메서드랑 진행원리는 동일
			user.addCount();
			System.out.println("\n[결과] 이번 라운드 유저 합계: " + scoreBoard);

			computerScore(d, com);//computerScore메서드에서 com의 주사위를 굴리고 값을 구하고 합계를 출력하는것까지 다 처리하여 메서드처리하였으므로
			//해당 메서드를 호출

			// 라운드가 종료될때마다 몇라운드가 종료됐는지 알려주고 각 플레이어의 점수를 출력
			System.out.println(round + "라운드 종료! 유저 총점: " + user.getScore() + " | 컴퓨터 총점: " + com.getScore() + "\n");

			if (user.getScore() >= 1000 || com.getScore() >= 1000) {//게임 종료를 위해 user또는 com 둘 중 한쪽이라도 100점과 같거나 넘어가면 종료 멘트 출력
				System.out.println("============ 게임 종료 ============");

				/*컴퓨터와 유저 둘 중 한 쪽이 먼저 100점을 찍었다는 자체가 다른 한 쪽은 100점을 찍기 위해 카운트를 하나 더 소비해야한다는 의미이므로 100점을 먼저
				 찍은 쪽이 승리하도록 if문으로 규칙 설정. 단, 둘 다 100점을 동시에 넘었을 경우 카운트도 같다는 의미이므로
				 총점을 비교하여 더 높은 쪽이 승리한다(최종적으로도 모든게 똑같을 경우 무승부 처리)*/
				if (user.getScore() >= 1000 && com.getScore() < 1000) {
					System.out.println("유저가 먼저 1000점을 돌파하여 승리했습니다!");
				} else if (com.getScore() >= 1000 && user.getScore() < 1000) {
					System.out.println("컴퓨터가 먼저 1000점을 돌파하여 승리했습니다!");
				} else {
					// 둘 다 100점을 넘겼을 경우엔 원래 규칙(횟수 비교) 적용
					if (user.getScore() < com.getScore()) {
						System.out.println("동시에 100점을 넘겼습니다. 판정 결과 점수가 더 높은 유저의 승리입니다!");
					} else if (user.getScore() > com.getScore()) {
						System.out.println("동시에 100점을 넘겼습니다. 판정 결과 점수가 더 높은 컴퓨터의 승리입니다!");
					} else {//어차피 위에 if조건들이 모두 거짓이 되어버릴 경우 남은 조건은 user와 com이 둘 다 동시에 100점을 넘었는데도 점수가 동일할 경우 밖에
						System.out.println("무승부입니다!"); //없으므로 남은 건 자동으로 (user.getScore() == ...Score())이므로 생략
					}
				}
				break; // while문 탈출
			}

			round++;//메인에서의 모든 로직이 끝난 후 게임 규칙상 라운드가 끝난 것이니 라운드가 끝날 때마다 라운드가 진행되고 있다는걸 알려주기 위해 round++;를 작성
		}

	}

	public static int selectDice(Scanner sc, int diceNum) {//주사위를 고르는 메서드 분리 + 메인에서의 스캐너 기능을 파라미터로 받고 selectDice메서드안에서 사용자가 몇번주사위를 고르는지
		while (true) {                                   //입력을 받은 int형태의 diceNum을 선언 + 파라미터에서 쓴 이유는 diceNum을 주사위고르기 메서드 안 while문 내부에서
			try {                                        //선언을 하게 된다면 diceNum에 값이 고정되기때문에 플레이어가 주사위를 잡을 수 없고 selectDice메서드를 호출하는 곳에서
				                                         //for문으로 1번~3번 주사위고르는것을 반복하고 있기 때문에 주사위를 고르기 위해 호출되는걸 반복하는 순간마다 번호를 추가하기 위해
				System.out.print(diceNum + "번 주사위를 골라주세요 [1:일반 주사위, 2:역배 주사위, 3:정배 주사위, 4:에매 주사위] : "); //파라미터에 선언
				int choice = sc.nextInt();
				if (choice >= 1 && choice <= 4)
					return choice; //플레이어가 고를 주사위를 choice라는 그릇에 받고있고 if문에선 1~4번 주사위를 옳게 선택하면 입력받은 값인 choice를 메서드 호출한곳에 반환하기 위해 return choice를 실행
				System.out.println("[!] 1~4번 사이의 주사위를 골라주세요.");//만약 choice의 값이 1 부터 4사이에 값이 아닐 경우 문장 출력(어차피 if문이 거짓일 경우 choice를 반환하는 return을 스킵하고
			} catch (Exception e) {                                  //내려오기 때문에 else 미작성(else작성시 코드가 조금 더 길어지고 복잡해지기 때문)
				System.out.println("[!] 잘못된 입력입니다. 숫자만 입력하세요.");
				sc.nextLine(); //숫자말고 다른게 입력됐을 경우 오류로 강제종료 되는걸 방지하기 위해 catch(Exception e)를 작성 후 문장 출력
			}
		}
	}

	public static int rollDiceChoice(int choice, rollingDice d) {//유저가 고른 3개의 주사위를 각 인덱스에 맞는 주사위의 값을 구하기 위해 작성
		if (choice == 1)
			return d.rollingDefaultDice();
		if (choice == 2)
			return d.rollingUnderDogDice();
		if (choice == 3)
			return d.rollingNormalDice();
		return d.rollingUnnervingDice();//어차피 유저가 고른 주사위가 1~3번까지 아무것도 없으면 if문을 모두 통과하고 에매한주사위만 남기 때문에 else 미작성
	}													  //컴퓨터의 스코어를 구하고 저장하는 메서드를 분리
	static void computerScore(rollingDice d, player com) {//메인에서 주사위굴리는 클래스를 객체생성했을때 선언한 d를 파라미터에 넣고 컴퓨터의 점수를 계산하는것이기에
		                                                  //player클래스에서 user와 com이라는 그릇중 com을 가져옴
					int scoreBoard2 = d.rollingDefaultDice() + d.rollingDefaultDice() + d.rollingDefaultDice();//1번주사위를 3번 랜덤돌린걸 스코어보드2에 대입
					com.addScore(scoreBoard2);//스코어보드2의 결과값을 player클래스의 com으로 이동해서 해당 메서드에서 결과값을 처리
					com.addCount();//com의 주사위 총합을 구하였으니 카운트도 세주기 위해 작성
					System.out.println("[결과] 이번 라운드 컴퓨터 합계: " + scoreBoard2 + "\n");
	}

}
