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
      System.out.println("난이도는 'easy' 'normal' 'hard' 모드가 존재하며");
      System.out.println("EASY에서는 20회, NORMAL에서는 10회, HARD에서는 5회의 기회가 주어집니다");
      System.out.println("숫자는 4개를 맞추시되 중복은 없으며 0또한 포함입니다");
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
      case "easy":
         System.out.println("easy모드를 선택하셨습니다. (기회 20번)");
         chance = 20;
         break;
      case "normal":
         System.out.println("normal모드를 선택하셨습니다. (기회 10번)");
         chance = 10;
         break;
      case "hard":
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

        System.out.println("ran[" + i + "] : " + ran[i]); // 컴퓨터가 자동 생성한 랜덤 숫자를 코멘트해주는 문장
         // 중복이 있는지 없는지 체크
         boolean flag = false;// 중복확인하는 변수다!
         for (int j = 0; j < i; j++) {
            if (ran[i] == ran[j]) {
               // 중복발생
               flag = true;
               break;
            }
         }//주석 테스트

         if (flag) {
            continue;
         } else {
            i++;
         }

      }

      int strike = 0; //스트라이크와 볼, 아웃을 카운팅하기 위해 스트라이크,볼,아웃을 int형으로 해서 0으로 선언
      int ball = 0;
      int out = 0;
      System.out.println("-----입력하시고자 하는 숫자를 순서대로 입력해주세요-----");
      int kor[] = new int[4];

//        System.out.println("주어진 모든 기회를 소진하셨습니다. 게임을 다시 실행하여 재시도 해주십시오");
      // for 조건식이 모드 == 이지모드 / strike ==4 / count <=19 >>> chance (단계별 도전횟수가 담긴 변수)
      for (int count = 1; count <= chance; count++) {
         strike = 0;
         ball = 0;
         
         for (int a = 0; a < 4; a++) {
            System.out.print((a + 1) + ") ");
            kor[a] = sc.nextInt();
         }
         
         for(int a = 0; a < 4; a++) {
            for(int b = 0; b < 4; b++) {
               if(ran[a]==kor[b] && a == b) {
                  strike++;
               }else {
                  if (ran[a]==kor[b] && a != b) {
                     ball++;
                  } 
                  
                  if (strike == 0 && ball == 0) {
                	  out = 1;
                  }
                  
                  
                  
                  
               }
            }
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
         System.out.println(strike + " Strike " + ball + " Ball " + out + " OUT 입니다");

         if (strike == 4 && count == 1) {System.out.println("한 방에 맞추셨습니다! 축하드립니다! (아래는 Ai가 생성한 랜덤 숫자들입니다)");
         System.out.println("1) " + ran[0] + ", 2) " + ran[1] + ", 3) " + ran[2] + ", 4) " + ran[3]);
            // 한방에 맞추었습니다!~
         break;
         } else if (strike == 4) {
            System.out.println("4스트라이크가 되어 승리하셨습니다! 축하드립니다! (아래 숫자들은 Ai가 자동 선택한 랜덤 숫자들입니다)");
            System.out.println("1) " + ran[0] + ", 2) " + ran[1] + ", 3) " + ran[2] + ", 4) " + ran[3]);
            break;

         } else
            System.out.println("틀렸습니다 남은기회는 " + (chance - count) + "번입니다.");

      }

      if (strike != 4) {
         System.out.println("탈락입니다.");
      }

   }
}

