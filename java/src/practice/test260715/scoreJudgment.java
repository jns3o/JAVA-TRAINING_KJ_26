package practice.test260715;

public class scoreJudgment {
	static boolean judgment(player user, player com) {//오직 player user,com이라는 객체와 그 객체에 저장된 스코어를 비교하기 이함이므로 객체두개만 파라미터로 불러옴
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
					System.out.println("동시에 100점을 넘겼습니다. 판정 결과 점수가 더 높은 유저의 승리입니다!");
				} else if (user.getScore() > com.getScore()) {
					System.out.println("동시에 100점을 넘겼습니다. 판정 결과 점수가 더 높은 컴퓨터의 승리입니다!");
				} else {// 어차피 위에 if조건들이 모두 거짓이 되어버릴 경우 남은 조건은 user와 com이 둘 다 동시에 1000점을 넘었는데도 점수가 동일할 경우
						// 카운트와 점수 모두 같으므로 무승부이고 남는게 무승부 로직밖에 없으므로 else만 적어도 무승부 적용
					System.out.println("무승부입니다!"); // 없으므로 남은 건 자동으로 (user.getScore() == ...Score())이므로 생략
				}
			}
			return true;//메인에서 while문이 반복되다가 누적스코어가 1000점이 넘어갈 경우 true를 반환해 break를 실행시켜 게임을 종료시킴
		}
		return false;//아직 점수판정이 안됏을 경우 게임을 종료시키면 안되기에 false값을 반환
	}
}
