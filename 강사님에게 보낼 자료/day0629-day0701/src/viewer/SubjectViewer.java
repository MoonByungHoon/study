package viewer;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import controller.SubjectController;
import controller.ScoreController;
import controller.UserController;
import model.SubjectDTO;
import model.ScoreDTO;
import model.UserDTO;
import util.ScannerUtil;

public class SubjectViewer {
	private Scanner sc;
	private Connection conn;
	private UserDTO login;

	public SubjectViewer(Scanner sc, Connection conn, UserDTO login) {
		this.sc = sc;
		this.conn = conn;
		this.login = login;
	}

//	강의 메인 메뉴
	public void showMenu() {
		int userChoice = ScannerUtil.nextInt(sc, "1.수강신청 2.수강신청취소 3.뒤로가기 4.종료");

		if (userChoice == 1) {
			selectAll();
			showMenu();
		} else if (userChoice == 2) {
			studentSubjectList();
			cancelSubjectList();
		} else if (userChoice == 3) {
			UserViewer uv = new UserViewer(sc, conn, login);

			uv.showMenu();
		} else if (userChoice == 4) {
			UserViewerSub.systemDown(sc, login);
		} else {
			System.out.println("잘못 입력하였습니다.");
		}
	}

//	학생 수강 취소
	public void cancelSubjectList() {
		int userChoice = ScannerUtil.nextInt(sc, "신청 취소할 강의를 선택해주세요");

		ScoreController scoreCon = new ScoreController(conn);

		if (scoreCon.cancelSubject(userChoice, login.getId())) {
			System.out.println("수강 신청 취소가 완료되었습니다.");
		} else {
			System.out.println("수강 신청 취소가 실패하였습니다.");
			System.out.println("다시 확인 후 시도해주세요.");

			showMenu();
		}

	}

// 학생 강의 리스트
	public void studentSubjectList() {
		ScoreController scoreCon = new ScoreController(conn);
		SubjectController subCon = new SubjectController(conn);
		ArrayList<ScoreDTO> scoreList = scoreCon.myScoreList(login.getId());
		ArrayList<SubjectDTO> subList = subCon.mySubjectList(scoreList);

		printList(subList, 1);
	}

//	관리자 권한 강의 삭제
	public void deleteSubject() {
// 미완 selectAll()

	}

//	수강에 대한 메인 메뉴
	public void printList(ArrayList<SubjectDTO> list, int menuNum) {

		ScoreController scoreCon = new ScoreController(conn);
		String check;

		for (SubjectDTO s : list) {
			check = scoreCon.joinCheck(s.getId(), login.getId());

			printOne(s, check);

		}

		if (login.getRank() == 1 && menuNum == 2) {
			check = ScannerUtil.nextLine(sc, "수강 신청 가능한 리스트만 보시겠습니까? (Y/N)");

			if (check.equalsIgnoreCase("Y")) {
				for (SubjectDTO s : list) {
					check = scoreCon.joinCheck(s.getId(), login.getId());
					if (check.equalsIgnoreCase("미신청")) {
						printOne(s, check);
					}
				}
			}
		}
	}

//	한과목만 출력
	private void printOne(SubjectDTO s, String check) {
		UserController userCon = new UserController(conn);

		System.out.println("======================================");
		System.out.printf("%d. 과목명 : %s 담당강사 : %s\n", s.getId(), s.getName(), userCon.getteacherName(s.getTeacherId()));
		System.out.printf("개강일 : %s 종강일 : %s\n", s.getFirstDay(), s.getFinishDay());
		System.out.println("--------------------------------------");
		System.out.printf("강의 정보\n %s\n", s.getSubjectInfo());
		System.out.println("--------------------------------------");
		System.out.printf("신청 여부: %s\n", check);
		System.out.println("======================================");
	}

	// 관리자 메뉴
	public void setSubject() {
		int userChoice = ScannerUtil.nextInt(sc, "1.강의개설 2.강의목록보기 3.뒤로가기 4.종료");

		if (userChoice == 1) {
			insertSubject();
			setSubject();
		} else if (userChoice == 2) {
			selectAll();
			setSubject();
		} else if (userChoice == 3) {
//			UserViewer userV = new UserViewer(sc, conn, login);
//			
//			userV.staffMenu();
		} else if (userChoice == 4) {
			UserViewerSub.systemDown(sc, login);
		} else {
			System.out.println("잘못 입력하였습니다.");

			setSubject();
		}
	}

//	강의 전체 출력
	public void selectAll() {
		SubjectController subCon = new SubjectController(conn);
		ArrayList<SubjectDTO> list = subCon.selectAll();

		if (list == null) {
			System.out.println("등록된 강의가 없습니다.");

			showMenu();
		}

		printList(list, 2);

//		학생 메뉴
		if (login.getRank() == 1) {
			registerSubject();
		}

//		관리자 메뉴
		if (login.getRank() == 3) {
			int userChoice = ScannerUtil.nextInt(sc, "1.강의수정 2.폐강 3.뒤로가기 4.종료");

			if (userChoice == 1) {
				updateSubject();
			} else if (userChoice == 2) {
				deleteSubject();
			} else if (userChoice == 3) {
				setSubject();
			} else if (userChoice == 4) {
				UserViewerSub.systemDown(sc, login);
			} else {
				System.out.println("잘못 입력하였습니다.");

				selectAll();
			}
		}
	}

//	관리자 권한 강의 수정
	private void updateSubject() {
		// 미완

	}

//	관리자 권한 강의 등록
	public void insertSubject() {
		SubjectDTO s = new SubjectDTO();

		s.setName(ScannerUtil.nextLine(sc, "과목명을 입력해주세요."));

		int year = ScannerUtil.nextInt(sc, "개강 년도를 입력해주세요.");
		int month = ScannerUtil.nextInt(sc, "개강 월을 입력해주세요.");
		int day = ScannerUtil.nextInt(sc, "개강 일을 입력해주세요.");

		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		Date d = new Date(cal.getTimeInMillis());
		s.setFirstDay(d);

		year = ScannerUtil.nextInt(sc, "종강 년도를 입력해주세요.");
		month = ScannerUtil.nextInt(sc, "종강 월을 입력해주세요.");
		day = ScannerUtil.nextInt(sc, "종강 일을 입력해주세요.");

		cal.set(year, month, day);
		d = new Date(cal.getTimeInMillis());
		s.setFinishDay(d);

		UserController userCon = new UserController(conn);

		ArrayList<UserDTO> list = userCon.teacherList();

		if (list.isEmpty()) {
			System.out.println("강의가 가능한 강사가 없습니다.");

			setSubject();
		}

		for (UserDTO u : list) {
			System.out.println("-----------------------------------------");
			if (u.isJoinlesson()) {
				System.out.printf("%d. 이름 : %s\n", u.getId(), u.getName());
			}
		}
		System.out.println("-----------------------------------------");

		s.setTeacherId(ScannerUtil.nextInt(sc, "강사번호를 입력해주세요."));
		s.setSubjectInfo(ScannerUtil.nextLine(sc, "강의에 대한 정보를 입력해주세요."));

		SubjectController subCon = new SubjectController(conn);

		subCon.registerSubject(s);

		userCon.teacherLessonUpdate(s.getTeacherId());

		System.out.println("강의 등록이 성공적으로 완료되었습니다.");
	}

//	학생 수강 신청
	public void registerSubject() {
		SubjectController subCon = new SubjectController(conn);

		while (true) {
			int userChoice = ScannerUtil.nextInt(sc, "신청할 수강 넘버를 입력해주세요. 뒤로가려면 0을 입력해주세요.");

			if (userChoice != 0 && subCon.registerSubjectScore(login.getId(), userChoice)) {
				System.out.println("수강 신청이 정상적으로 완료 되었습니다.");

				selectAll();
			} else if (userChoice == 0) {
				showMenu();
			} else {
				System.out.println("수강신청에 실패하였습니다.");
			}
		}
	}

	public ArrayList<SubjectDTO> studentAll() {
		ScoreController scoreCon = new ScoreController(conn);
		UserController userCon = new UserController(conn);
		SubjectController subCon = new SubjectController(conn);

		ArrayList<SubjectDTO> subList = subCon.myLessonAll(login.getId());

		if (subList != null) {
			ArrayList<ScoreDTO> scoreList = scoreCon.myLessonStudentAll(subList);
			ArrayList<UserDTO> userList = userCon.myLessonStudentAll(scoreList);

			for (SubjectDTO sub : subList) {
				for (UserDTO user : userList) {
					for (ScoreDTO score : scoreList) {
						if (score.getStudentId() == user.getId() && sub.getId() == score.getSubjectId()) {
							System.out.printf("과목명 : %s ", sub.getName());
							System.out.printf(" 이름 : %s ", user.getName());
							System.out.printf(" 성적 : %d\n", score.getScore());
						}
					}
				}
			}
		}

		return subList;
	}
}
