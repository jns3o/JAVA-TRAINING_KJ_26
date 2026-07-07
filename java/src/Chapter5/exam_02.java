package Chapter5;

public class exam_02 {

	public static void main(String[] args) { // (String[] args) = 배열
		String str1 = ""; // 이건 아무것도 없는 메모리를 가리키고 있음
		String str2 = null; // 어떤것도 가리키고 있지 않음
		// int i = null; //없다 라는 의미는 값이 될 수 없음
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);

		// ""/ null 비교
		// 화장실에 갔는데 휴지심은 있고 휴지가 없는 상태 > ""
		// 휴지심 조차도 없는 경우 > null

		int[] num = { 0, 1, 2, 3 };
		System.out.println(num.length);

		int[][] array = new int[5][5];
		System.out.println(array.length);
		System.out.println(array[0].length);
		System.out.println(array[1].length);
		System.out.println(array[2].length);

		/*
		 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
		 */

		int n = 25;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				array[i][j] += n;
				n--;
			}
			System.out.println();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf(" %2d", array[i] [j]);
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
