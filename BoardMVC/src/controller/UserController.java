package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connector.DBConnector;
import model.UserDTO;

public class UserController {
	private Connection conn;

	public UserController(DBConnector conn) {
		this.conn = conn.makeConnection();
	}

	public void insert(UserDTO u) {
		String query = "INSERT INTO `user` (`username`, `password`, `nickname`) values(?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getNickname());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("회원가입에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	public UserDTO login(UserDTO u) {
		u = userCheck(u, 2);

		if (u != null) {

			return u;
		} else {

			return null;
		}
	}

	public boolean delete(UserDTO u) {
		u = userCheck(u, 2);

		if (u != null) {
			String query = "DELETE FROM `user` WHERE id = ?";

			try {
				PreparedStatement pstmt = conn.prepareStatement(query);

				pstmt.setInt(1, u.getId());

				pstmt.executeUpdate();

				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	public UserDTO userCheck(UserDTO u, int i) {

		if (i == 1) {
			String query = "SELECT * FROM `user` WHERE `username` = ?";

			try {
				PreparedStatement pstmt = conn.prepareStatement(query);

				pstmt.setString(1, u.getUsername());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {

					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return u;
		} else if (i == 2) {
			String query = "SELECT * FROM `user` WHERE `username` = ? AND `password` = ?";

			try {
				PreparedStatement pstmt = conn.prepareStatement(query);

				pstmt.setString(1, u.getUsername());
				pstmt.setString(2, u.getPassword());

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					u.setId(rs.getInt("id"));
					u.setNickname(rs.getString("nickname"));

					return u;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return null;
		}

		return null;
	}

//	private ArrayList<UserDTO> selectAll() {
//		ArrayList<UserDTO> list = new ArrayList<>();
//
//		String query = "SELECT * FROM `user`";
//
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(query);
//
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				UserDTO u = new UserDTO();
//
//				u.setId(rs.getInt("id"));
//				u.setUsername(rs.getString("username"));
//				u.setPassword(rs.getString("password"));
//				u.setNickname(rs.getString("nickname"));
//
//				list.add(u);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return list;
//	}

	public int updateCheck(UserDTO u) {
		u = userCheck(u, 2);

		if (u == null) {

			return -1;
		} else {

			return u.getId();
		}
	}

	public void update(UserDTO u) {
		String query = "UPDATE `user` SET `password` = ?, `nickname` = ? WHERE `id` = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, u.getPassword());
			pstmt.setString(2, u.getNickname());
			pstmt.setInt(3, u.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}