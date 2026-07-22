package Chapter5;

public class exam5_03 {

	public static void main(String[] args) {
		int[] a = {0, 1, 2};
		 
		// int[] b =a;//주소값이 대입되므로 같이 바뀜
		int[] b = new int[3];
		
		for(int i = 0; i < b.length; i++) {
			b[i] = a[i];
		}
		
		b[1] = 4;
		
		for(int i : a) {
			System.out.println(i + " ");
		}
		
		
		
//		for(int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + " ");
//		}
		System.out.println();
		
		for(int i : b) {
			System.out.println(i + " ");
		
//		for(int i = 0; i < b.length; i++) {
//			System.out.print(b[i] + " ");
		}
		System.out.println();
		String[] array = {"Hello", "World", "Java"};
		
		for(String str : array) {
			System.out.print(str + " ");
		}
		
//		for (int i = 0; i < array.length; i++) {
//			System.out.println(array[i] + " ");
//		}
		System.out.println();
	}

}
