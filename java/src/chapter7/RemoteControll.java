package chapter7;

import java.util.Scanner;

public abstract class RemoteControll {
	
	boolean power = false;
	boolean powerOn2() { /*부모 클래스인 RemoteControll에서 자식 클래스에서 쓸 수 있게 boolean power = false;
	로 미리 선언을 해놓았는데 메인 메소드에서 각 자식 클래스들이 boolean power의 값이 true인지 볼 수 있으려면
	부모 클래스에서 boolean powerOn2라는 변수를 또 선언해주고 중괄호는 친 뒤 그 안에 return this.power 즉,
	power라는 변수를 지정하기 위해 this. 을 쓰고 이걸 메인 메소드에서 쓸 수 있게 '반환'하기 위해 return을 사용*/
		return this.power;
	}
	Scanner sc = new Scanner(System.in);
	
	abstract void powerOn();	
	abstract void powerOff();
	}
