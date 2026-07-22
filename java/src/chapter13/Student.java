package chapter13;

public class Student {
	private String studentId;
	private String name;
	private String grade;
	private	String clas;
	private String code;
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
	public void setStudentId() {
		String averageId =  this.grade + this.clas + this.code;
		this.studentId = averageId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		if(grade.indexOf("학년") != -1) {
			grade = grade.replace("학년", "");
		}
		this.grade = grade;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		if(clas.indexOf("반") != -1) {
			clas = clas.replace("반", "");
		}
		this.clas = clas;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		if(code.indexOf("번") != -1) {
			code = code.replace("번", "");
		}
		this.code = code;
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
