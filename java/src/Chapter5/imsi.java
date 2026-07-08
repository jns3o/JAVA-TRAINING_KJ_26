package Chapter5;

public class imsi {

	public static void main(String[] args) {
		/////////////////////////////////////////////
		//5번 문제
		System.out.println("5)-------");
		int [][]bingo4 = new int[5][5];
		
		int ga = 0;
		int se = 0;
		int num = 1;
		
		int jn = 0; 
		
		while (num <= 25) {
		
		for (int b = jn; b < 5 - jn; b++) {
		bingo4[ga][b] = num++;
		}
		se = 5 - 1 - jn; 
		
		for (int a = jn + 1; a < 5 - jn; a++) {
		bingo4[a][se] = num++;
		}
		ga = 5 - 1 - jn; 
		
		for (int b = se - 1; b >= jn; b--) {
		bingo4[ga][b] = num++;
		}
		se = jn; 
		
		for (int a = ga - 1; a > jn; a--) {
		bingo4[a][se] = num++;
		}
		jn++; 
		ga = jn; 
		}
		
		
		for (int i = 0; i < 5; i++) {
		for (int b = 0; b < 5; b++) {
		System.out.printf(" %2d", bingo4[i][b]);
		}
		System.out.println();   
		}
		
			}
		
		}
