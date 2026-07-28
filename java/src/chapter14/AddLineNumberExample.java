package chapter14;

import java.io.BufferedReader;
import java.io.FileReader;

public class AddLineNumberExample {

	public static void main(String[] args) throws Exception{
		String filePath = "src/chapter14/AddLineNumberExample.java";
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		int i = 1;
		while(true) {
			String data = br.readLine();
			if(data == null) break;
			System.out.println(i + ": " + data);
			i++;
		}
		br.close();
	}
	
}
