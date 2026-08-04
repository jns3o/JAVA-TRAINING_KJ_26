package practice.test260715;

import java.util.Random;

public class BackBigNum {

	public static void main(String[] args) {
		Random r = new Random(); //각 인덱스마다 랜덤한 숫자를 부여하기 위해 랜덤 객체 생성
		int array = 1000000; //랜덤숫자들을 넣을 배열을 정하는 변수(array)의 값만 바꾸면 밑에 로직들도 따라서 바뀜
		int[] numbers = new int[array]; //array의 값만큼의 int형 배열이 'numbers'라는 이름으로 만들어짐

		for (int i = 0; i < numbers.length; i++) { //'numbers'배열의 길이 만큼 각 인덱스마다 숫자를 넣기 위한 for문
			numbers[i] = r.nextInt(0, 9);// 각 인덱스마다 랜덤숫자를 넣는 로직
			System.out.println("Index[" + i +  "] : " + numbers[i]); // 여기서 처음 지정한 array의 값만큼 배열이 만들어지고 숫자가 입력
		}
		System.out.println("================");
		for (int a = 0; a < numbers.length; a++) { // 인덱스끼리 비교하기 위한 for문
			boolean flag = false; 
			for (int j = a + 1; j < numbers.length; j++) {//0번(1번째)인덱스는 자기자신을 비교할 필요가 없으니 j = a + 1;을 작성
				if (numbers[a] < numbers[j]) { 
					flag = true; 
					/* 위 for문을 통해 뒤에 있는 인덱스들을 차례로 비교하다가 자신보다 큰걸 발견했으면 true로 선언하면서
					 * 입출력 규칙대로 예를 들어 numbers[1] < numbers[3]인데 2와 5면은 1번 인덱스에다가 3번 인덱스의
					 * 값을 덮어씌우기 위한 if문
					 */
					numbers[a] = numbers[j]; 
					System.out.println("Index[" + a + "] : " + numbers[a]);
					break; //if문이 실행되서 값을 덮어씌우는것까지 했다면 다시 for문을 돌리기 위해 break; 사용
				}
			}
			if (!flag) { 
				/* 0번 인덱스부터 array의 값만큼 인덱스들을 비교하는데 a번 인덱스보다 큰 값을 찾지 못하였을 경우 false가
				 * 유지되므로 "만약 false"라면은 a번 인덱스에 -1을 덮어씌우기 위해 작성
				 */
				numbers[a] = -1;
				System.out.println("Index[" + a + "] : " + numbers[a]);

			}

		}

	}

}
