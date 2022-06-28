package viewer;

import java.util.Scanner;

import connector.DBConnector;
import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
	private Scanner sc;
	private UserDTO logIn;
	private DBConnector conn;

	public UserViewer(Scanner sc, DBConnector conn) {
		this.sc = sc;
		this.conn = conn;
	}

	public void showIndex() {
		String message = "1.로그인 2.회원가입 3.종료";

		while (true) {
			int userChoice = ScannerUtil.nextInt(sc, message);

			switch (userChoice) {
			case 1:
				logIn();
				if (logIn != null) {
					showMenu();
				}
			case 2:
				register();
			case 3:
				System.exit(0);
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}
	}

	private void register() {
		UserDTO u = new UserDTO();

		u.setUsername(ScannerUtil.nextLine(sc, "사용하실 아이디를 입력해주세요."));
		u.setPassword(ScannerUtil.nextLine(sc, "사용하실 패스워드를 입력해주세요."));
		u.setNickname(ScannerUtil.nextLine(sc, "사용하실 닉네임을 입력해주세요."));

		UserController con = new UserController(conn);

		while (!con.register(u)) {
			System.out.println("잘못 입력하였습니다.");

			String yesNo = ScannerUtil.nextLine(sc, "새로운 아이디를 입력하시겠습니까? Y/N");

			if (yesNo.equalsIgnoreCase("N")) {

				showIndex();
			}

			u.setUsername(ScannerUtil.nextLine(sc, "사용하실 아이디를 입력해주세요."));
		}
	}

	private void logIn() {
		String username = ScannerUtil.nextLine(sc, "아이디를 입력해주세요. 뒤로 가시려면 x를 입력해주세요.");

		if (username.equalsIgnoreCase("x")) {

			showIndex();
		}

		String password = ScannerUtil.nextLine(sc, "패스워드를 입력해주세요.");

		UserController con = new UserController(conn);

		logIn = con.login(username, password);

		while (logIn == null) {
			System.out.println("잘못 입력하였습니다.");

			username = ScannerUtil.nextLine(sc, "아이디를 입력해주세요. 뒤로가시려면 x를 입력해주세요.");

			if (username.equalsIgnoreCase("x")) {

				showIndex();
			}

			password = ScannerUtil.nextLine(sc, "패스워드를 입력해주세요.");

			logIn = con.login(username, password);
		}
	}

	private void showMenu() {
		while (logIn != null) {
			int userChoice = ScannerUtil.nextInt(sc, "1.게시판 2.회원정보 3.로그아웃");

			switch (userChoice) {
			case 1:
				BoardViewer boardViewer = new BoardViewer(sc, conn, logIn);

				boardViewer.showMenu();
			case 2:
				printOne();
			case 3:
				logIn = null;
				System.out.println("로그아웃되었습니다.");
				showIndex();
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}
	}

	private void printOne() {
		System.out.println("아이디 : " + logIn.getUsername());
		System.out.println("닉네임 : " + logIn.getNickname());

		int userChoice = ScannerUtil.nextInt(sc, "1.회원정보 수정 2.회원탈퇴 3.뒤로가기");

		switch (userChoice) {
		case 1:
			update();
			printOne();
		case 2:
			delete();
			showIndex();
		case 3:
			showMenu();
		default:
			System.out.println("잘못 입력하였습니다.");

			printOne();
		}

	}

	private void delete() {
		String yesNo = ScannerUtil.nextLine(sc, "정말로 탈퇴하시겠습니까? Y/N");

		if (yesNo.equalsIgnoreCase("y")) {
			String password = ScannerUtil.nextLine(sc, "비밀번호를 입력해주세요.");

			UserController con = new UserController(conn);

			if (con.convertToSha(password).equals(logIn.getPassword())) {
				con.delete(logIn.getId());

				logIn = null;
			}
		}
	}

	private void update() {
		String oldPassword = ScannerUtil.nextLine(sc, "기존 비밀번호를 입력해주세요.");
		String newPassword = ScannerUtil.nextLine(sc, "새로운 비밀번호를 입력해주세요.");
		String newNickname = ScannerUtil.nextLine(sc, "새로운 닉네임을 입력해주세요.");

		UserController con = new UserController(conn);

		if (con.convertToSha(oldPassword).equals(logIn.getPassword())) {
			logIn.setPassword(newPassword);
			logIn.setNickname(newNickname);

			con.update(logIn);
		} else {
			System.out.println("비번이 틀렸습니다.");
			update();
		}
	}
}