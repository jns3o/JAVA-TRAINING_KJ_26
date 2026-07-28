package chapter14;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample2 {

	public static void main(String[] args) throws Exception{
		File dir = new File("C:/Users/kj/Desktop/서준서/test/filetest");
		File file1 = new File("C:/Users/kj/Desktop/서준서/test/filetest/file1.txt");
		File file2 = new File("C:/Users/kj/Desktop/서준서/test/filetest/file2.txt");
		File file3 = new File("C:/Users/kj/Desktop/서준서/test/filetest/file3.txt");
		
		if(dir.exists() == false) { dir.mkdir();}
		if(file1.exists() == false) { file1.createNewFile(); }
		if(file2.exists() == false) { file2.createNewFile(); }
		if(file3.exists() == false) { file3.createNewFile(); }
		
		File temp = new File("C:/Users/kj/Desktop/서준서/test");
		File[] content = temp.listFiles();
		
		System.out.println("|시간\t\t\t|형태\t\t|크기\t|이름");
		System.out.println("================================================================");
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd a HH:mm");
		for(File file : content) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			}else {
				System.out.print("\t\t\t + " + file.length() + "\t" + file.getName());
			}
			System.out.println();
		}
	}
	


	}

