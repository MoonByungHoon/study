package controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ScoreDTO;
import model.UserDTO;

public class UserController {
	private Connection conn;

	public UserController(Connection conn) {
		this.conn = conn;
	}

//	아이디 체크 기능
	public boolean idCheck(String loginId) {
		String query = "SELECT loginID FROM `user`";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("loginId").equalsIgnoreCase(loginId)) {

					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("아이디 체크 에러");
			e.printStackTrace();
		}

		return false;
	}

//	계정 생성 기능
	public void register(UserDTO u) {
		String query = "INSERT INTO `user`(`loginId`, `password`, `name`, `age`, `joinDate`) VALUES(?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, u.getLoginId());
			pstmt.setString(2, convertTosha(u.getPassword()));
			pstmt.setString(3, u.getName());
			pstmt.setInt(4, u.getAge());
			pstmt.setDate(5, u.getJoinDate());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("계정 생성 에러");
			e.printStackTrace();
		}
	}

//	패스워드 암호화 기능
	public String convertTosha(String password) {
		String converted = null;
		StringBuilder builder = null;

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes("UTF-8"));

			builder = new StringBuilder();

			for (int i = 0; i < hash.length; i++) {
				builder.append(String.format("%02x", 255 & hash[i]));
			}

			converted = builder.toString();

		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			System.out.println("암호화 에러");
			e.printStackTrace();
		}

		return converted;
	}

//	로그인 기능
	public UserDTO login(String loginId, String password) {
		String query = "SELECT * FROM `user` WHERE `loginId` = ? AND `password` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, loginId);
			pstmt.setString(2, convertTosha(password));

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				UserDTO u = new UserDTO();

				u.setId(rs.getInt("id"));
				u.setRank(rs.getInt("rank"));
				u.setAge(rs.getInt("age"));
				u.setLoginId(rs.getString("loginId"));
				u.setName(rs.getString("name"));
				u.setJoinDate(rs.getDate("joinDate"));
				u.setPassword(rs.getString("password"));

				return u;
			}
		} catch (SQLException e) {
			System.out.println("로그인 에러");
			e.printStackTrace();
		}

		return null;
	}

// 계정 삭제 기능
	public void delete(int id) {
		String query = "DELETE FROM `user` WHERE `id` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("삭제 에러");
			e.printStackTrace();
		}
	}

//	학생 또는 강사가 비번 변경 하는 기능
	public void update(UserDTO login) {
		String query = "UPDATE `user` SET `password` = ? WHERE `id` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, convertTosha(login.getPassword()));
			pstmt.setInt(2, login.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("수정 에러");
			e.printStackTrace();
		}
	}

//	관리자 권한 유저의 등급 변경
	public void updateUserRank(String loginId, String name, int rank) {
		String query = "UPDATE `user` SET `rank` = ? WHERE `loginId` = ? AND `name` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, rank);
			pstmt.setString(2, loginId);
			pstmt.setString(3, name);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("랭크 변경 에러");
			e.printStackTrace();
		}

	}

//	강사의 이름을 가져오는 기능
	public String getteacherName(int teacherId) {
		String query = "SELECT name FROM `user` WHERE `id` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, teacherId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				return rs.getString("name");
			}

		} catch (SQLException e) {
			System.out.println("강사 아이디 겟 에러");
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<UserDTO> teacherList() {
		String query = "SELECT `id`, `name`, `joinlesson` FROM `user` WHERE `rank` = 2 AND `joinlesson` = 1";
		ArrayList<UserDTO> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				UserDTO u = new UserDTO();

				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setJoinlesson(rs.getBoolean("joinlesson"));

				list.add(u);
			}

		} catch (SQLException e) {

			System.out.println("강사 리스트 출력 에러");
			e.printStackTrace();
		}

		return list;
	}

	public boolean userCheck(String userId, String name) {
		String query = "SELECT `loginId`, `name` FROM `user` WHERE `loginId` = ? AND `name` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, userId);
			pstmt.setString(2, name);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<UserDTO> myLessonStudentAll(ArrayList<ScoreDTO> scoreList) {
		String query = "SELECT `name`, `age`, `id` FROM `user` WHERE `user`.`id` = ?";
		ArrayList<UserDTO> list = new ArrayList<>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			for (ScoreDTO s : scoreList) {
				pstmt.setInt(1, s.getStudentId());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					UserDTO u = new UserDTO();

					u.setId(rs.getInt("id"));
					u.setAge(rs.getInt("age"));
					u.setName(rs.getString("name"));

					list.add(u);
				}
			}

		} catch (SQLException e) {
			System.out.println("유저 컨트롤 myLessonStudentAll 에러");

			e.printStackTrace();
		}

		return list;
	}

	public void teacherLessonUpdate(int teacherId) {
		String query = "UPDATE `user` SET `joinlesson` = ? WHERE `id` = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setBoolean(1, false);
			pstmt.setInt(2, teacherId);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("선생 수업 가능 상태 업데이트 실패 에러");
			e.printStackTrace();
		}
	}

	public int getSelectOneId(String name) {
		String query = "SELECT `id` FROM `user` WHERE `name` = ?";
		int studentId;

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();

			studentId = rs.getInt("id");
		} catch (SQLException e) {

			return -1;
		}

		return studentId;
	}
}