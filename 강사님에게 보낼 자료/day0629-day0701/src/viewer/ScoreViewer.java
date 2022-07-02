package viewer;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ScoreController;
import controller.SubjectController;
import controller.UserController;
import model.ScoreDTO;
import model.SubjectDTO;
import util.ScannerUtil;

public class ScoreViewer {
	private Scanner sc;
	private Connection conn;

	public ScoreViewer(Scanner sc, Connection conn) {
		this.sc = sc;
		this.conn = conn;
	}

	public void getOneStudentScore(int loginid) {
		ScoreController scoreCon = new ScoreController(conn);

		ArrayList<ScoreDTO> scoreList = scoreCon.myScoreList(loginid);

		if (scoreList.isEmpty()) {
			System.out.println("수강중인 강의가 없습니다.");
		} else {
			SubjectController subCon = new SubjectController(conn);

			ArrayList<SubjectDTO> subList = subCon.mySubjectList(scoreList);

			for (SubjectDTO s1 : subList) {
				for (ScoreDTO s2 : scoreList) {
					if (s1.getId() == s2.getSubjectId()) {
						System.out.printf("%d. %s : %d점\n", s1.getId(), s1.getName(), s2.getScore());
					}
				}
			}
		}
	}

	public int inputStudentScore() {
		String userChoice = ScannerUtil.nextLine(sc, "점수를 수정할 학생의 이름을 입력해주세요.\n그만두시려면 x를 입력해주세요.");

		if (!userChoice.equals("X")) {
			int userChoice2 = ScannerUtil.nextInt(sc, "학생의 점수를 입력해주세요.");

			UserController userCon = new UserController(conn);
			ScoreController scoreCon = new ScoreController(conn);

			int studentId = userCon.getSelectOneId(userChoice);

			if (studentId == -1) {
				System.out.println("잘못 입력하였습니다.");
			} else {
				scoreCon.updateScore(studentId, userChoice2);
			}
		}

		return 0;
	}
}
