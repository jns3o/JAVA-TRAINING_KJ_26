package chapter14;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class WritterReaderExample {
	public static void main(String[] args) throws Exception{
//		Writer wt = new FileWriter("C:/Users/kj/Desktop/김지현/test.txt");	
		
		//한글자씩 입력하기(텍스트파일에~)
//		char a = 'A';
//		char b = 'B';
//		char c = 'C';
		
//		wt.write(a);
//		wt.write(b);
//		wt.write(c);

		//배열을 이용하여 여러글자 한번에 넣기
//		char[] charArray = {'H','E','L','L','O'};
		
//		wt.write(charArray);
//		wt.write(charArray, 1, 2);
		
		//String을 이용하여 여러글자 한번에 넣기
//		String str = "Hello Java!";
			
//		wt.write(str);
//		wt.write(str, 1, 5);
//		
//		wt.flush();
//		wt.close();
		
//      ------------------------------------------------------
		Reader rd = new FileReader("C:/Users/kj/Desktop/김지현/test.txt");
		
		String str1 = "";
		//한글자씩 가져오기
		while(true) {
			int data = rd.read();
			if(data == -1) break;
			str1 += String.valueOf((char)data);
			System.out.println((char)data);
		}
		System.out.println(str1);
		
		
//		char[] buffer = new char[100];
//		
//		while(true) {
//			int readCharNum = rd.read(buffer);
//			if(readCharNum == -1) break;
//			for(int i = 0; i < readCharNum; i++) {
//				System.out.print(buffer[i]);
//			}
//			System.out.println();
//		}
//		
//		int readCharNum2 = rd.read(buffer, 0, 100);
//		
//		if(readCharNum2 != -1) {
//			for(int i = 0; i < readCharNum2; i++) {
//				System.out.println(buffer[i]);
//			}
//		}

		rd.close();
		
		
	}
}
