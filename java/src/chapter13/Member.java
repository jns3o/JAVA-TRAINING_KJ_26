package chapter13;

public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		/* 강제 형변환은 해당 객체와 같은 객체이거나 해당 객체를 상속받고 있어야 가능하다!
		 파라미터로 받은 obj가 Member 객체와 같은 클래스로 만들어진 객체인지 또는
		 obj가 Member를 상속받고 있는 클래스로 만들어진 객체인지 확인하는 작업
		 ==> Member 클래스와 연관이 있는지 확인
		 
		*/ 
		if(obj instanceof Member) {
			// Member로 만들어진 객체나 상속받은 녀석이라면 강제 형변환 시킨다
			Member member = (Member) obj;
			// 강제 형변환 시킨것의 이름(name)과 이 객체의 name이 같은지
			// 나이(age)들도 같은지 둘 다 같다면 True(같은것이다)를 리턴(반환) 한다.
			return member.name.equals(this.name) && (member.age==this.age);
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return this.name.hashCode() + this.age;
	}
}
