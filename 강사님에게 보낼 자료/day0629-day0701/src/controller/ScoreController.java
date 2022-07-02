package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ScoreDTO;
import model.SubjectDTO;

public class ScoreController {
	private Connection conn;

	public ScoreController(Connection conn) {
		this.conn = conn;
	}

//	수강 신청에 대한 점수 테이블 생성
	public boolean insertScore(int studentId, int subjectId) {
		String query = "INSERT INTO `score` (`studentId`, `subjectId`, `score`) VALUES(?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, studentId);
			pstmt.setInt(2, subjectId);
			pstmt.setInt(3, 0);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("수강 신청 테이블 에러");
			e.printStackTrace();
		}

		return true;
	}

// 전체 과목에 대한 테이블 가져오기
	public ArrayList<ScoreDTO> selectAll(int id) {
		String query = "SELECT * FROM `score` WHERE `studentId` = ?";
		ArrayList<ScoreDTO> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ScoreDTO s = new ScoreDTO();

				s.setSubjectId(rs.getInt("subjectId"));
				s.setScore(rs.getInt("score"));
				s.setStudentId(rs.getInt("studentId"));

				list.add(s);
			}

		} catch (SQLException e) {

			return null;
		}

		return list;
	}

	public ArrayList<ScoreDTO> myScoreList(int id) {
		ArrayList<ScoreDTO> list = new ArrayList<>();
		String query = "SELECT * FROM `score` WHERE `studentId` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ScoreDTO s = new ScoreDTO();

				s.setScore(rs.getInt("score"));
				s.setStudentId(rs.getInt("studentId"));
				s.setSubjectId(rs.getInt("subjectId"));

				list.add(s);
			}

		} catch (SQLException e) {

			return null;
		}

		return list;
	}

	public String joinCheck(int subjectId, int studentId) {
		String query = "SELECT * FROM `score` WHERE subjectId = ? AND `studentId` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, subjectId);
			pstmt.setInt(2, studentId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				return "신청완료";
			}
		} catch (SQLException e) {
			System.out.println("조인 체크 에러");
			e.printStackTrace();
		}

		return "미신청";
	}

//	중복 수강 체크
	public boolean registerSubjectCheck(int studentId, int subjectId) {
		String query = "SELECT * FROM `score` WHERE `studentId` = ? AND `subjectId = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, studentId);
			pstmt.setInt(2, subjectId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				return false;
			}
		} catch (SQLException e) {

		}

		return true;
	}

	public boolean cancelSubject(int userChoice, int loginId) {
		String query = "DELETE FROM `score` WHERE `subjectId` = ? AND `studentId` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, userChoice);
			pstmt.setInt(2, loginId);

			pstmt.executeUpdate();

		} catch (SQLException e) {

			return false;
		}

		return true;
	}

	public ArrayList<ScoreDTO> myLessonStudentAll(ArrayList<SubjectDTO> subList) {
		String query = "SELECT `score`, `studentId`, `subjectId` FROM `score` WHERE `subjectId` = ?";
		ArrayList<ScoreDTO> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			for (SubjectDTO sub : subList) {
				pstmt.setInt(1, sub.getId());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					ScoreDTO s = new ScoreDTO();

					s.setSubjectId(rs.getInt("subjectId"));
					s.setScore(rs.getInt("score"));
					s.setStudentId(rs.getInt("studentId"));

					list.add(s);
				}
			}

		} catch (SQLException e) {
			System.out.println("스코어 컨트롤 myLessonStudentAll 에러");

			e.printStackTrace();
		}

		return list;
	}

	public void updateScore(int studentId, int score) {
		String query = "UPDATE `score` SET `score` = ? WHERE `studentId` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, score);
			pstmt.setInt(2, studentId);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("다시 확인 후 시도해주세요.");
		}

		System.out.println("수정이 정상적으로 완료되었습니다.");
	}
}
