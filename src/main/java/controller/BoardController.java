package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import connector.DBConnector;
import model.BoardDTO;

public class BoardController {
	private Connection conn;

	public BoardController(DBConnector connector) {
		this.conn = connector.makeConnection();
	}

	// 1.글 입력
	public void insert(BoardDTO b) {
		String query = "INSERT INTO `board`(`writerId`,`title`,`content`, `writtenDate`, `updateDate`) VALUES(?, ?, ?, ?, ?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getWriterId());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());

			Timestamp d1 = new Timestamp(b.getWrittenDate().getTimeInMillis());
			
			pstmt.setTimestamp(4, d1);
			pstmt.setTimestamp(5, d1);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 2.글 수정
	public void udpate(BoardDTO b) {
		String query = "UPDATE `board` SET `title`=?, `content`=? WHERE `id`=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 3.글 삭제
	public void delete(int id) {
		String query = "DELETE FROM `board` WHERE `id`=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 4.글 목록 조회
	public ArrayList<BoardDTO> selectAll() {
		ArrayList<BoardDTO> list = new ArrayList<>();
		String query = "SELECT * FROM `board`";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO b = new BoardDTO();
				b.setId(rs.getInt("id"));
				b.setWriterId(rs.getInt("writerId"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				Calendar temp = Calendar.getInstance();
				temp.setTime(rs.getTimestamp("writtenDate"));
				b.setWrittenDate(temp);
				Calendar temp2 = Calendar.getInstance();
				temp2.setTime(rs.getTimestamp("updateDate"));
				b.setUpdateDate(temp2);

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 5.글 개별 조회
	public BoardDTO selectOne(int id) {
		BoardDTO b = null;
		String query = "SELECT * FROM `board` WHERE `id`=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				b = new BoardDTO();
				b.setId(rs.getInt("id"));
				b.setWriterId(rs.getInt("writerId"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}
}
