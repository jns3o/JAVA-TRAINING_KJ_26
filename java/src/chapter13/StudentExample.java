package chapter13;

import java.util.Scanner;

public class StudentExample {

	public static void main(String[] args) {
		Student std = new Student();
		inputInfo(std);
	}
	static void inputInfo(Student std) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		std.setName(sc.nextLine());
		System.out.print("학년을 입력하세요 : ");
		std.setGrade(sc.nextLine());
		System.out.print("반을 입력하세요 : ");
		std.setClas(sc.nextLine());
		System.out.print("번호를 입력하세요 : ");
		std.setCode(sc.nextLine());
		std.setStudentId();
		System.out.println("학번이 생성되었습니다");	
		System.out.print("학번 : " + std.getStudentId());
	}

}
