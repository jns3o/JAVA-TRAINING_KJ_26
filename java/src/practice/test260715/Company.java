package practice.test260715;

import java.util.Random;
import java.util.Scanner;

public class Company {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int i = sc.nextInt();
		int[][] scores = new int[i][2];
		
		// 각 칸마다 생성된 배열들의 합을 저장할 배열을 새로 생성
		int[] sums = new int[i];
		
		for (int a = 0; a < i; a++) {
			scores[a][0] = r.nextInt(0, 10); // n번째 배열의 첫 번째 칸 숫자 생성로직
		}
		for (int b = 0; b < i; b++) {
			scores[b][1] = r.nextInt(0, 10); // n번째 배열의 두 번째 칸 숫자 생성로직
		}
		
		//각각의 배열들의 합을 구해서 비교하기 위해 저장을 해둠
		for (int c = 0; c < i; c++) {
			sums[c] = scores[c][0] + scores[c][1];
		}
		
		
		int wanhoRank = 1;
		
		// 결과 출력 및 공동 등수 계산
		for (int c = 0; c < i; c++) {
			int rank = 1;
			
			for (int j = 0; j < i; j++) {
				if (sums[j] > sums[c]) {
					rank++;
				}
			}
			
			//초기조건에 scores[0]은 완호의 점수라고 되어있었으니 완호의 등수만 따로 표시해주기 위해 완호랭크에 대입
			if (c == 0) {
				wanhoRank = rank;
			}
			
			System.out.println("[" + scores[c][0] + "," + scores[c][1] + "] 의 합 : " + sums[c] + " , 등수 : " + rank + "등");
		}
		
		System.out.println("\n완호씨의 점수 : " + sums[0] + " (합산 점수) , 등수 : " + wanhoRank + "등");
	}
}