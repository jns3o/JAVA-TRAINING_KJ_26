package chapter09;

public class Test {
	 class Apple{
		 int appleCnt;
		
		 void appleTest() {
			 class Box{
				 Box(){
					 System.out.println("Box생성됨.");
				 }
				 int boxCnt;
				 
				 void boxPrint() {
					 System.out.println("boxCnt : " + boxCnt);
				 }
			 }
			 
			 Box box = new Box();
			 box.boxPrint();
		 }
		 
		void applePrint() {
			System.out.println("appleCnt : " + appleCnt);
		}
	}
	 static class Apple2{
		 int appleCnt;
			
			void applePrint() {
				System.out.println("appleCnt : " + appleCnt);
			}
	 }
}
