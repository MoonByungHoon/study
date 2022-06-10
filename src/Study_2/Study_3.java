package Study_2;

import java.util.Random;
import java.util.Scanner;

public class Study_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double count = 0;
		int win = 0;
		int lose = 0;
		int draw = 0;

		while (true) {
			Scanner sc = new Scanner(System.in);
			Random ran = new Random();
			
			int pick;

			Message1.mainMessage();

			switch (pick = sc.nextInt()) {
			case 1:
				Message1.gameStart();
				pick = sc.nextInt();
				
				switch (pick = Message1.matchUp(pick, (ran.nextInt(3) + 1))) {
				case 0:
					draw++;
					count++;
					break;
				case 1:
					lose++;
					count++;
					break;
				case 2:
					win++;
					count++;
					break;
				}

				break;
			case 2:
				Message1.winRate(win, lose, draw, ((double)(win / count * 100)));

				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("잘못 선택하셨습니다.");

				break;
			}
		}
	}
}

class Message1 {
	public static void mainMessage() {
		System.out.println("가위 바위 보 게임을 시작합니다.");
		System.out.println("1.시작 2.승률확인 3.종료");
		System.out.print("> ");
	}

	public static void gameStart() {
		System.out.println("1.가위 2.바위 3.보");
		System.out.print("> ");
	}

	public static int matchUp(int pick, int ran) {
		if (pick == ran) {
			System.out.println("무승부!!");

			return 0;

		} else if ((pick == 1 && ran == 2) || (pick == 2 && ran == 3) || (pick == 3 && ran == 1)) {
			System.out.println("패배!!");
			System.out.println(ran);

			return 1;
		} else {
			System.out.println("승리!!");
			System.out.println(ran);

			return 2;
		}
	}

	public static void winRate(int win, int lose, int draw, double winRate) {
		System.out.printf("승리 : %d, 패배 : %d, 무승부 : %d\n 승률 : %.2f\n", win, lose, draw, winRate);
	}
}