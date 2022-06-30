package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import connector.DBConnector;
import controller.LessonController;
import controller.UserController;
import model.LessonDTO;
import model.UserDTO;
import util.ScannerUtil;

public class LessonViewer {
	Scanner sc;
	DBConnector conn;
	UserDTO login;

	public LessonViewer(Scanner sc, DBConnector conn, UserDTO login) {
		this.sc = sc;
		this.conn = conn;
		this.login = login;
	}

	public void showMenu() {
		int userChoice = ScannerUtil.nextInt(sc, "1.수강신청 2.수강신청취소 3.뒤로가기 4.종료");

		if (userChoice == 1) {
			selectAll();
			showMenu();
		} else if (userChoice == 2) {
			myLesson();
		} else if (userChoice == 3) {
//			UserViewer.showMenu();
//			적지 않아도 돌아가지나 어디로 가는지 명확히 보여주기 위한용도로 주석처리.
		} else if (userChoice == 4) {
			login = null;
			sc.close();
			System.exit(0);
		} else {
			System.out.println("잘못 입력하였습니다.");
		}
	}

	private void myLesson() {

	}

	public void deleteLesson() {

	}

	public void selectAll() {
		LessonController lcon = new LessonController(conn);
		UserController ucon = new UserController(conn);
		ArrayList<LessonDTO> list = lcon.selectAll();

		for (LessonDTO l : list) {
			System.out.println("--------------------------------------");
			System.out.printf("%d. 과목명 : %s 담당강사 : %s\n", l.getId(), l.getName(), ucon.getteacherName(l.getTeacherId()));
			System.out.printf("개강일 : %s 종강일 : %s\n", l.getFirstDay(), l.getFinishDay());
			System.out.printf("강의 정보\n %s", l.getLessonInfo());
			System.out.println("--------------------------------------");
		}

		if (login.getRank() == 1) {

			while (true) {
				int userChoice = ScannerUtil.nextInt(sc, "신청할 수강 넘버를 입력해주세요. 뒤로가려면 0을 입력해주세요.");

				if (lcon.selectOne(userChoice) != null) {
					lcon.registerLessonScore(userChoice);
				} else if (userChoice == 0) {
					showMenu();
				} else {
					System.out.println("존재하지 않는 수강 넘버입니다.");
				}
			}
		}

	}

	public void insertLesson() {
		// TODO Auto-generated method stub

	}

}
