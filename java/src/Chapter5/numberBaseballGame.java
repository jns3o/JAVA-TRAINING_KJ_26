package Chapter5;

import java.util.Random;
import java.util.Scanner;

public class numberBaseballGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자야구게임입니다");
		System.out.println("난이도는 'EASY' 'NORMAL' 'HARD' 모드가 존재하며");
		System.out.println("EASY에서는 20회, NORMAL에서는 10회, HARD에서는 5회의 기회가 주어집니다");
		System.out.println("숫자는 4개를 맞추시되 중복은 없으며 0또한 포함입니다");
		System.out.println("숫자는 맞지만 위치가 맞지 않을 시 '볼'");
		System.out.println("숫자의 위치가 옳다면 '스트라이크'");
		System.out.println("각각의 볼과 스트라이크는 숫자로 표시되며, 숫자가 볼 /스트라이크 모두 없을 시 '아웃'입니다");
		
		System.out.println("---게임 시작에 앞서 원하는 난이도를 입력해주세요---");
		System.out.print("MODE: ");
		String difficult = (sc.next());
		
		
		
		
		
		
		
		
		System.out.println("-----입력하시고자 하는 숫자를 순서대로 입력해주세요-----");
		System.out.print("1) ");
		double han1 = Double.parseDouble(sc.next());
		System.out.print("2) ");
		double han2 = Double.parseDouble(sc.next());
		System.out.print("3) ");
		double han3 = Double.parseDouble(sc.next());
		System.out.print("4) ");
		double han4 = Double.parseDouble(sc.next());
		
        Random r = new Random(); // 랜덤 숫자 뽑기 위한 셋팅
		
		// 야구게임 숫자 4개 (아직 중복제거 없음)
		int numarr[] = new int[4]; // 4칸짜리 빈 배열
		
		for (int i = 0; i < 4; i++) {
			numarr[i] = r.nextInt(0,9);
			System.out.println("numarr[" + i + "] : " + numarr[i]);
		}
		
		
		
		
      
			
			
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
	}

}
