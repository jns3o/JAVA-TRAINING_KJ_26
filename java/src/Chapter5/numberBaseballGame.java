package Chapter5;

import java.util.Random;
import java.util.Scanner;

public class numberBaseballGame {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); // 밑에서 모드 선택값 입력 및 숫자 입력을 위해 scanner를 사용
      Random r = new Random(); // 랜덤 숫자 뽑기 위한 셋팅
      // 야구게임 숫자 4개 (아직 중복제거 없음)
      int ran[] = new int[4]; // 4칸짜리 빈 배열

      System.out.println("숫자야구게임입니다");
      System.out.println();
      System.out.println("난이도는 'easy' 'normal' 'hard' 모드가 존재하며(쉬움,보통,어려움[한글로도 입력가능])");
      System.out.println("EASY에서는 20회, NORMAL에서는 10회, HARD에서는 5회의 기회가 주어집니다");
      System.out.println("숫자는 4개를 맞추시되 중복은 없으며 0또한 포함입니다 (숫자는 0부터 9까지 입니다)");
      System.out.println("숫자는 맞지만 위치가 맞지 않을 시 '볼'");
      System.out.println("숫자의 위치가 옳다면 '스트라이크'");
      System.out.println("각각의 볼과 스트라이크는 숫자로 표시되며, 숫자가 볼 /스트라이크 모두 없을 시 '아웃'입니다");
      System.out.println();
      System.out.println("---게임 시작에 앞서 원하는 난이도를 입력해주세요---");

      System.out.print("MODE: ");
      String difficult = sc.next(); // MODE를 입력 받기 위해 입력
      int chance = 0; // easy,normal,hard 별로 기회가 다르기 때문에 int chance를 선언해준다
      boolean moded = true; // boolean은 기본 타입중에서 논리 타입인데 true를 선언하면 switch문 각 case에서 참(true)가 선택됐을 경우 실행되게
      // 해준다
      switch (difficult) { // if나 if - else 문으로 해도 되지만 boolean을 쓰면서 if문보다 코드 길이를 줄이려면 switch가 효과적이어서 선택
      case "easy" , "쉬움":
         System.out.println("easy모드를 선택하셨습니다. (기회 20번)");
         chance = 20; // 추후 숫자 맞추기 실패시 남은 횟수를 보여주기 위해 난이도 별로 chance의 값을 따로 지정해줌(예:쉬움 20회)
         break;
      case "normal" , "보통":
         System.out.println("normal모드를 선택하셨습니다. (기회 10번)");
         chance = 10;
         break;
      case "hard" , "어려움":
         System.out.println("hard모드를 선택하셨습니다. (기회 5번)");
         chance = 5;
         break;
      default:
         System.out.println("올바르지 않은 모드를 입력했습니다. 알맞은 모드를 입력해주세요");
         moded = false;
         return;
      // 처음 boolean은 선언했을때 'boolean moded = true를 참으로 선언하였는데 만약 switch문에서 default까지
      // 내려왔을 경우
      // "MODE: "가 거짓이기에 올바르지 않다는 멘트를 출력 후 소스 코드 실행을 default에서 정지시키기 위해 return 사용
      /*
       * ("return은 논리 타입인 'boolean'을 활용해서 switch문을 썼을 때 거짓값이 나오면 실행했을 때 콘솔에서 어떻게 하면
       * 다음으로 안넘어가고 거기서 멈출 수 궁금해서 인터넷에서 검색하다 찾아서 활용하였습니다")
       */}

      int i = 0;

      while (i < 4) {
         ran[i] = r.nextInt(0, 9);

         System.out.println("ran[" + i + "] : " + ran[i]); 
         //컴퓨터가 자동 생성한 랜덤 숫자를 'Console'에 출력해주는 문장(실제 게임 진행 때 필요시 코드 앞에 주석처리하여 실행)
         
         // 중복이 있는지 없는지 체크
         boolean flag = false;// 중복확인하는 변수다!
         for (int j = 0; j < i; j++) {
            if (ran[i] == ran[j]) {
               // 중복발생
               flag = true;//처음 bolean flag = false;에서는 flag가 거짓이다, 즉 변수가 없다고 해주었는데
               //for문이 반복되다가 if문에서 변수가 발생했을 경우 flag 가 false(거짓)에서 true(참)으로 선언이됨          
               break;
            }
         }

         if (flag) { //만약 flag가 true(참)일 경우 continue가 되면서 위로 되돌아가 다시 랜덤 숫자 생성
            continue;
         } else {
            i++; // 중복이 발생하지 않을 경우 i++를 해서 2번째~3,4번째 칸의 숫자를 생성할 준비를 함
         }

      }

      int strike = 0; // 밑에 랜덤 생성한 칸의 숫자를 입력 받기 전 스트라이크,볼,아웃의 값을 0으로 미리 선언해놓음
      int ball = 0;
      int out = 0;
      System.out.println("-----입력하시고자 하는 숫자를 순서대로 입력해주세요-----");
      int kor[] = new int[4]; //kor[]이라는 랜덤 배열칸을 4칸을 선언하고 그 안에 정수를 입력받을 거기 때문에 int로 선언

//        System.out.println("주어진 모든 기회를 소진하셨습니다. 게임을 다시 실행하여 재시도 해주십시오");
      // for 조건식이 모드 == 이지모드 / strike ==4 / count <=19 >>> chance (단계별 도전횟수가 담긴 변수)
      for (int count = 1; count <= chance; count++) { //초반 chance를 난이도 별로 20,10,5회로 지정해주었는데 
    	 // int count를 1로 선언을 해준다음 i <= chance(20,10,5) 일 때 i++를 하게 해줌
         strike = 0;
         ball = 0;
         
         for (int a = 0; a < 4; a++) {
            System.out.print((a + 1) + ") ");
            kor[a] = sc.nextInt(); //숫자를 입력받기 위해 4개의 입력칸을 생성함
         }
         
         for(int a = 0; a < 4; a++) {
            for(int b = 0; b < 4; b++) {
               if(ran[a]==kor[b] && a == b) {
                  strike++; // 내가 입력한 숫자와 랜덤 생성 숫자가 같고 위치도 둘 다 일치할시 Strike++ 가 되게 해놓음
               }else {
                  if (ran[a]==kor[b] && a != b) {
                     ball++; //strike의 경우는 아니지만 위치가 달라도 숫자는 랜덤 생성한 숫자랑 일치하는게 있을 시
                     // ball이 하나씩 늘어나도록 ball++를 해놓음
                  } 
                  
                  
                  
                  
                  
                  
               }
            }
         }
         if (strike == 0 && ball == 0) {
        	 out = 1; 
        	 /* sttrike와 ball의 조건이 모두 일치하지 않을 시 out이 하나 올라가도록 위에서 코드를 짜보았으나
        	  자꾸 OUT이 12씩 더해지는 현상이 발생해서 out만 따로 이중 for문에서 빼내어서 별도로 작성하였습니다
        	  만약 스트라이크가 0이고 볼도 0이라면 out은 1로 선언이 되게 해놓았습니다
        	 */
        	 System.out.println("0 Strike 0 Ball " + out + " OUT 입니다");
         }else { 
        	 System.out.println(strike + " Strike " + ball + " Ball " + " 0 OUT 입니다");
         }

//           if (kor1 == ran[0]) strike++;
//           else if (kor1 == ran[1] || kor1 == ran[2] || kor1 == ran[3])ball++;
//           else if (kor1 != ran[0] && kor1 != ran[1] && kor1 != ran[2] && kor1 != ran[3])
//              out++;
//           
//           if (kor2 == ran[1]) strike++;
//           else if (kor2 == ran[0] || kor2 == ran[2] || kor2 == ran[3])ball++;
//           else if (kor2 != ran[0] && kor2 != ran[1] && kor2 != ran[2] && kor2 != ran[3])
//              out++;
//           
//           if (kor3 == ran[2]) strike++;
//           else if (kor3 == ran[0] || kor3 == ran[1] || kor3 == ran[3])ball++;
//           else if (kor3 != ran[0] && kor3 != ran[1] && kor3 != ran[2] && kor3 != ran[3])
//              out++;
//           
//           if (kor4 == ran[3]) strike++;
//           else if (kor4 == ran[0] || kor4 == ran[1] || kor4 == ran[2])ball++;
//           else if (kor4 != ran[0] && kor4 != ran[1] && kor4 != ran[2] && kor4 != ran[3])
//              out++;
         //System.out.println(strike + " Strike " + ball + " Ball " + out + " OUT 입니다");

         if (strike == 4 && count == 1) {System.out.println("한 방에 맞추셨습니다! 축하드립니다! (아래는 Ai가 생성한 랜덤 숫자들입니다)");
         System.out.println("1) " + ran[0] + ", 2) " + ran[1] + ", 3) " + ran[2] + ", 4) " + ran[3]);
            // 한방에 맞추었습니다!~
         //한 방에 맞췄을 경우에만 따로 출력이 되도록 별도의 멘트를 작성 후 그 밑에 컴퓨터가 랜덤 생성한 임의의 4자리 숫자를 표시해주고 break;로 마무리
         break;
         } else if (strike == 4) {
            System.out.println("4스트라이크가 되어 승리하셨습니다! 축하드립니다! (아래 숫자들은 Ai가 자동 선택한 랜덤 숫자들입니다)");
            System.out.println("1) " + ran[0] + ", 2) " + ran[1] + ", 3) " + ran[2] + ", 4) " + ran[3]);
            break;

         } else
            System.out.println("틀렸습니다 남은기회는 " + (chance - count) + "번입니다.");

      }

      if (strike != 4) {
         System.out.println("탈락입니다."); //만약 기회를 다 썼을 경우 스트라이크가 4가 아닐 경우 탈락입니다 멘트를 출력
      }

   }
}

