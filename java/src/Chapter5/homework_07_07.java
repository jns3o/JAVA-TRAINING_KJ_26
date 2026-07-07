package Chapter5;

public class homework_07_07 {

	public static void main(String[] args) {
		System.out.print("1)");
		// 1번 문제
		int[][]bingo  = new int[5][5];
		int n = 25;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo[i][j] += n;
				n--;
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf(" %2d", bingo[i][j]);
			}
			System.out.println();
		}
		System.out.println("2)");
		//2번 문제
		int[][]bingo1 = new int[5][5];
		int n1 = 1;
		
		for (int a = 0; a < 5; a++){
			for (int b = 0; b < 5; b++) {
				bingo1[a][b] 
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
