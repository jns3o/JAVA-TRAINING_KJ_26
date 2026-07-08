package Chapter5;

public class homework_07_07 {

	public static void main(String[] args) {

		System.out.println("1)"); 
		// 1번 문제
		int[][] bingo = new int[5][5];
		int n = 25;

		for (int i = 0; i < 5; i++) {
		    for (int j = 0; j < 5; j++) {
		        bingo[i][j] += n; 
		        n--;
		    }
		} 

		
		for (int i = 0; i < 5; i++) {
		    for (int j = 0; j < 5; j++) {
		        System.out.printf(" %2d", bingo[i][j]);
		    }
		    System.out.println(); 
		}
		///////////////////////////////////////////
		System.out.println("2)-------");
		/*2번 문제 (풀이 설명: 1번 문제와 원리 자체는 같지만 1은 우측으로 1씩 빼면서 밑으로 내려가는 식이었다면 2번문제는
		 1부터 시작해서 우측으로 +2씩 해가며 내려가는 형식으로 코드를 구성 */
		 
		int[][]bingo1 = new int[5][5];
		int n1 = 1;
		
		for (int a = 0; a < 5; a++){
			for (int b = 0; b < 5; b++) {
				bingo1[a][b] += n1;
				n1 = n1 + 2;
			}
		}
		
		for (int a = 0; a < 5; a++) {
			for (int b = 0; b< 5; b++) {
				System.out.printf(" %2d", bingo1[a][b]);
			}
			System.out.println();
		}
		////////////////////////////////////////////
		System.out.println("3)-------");
		/*3번 문제 (풀이 설명: 3번 문제는 1번 문제처럼 25부터 1씩 빼며 진행된다는 점은 같으나 가로로 진행하지 않고
		 가로 첫째줄부터 세로로 내려가면서 진행된다*/

		int[][]bingo2 = new int[5][5];
		int n2 = 25;
		
		for (int t = 0; t < 5; t++) {
			for (int f = 0; f < 5;f++) {
				bingo2[f][t] += n2; /*for문 안에서의 진행방식 자체는 1,2번 문제와 동일하지만 3번 문제는 세로열부터 늘어나야 하므로
				'bingo2'에서 두개의 배열안에 들어가는 변수명(t,f)을(를) 1,2번과 다르게 f를 앞으로 t를 두 번째 배열칸에 넣는다*/
				n2--;
			}
		}
		for (int t = 0; t < 5; t++) {
			for (int f = 0; f < 5; f++) {
				System.out.printf(" %2d", bingo2[t][f]);
			}
			System.out.println();
		}
		////////////////////////////////////////////
		System.out.println("4)-------");
		//4번 문제 
		/* 1,2번 문제와 동일한 경우이다. 4번 문제는 3번 문제와 진행방식은 같지만 세로열부터 진행되는 과정에서 25부터 시작하지 않고 1부터
		 시작이 되는데 -1이 아닌 +1을 하며 지나가기 때문에 아래와 같은 코드를 작성 */
		int[][]bingo3 = new int[5][5];
		int n3 = 1;
		
		for (int q = 0; q < 5; q++) {
			for (int o = 0; o < 5;o++) {
				bingo3[o][q] += n3;
				n3++;
			}
		}
		for (int q = 0; q < 5; q++) {
			for (int o = 0; o < 5; o++) {
				System.out.printf(" %2d", bingo3[q][o]);
			}
			System.out.println();
		}
		/////////////////////////////////////////////
		//5번 문제
		System.out.println("5)-------");
		int [][]bingo4 = new int[5][5];
				
		int ga = 0;
		int se = 0;
		int ban = 0;
		
		for (int i = 1; i <= 25; i++) {
			bingo4[ga][se] = i;

		int t_ga = ga;
		int t_se = se;
			
			
		if (ban == 0) {t_se = se + 1;}
		else if (ban == 1) {t_ga = ga + 1;}
		else if (ban == 2) {t_se = se - 1;}
		else if (ban == 3) {t_ga = ga - 1;}
		
		if (t_ga >= 5 || t_se >= 5 || t_ga < 0 || t_se < 0 || bingo4[t_ga][t_se] != 0) {
			ban++;
		if (ban == 4) {ban = 0;}
		
		if (ban == 0) {t_ga = ga; t_se = se + 1;}
		else if (ban == 1) {t_ga = ga + 1; t_se = se;}
		else if (ban == 2) {t_ga = ga; t_se = se - 1;}
		else if (ban == 3) {t_ga = ga - 1; t_se = se;}
		}
		ga = t_ga;
		se = t_se;	
		}
		for (int i = 0; i < 5; i++) {
			for (int b = 0; b < 5; b++) {
				System.out.printf(" %2d", bingo4[i][b]);
			}
			System.out.println();	
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}

