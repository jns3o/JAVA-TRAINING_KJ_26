package Chapter5;

import java.util.Random;

public class exam05_1 {

	public static void main(String[] args) {
//		String str1 = "Hello";
//		String str2 = "Hello World";
//		
//		
//		String[] str3 = str2.split(" ");
//		System.out.println("str1: " + str1);
//		System.out.println("str3[0]: " + str3[0]);
//		
//		System.out.println(str1 == str3[0]);
//		
		/*
		 *  배열이란:
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		//int num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;
		int num[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int numarr[] = new int[4]; // 빈 배열
		
		
//		for(int i = 0; i < 10; i++)
//		System.out.println("num[" + i + "] : " + num[i] );
		
//		String strarr[] = {"Hello","Apple","Computer","Java"};
//		for(int i = 0; 1 < 4; i++) {
//			System.out.println("num[" + i +"] : " + strarr[1]);
			
		
		
		

	     Random r = new Random();
		for (int i = 0; i<10; i++) {
			numarr[i] = r.nextInt();
			System.out.println("numarr[" + i + "] : " + numarr[i]);
		}
		 String bingo[][] = new String[5][5];
		 
		 for (int i = 0; i < 5; i++) {
			 for(int j = 0; j < 5; j++) {
				 System.out.printf("%3s", bingo[i][j] + " ");
				 
			 }
			 System.out.println();
			 
		 }
		char sitArr[][] = new char[2][5];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.printf("%3c ", sitArr[i][j] ); 
				
				
			}
		}
		
		
		
		
		
		}


	}

