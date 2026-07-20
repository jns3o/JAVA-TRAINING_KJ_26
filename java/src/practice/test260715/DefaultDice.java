package practice.test260715;

import java.util.Random;

public class DefaultDice implements roll{
	Random r = new Random();
	int[] defaultDice = {1,2,3,4,5,6};//defaultDice라는 이름의 주사위를 배열로 만들고 int형식으로 선언한 다음 배열안에 1~6이라는 숫자를 지정해줌
	@Override
	public int roll() {
		return defaultDice[r.nextInt(defaultDice.length)];
	}//만약 DefaultDice클래스를 객체 생성하여 그곳에서 해당 객체를 호출한다면 일반주사위 클래스의 roll메서드가 호출되서 주사위의 인덱스 중에서 랜덤한 인덱스가 반환되게됨
}
