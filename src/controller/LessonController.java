package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connector.DBConnector;
import model.LessonDTO;

public class LessonController {
	Connection conn;

	public LessonController(DBConnector conn) {
		this.conn = conn.makeConnection();
	}

	public ArrayList<LessonDTO> selectAll() {
		String query = "SELECT * FROM `lesson`";
		ArrayList<LessonDTO> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				LessonDTO l = new LessonDTO();

				l.getLessonInfo();
				l.getFinishDay();
				l.getFirstDay();
				l.getId();
				l.getName();
				l.getTeacherId();
				l.getStudentId();

				list.add(l);
			}
		} catch (SQLException e) {
			System.out.println("강의 전체 출력 에러");
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<LessonDTO> selectOne(int id) {
		ArrayList<LessonDTO> list = selectAll();

		for (LessonDTO l : list) {
			if (l.getId() == id) {
				l.getFinishDay();
				l.getFirstDay();
				l.getId();
				l.getLessonInfo();
				l.getName();
				l.getStudentId();
				l.getTeacherId();

				list.add(l);

				return list;
			}
		}

		return null;
	}

	public void registerLessonScore(int userChoice) {
		// TODO Auto-generated method stub
		
	}
}
