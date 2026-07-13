package chapter7;

import java.util.Scanner;

public class TV_RemoteControll extends RemoteControll {

	int[] channel = { 50 };
	int[] volume = { 10 };

	@Override
	void powerOn() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\nTV전원을 켭니다\n");
			System.out.println("현재 채널은 " + channel[0] + " 번 채널입니다.");
			System.out.println("현재 TV Volume은 " + volume[0] + " 입니다.\n");
			System.out.print("채널 변경을 하시려면 1번, 볼륨 조절을 하시려면 2번을 입력해주세요 : ");
			String channelVolume = sc.nextLine();
			if ("1".equals(channelVolume)) {
				System.out.println("+ : 다음 채널, - : 이전 채널 | [해당 TV서비스는 1~100번 채널 까지 지원합니다]");
				System.out.print("+/- : ");
				String UpDown = sc.nextLine();
				if ("+".equals(UpDown)) {
					System.out.println("\n다음 채널로 넘어가는중...");
					channel[0] += 1;
					if (channel[0] > 100) {
						System.out.println("[!]경고, 해당 TV서비스는 100번 채널까지만 지원합니다. 메뉴로 되돌아갑니다");
						channel[0] -= 1;
						return;
					}
					System.out.println(channel[0] + " 번 채널로 설정되었습니다\n");
					return;
				} else if ("-".equals(UpDown)) {
					System.out.println("\n이전 채널로 넘어가는중...");
					channel[0] -= 1;
					if (channel[0] < 1) {
						System.out.println("[!]경고, 해당 TV서비스는 100번 채널까지만 지원합니다. 메뉴로 되돌아갑니다.");
						channel[0] -= 1;
						return;
					}
					System.out.println(channel[0] + " 번 채널로 설정되었습니다\n");
					return;
				} else {
					System.out.println("\n[!] 잘못된 입력감지. 메뉴로 돌아갑니다");
					return;
				}
			}
			if ("2".equals(channelVolume)) {
				System.out.println("+ : 볼륨 키우기, - : 볼륨 줄이기 | [해당 TV는 볼륨을 0부터 30까지 지원합니다]");
				System.out.println("+/- : ");
				String UpDown = sc.nextLine();
				if ("+".equals(UpDown)) {
					volume[0] += 1;
					if (volume[0] > 30) {
						System.out.println("[!]경고, TV볼륨은 30을 넘길 수 없습니다. 메뉴로 돌아갑니다.");
						volume[0] -= 1;
						return;
					}
					System.out.println("볼륨 : " + volume[0] + " 으로 조절되었습니다");
					return;
				} else if ("-".equals(UpDown)) {
					volume[0] -= 1;
					if (volume[0] < 0) {
						System.out.println("[!]경고, TV볼륨은 0까지만 설정 가능합니다. 메뉴로 돌아갑니다.");
						volume[0] += 1;
						return;
					}
				} else {
					System.out.println("\n[!]잘못된 입력감지. 메뉴로 돌아갑니다...");
					return;
				}
			}

		}
	}
//
	@Override
	void powerOff() {
		System.out.println("TV전원을 종료합니다...");
		return;
	}
}
