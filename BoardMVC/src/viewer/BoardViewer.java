package viewer;

import java.util.Scanner;

import connector.DBConnector;
import main.Main;
import util.ScannerUtil;

public class BoardViewer {
	private Scanner sc;
	private DBConnector conn;
	private int writerId;

	public BoardViewer(Scanner sc, DBConnector conn, int writerId) {
		this.sc = sc;
		this.conn = conn;
		this.writerId = writerId;
	}

	public void showBoardMenu() {
		String message = "1.글 작성 2.글 목록 3. 로그아웃 4. 종료";

		while (true) {
			int userChoice = ScannerUtil.nextInt(sc, message);

			switch (userChoice) {
			case 1:
				writer();
			case 2:
				writerList();
			case 3:
				logout();
			case 4:
				System.exit(0);
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}

	}

	private void logout() {
		Main.main(null);
	}

	private void writerList() {
 
	}

	private void writer() {

	}

}
