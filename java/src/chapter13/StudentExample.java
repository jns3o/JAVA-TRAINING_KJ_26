package chapter13;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> studentList = new ArrayList<Student>(); //Student클래스를 리스트화한 'studentList'라는 새로운 리스트를 생성
		
		while(true){//추후 사용자가 프로그램 종료키를 누르지 않는 이상 프로그램이 꺼지지 않고 반복되도록 while문을 사용
			System.out.println("========학생 성적관리 프로그램========\n신규 학생 기본 정보를 입력하시려면 '신규입력'");
			System.out.println("학생 연락처를 등록하려면 '연락처', 시스템에 등록된 학생들을 전부 조회하려면 '조회'");
			System.out.println("학생 성적을 입력 하려면 '성적', 학생 정보를 수정 하려면 '수정'을 입력해주세요!");
			System.out.print("선택기능 : ");
			String input = sc.nextLine();
		if(input.equals("신규입력")) {
			System.out.println("[주의사항] - 기본정보 입력시 '학년','반','번'의 단위는 미입력 할 것");
			Student std = new Student();//inputInfo메서드에서 각 학생 개인의 정보를 입력함과 동시에 학번 중복비교를 해야하므로 리스트와 student객체 전부 넘겨줌
			inputInfo(studentList, std, sc);	
		}else if(input.equals("연락처")) {
			inputTel(studentList, sc);
		}else if(input.equals("조회")) {
			show(studentList, sc);
		}else if(input.equals("성적")) {
			System.out.println("[주의사항] - 성적 입력 시 단위는 생략하고 입력할 것");
			result(studentList, sc);
		}else if(input.equals("수정")) {
			modify(studentList, sc);
		}else {
			System.out.println("잘못입력하셨습니다\n");
			
		}
		}
	}
	static void inputInfo(ArrayList<Student> studentList,Student std, Scanner sc) {//입력을 호출받을때 Student클래스 객체와 스캐너를 넘겨받음
		System.out.print("- 학생의 이름을 입력해주세요 : "); //ArrayList도 함께 넘겨받아서 학번 중복비교
		std.setName(sc.nextLine());
		while(true) { //학년,반,번호는 int형이고 잘못입력하였을 경우 재입력 받아야 하기에 while문을 사용
		System.out.print("-학년을 입력하세요[1학년~6학년] : ");
		try { std.setGrade(sc.nextInt());
		} catch (Exception e) {
			sc.nextLine();  
//입력을 int형으로 받았는데 문자를 입력해 예외가 발생하면 nextLine이 없을 경우에는 Int형에 오류가 그대로 남아있어 
//try와 continue가 무한반복을 하여 프로그램이 터지므로 아무것도 입력받지 않지만 nextInt에 남아있는 오류를 치워줄 nextLine을 생성
			System.out.println("[!]잘못된 값을 입력하셨습니다. 정보입력화면으로 되돌아갑니다");
			continue;
		}
		if(std.getGrade() > 6) { //학년은 6학년까지로 제한
			System.out.println("[!]올바른 학년을 입력해주세요");
			continue;
		}	
		System.out.print("-학생의 반을 입력하세요[1반~12반] : ");
		try { std.setClas(sc.nextInt());
		} catch (Exception e) {
			sc.nextLine();
			System.out.println("[!]잘못된 값을 입력하셨습니다. 정보입력화면으로 되돌아갑니다");
			continue;
		}
		if(std.getClas() > 12) {//학급수는 12학급으로 제한
			System.out.println("[!]올바른 학급을 입력해주세요");
			continue;
		}
		System.out.print("-학생 번호를 입력하세요[1번~30번] : ");
		try { std.setCode(sc.nextInt());
		} catch (Exception e) {
			sc.nextLine();
			System.out.println("[!]잘못된 값을 입력하셨습니다. 정보입력화면으로 되돌아갑니다");
			continue;
		}
		if(std.getCode() > 30) {//한 반에 30명이하로 제한
			System.out.println("[!]올바른 번호를 입력해주세요");
			continue;
		}
		sc.nextLine();
		System.out.print("-학생 성별을 입력해주세요 : ");
		std.setGender(sc.nextLine());
		System.out.println(std.getGender() + "자로 입력되었습니다" );
		std.setStudentId(); //학년,반,번호를 전부 입력에 성공했다면 학번 세터로 넘어가서 학번을 생성함
		boolean overLap = false;
		for(Student idCheck : studentList) { //현재 리스트를 전부 뒤져본뒤 중복이 발견되면 overLap이 true가 되고 for문을 빠져나감
			if(std.getStudentId().equals(idCheck.getStudentId())) {
				overLap = true;
				break;
			}
		}	
		if(overLap) { //첫 번째 if문에서 overLap이 true로 선언됐으므로 if(overLap)실행 후 멘트 출력, 만약 중복되는게 없을시 if(overLap)은 그냥 없는 취급으로 통과되버림
			System.out.println("[!]해당 학번은 이미 존재하는 학번입니다. 알맞게 확인 후 재입력 바랍니다");
			continue;
		}
		studentList.add(std);
		System.out.println("\n학번이 생성되었습니다");
		System.out.print("학번 : " + std.getStudentId()); //Student클래스의 id세터에서 생성한 학번을 게터로 보여줌
		System.out.println();
		break; 
		}
	}
	static void inputTel(ArrayList<Student> studentList, Scanner sc) {//연락처를 입력할때 해당 학생조회를 위해 studentList객체와 스캐너를 불러옴
		System.out.print("전화번호 등록을 하기 위해 해당 학생의 학번을 입력해주세요 : ");
		String id = sc.nextLine();
		boolean checkId = false; //if문을 원활하게 실행하기 위해 boolean을 선언
		if(studentList.size() == 0) {//최초 실행때 연락처를 먼저 입력하려고 할시 리스트는 null이므로 처음으로 돌아가기 위한 로직
			System.out.println("\n[!]현재 전산 상 입력된 학생의 정보가 0건입니다 - 메뉴로 되돌아갑니다\n");
			return; 
		}
		for(Student student : studentList) {//for문으로 리스트를 싹 뒤지고 유저가 입력한 것이랑 같은 학번이 있을 경우 if문 실행
		if(id.equals(student.getStudentId())) {
			checkId = true; //for문 밖에서 설정한 boolean checkId의 값이 true로 변환 
			if(student.getTel() != null) { //만약 해당 학생의 전화번호가 null이 아닐 경우 전화번호를 보여주고 처음으로 되돌아가게 하는 로직
				System.out.println("현재 [" + student.getName() + "] 학생의 전화번호는 [" + student.getTel() + "] 으로 이미 입력되어있습니다. 수정하시려면 수정메뉴로 이동해주세요");
				continue;
			}
			System.out.print("[" + student.getName() + "] 학생의 전화번호를 등록하시겠습니까?[등록하려면 'o', 아니라면 'x' 입력]\n : ");
			String answer = sc.nextLine();
			if(answer.equals("o")) {
				while(true) { //전화번호를 잘못입력하였을 경우 다시 입력해야 하기에 while문을 사용
				System.out.print("등록할 전화번호를 입력해주세요 : ");
				String inputNum = sc.nextLine();
				inputNum = inputNum.replace("-", "");//먼저 inputNum으로 번호를 입력받고 '-'라 써진 부분이 있을 시 없애버리고 그걸 다시 inputNum에 대입한뒤 if문 실행
				if(inputNum.length() > 11) {
					System.out.println("전화번호는 11자리 까지만 입력가능합니다. 다시 입력해주세요");
					continue;
				}
				student.setTel(inputNum); //if문을 통과하였으면 입력한 전화번호인 inputNum을 setTel에 저장
				break;
				}
				System.out.println(student.getTel() + " 로 입력되었습니다.");
				break;
			}else if(answer.equals("x")) {
				System.out.println("x를 선택하셨습니다. 메뉴로 돌아갑니다.");
				break;
			}
		}
		}
		if(!checkId) { //입력한 학번이 조회되지 않으면 출력
			System.out.println("전산 상 해당 학번은 없는 학번입니다");
		}
		
	}
	static void result(ArrayList<Student> studentList, Scanner sc) {
		System.out.print("성적 수정/등록을 하기 위해 해당 학생의 학번을 입력해주세요 : ");
		String id = sc.nextLine();
		boolean checkId = false; //if문을 원활하게 실행하기 위해 boolean을 선언
		if(studentList.size() == 0) {//최초 실행때 성적을 먼저 입력하려고 할시 리스트는 null이므로 처음으로 돌아가기 위한 로직
			System.out.println("\n[!]현재 전산 상 입력된 학생의 정보가 0건입니다 - 메뉴로 되돌아갑니다\n");
			return; 
		}
		for(Student student : studentList) {//for문으로 리스트를 싹 뒤지고 유저가 입력한 것이랑 같은 학번이 있을 경우 if문 실행
			if(id.equals(student.getStudentId())) {
				checkId = true;
				System.out.println("\n[" + student.getName() +"] 학생 확인되었습니다. '국어,영어,수학,사회,과학'중 수정 또는 입력하고자 하는 과목을 입력해주세요");
				while(true) {
				System.out.print("- 선택과목 : ");
				String subject = sc.nextLine();
				
				switch(subject) {
				case "국어" : //국어 케이스일 경우 실행
					if(student.getKoreanScore() != 0) { //점수가 0이 아닐 경우 이미 입력이 되어있다는 뜻이므로 수정불가 코드
						System.out.println(student.getName() + " 학생의 국어 점수는 이미 입력되어있습니다. 수정하시려면 수정 메뉴로 이동해주세요");
						continue;
					}
					try { System.out.print("국어점수를 입력해주세요 : ");
						student.setKoreanScore(sc.nextInt());
						if(student.getKoreanScore() > 100) { //점수는 100점 초과는 입력 불가
							System.out.println("(!)점수는 100점 까지 입력가능합니다");
							sc.nextLine();
							continue;
						}
						System.out.println(student.getKoreanScore() + "점으로 입력되었습니다");
						sc.nextLine();
					} catch (Exception e) {
						System.out.println("단위가 입력되었습니다. 단위 미표기 후 입력바랍니다");
						sc.nextLine(); //예외상황이 발생했을 경우 초기에 int로 입력받았기에 무한반복되는 상황 방지를 위해 sc.nextLine작성
						continue;
					}break;
				case "영어" : //국어랑 동작원리는 동일
					if(student.getEngScore() != 0) {
						System.out.println(student.getName() + " 학생의 국어 점수는 이미 입력되어있습니다. 수정하시려면 수정 메뉴로 이동해주세요");
						continue;
					}
					try { System.out.print("영어점수를 입력해주세요 : ");
					student.setEngScore(sc.nextInt());
					if(student.getEngScore() > 100) {
						System.out.println("(!)점수는 100점 까지 입력가능합니다");
						sc.nextLine();
						continue;
					}
					System.out.println(student.getEngScore() + "점으로 입력되었습니다");
					sc.nextLine();
					} catch (Exception e) {
						System.out.println("단위가 입력되었습니다. 단위 미표기 후 입력바랍니다");
						sc.nextLine();
						continue;
					}break;	
				case "수학" : //국어랑 동작 원리 동일
					if(student.getMathScore() != 0) {
						System.out.println(student.getName() + " 학생의 국어 점수는 이미 입력되어있습니다. 수정하시려면 수정 메뉴로 이동해주세요");
						continue;
					}
					try { System.out.print("수학점수를 입력해주세요 : ");
					student.setMathScore(sc.nextInt());
					if(student.getMathScore() > 100) {
						System.out.println("(!)점수는 100점 까지 입력가능합니다");
						sc.nextLine();
						continue;
					}
					System.out.println(student.getMathScore() + "점으로 입력되었습니다");
					sc.nextLine();
					} catch (Exception e) {
						System.out.println("단위가 입력되었습니다. 단위 미표기 후 입력바랍니다");
						sc.nextLine();
						continue;
					}break;	
				case "사회" : //국어랑 동작 원리 동일
					if(student.getSocialScore() != 0) {
						System.out.println(student.getName() + " 학생의 국어 점수는 이미 입력되어있습니다. 수정하시려면 수정 메뉴로 이동해주세요");
						continue;
					}
					try { System.out.print("사회점수를 입력해주세요 : ");
					student.setSocialScore(sc.nextInt());
					if(student.getSocialScore() > 100) {
						System.out.println("(!)점수는 100점 까지 입력가능합니다");
						sc.nextLine();
						continue;
					}
					System.out.println(student.getSocialScore() + "점으로 입력되었습니다");
					sc.nextLine();
					} catch (Exception e) {
						System.out.println("단위가 입력되었습니다. 단위 미표기 후 입력바랍니다");
						sc.nextLine();
						continue;
					}break;	
				case "과학" : //국어랑 동작 원리 동일
					if(student.getScienceScore() != 0) {
						System.out.println(student.getName() + " 학생의 국어 점수는 이미 입력되어있습니다. 수정하시려면 수정 메뉴로 이동해주세요");
						continue;
					}
					try { System.out.print("과학점수를 입력해주세요 : ");
					student.setScienceScore(sc.nextInt());
					if(student.getScienceScore() > 100) {
						System.out.println("(!)점수는 100점 까지 입력가능합니다");
						sc.nextLine();
						continue;
					}
					System.out.println(student.getScienceScore() + "점으로 입력되었습니다");
					sc.nextLine();
					} catch (Exception e) {
						System.out.println("단위가 입력되었습니다. 단위 미표기 후 입력바랍니다");
						sc.nextLine();
						continue;
					}break;	
				default : //만약 국,영,수,사,과가 아닌 다른 과목이나 잘못된 것을 입력하면 띄우도록 설정
					System.out.println("[!]입력하신 과목은 없는 과목입니다. 다시 입력해주세요");
					continue;
				}
				break;
			}
			}if(!checkId) { //마찬가지로 초기 입력한 학번이 없으면 없다고 띄우기 위한 if문
				System.out.println("전산 상 해당 학번은 없는 학번입니다");
				break;
			}
	}
	}
	static void modify(ArrayList<Student> studentList, Scanner sc) {//앞서 입력한 것들을 수정하기 위한 메서드
		if(studentList.size() == 0) {
			System.out.println("\n[!]현재 전산 상 등록된 학생이 없습니다. 학생 정보 입력 후 수정바랍니다\n");
			return;
		}
		System.out.print("수정을 하려는 학생의 학번을 입력해주세요 : ");
		String id = sc.nextLine();
		for(Student student : studentList) {
			if(id.equals(student.getStudentId())) {
				System.out.println("[" + student.getName() + "] 학생 확인되었습니다.");
				while(true) {
					System.out.println("연락처를 수정하시려면 ");
				}
			}
		}
		
		
		System.out.println("연락처를 수정하시려면 '연락처', 성적을 수정하시려면 '성적'을 입력해주세요\n : ");
		String md = sc.nextLine();
		if(md.equals("연락처")) {
		}
	}
	
	
	
	
	
	
	
	
	
	//학생 성적조회 프로그램 중간중간 입력이 잘되고 있나 확인하기 위한 메서드
	static void show(ArrayList<Student> studentList, Scanner sc) {
		if(studentList.size() == 0) {
			System.out.println("- [!] 현재 전산 상 등록된 학생이 없습니다\n");
			return;
		}
		for(Student student : studentList) {
			System.out.println("[" + student.getName() + "] 학생의 정보");
			System.out.println("학년  : " + student.getGrade());
			System.out.println("반    : " + student.getClas());
			System.out.println("번호  : " + student.getCode());
			if(student.getTel() == null) {
				System.out.println("연락처 : [입력된 번호 없음]");
			}else {
				System.out.println("연락처 : " + student.getTel());
			}
			System.out.println("성별 : " + student.getGender());
			System.out.println("국어 점수 : " + student.getKoreanScore());
			System.out.println("영어 점수 : " + student.getEngScore());
			System.out.println("수학 점수 : " + student.getMathScore());
			System.out.println("사회 점수 : " + student.getSocialScore());
			System.out.println("과학 점수 : " + student.getScienceScore());
		}
	}

}
