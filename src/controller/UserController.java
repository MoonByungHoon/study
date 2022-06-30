package controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connector.DBConnector;
import model.UserDTO;

public class UserController {
	private Connection conn;

	public UserController(DBConnector conn) {
		this.conn = conn.makeConnection();
	}

//	아이디 체크
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

//	계정 생성
	public void register(UserDTO u) {
		String query = "INSERT INTO `user`(`loginId`, `password`, `name`, `age`, `joinDate`) VALUES(?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, u.getLoginId());
			pstmt.setString(2, convertTosha(u.getPassword()));
			pstmt.setString(3, u.getName());
			pstmt.setInt(4, u.getAge());
			pstmt.setDate(6, u.getJoinDate());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("계정 생성 에러");
			e.printStackTrace();
		}
	}

//	패스워드 암호화
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

//	로그인
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

//	계정 삭제
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

	public void updateUserRank(UserDTO u) {
		String query = "UPDATE `user` SET `rank` = ? WHERE `loginId` = ? AND `name` = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, u.getRank());
			pstmt.setString(2, u.getLoginId());
			pstmt.setString(3, u.getName());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("랭크 변경 에러");
			e.printStackTrace();
		}
		
	}

	public String getteacherName(int teacherId) {
		String query = "SELECT name FROM `user` WHERE `id` = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, teacherId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				return rs.getString("name");
			}
			
		} catch (SQLException e) {
			System.out.println("강사 아이디 겟 에러");
			e.printStackTrace();
		}
		
		return null;
	}
}