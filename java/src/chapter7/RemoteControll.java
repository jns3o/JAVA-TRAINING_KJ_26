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
	Scanner sc = new Scanner(System.in); /*부모클래스인 RemoteControll의 필드에 있는 것들은
	상속(extends)받은 자식 클래스에서 쓸 수 있는데 일일이 자식 클래스마다 Scanner를 선언하는것보단
	부모클래스에서 Scanner를 선언해놓고 자식클래스에 상속을 사용하는게 효율적이어서 부모클래스에만 
	Scanner를 선언*/
	
	abstract void powerOn();
	abstract void powerOff();
	}
/*부모클래스에서 void powerOn/Off라는 메서드를 만들어놓고 앞에 abstract를 쓰게 된다면powerOn/Off
 라는 메소드는 추상메소드가 된다.abstract가 추상이라는 뜻인데 이걸 붙이게 되면 부모클래스에서는
 메서드에서 객체를 생성할 수 없게 되지만 부모클래스를 물려받은 자식클래스에서 써야되는 일종의 규칙이다
 + 예시로 부모클래스에서 abstract void powerOn();이라고 추상메서드를 만들었는데, 이렇게 되면
 부모 클래스에서 void powerOn();메서드 밑으로는 객체를 생성하지 못하게 되지만 RemoteControll 클래스를
 extends(상속)받은 클래스에서는 물려받은 클래스가 하나라면 무조건 써야하는 규칙이 되는 것이고 물려받은
 클래스가 여러개라면 한 곳만 써도되고 여러곳도 써도되지만 한 군데라도 쓰지 않으면 불완전한 규칙이 되는것이라
 써야되는것이다.*/
/*chapter7을 예로 들면 리모컨 기능을 구현하는 걸 만드는데 부모 클래스인 RemoteControll에서
 void powerOn(); 즉, 전원을 키는 기능을 구현할 메소드를 만들어놓았는데 abstract를 붙이면
 부모클래스에서는 객체를 생성하지 못하기에 RemoteControll클래스에서는 전원 on/off기능을
 구현하지는 못하지만 이걸 자식 클래스에서 무조건 써야하는 규칙을 만들어줌으로써 자식 클래스에서 직접적으로
 각각의 리모컨 전원 on/off기능을 구현하도록 의도*/
 