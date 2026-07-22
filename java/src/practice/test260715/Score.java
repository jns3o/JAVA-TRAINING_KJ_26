package practice.test260715;
//
public class score {// 유저가 고른 주사위 3개와 컴퓨터가 사용하는 1번 주사위를 3번 굴리는 값의 합을 구하고 출력하기 위한 클래스를 분리
	static roll createDice(int choice){//각 주사위 별로 따로 인터페이스로 만들고 상속받고 하여 score클래스에서 반환형을 roll로 하여 객체생성
		if (choice == 1) return new DefaultDice();
        if (choice == 2) return new UnderDogDice();//유저가 dice클래스에서 각 인덱스마다 고른 주사위에 맞는것을 호출하기 위함
        if (choice == 3) return new NormalDice();
        return new UnnervingDice();
	}
	
	static int playUserScore(player user, int[] choiceDice) {// (유저의 스코어를 구하는 메서드를 생성 후 메인에서 객체 생성했던
																			// player와 rollingDice
		int scoreBoard = 0; // 그리고 int배열의 choiceDice를 파라미터로 불러옴(메서드 내부에서 player객체를 새로 생성 시
							// player클래스에서 가리키는 user라는 player와 다르게 되므로 객체 생성을 하지 않고 불러옴)
		for (int i = 0; i < 3; i++) {// 유저가 고른 1번부터 3번 주사위까지 각각의 값을 구해줄때 n번째 주사위를 출력하기 위해 for문을 작성
			roll selectedDice = createDice(choiceDice[i]);//만약 0번 인덱스에 유저가 1번 주사위를 선택했다면 createDice메서드에서 일반주사위의 값을 가져옴
			int result = selectedDice.roll();//해당하는 클래스의 roll();메서드를 호출해서 랜덤값을 구하고 그걸 result에 저장
			System.out.println("-" + (i + 1) + "번째 주사위 결과: [" + result + "]");// 결과값을 구하고 그것을 int형 result에 저장
			scoreBoard += result;// 결과값인 result를 scoreBoard에 저장하여 매 라운드마다 누적점수를 유저에게 보여줌
		}
		System.out.println("\n[결과] 이번 라운드 유저 합계 : " + scoreBoard);

		user.addScore(scoreBoard);// 만약 메인에서 playUserScore메서드를 호출하고 객체를 user객체를 호출했으면 scoreBoard의 값은 user라는 객체에 저장이됨								
		user.addCount();
		return scoreBoard;// 이미 addScore와 메서드 이름 앞에 반환형 int를 통해 play와 player클래스에 저장할건 다했지만 반환형을 void가 아닌
							// int형으로 하였기 때문에
							// return을 쓰지 않으면 메서드를 끝낼 수 없어서 return scoreBoard;를 입력
	}

	static int playComScore(player com) {// 컴퓨터 주사위 값을 구하는 전용 메서드 생성
		int scoreBoard2 = 0;
		roll comDice = new DefaultDice();
		for (int i = 0; i < 3; i++) {
			scoreBoard2 += comDice.roll();// for문이 3번 반복될때마다 scoreBoard2에 저장되는 일반주사위의 값이 전부 다르게 저장됨
		}
		System.out.println("[결과] 이번 라운드 컴퓨터 합계 : " + scoreBoard2 + "\n");
		com.addScore(scoreBoard2);
		com.addCount();
		return scoreBoard2;// 마찬가지로 int형으로 반환형을 설정해주었기에 메서드를 끝내기 위해 return scoreBoard2를 작성
	}    /*
		 * score클래스 해석: 메인메서드에서 selectDice메서드를 호출해서 사용자에게 입력받은 각 주사위를 choiceDice[i]라는
		 * 배열안에 저장을 한다음에 메인에서 score.playUserScore를 호출하게 되면 파라미터안에 int[] choiceDice를
		 * 불러오게끔 작성을 해놓았고 호출이 되면 for문을 통해 choiceDice의 0번~2번 인덱스까지의 담겨있는 플레이어가 고른 주사위의 값을
		 * 구하고 그걸 result에 저장해서 사용자에게 보여주고 scoreBoard에 저장을 해서 그 scoreBoard는 player클래스의
		 * user라는 주소에 저장이 되게 됨
		 */

	static boolean scoreJudgment(player user, player com) {// 오직 player user,com이라는 객체와 그 객체에 저장된 스코어를 비교하기 이함이므로 객체두개만 파라미터로
														// 불러옴
		if (user.getScore() >= 1000 || com.getScore() >= 1000) {// 게임 종료를 위해 user또는 com 둘 중 한쪽이라도 1000점과 같거나 넘어가면 종료
			// 멘트 출력
			System.out.println("============ 게임 종료 ============");

			/*
			 * 컴퓨터와 유저 둘 중 한 쪽이 먼저 1000점을 찍었다는 자체가 다른 한 쪽은 1000점을 찍기 위해 카운트를 하나 더 소비해야한다는
			 * 의미이므로 1000점을 먼저 찍은 쪽이 승리하도록 if문으로 규칙 설정. 단, 둘 다 1000점을 동시에 넘었을 경우 카운트도 같다는
			 * 의미이므로 총점을 비교하여 더 높은 쪽이 승리한다(최종적으로도 모든게 똑같을 경우 무승부 처리)
			 */
			if (user.getScore() >= 1000 && com.getScore() < 1000) {
				System.out.println("유저가 먼저 1000점을 돌파하여 승리했습니다!");
			} else if (com.getScore() >= 1000 && user.getScore() < 1000) {
				System.out.println("컴퓨터가 먼저 1000점을 돌파하여 승리했습니다!");
			} else {
				// 둘 다 1000점을 넘겼을 경우엔 원래 규칙(횟수 비교) 적용
				if (user.getScore() < com.getScore()) {
					System.out.println("동시에 100점을 넘겼습니다. 판정 결과 점수가 더 높은 컴퓨터의 승리입니다!");
				} else if (user.getScore() > com.getScore()) {
					System.out.println("동시에 1000점을 넘겼습니다. 판정 결과 점수가 더 높은 유저의 승리입니다!");
				} else {// 어차피 위에 if조건들이 모두 거짓이 되어버릴 경우 남은 조건은 user와 com이 둘 다 동시에 1000점을 넘었는데도 점수가 동일할
						// 경우
						// 카운트와 점수 모두 같으므로 무승부이고 남는게 무승부 로직밖에 없으므로 else만 적어도 무승부 적용
					System.out.println("무승부입니다!"); // 없으므로 남은 건 자동으로 (user.getScore() == ...Score())이므로 생략
				}
			}
			return true;// 메인에서 while문이 반복되다가 누적스코어가 1000점이 넘어갈 경우 true를 반환해 break를 실행시켜 게임을 종료시킴
		}
		return false;// 아직 점수판정이 안됏을 경우 게임을 종료시키면 안되기에 false값을 반환
	}
}
