package soloPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Practice01 {
	public static void main(String[] args) {
		output(); 
		/* 메인이 실행되면 곧바로 outPut메서드를 호출하여 outPut메서드를 실행하고
		 * 소스 순서대로 쭉 실행된다
		 */
		
	}
	static void output() {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<>(); //n개의 숫자가 담길 배열을 저장할 리스트를 생성
		System.out.print("숫자를 입력 해주세요(1이상 15이하) : ");
		int n = sc.nextInt(); //n개의 숫자가 담길 배열을 생성하기 위해 우선 사용자에게 값을 입력받고 int n에 저장
		int[] arr = new int[n]; //사용자가 입력한 n의 값만큼의 배열을 생성
		for (int i = 0; i < arr.length; i++) { 
			arr[i] = r.nextInt(1, 16); // 배열의 길이 만큼 각 인덱스마다 1부터 15까지의 랜덤숫자 대입
			System.out.println("arr[" + i + "] 의 숫자 : " + arr[i]);
			list.add(arr[i]); //for문을 돌면서 arr의 i번째 인덱스마다 숫자를 넣어줌(.add)
		}
		int result = calculator(list); //calculator메서드를 호출하고 파라미터에 list를 넘겨줌 + 호출하고 난 값을 result에 저장
		System.out.println("\n최소공배수는 : " + result + " 입니다");
		
	}
	
	static int calculator(List<Integer> list) { 
		// calculator를 호출한 outPut로부터 리스트를 파라미터로 받아옴, 값을 반환해야 하기에 반환형은 int를 선언
		int size = list.size(); //리스트 사이즈(길이)만큼의 값을 size라는 변수에 저장
		int[] test = new int[size];
		int[] cal = new int[size];
		
		
		for (int i = 0; i < size; i++) {
			test[i] = list.get(i); //밑에서 계산할때 변하지 않는 원래 배열의 값이 필요하게 test배열 생성
			cal[i] = list.get(i); //최소공배수를 구할때 원래 배열값에서 더해나가는걸 저장하기 위해 cal배열 생성
		}
		while(true) { //최소공배수를 구할때까지 서로 더해주면서 계산하기 위해 while(true)문을 사용
			boolean flag = true; //최소 공배수가 구해지면 while문을 탈출하기 위해 boolean을 사용
								//이미 최소공배수가 구해졌다고 가정
			int min = 0;
			
			/* 
			  1. for문은 검사를 위한 로직이다. 전체적인 작동원리는 n개의 인덱스가 있는 배열에서 배열 전체 검사를
			  싹 돌린뒤 가장 작은 값이 발견되면 그 작은값이 스스로를 더하고 다시 검사를 돌리고 거기서 또 가장 작은
			  수가 스스로를 더하는 방식으로 최소공배수를 구하게 된다. 이를 더하면서 검사하기 위해 값이 변해야 하는
			  배열인 cal배열을 만들어서 계산을 한다. (더해지는것은 n번 인덱스가 자기자신의 초기값을 계속 더해나가야
			  하므로 초기값을 저장해줄 test 배열을 추가로 생성 해줌)
			  ----------
			  2. 첫 번째 for문은 모든 값이 동일해지면 그 값이 최소공배수인 cal배열을 검사하기 위한 로직인데
			  사전에 최소공배수가 있다는 가정으로 flag을 true로 선언을 해줬었는데 0번 인덱스랑 그 외에
			  인덱스를 검사하는데 값이 하나라도 다르면 어차피 최소공배수가 아니라는 뜻이다.
			  값이 다를 경우 if문이 '참'이 되고 flag가 false로 바뀌게 하고 break로 첫 for문을 탈출한뒤
			  if문을 스킵하고 배열에서 최저값을 찾아서 더해줄 두 번째 for문으로 이동한다.
			  ----------
			  2-1. 만약 cal배열의 값이 모두 같을 경우 그 수들이 최소 공배수라는 뜻이다
			  그렇게 되면 첫 for문에서 if문이 거짓이 되는데 이렇게 되면 초기 flag의 true값이 변하지 않아
			  if(flag == true)가 참이 되어 실행이 되고 최소 공배수인 cal[0]의 값을 반환해주고
			  그 즉시 while(true)는 끝나게 된다.
			  ----------
			  3. min을 0으로 위에서 선언을 해주었었는데, 두 번째 for문 로직을 예시를 들어 설명을 한다고 하면
			  
			  
			  [4칸짜리 배열을 만들었다 가정하고 각각의 수는 [15, 5, 10, 10] 이다]
			  예)  cal[i] < cal[min]은 cal[1] < cal[0]이므로 즉, 5 < 15이므로 if문은 참이 됨
			  min(0)에 i가 대입(현재 i는 1) / 다시 for문을 돌아서 증감식이 i++이므로 
			  cal[2] < cal[1] ==> 10 < 5, 즉 거짓이다. 한 번 더 돌아서 i는 3이 된다(min은 아직 1)
			  cal[3] < cal[1] ==> 10 < 5, 즉 거짓이다. 이렇게 첫 바퀴에서 min은 현재 1이므로
			  for문을 빠져나가서  cal[min] += test[min];을 계산하게 된다면
			  cal[1] += test[1];이고 이는 5 += 5; 이므로 첫 바퀴가 끝나면 값이 변하는 배열인
			  cal배열 [15, 5, 10, 10]에서 1번 인덱스인 5를 test배열의 1번 인덱스인 5를 더해줘서
			  10을 만들고 cal배열의 1번 인덱스에는 5가 10으로 저장되게 된다. [15, 10, 10, 10]
			  그리고 아직 cal배열의 인덱스들이 모두 같은 값이 되지 않았으므로 최소 공배수가 없다는 뜻인데
			  그러면 while문을 아직 빠져나올수 없고 다시 for문을 돌때는 min은 0이 된다
			  
			  ----------
			  4. 3하고 2-1에서 설명이 되었듯 최소공배수를 구하기 위한 배열인 cal배열의 인덱스들의 값들이
			  전부 다를 경우 첫 for문과 두 번째 for문을 무한반복하게 되고 전체의 값이 같아질 경우에
			  드디어 flag의 값이 true가 되었으므로 while문의 조건을 만족하게 되어 탈출을 한다.
			  그렇게 되면 List에는 cal[0]의 값인 30이 반환되게 되고 그게 result에 담긴 뒤
			  System.out.println("");을 통해서 최소공배수의 값을 출력해줄 코드를 작성한 뒤
			  메인에서 output메서드를 호출해서 최종적으로 각 배열의 수와 최소공배수를 보여주게된다
			 */
			
			for(int i = 1; i < cal.length; i++) {
				if(cal[0] != cal[i]) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				return cal[0];
			}
			for(int i = 1; i < cal.length; i++) {
				if(cal[i] < cal[min]) {
					min = i;
				}
			}
			cal[min] += test[min];
			
		}
		
		
		
	}

}
