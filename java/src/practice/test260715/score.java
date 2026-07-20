package practice.test260715;

public class score {//유저가 고른 주사위 3개와 컴퓨터가 사용하는 1번 주사위를 3번 굴리는 값의 합을 구하고 출력하기 위한 클래스를 분리
	static int playUserScore(player user, rollingDice d, int[] choiceDice) {//(유저의 스코어를 구하는 메서드를 생성 후 메인에서 객체 생성했던 player와 rollingDice
		int scoreBoard = 0; 											//그리고 int배열의 choiceDice를 파라미터로 불러옴(메서드 내부에서 player객체를 새로 생성 시
																		//player클래스에서 가리키는 user라는 player와 다르게 되므로 객체 생성을 하지 않고 불러옴)
			for (int i = 0; i < 3; i++){//유저가 고른 1번부터 3번 주사위까지 각각의 값을 구해줄때 n번째 주사위를 출력하기 위해 for문을 작성
				int result = rollDiceChoice(choiceDice[i], d); //메인에서 choiceDice[i]에 저장된 유저가 고른 주사위의 맞는 주사위를 'rollDiceChoice'메서드 호출을 통해
				System.out.println("-" + (i + 1) + "번째 주사위 결과: [" + result + "]");//결과값을 구하고 그것을 int형 result에 저장
				scoreBoard += result;//결과값인 result를 scoreBoard에 저장하여 매 라운드마다 누적점수를 유저에게 보여줌
			}System.out.println("\n[결과] 이번 라운드 유저 합계 : " + scoreBoard);
				
		user.addScore(scoreBoard);//만약 메인에서 playUserScore메서드를 호출하고 객체를 user객체를 호출했으면 scoreBoard의 값은 user라는 객체에 저장이됨
		user.addCount();
		return scoreBoard;//이미 addScore와 메서드 이름 앞에 반환형 int를 통해 play와 player클래스에 저장할건 다했지만 반환형을 void가 아닌 int형으로 하였기 때문에
		                  //return을 쓰지 않으면 메서드를 끝낼 수 없어서 return scoreBoard;를 입력
	}
	static int playComScore(player com, rollingDice d) {//컴퓨터 주사위 값을 구하는 전용 메서드 생성
		int scoreBoard2 = 0;
		for (int i = 0; i < 3; i++) {
			scoreBoard2 += d.rollingDefaultDice();//for문이 3번 반복될때마다 scoreBoard2에 저장되는 일반주사위의 값이 전부 다르게 저장됨
		}System.out.println("[결과] 이번 라운드 컴퓨터 합계 : " + scoreBoard2 + "\n");
		com.addScore(scoreBoard2);
		com.addCount();
		return scoreBoard2;//마찬가지로 int형으로 반환형을 설정해주었기에 메서드를 끝내기 위해 return scoreBoard2를 작성
}
		public static int rollDiceChoice(int choice, rollingDice d) {//유저가 고른 3개의 주사위를 각 인덱스에 맞는 주사위의 값을 구하기 위해 작성
			if (choice == 1)
				return d.rollingDefaultDice();
			if (choice == 2)
				return d.rollingUnderDogDice();
			if (choice == 3)
				return d.rollingNormalDice();
			return d.rollingUnnervingDice();//만약 유저가 4번을 골랐을 경우 if choice가 1,2,3중 아무것도 아니게 되고 반환형이 int라서 return을 해줘야 하기에
									//마지막까지 내려오면 에매한 주사위가 남기 때문에 유저가 4번 주사위를 고른다면 자동으로 choice에는 에매한 주사위의 값이 반환되게됨
}
}
/* score클래스 해석: 메인메서드에서 selectDice메서드를 호출해서 사용자에게 입력받은 각 주사위를 choiceDice[i]라는 배열안에 저장을 한다음에 메인에서
 score.playUserScore를 호출하게 되면 파라미터안에 int[] choiceDice를 불러오게끔 작성을 해놓았고 호출이 되면 for문을 통해 choiceDice의 0번~2번 인덱스까지의 담겨있는
 플레이어가 고른 주사위의 값을 구하고 그걸 result에 저장해서 사용자에게 보여주고 scoreBoard에 저장을 해서 그 scoreBoard는 player클래스의 user라는 주소에 저장이 되게 됨*/
 