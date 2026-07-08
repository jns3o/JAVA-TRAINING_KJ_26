package chapter6;

public class Student {
	public int kor;
	public int eng;
	public int mat;
	
	public String name;
	public int no; //ÇÐ¹ø
	public String tel;
	
	public void insertName(String name) {
		this.name = name;
		
	}
	public void printName() {
		System.out.println(this.name);
	}
	
	public void insertKor(int k) {
		this.kor = k;
	}
	
	public void insertEng(int e) {
		this.eng = e;
	}
	
	public void insertMat(int m) {
		this.mat = m;
	}
	
	
	
	
	
}
