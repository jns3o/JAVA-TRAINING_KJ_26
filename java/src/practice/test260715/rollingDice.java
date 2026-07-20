package practice.test260715;
//
import java.util.Random;

public class rollingDice implements roll{/*주사위를 굴리는 기능을 할 클래스를 생성 한 뒤 인터페이스 roll을 상속받음*/
	Random r = new Random();//각 주사위를 굴려서 랜덤한 값을 출력해야 하므로 랜덤 객체를 생성함
	
	int[] defaultDice = {1,2,3,4,5,6};//defaultDice라는 이름의 주사위를 배열로 만들고 int형식으로 선언한 다음 배열안에 1~6이라는 숫자를 지정해줌
	int[] underDogDice = {1,1,1,1,6,6};//underDogDice, normalDice, unnervingDice도 같은 형식이나 배열 안 숫자를 다르게 입력 
	int[] normalDice = {3,3,3,4,4,4};
	int[] unnervingDice = {2,2,2,5,5,5};
	
	@Override
	public int rollingDefaultDice() {//일반주사위를 굴리는 기능의 메소드
		int ran1 = r.nextInt(defaultDice.length);
		int randomNum1 = defaultDice[ran1];
		return randomNum1;
		/* ran1이라는 int형식의 그릇을 만들어준다음 객체 생성한 Random r을 이용해서 r.nextInt(dafultDice.length) 즉 
		 일반주사위의 인덱스중에서 랜덤한 인덱스를 ran1에 담은 다음, ran1이 0번인덱스라고 가정한다면
		 deaultDice[0], 즉 일반주사위의 0번 인덱스에 있는 값을 randomNum1이라는 그릇에 담게 됨
		 예시) => int ran1 = 0
		         int randomNum1 = defaultDice[0]
		         randomNum1 = 1 이 되게됨(defaultDice는 1부터 순서대로 6까지 있으므로 0번 인덱스는 1이다)*/
	}
	@Override
	public int rollingUnderDogDice() { //rollingDefaultDice 메소드랑 동작하는 원리는 같음
		int ran2 = r.nextInt(underDogDice.length);
		int randomNum2 = underDogDice[ran2];	
		return randomNum2;
	}
	@Override
	public int rollingNormalDice() {
		int ran3 = r.nextInt(normalDice.length);
		int randomNum3 = normalDice[ran3];
		return randomNum3;
	}
	@Override
	public int rollingUnnervingDice() {
		int ran4 = r.nextInt(unnervingDice.length);
		int randomNum4 = unnervingDice[ran4];	
		return randomNum4;
	}
}
