package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connector.DBConnector;
import model.StudentDTO;

public class StudentController {
	private Connection conn;

	public StudentController(DBConnector conn) {
		this.conn = conn.makeConnection();
	}

	public void insert(StudentDTO s) {
		String query = "INSERT INTO `student`(`name`, `kor`, `eng`, `math`, `entrydate`, `updateddate`) VALUES(?, ?, ?, ?, NOW(), NOW())";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getKor());
			pstmt.setInt(3, s.getEng());
			pstmt.setInt(4, s.getMath());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("StudentController.insert Error");
			e.printStackTrace();
		}
	}

	public void update(StudentDTO s) {
		String query = "UPDATE `student` SET `name` = ?, `kor` = ?, `eng` = ?, `math` = ?, `updateddate` = NOW() WHERE `id` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getKor());
			pstmt.setInt(3, s.getEng());
			pstmt.setInt(4, s.getMath());
			pstmt.setInt(5, s.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("StudentController.update Error");
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		String query = "DELETE FROM `student` WHERE `id` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("StudentController.delete Error");
			e.printStackTrace();
		}
	}

	public ArrayList<StudentDTO> selectAll() {
		ArrayList<StudentDTO> list = new ArrayList<>();
		String query = "SELECT * FROM `student`";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				StudentDTO s = new StudentDTO();

				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setKor(rs.getInt("kor"));
				s.setEng(rs.getInt("eng"));
				s.setMath(rs.getInt("math"));
				s.setEntryDate(rs.getTimestamp("entryDate"));
				s.setUpdatedDate(rs.getTimestamp("updatedDate"));

				list.add(s);
			}
		} catch (SQLException e) {
			System.out.println("StudentController.selectAll Error");
			e.printStackTrace();
		}

		return list;
	}

	public StudentDTO selectOne(int id) {
		StudentDTO s = null;
		String query = "SELECT * FROM `student` WHERE `id` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				s = new StudentDTO();

				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setKor(rs.getInt("kor"));
				s.setEng(rs.getInt("eng"));
				s.setMath(rs.getInt("math"));
				s.setEntryDate(rs.getTimestamp("entryDate"));
				s.setUpdatedDate(rs.getTimestamp("updatedDate"));
			}
		} catch (SQLException e) {
			System.out.println("StudentController.selectOne Error");
			e.printStackTrace();
		}

		return s;
	}
}
