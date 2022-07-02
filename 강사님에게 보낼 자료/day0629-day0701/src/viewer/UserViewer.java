package viewer;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import connector.DBConnector;
import controller.UserController;
import model.SubjectDTO;
import model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
	private Scanner sc;
	private Connection conn;
	private UserDTO login;

	public UserViewer(Scanner sc, DBConnector conn) {
		this.sc = sc;
		this.conn = conn.makeConnection();
	}

	public UserViewer(Scanner sc, Connection conn, UserDTO login) {
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
				UserViewerSub.systemDown(sc, login);
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}

//	메뉴 메소드
	public void showMenu() {
		while (true) {
			int userChoice = ScannerUtil.nextInt(sc, "1.강의메뉴 2.계정정보 3.로그아웃 4.관리자메뉴 5.강사메뉴 6.종료");

			if (userChoice == 1) {
//				강의메뉴
				if (login.getRank() == 1) {
					SubjectViewer subV = new SubjectViewer(sc, conn, login);

					subV.showMenu();
				} else {
					System.out.println("학생만 접근이 가능합니다.");
				}

				showMenu();
			} else if (userChoice == 2) {
//				계정정보
				printOne();
			} else if (userChoice == 3) {
//			로그아웃
				login = null;
				showIndex();
			} else if (userChoice == 4) {
//				관리자메뉴
				if (login.getRank() == 3) {
					staffMenu();
					showMenu();
				} else {
					System.out.println("관리자만 이용이 가능합니다.");

					showMenu();
				}
			} else if (userChoice == 5) {
//				강사메뉴
				if (login.getRank() == 2) {
					teacherMenu();
					showMenu();
				} else {
					System.out.println("강사만 이용이 가능합니다.");

					showMenu();
				}
			} else if (userChoice == 6) {
				UserViewerSub.systemDown(sc, login);
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}

	private void teacherMenu() {
		// 미정 1.수강생목록 2.로그아웃 3.종료
		int userChoice = ScannerUtil.nextInt(sc, "1.수강생확인 2.뒤로가기 3.로그아웃 4.종료");

		if (userChoice == 1) {
			SubjectViewer subV = new SubjectViewer(sc, conn, login);
			while (userChoice != 0) {
				ArrayList<SubjectDTO> sub = subV.studentAll();

				if (sub == null) {
					System.out.println("수업중인 강의가 없습니다.");

					teacherMenu();
				}

				ScoreViewer scoreV = new ScoreViewer(sc, conn);

				userChoice = scoreV.inputStudentScore();
			}
		} else if (userChoice == 2)

		{
			showMenu();
		} else if (userChoice == 3) {
			login = null;
			showIndex();
		} else if (userChoice == 4) {
			UserViewerSub.systemDown(sc, login);
		} else {
			System.out.println("잘못 입력하였습니다.");
			teacherMenu();
		}
	}

	public void staffMenu() {
		int userChoice = ScannerUtil.nextInt(sc, "1.계정등급변경 2.강의업무 3.기타업무 4.뒤로가기 5.종료");

		if (userChoice == 1) {
			updateUserRank();
			staffMenu();
		} else if (userChoice == 2) {
			SubjectViewer subV = new SubjectViewer(sc, conn, login);

			subV.setSubject();
			staffMenu();
		} else if (userChoice == 3) {
			setEtc();
			staffMenu();
		} else if (userChoice == 4) {
			showMenu();
		} else if (userChoice == 5) {
			UserViewerSub.systemDown(sc, login);
		} else {
			System.out.println("잘못 입력하였습니다.");

			staffMenu();
		}
	}

	private void updateUserRank() {
		String id = ScannerUtil.nextLine(sc, "변경할 아이디를 입력해주세요.");
		String name = (ScannerUtil.nextLine(sc, "계정 가입자 이름을 입력해주세요."));
		int rank = (ScannerUtil.nextInt(sc, "변경할 등급을 입력해주세요.\n 1.학생 2.강사 3.관리자"));

		UserController userCon = new UserController(conn);

		if (userCon.userCheck(id, name)) {
			userCon.updateUserRank(id, name, rank);

			System.out.println("등급 변경이 정상적으로 완료되었습니다.");
		} else {
			System.out.println("등급 변경에 실패하였습니다.");
			System.out.println("가입자 정보를 확인 후 다시 시도해주세요.");
		}
	}

	private void setEtc() {
		System.out.println("마땅히 넣을게 없어서 넣어본 옵션.");
	}

	// 계정 정보 출력
	private void printOne() {
		System.out.printf("아이디 : %s | 등급 : %s\n", login.getLoginId(), login.getRating(login.getRank()));
		System.out.printf("이름 : %s | 나이 : %d\n", login.getName(), login.getAge());
		System.out.printf("등록일 : %s\n", login.getJoinDate());

		if (login.getRank() == 1) {
			printOneUserMenu();
		} else {
			printOneMenu();
		}
	}

	private void printOneMenu() {
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
			UserViewerSub.systemDown(sc, login);
		} else {
			System.out.println("잘못 입력하였습니다.");

			printOne();
		}
	}

	private void printOneUserMenu() {
		int userChoice = ScannerUtil.nextInt(sc, "1.패스워드변경 2.수강목록 3.점수확인 4.계정탈퇴 5.뒤로가기 6.종료");
//		1.패스워드변경 2.수강목록 3.점수확인 4.계정탈퇴 5.뒤로가기 6.종료
		if (userChoice == 1) {
//			패스워드변경
			update();
			printOne();
		} else if (userChoice == 2) {
//			수강목록
			SubjectViewer subV = new SubjectViewer(sc, conn, login);

			subV.studentSubjectList();

			String choice = ScannerUtil.nextLine(sc, "수강 취소 메뉴로 이동하시겠습니까? (Y/N)");

			if (choice.equalsIgnoreCase("y")) {
				subV.cancelSubjectList();
			} else {
				printOne();
			}
		} else if (userChoice == 3) {
//			점수확인
			ScoreViewer scoreV = new ScoreViewer(sc, conn);

			scoreV.getOneStudentScore(login.getId());
			printOneUserMenu();
		} else if (userChoice == 4) {
//			계정탈퇴
			delete();

			if (login == null) {
				showIndex();
			} else {
				printOne();
			}

		} else if (userChoice == 5) {
//			뒤로가기
			showMenu();
		} else if (userChoice == 6) {
//			종료
			UserViewerSub.systemDown(sc, login);
		} else {
			System.out.println("잘못 입력하였습니다.");

			printOne();
		}
	}

	// 계정 수정
	private void update() {
		String oldPassword = ScannerUtil.nextLine(sc, "기존 패스워드를 입력해주세요.");
		String newPassword = ScannerUtil.nextLine(sc, "새로운 패스워드를 입력해주세요.");

		UserController userCon = new UserController(conn);

		if (login.getPassword().equals(userCon.convertTosha(oldPassword))) {
			login.setPassword(newPassword);

			userCon.update(login);

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

			UserController userCon = new UserController(conn);

			if (userCon.convertTosha(password).equals(login.getPassword())) {
				userCon.delete(login.getId());

				login = null;
			}
		}
	}

	// 로그인 메소드
	private void login() {
		UserViewerSub input = new UserViewerSub(sc);
		String loginId = input.loginIdInput();

		if (loginId.equalsIgnoreCase("x")) {

			showIndex();
		}

		String password = input.loginPasswordInput();

		UserController userCon = new UserController(conn);

		login = userCon.login(loginId, password);

		while (login == null) {
			System.out.println("아이디나 패스워드가 잘못되었습니다.");

			login();
		}
	}

//	회원가입 메소드
	private void register() {
		UserDTO u = new UserDTO();
		UserViewerSub input = new UserViewerSub(sc);

//	아이디 입력
		u.setLoginId(input.registerIdInput());
//	뒤로가기인 x 입력일 경우
		if (u.getLoginId().equalsIgnoreCase("x")) {
			showIndex();
		}

		UserController userCon = new UserController(conn);

//	아이디 중복 체크
		while (userCon.idCheck(u.getLoginId())) {
			System.out.println("사용할 수 없는 아이디입니다. 다시 입력해주세요.");

			u.setLoginId(input.registerIdInput());
		}

//	패스워드 입력
		u.setPassword(input.registerPasswordInput());

//	이름 입력
		u.setName(input.registerNameInput());

//	나이 입력
		u.setAge(input.registerAgeInput());
		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());
		u.setJoinDate(date);

//	DB에 데이터 전송
		userCon.register(u);

		System.out.println("회원가입이 완료되었습니다.");
	}
}