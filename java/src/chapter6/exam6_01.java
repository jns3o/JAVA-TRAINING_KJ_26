package chapter6;

class Student{
	String name;
	String tel;
	
	int korea;
	int english;
	int math;
	
	Student(String inputName){
		this.name = inputName;
	}
	double average() {
		double average = ((double)this.korea + (double)this.math + (double)this.english) / 3;
		return average;
	}
}

public class exam6_01 {

	public static void main(String[] args) {
		Student std1 = new Student("È«±æµ¿");
		Student std2 = new Student("±è¸íÈñ");
		System.out.println(std1.name);
		System.out.println(std2.name);
		
		std1.korea = 90;
		std1.math = 85;
		std1.english = 95;
		
		System.out.println(std1.average());
		
		
	
	}	
	

}
