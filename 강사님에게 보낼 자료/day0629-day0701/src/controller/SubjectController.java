package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SubjectDTO;
import model.ScoreDTO;

public class SubjectController {
	private Connection conn;

	public SubjectController(Connection conn) {
		this.conn = conn;
	}

//	전체 강의 출력 기능
	public ArrayList<SubjectDTO> selectAll() {
		String query = "SELECT * FROM `subject`";
		ArrayList<SubjectDTO> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				SubjectDTO s = new SubjectDTO();

				s.setSubjectInfo(rs.getString("subjectInfo"));
				s.setFinishDay(rs.getDate("finishDay"));
				s.setFirstDay(rs.getDate("firstDay"));
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setTeacherId(rs.getInt("teacherId"));

				list.add(s);
			}
		} catch (SQLException e) {

			return null;
		}

		return list;
	}

//	일단 보류 기능
	public ArrayList<SubjectDTO> selectOne(int id) {
		ArrayList<SubjectDTO> list = selectAll();

		for (SubjectDTO s : list) {
			if (s.getId() == id) {
				s.getFinishDay();
				s.getFirstDay();
				s.getId();
				s.getSubjectInfo();
				s.getName();
				s.getTeacherId();

				list.add(s);

				return list;
			}
		}

		return null;
	}

//	강의 신청에 대한 점수 테이블 생성 여부 체크
	public boolean registerSubjectScore(int studentId, int subjectId) {
		ScoreController scoreCon = new ScoreController(conn);

		if (scoreCon.registerSubjectCheck(studentId, subjectId)) {

			return scoreCon.insertScore(studentId, subjectId);
		}

		return false;
	}

	// 학생이 수강 신청한 과목에 대한 강의 테이블을 출력.
	public ArrayList<SubjectDTO> mySubjectList(ArrayList<ScoreDTO> scoreList) {
		String query = "SELECT * FROM `subject` WHERE `id` = ?";
		ArrayList<SubjectDTO> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			for (ScoreDTO s : scoreList) {
				pstmt.setInt(1, s.getSubjectId());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					SubjectDTO sub = new SubjectDTO();

					sub.setFinishDay(rs.getDate("finishDay"));
					sub.setFirstDay(rs.getDate("firstDay"));
					sub.setId(rs.getInt("id"));
					sub.setSubjectInfo(rs.getString("subjectInfo"));
					sub.setName(rs.getString("name"));
					sub.setTeacherId(rs.getInt("teacherId"));

					list.add(sub);
				}
			}

		} catch (SQLException e) {

			return null;
		}

		return list;
	}

	public void registerSubject(SubjectDTO s) {
		String query = "INSERT INTO `subject` (`teacherId`, `name`, `subjectInfo`, `firstDay`, `finishDay`) VALUES(?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, s.getTeacherId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getSubjectInfo());
			pstmt.setDate(4, s.getFirstDay());
			pstmt.setDate(5, s.getFinishDay());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("강의 등록 에러");

			e.printStackTrace();
		}
	}

	public ArrayList<SubjectDTO> myLessonAll(int teadcherId) {
		String query = "SELECT `id`, `name` FROM `subject` WHERE `teacherId` = ?";
		ArrayList<SubjectDTO> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, teadcherId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				SubjectDTO s = new SubjectDTO();

				s.setName(rs.getString("name"));
				s.setId(rs.getInt("id"));

				list.add(s);
			}

		} catch (SQLException e) {

			return null;
		}

		return list;
	}
}
