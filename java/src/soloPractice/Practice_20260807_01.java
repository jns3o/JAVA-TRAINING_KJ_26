package soloPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Practice_20260807_01 {
    public static void main(String[] args) {
        int[] arr = randomArray(1000); // randomArray메서드를 호출해서 파라미터에 int값을(배열의 총 길이) 넘겨주고 메서드가 끝난 뒤 그 값을 return을 통해 다시 돌려받고 int[]arr에 저장
        int[] answer = calculator(arr); //randomArray에서 반환받은 값을 calculator메서드를 호출해서 파라미터로 넘겨주고 중복제거가 된 값을 return통해 돌려받고 int[]answer에 저장
        
        
        System.out.println("arr : " + Arrays.toString(arr));
        System.out.println("answer : " + Arrays.toString(answer));
        System.out.println("answer의 길이 : " + answer.length);
        System.out.println("중복처리 된 인덱스들의 개수 : " + (arr.length - answer.length));
    }
    
    // 크기가 정해진 배열안에 각 인덱스마다 랜덤 수를 넣어주는 메서드
    static int[] randomArray(int length) { //메인에서 호출받고 파라미터로 100이라는 값을 받았으므로 int length를 선언
        Random r = new Random(); //랜덤숫자를 넣어주기 위한 코드
        int[] temporary = new int[length]; //메인에서 파라미터로 받은 int값 만큼 인덱스마다 숫자를 넣어주기 위해 randomArray메서드에서도 임시 배열을 생성
        for (int i = 0; i < temporary.length; i++) {
        	temporary[i] = r.nextInt(10); //메인에서 정한 배열의 길이만큼 인덱스마다 0부터 9까지의 정수를 넣어줌
        }
        return temporary; //for문이 끝나면 사용자가 중복제거가 되지 않은 값들을 보여주기 위해 randomArray메서드에서 생성한 배열 temporary(뜻: 임시)의 값을 return해줌
    }
    
   // 메인에서 메서드 호출이 되면 메인에서 randomArray();메서드를 통해 arr배열에 저장된 값을 파라미터로 넘겨받음
    static int[] calculator(int[] arr) { 
        List<Integer> list = new ArrayList<>(); 
        //넘겨받은 arr배열의 값을 "중복제거"문제의 조건과 같이 앞뒤 인덱스의 값이 같으면 제거하기 위해, 즉 중복제거를 하기 위한 리스트를 생성
           
        for (int i = 0; i < arr.length; i++) { //배열의 길이만큼 for문을 돌림
            if (i == 0 || arr[i] != arr[i - 1]) {
            // ['i가 0일 때' => 0번 인덱스임을 의미함] 또는 arr의 i번 인덱스와 arr[i - 1], 즉 i번째의 바로 앞 인덱스와 비교를 해서 둘이 같지 않다면
            // 이 두 조건 중 하나라도 만족할 시 중복이 아니라는 의미이므로 리스트에 추가를 해줌
                list.add(arr[i]);
            }
        }
        
        int[] temporary = new int[list.size()]; // 중복제거된 리스트의 길이만큼 temporary 임시배열을 만들어줌
        for (int i = 0; i < list.size(); i++) { //리스트의 길이만큼 for문을 돌림
        	temporary[i] = list.get(i); // 리스트의 i번 인덱스를 가져와서 임시 배열의 i번 인덱스에 값을 담아줌
        	
        	/*
        	 최종적으로 이 메서드에서 리스트를 생성한 이유는 "중복제거"문제에서 [입출력 예]를 보면 중복제거가 되지 않은 초기의 배열과 제거가 된 배열을 보여주고 있는데
        	최초에 10만개의 인덱스가 있는 배열을 만든다했으면 arr배열은 중복여부 관계없이 처음 선언한대로 10만개의 인덱스가 있는 배열을 보여주면 되지만
        	만약 중복제거하지 않은 원본은 사용자에게 보여주지 않고 중복제거를 하고 배열에 값을 넣어준뒤 출력하려고 하면 인덱스는 처음 10만개가 생성이 됐지만
        	담긴 값이 10만개가 아니여서 오류가 날 수 있기 때문에 메인에서 answer이라는 배열을 따로 만들어주고 calculator메서드에서
        	아직 배열의 크기가 정해지지 않았기에 list를 만들어준뒤 중복제거가 되면 list에 추가를 해주고 최종적으로 중복제거가 된 list들의 값을 리스트의 길이만큼
        	배열의 길이가 정해진 임시배열에 담고 그 값을 반환하면 자동적으로 메인에서 answer배열에는 중복제거가 된 값들이 오류 없이 순서에 맞게 입력되게 된다.
        	*/
        }
        
        return temporary;
    }
}