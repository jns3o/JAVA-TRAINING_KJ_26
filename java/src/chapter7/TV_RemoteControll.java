package chapter7;

import java.util.Scanner;

public class TV_RemoteControll extends RemoteControll {

	
	int channel = 50 ;
	int volume = 10 ;

	@Override
	void powerOn() {
		if (!power) {
			System.out.println("\nTV전원을 켭니다\n");
			System.out.println("현재 채널은 " + channel + " 번 채널입니다.[해당 TV서비스는 1~100번 채널 까지 지원합니다]");
			System.out.println("현재 TV Volume은 " + volume + " 입니다.[볼륨은 0~30까지 설정 가능합니다]\n");
			power = true;
		}else {
			System.out.println("\nTV전원이 이미 켜져 있습니다\n");
			System.out.println("현재 채널은 " + channel + " 번 채널입니다.[해당 TV서비스는 1~100번 채널 까지 지원합니다]");
			System.out.println("현재 TV Volume은 " + volume + " 입니다.[볼륨은 0~30까지 설정 가능합니다]\n");
		}
		}
		void channel(){
		while (true) {	
			System.out.print("다음 채널로 넘어가시려면 '+' , 이전 채널로 넘어가시려면 '-'를 입력해주세요 : ");
			String channelUpDown = sc.nextLine();
			if ("+".equals(channelUpDown)) {
				System.out.println("\n다음 채널로 넘어가는중...");
				channel += 1;
					if (channel > 100) {
						System.out.println("[!]경고, 해당 TV서비스는 100번 채널까지만 지원합니다. 메뉴로 되돌아갑니다");
						channel -= 1;
						return;
					}
					System.out.println(channel + " 번 채널로 설정되었습니다\n");
					return;
				} else if ("-".equals(channelUpDown)) {
					System.out.println("\n이전 채널로 넘어가는중...");
					channel -= 1;
					if (channel < 1) {
						System.out.println("[!]경고, 해당 TV서비스는 100번 채널까지만 지원합니다. 메뉴로 되돌아갑니다.");
						channel -= 1;
						return;
					}
					System.out.println(channel + " 번 채널로 설정되었습니다\n");
					return;
				} else {
					System.out.println("\n[!] 잘못된 입력감지. 메뉴로 돌아갑니다");
					return;
				}
			}
			

		
	}
		void volume() {
			while (true) {
				System.out.println("볼륨을 키우시려면 '+', 볼륨을 줄이시려면 '-'을 입력해주세요 : ");
				String volumeUpDown = sc.nextLine();
				if ("+".equals(volumeUpDown)) {
					System.out.println("\n볼륨을 키우는 중...");
					volume += 1;
						if (volume > 30) {
							System.out.println("[!]경고, 볼륨은 30까지만 설정 가능합니다. 메뉴로 되돌아갑니다");
							channel -= 1;
							return;
						}
						System.out.println(volume + " 볼륨으로 설정되었습니다\n");
						return;
					} else if ("-".equals(volumeUpDown)) {
						System.out.println("\n볼륨을 줄이는 중...");
							volume -= 1;
						if (volume < 0) {
							System.out.println("[!]경고, 볼륨은 0미만으로 설정 할 수 없습니다. 메뉴로 되돌아갑니다.");
							volume -= 1;
							return;
						}
						System.out.println(volume + " 볼륨으로 설정되었습니다\n");
						return;
					} else {
						System.out.println("\n[!] 잘못된 입력감지. 메뉴로 돌아갑니다");
						return;
					}
				}
			}
		}

	

