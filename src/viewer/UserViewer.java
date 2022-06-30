package viewer;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

import connector.DBConnector;
import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
	private Scanner sc;
	private DBConnector conn;
	private UserDTO login;

	public UserViewer(Scanner sc, DBConnector conn) {
		this.sc = sc;
		this.conn = conn;
	}

	public UserViewer(Scanner sc, DBConnector conn, UserDTO login) {
		this.sc = sc;
		this.conn = conn;
		this.login = login;
	}

	public void showIndex() {
		while (true) {
			int userChoice = ScannerUtil.nextInt(sc, "1.로그인 2.회원가입 3.종료");

			if (userChoice == 1) {
				login();
				showMenu();
			} else if (userChoice == 2) {
				register();
				showIndex();
			} else if (userChoice == 3) {
				sc.close();
				System.exit(0);
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}

//	메뉴 메소드
	private void showMenu() {
		while (true) {
			int userChoice = ScannerUtil.nextInt(sc, "1.강의목록 2.계정정보 3.로그아웃 4.관리자메뉴 5.종료");

			if (userChoice == 1) {
				if (login.getRank() == 1) {
					LessonViewer classviewer = new LessonViewer(sc, conn, login);

					classviewer.showMenu();
				} else {
					System.out.println("학생만 접근이 가능합니다.");
				}

				showMenu();
			} else if (userChoice == 2) {
				printOne();
			} else if (userChoice == 3) {
				login = null;
				showIndex();
			} else if (userChoice == 4) {
				if (login.getRank() == 3) {
					staffMenu();
					showMenu();
				} else {
					System.out.println("관리자만 이용이 가능합니다.");

					showMenu();
				}
			} else if (userChoice == 5) {
				login = null;
				sc.close();
				System.exit(0);
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}

	private void staffMenu() {
		int userChoice = ScannerUtil.nextInt(sc, "1.계정등급변경 2.강의업무 3.기타업무 4.뒤로가기 5.종료");

		if (userChoice == 1) {
			updateUserRank();
			staffMenu();
		} else if (userChoice == 2) {
			setLesson();
			staffMenu();
		} else if (userChoice == 3) {
			setEtc();
			staffMenu();
		} else if (userChoice == 4) {
			showMenu();
		} else if (userChoice == 5) {
			login = null;
			sc.close();
			System.exit(0);
		} else {
			System.out.println("잘못 입력하였습니다.");

			staffMenu();
		}
	}

	private void updateUserRank() {
		UserDTO u = new UserDTO();

		u.setLoginId(ScannerUtil.nextLine(sc, "변경할 아이디를 입력해주세요."));
		u.setName(ScannerUtil.nextLine(sc, "해당 계정의 사용자를 입력해주세요."));
		u.setRank(ScannerUtil.nextInt(sc, "변경할 등급을 입력해주세요."));

		UserController ucon = new UserController(conn);

		ucon.updateUserRank(u);
	}

	private void setEtc() {
		System.out.println("마땅히 넣을게 없어서 넣어본 옵션.");
	}

	private void setLesson() {
		int userChoice = ScannerUtil.nextInt(sc, "1.강의개설 2.강의목록보기 3.뒤로가기 4.종료");
		LessonViewer lessonViewer = new LessonViewer(sc, conn, login);

		if (userChoice == 1) {
			lessonViewer.insertLesson();
			setLesson();
		} else if (userChoice == 2) {
			lessonViewer.selectAll();
			setLesson();
		} else if (userChoice == 3) {
			staffMenu();
		} else if (userChoice == 4) {
			login = null;
			sc.close();
			System.exit(0);
		} else {
			System.out.println("잘못 입력하였습니다.");

			setLesson();
		}
	}

	// 계정 정보 출력
	private void printOne() {
		System.out.printf("아이디 : %s 등급 : %s\n", login.getLoginId(), login.getrating(login.getRank()));
		System.out.printf("이름 : %s 나이 : %d\n", login.getName(), login.getAge());
		System.out.printf("등록일 : %s\n", login.getJoinDate());

		int userChoice = ScannerUtil.nextInt(sc, "1.패스워드변경 2.계정탈퇴 3.뒤로가기 4.종료");

		if (userChoice == 1) {
			update();
			printOne();
		} else if (userChoice == 2) {
			delete();
			if (login == null) {
				showIndex();
			} else {
				printOne();
			}
		} else if (userChoice == 3) {
			showMenu();
		} else if (userChoice == 4) {
			login = null;
			sc.close();
			System.exit(0);
		} else {
			System.out.println("잘못 입력하였습니다.");

			printOne();
		}

	}

//	계정 수정
	private void update() {
		String oldPassword = ScannerUtil.nextLine(sc, "기존 패스워드를 입력해주세요.");
		String newPassword = ScannerUtil.nextLine(sc, "새로운 패스워드를 입력해주세요.");

		UserController ucon = new UserController(conn);

		if (login.getPassword().equals(ucon.convertTosha(oldPassword))) {
			login.setPassword(newPassword);

			ucon.update(login);

			System.out.println("패스워드 변경이 완료되었습니다.");
		} else {
			System.out.println("패스워드가 틀렸습니다.");

			update();
		}
	}

//	계정 삭제
	private void delete() {
		String yesNo = ScannerUtil.nextLine(sc, "정말로 삭제하시겠습니까? Y/N");

		if (yesNo.equalsIgnoreCase("y")) {
			String password = ScannerUtil.nextLine(sc, "패스워드를 입력해주세요");

			UserController ucon = new UserController(conn);

			if (ucon.convertTosha(password).equals(login.getPassword())) {
				ucon.delete(login.getId());

				login = null;
			}
		}
	}

	// 로그인 메소드
	private void login() {
		String loginId = loginIdInput();

		if (loginId.equalsIgnoreCase("x")) {

			showIndex();
		}

		String password = loginPassword();

		UserController ucon = new UserController(conn);

		login = ucon.login(loginId, password);

		while (login == null) {
			System.out.println("아이디나 패스워드가 잘못되었습니다.");

			login();
		}
	}

	private String loginPassword() {
		String password = ScannerUtil.nextLine(sc, "해당 계정의 패스워드를 입력해주세요.");

		while (password == "") {
			System.out.println("잘못 입력하였습니다.");

			password = ScannerUtil.nextLine(sc, "해당 계정의 패스워드를 입력해주세요.");
		}

		return password;
	}

//	회원가입 메소드
	private void register() {
		UserDTO u = new UserDTO();

//	아이디 입력
		u.setLoginId(registerIdInput());
//	뒤로가기인 x 입력일 경우
		if (u.getLoginId().equalsIgnoreCase("x")) {
			showIndex();
		}

		UserController ucon = new UserController(conn);

//	아이디 중복 체크
		while (ucon.idCheck(u.getLoginId())) {
			System.out.println("사용할 수 없는 아이디입니다. 다시 입력해주세요.");

			u.setLoginId(registerIdInput());
		}

//	패스워드 입력
		u.setPassword(registerPasswordInput());

//	이름 입력
		u.setName(registerNameInput());

//	나이 입력
		u.setAge(registerAgeInput());

		Calendar cal = Calendar.getInstance();

		Date date = new Date(cal.getTimeInMillis());

		u.setJoinDate(date);

//	DB에 데이터 전송
		ucon.register(u);

		System.out.println("회원가입이 완료되었습니다.");
	}

	// 로그인 아이디 입력 메소드
	private String loginIdInput() {
		String loginId = ScannerUtil.nextLine(sc, "아이디를 입력해주세요. 뒤로가시려면 x를 입력해주세요.");

		while (loginId == "") {
			System.out.println("잘못 입력하였습니다.");

			loginId = ScannerUtil.nextLine(sc, "아이디를 입력해주세요. 뒤로가시려면 x를 입력해주세요.");
		}

		return loginId;
	}

//	나이 입력 메소드
	private int registerAgeInput() {
		int age = ScannerUtil.nextInt(sc, "나이를 입력해주세요.");

//	나이 설정 범위 체크
		while (age <= 0) {
			System.out.println("잘못 입력하였습니다.");

			age = ScannerUtil.nextInt(sc, "나이를 입력해주세요.");
		}

		return age;
	}

//	이름 입력 메소드
	private String registerNameInput() {
		String name = ScannerUtil.nextLine(sc, "성함을 입력해주세요.");

//	이름 널 체크
		while (name == null) {
			System.out.println("잘못 입력하였습니다.");

			name = ScannerUtil.nextLine(sc, "성함을 입력해주세요.");
		}

		return name;
	}

//	패스워드 체크 메소드
	private String registerPasswordInput() {
		String password1 = ScannerUtil.nextLine(sc, "사용할 패스워드를 입력해주세요.");

//	패스워드 널 체크
		while (password1 == "") {
			System.out.println("잘못 입력하였습니다.");

			password1 = ScannerUtil.nextLine(sc, "사용할 패스워드를 입력해주세요.");
		}

//	패스워드 재차 입력 및 널 체크
		String password2 = ScannerUtil.nextLine(sc, "패스워드를 한번 더 입력해주세요.");

		while (password2 == "") {
			System.out.println("잘못 입력하였습니다.");

			password2 = ScannerUtil.nextLine(sc, "패스워드를 한번 더 입력해주세요.");
		}

//	패스워드가 일치하지 않을 경우 재입력
		while (!password1.equals(password2)) {
			System.out.println("패스워드가 일치하지 않습니다.");

			password1 = ScannerUtil.nextLine(sc, "사용할 패스워드를 입력해주세요.");

			while (password1 == "") {
				System.out.println("잘못 입력하였습니다.");

				password1 = ScannerUtil.nextLine(sc, "사용할 패스워드를 입력해주세요.");
			}

			password2 = ScannerUtil.nextLine(sc, "패스워드를 한번 더 입력해주세요.");

			while (password2 == "") {
				System.out.println("잘못 입력하였습니다.");

				password2 = ScannerUtil.nextLine(sc, "패스워드를 한번 더 입력해주세요.");
			}
		}

		return password1;
	}

//	아이디 입력 메소드
	private String registerIdInput() {
		String loginId = ScannerUtil.nextLine(sc, "사용할 아이디를 입력해주세요. 뒤로가려면 x를 입력해주세요.");

//	아이디 널 체크
		while (loginId == "") {
			System.out.println("잘못 입력하였습니다.");

			loginId = ScannerUtil.nextLine(sc, "사용할 아이디를 입력해주세요.");
		}

		return loginId;
	}
}