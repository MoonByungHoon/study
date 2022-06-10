package Study_2;

import java.util.Random;
import java.util.Scanner;

public class Study4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Message2 game = new Message2();	
		
		while(true) {
			Random ran = new Random();
			
			int pick;
			
			game.putMainMessage();
			
			switch (pick = sc.nextInt()) {
			case 1:
				game.gameStart(ran.nextInt(100) + 1);
				game.round(pick = sc.nextInt());
				
				break;
			case 2:
				game.putCount();
				
				break;
			case 3:
				System.exit(0);
				
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
				
				break;
			}
		}
	}
}

class Message2 {
	int count, ran;
	public void putMainMessage() {
		System.out.println("메뉴를 선택해주세요.");
		System.out.println("1.시작 2.최고기록 3.종료");
	}
	
	public void putCount() {
		System.out.println();
		System.out.printf("최고 기록 : %d\n", count);
		System.out.println();
	}
	
	public void gameStart(int ran) {
		this.ran = ran;
		
		System.out.println("업다운 게임을 시작합니다.");
		System.out.println("게임의 규칙을 설명드리겠습니다.");
		System.out.println("1~100사이의 랜덤한 값이 주어지고");
		System.out.println("해당 값이 몇일지 생각하며 입력하면 주어진 값보다");
		System.out.println("작다면 다운 크다면 업을 알려줍니다.");
		System.out.println("행운을 빕니다.");
		System.out.println();
		System.out.println("숫자를 입력해주세요.");
		System.out.print("> ");
	}
	
	public void round(int pick) {
		Scanner sc = new Scanner(System.in);
		
		while(!(pick >= 1 && pick <= 100)) {	
			pick = sc.nextInt();
		}
		
		while(true) {
			if(pick > ran) {
				System.out.println("다운 입니다.");
				count++;
			} else if (pick < ran) {
				System.out.println("업 입니다.");
				count++;
			} else {
				System.out.println("정답입니다.");
				count++;
				break;
			}
			pick = sc.nextInt();
		}
	}
}