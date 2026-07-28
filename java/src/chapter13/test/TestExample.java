package chapter13.test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestExample {
	public static void main(String[] args) {
		TestDao dao = new TestDao();
		Scanner sc = new Scanner(System.in);
		
		int num = Integer.parseInt(sc.nextLine());
		
		ArrayList<Test> list = dao.getTestList(num);
		
		for(Test t : list) {
			System.out.println(t.getTitle() + "-" + t.getContent());
		}
		
		// 입력
		// >> 3
		//출력형태
		/* --------------------
		 * 제목1-내용1
		 * 제목2-내용3
		 * 제목3-내용3

		
		 */
	}
}
