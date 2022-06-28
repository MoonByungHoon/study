package viewer;

import java.util.Scanner;

import connector.DBConnector;
import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
	private Scanner sc;
	private DBConnector conn;

	public UserViewer(Scanner sc, DBConnector conn) {
		this.sc = sc;
		this.conn = conn;
	}

	public void showMenu() {
		String message = "1.로그인 2.회원가입 3.회원탈퇴 4.회원정보수정 5.종료";

		while (true) {
			int userChoice = ScannerUtil.nextInt(sc, message);

			switch (userChoice) {
			case 1:
				login();
			case 2:
				register();
			case 3:
				resign();
			case 4:
				update();
			case 5:
				System.exit(0);
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}
	}

	private void update() {
		UserDTO u = new UserDTO();

		String message = "수정할 아이디를 입력해주세요. 뒤로가기를 원하시면 0을 입력해주세요.";
		u.setUsername(ScannerUtil.nextLine(sc, message));

		if (message == "0") {
			showMenu();
		}

		message = "해당 계정의 패스워드를 입력해주세요.";
		u.setPassword(ScannerUtil.nextLine(sc, message));

		UserController con = new UserController(conn);

		int check = con.updateCheck(u);

		if (check != -1) {

			message = "사용할 패스워드를 입력해주세요.";
			u.setPassword(ScannerUtil.nextLine(sc, message));

			message = "사용할 닉네임을 입력해주세요.";
			u.setNickname(ScannerUtil.nextLine(sc, message));

			con.update(u);

			System.out.println("회원 정보 수정이 완료되었습니다.");
		} else {
			System.out.println("아이디 혹은 패스워드가 틀렸습니다.");

			update();
		}

		showMenu();
	}

	private void resign() {
		UserDTO u = new UserDTO();

		String message = "탈퇴할 아이디를 입력해주세요. 뒤로가기를 원하시면 0을 입력해주세요.";
		u.setUsername(ScannerUtil.nextLine(sc, message));

		if (message == "0") {
			showMenu();
		}

		message = "해당 아이디의 비밀번호를 입력해주세요.";
		u.setPassword(ScannerUtil.nextLine(sc, message));

		UserController con = new UserController(conn);

		if (con.delete(u)) {
			System.out.println("회원탈퇴가 정상적으로 처리되었습니다.");
			System.out.println("이용해주셔서 감사합니다.");
		} else {
			System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");

			resign();
		}

		showMenu();
	}

	private void register() {
		UserDTO u = new UserDTO();

		String message = "가입할 아이디를 입력해주세요. 뒤로가기를 원하시면 0을 입력해주세요.";
		u.setUsername(ScannerUtil.nextLine(sc, message));

		UserController uc = new UserController(conn);

		if (uc.userCheck(u, 1) == null) {
			System.out.println("이미 사용중인 아이디입니다.");

			register();
		}

		if (u.getUsername() == "0") {
			showMenu();
		}

		message = "사용하실 패스워드를 입력해주세요.";
		u.setPassword(ScannerUtil.nextLine(sc, message));

		message = "사용하실 닉네임을 입력해주세요.";
		u.setNickname(ScannerUtil.nextLine(sc, message));

		UserController con = new UserController(conn);

		con.insert(u);

		System.out.println("회원가입이 완료되었습니다.");

		showMenu();
	}

	private void login() {
		UserDTO u = new UserDTO();

		String message = "로그인할 아이디를 입력해주세요. 뒤로가기를 원하시면 0을 입력해주세요.";
		u.setUsername(ScannerUtil.nextLine(sc, message));

		if (message == "0") {
			showMenu();
		}

		message = "패스워드를 입력해주세요.";
		u.setPassword(ScannerUtil.nextLine(sc, message));

		UserController con = new UserController(conn);

		u = con.login(u);

		if (u != null) {
			System.out.println("로그인에 성공하였습니다.");
		} else {
			System.out.println("아이디 혹은 패스워드가 틀렸습니다.");

			login();
		}

		BoardViewer bv = new BoardViewer(sc, conn, u.getId());

		bv.showBoardMenu();
	}
}
