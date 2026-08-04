package practice.test260715;

import java.util.Random;
import java.util.Scanner;

public class Company {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		//int i = r.nextInt(4, 100000); //4부터 10만까지 랜덤한 숫자를 i에 저장(i는 사원의 수)
		int i = sc.nextInt();
		int[][] scores = new int[i][2]; //사원의 수만큼(i) 배열이 생성이 됨
		
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
		/* 첫번째와 두번째 for문의 원리는 예를 들어 유저가 5명을 선택했다면 배열은 5칸이 생성이 되었고
		 * i는 5이다. 첫 번째 포문에서 c < 5이니 첫 포문은 5번을 돌게 되는데 이중포문이므로 0번 인덱스부터
		 * 4번 인덱스까지 두번째 포문에서 비교하게 되는데 인덱스가 겹치게 되는 경우 자기자신이니 랭크는 오르지 않고
		 * 사전에 sums[c]에 저장된것과 비교를 하여 클 경우 등수가 하락하게 되는 식이다
		 * 그렇게 해서 각 인덱스마다 rank점수가 저장이 되고 마지막에 각 인덱스마다 맞는 랭크가 출력이 되는것이다.
		 */
		
		for (int c = 0; c < i; c++) {
			int rank = 1;
			
			for (int j = 0; j < i; j++) {
				if (sums[j] > sums[c]) {
					rank++;
				}
			}
			
			//초기조건에 scores[0]은 완호의 점수라고 되어있었으니 처음 for문이 c는 0으로 시작할때 바로 완호의 점수로 저장
			if (c == 0) {
				wanhoRank = rank;
			}
			
			System.out.println("[" + scores[c][0] + "," + scores[c][1] +  "] 의 합 : " + sums[c] + " , 등수 : " + rank + "등");
		}
		
		System.out.println("\nA사 전체 사원 수 : " + i + "명");
		System.out.println("완호씨의 점수 : " + sums[0] + " (합산 점수) , 등수 : " + wanhoRank + "등");
		// +완호씨의 등수가 상위 몇프로인지 구하기 위해 백분율 식을 이용해서 구하는 로직
		double percent = 100 * wanhoRank / i;
		System.out.println("완호씨의 인사고과 등급 : " + percent + "%");
	}
}