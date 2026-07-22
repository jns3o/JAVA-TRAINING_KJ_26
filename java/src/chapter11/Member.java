package chapter11;

public class Member {
	public String id;
	public Member() {}
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "이 클래스의 id는 " + this.id + "입니다";
	}
}
