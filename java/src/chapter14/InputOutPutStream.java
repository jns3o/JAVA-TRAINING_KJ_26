package chapter14;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputOutPutStream {

	public static void main(String[] args) throws Exception{
		//OutputStream os = new FileOutputStream("C:/Users/kj/Desktop/서준서/test.db");
		
	//	byte a = 10;
	//	byte b = 20;
	//	byte c = 30;
		
	//	os.write(a);
	//	os.write(b);
	//	os.write(c);
		
	//	byte[] array = {10, 20, 30};
	//	os.write(array);
		
	//	os.flush();
	//	os.close();
		
		InputStream is = new FileInputStream("C:/Users/kj/Desktop/서준서/test.db");
		while(true) {
			int data = is.read();
			if(data == -1) break;
			System.out.println(data);
		}
		is.close();
	}

}
