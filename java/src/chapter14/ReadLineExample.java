package chapter14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class ReadLineExample {

	public static void main(String[] args) throws Exception{
		Reader rd = new FileReader("C:/Users/kj/Desktop/서준서/myReadLineTest.txt");
		BufferedReader br = new BufferedReader(rd);
		
		String[][] userList = new String[2][3];
		
		
		int i = 0;
		while(true) {
			String data = br.readLine();
			if(data == null) break;
			System.out.println(data);
			userList[i][0] = data.split(",")[0];
			userList[i][1] = data.split(",")[1];
			userList[i][2] = data.split(",")[2];
			i++;
		}
		System.out.println("===============");
		for(String[] user : userList) {
			System.out.print(user[0] + " ");
			System.out.print(user[1] + " ");
			System.out.println(user[2] + " ");
		}
		br.close();

	}

}
