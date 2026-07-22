package chapter13;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		while(true){
			System.out.println("==학생 성적관리 프로그램==\n신규 학생 기본 정보를 입력하시려면 '입력'");
			System.out.println("학생 연락처를 등록하려면 '등록', 학생 정보를 수정하려면 '수정'");
			String input = sc.nextLine();
		if(input.equals("입력")) {
			Student std = new Student();
			inputInfo(std, sc);	
			studentList.add(std);
		}else if(input.equals("등록")) {
			inputTel(studentList);
		}else if(input.equals("수정")) {
			modify(studentList, sc);
		}
		
		
		else {
			System.out.println("잘못입력하셨습니다\n");
			
		}
		}
	}
	static void inputInfo(Student std, Scanner sc) {
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
		System.out.println();
		
	}
	static void inputTel(ArrayList<Student> studentList) {
		Scanner sc = new Scanner(System.in);
		System.out.print("전화번호 등록을 하기 위해 해당 학생의 학번을 입력해주세요 : ");
		String id = sc.nextLine();
		for(Student student : studentList) {
		if(id.equals(student.getStudentId())) {
			System.out.print("[" + student.getName() + "] 학생의 전화번호를 등록하시겠습니까?[등록하려면 'o', 아니라면 'x' 입력]\n : ");
			String answer = sc.nextLine();
			if(answer.equals("o")) {
				System.out.print("등록할 전화번호를 입력해주세요 : ");
				student.setTel(sc.nextLine());
				
			}return;
		}
		}System.out.println("틀렸습니다");
	}
	static void modify(ArrayList<Student> studentList, Scanner sc) {
		for(Student student : studentList) {
			System.out.println(student.getName());
			System.out.println(student.getGrade());
			System.out.println(student.getClas());
			System.out.println(student.getCode());
			System.out.println(student.getTel());
		}
	}

}
