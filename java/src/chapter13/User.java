package chapter13;

public class User {
	private String name;
	private String tel;
	private int age;
	private String birth;
	private String gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		String telStr = tel.replace("-", "");
		if(tel.length() == 8) {
			telStr = "010" + telStr;
		}else if(tel.length() == 11) {
			
		}else {
			//062-155-1888
		}
		telStr = telStr.substring(0,3) + "-" + telStr.substring(3,7) + "-" + telStr.substring(7,11);
		this.tel = telStr;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		//만약 입력받는 내용의 "남자" / "여자" 이런 모양으로 되어있는지 확인
		if(gender.indexOf("남") == -1 && gender.indexOf("여") == -1) {
			System.out.println("잘못된 입력입니다");
		}
		
		if (gender.indexOf("자") != -1) {
			//"자"라는 글자가 있다면 지워버리겠다!
			gender = gender.replace("자", "");
		}
		this.gender = gender;
	}
	
	
}
