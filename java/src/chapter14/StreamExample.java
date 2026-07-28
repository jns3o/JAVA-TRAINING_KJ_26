package chapter14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.Reader;
import java.io.OutputStreamWriter;

public class StreamExample {

	public static void main(String[] args) throws Exception{
		 write("안녕하세요 지금은 11시 31분 입니다.");
		 String data = read();
		 System.out.println(data);
	}
	
	public static void write(String str) throws Exception{
		FileOutputStream fos = new FileOutputStream("C:/Users/kj/Desktop/서준서/testStream");
		Writer writer = new OutputStreamWriter(fos);
		
		writer.write(str);
		writer.flush();
		writer.close();
	}
	public static String read() throws Exception{
		FileInputStream fis = new FileInputStream("C:/Users/kj/Desktop/서준서/testStream");
		Reader reader = new InputStreamReader(fis);
		
		char[] buffer = new char[100];
		int readCharNum = reader.read(buffer);
		reader.close();
		String data = new String(buffer, 0, readCharNum);
		return data;
	}

}
