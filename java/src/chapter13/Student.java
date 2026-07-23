package chapter13;

public class Student {
	private String studentId;
	private String name;
	private int grade;
	private	int clas;
	private int code;
	private String tel;
	private String gender;
	private int koreanScore;
	private int mathScore;
	private int engScore;
	private int socialScore;
	private int scienceScore;
	private int averageScore;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId() {//학생의 학번 생성 세터
		String nameId = String.valueOf(this.grade);
		String clasId = "";
		if (this.clas < 10) {
			clasId = "0" + this.clas;
		}else {
			clasId = String.valueOf(this.clas);
		}
		String codeId = "";
		if (this.code < 10) {
			codeId = "0" + this.code;
		}else {
			codeId = String.valueOf(this.code);
		}
		this.studentId = nameId + clasId + codeId; 
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		
		this.grade = grade;
	}
	public int getClas() {
		return clas;
	}
	public void setClas(int clas) {
		
		this.clas = clas;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		
		this.code = code;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		String telStr = tel.replace("-", "");
		if(tel.length() == 8) { //만약 사용자가 입력한 전화번호가 8자리일 경우 앞 010이 빠졌으므로 앞에 010을 추가해줌
			telStr = "010" + telStr;
		}else if(tel.length() == 11) {
			
		}else {
			//062-155-1888
		}
		telStr = telStr.substring(0,3) + "-" + telStr.substring(3,7) + "-" + telStr.substring(7,11); 
		this.tel = telStr; //사용자가 번호를 어떤 형식으로 입력을 하든 실제 번호 처럼 중간에 '-'가 들어가게 하기 위함.
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
	public int getKoreanScore() {
		return koreanScore;
	}
	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getSocialScore() {
		return socialScore;
	}
	public void setSocialScore(int socialScore) {
		this.socialScore = socialScore;
	}
	public int getScienceScore() {
		return scienceScore;
	}
	public void setScienceScore(int scienceScore) {
		this.scienceScore = scienceScore;
	}
	public int getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(int averageScore) {
		int average = this.koreanScore + this.mathScore + this.engScore + this.socialScore + this.scienceScore;
		int scoreAverage = average / 5; //5과목의 값을 더한 뒤 총합을 5로 나눔 
		
		this.averageScore = scoreAverage;
	}
	
	
	
	
}
