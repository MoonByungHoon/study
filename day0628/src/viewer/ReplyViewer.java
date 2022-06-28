package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import connector.DBConnector;
import controller.ReplyController;
import controller.UserController;
import model.ReplyDTO;
import model.UserDTO;
import util.ScannerUtil;

public class ReplyViewer {
	private Scanner sc;
	private UserDTO logIn;
	private DBConnector conn;

	public ReplyViewer(Scanner sc, DBConnector conn, UserDTO logIn) {
		this.sc = sc;
		this.conn = conn;
		this.logIn = logIn;
	}

	public void printList(int boardId) {
		ReplyController con = new ReplyController(conn);
		ArrayList<ReplyDTO> list = con.selectAll(boardId);
		
		if(list.isEmpty()) {
			System.out.println("작성된 댓글이 없습니다.");
		} else {
			UserController ucon = new UserController(conn);
			
			for(ReplyDTO r : list) {
				System.out.printf("%s : %s\n", ucon.selectOne(r.getWriterId()).getId(), r.getContent());
			}
		}
	}

	public void write(int boardId) {
		ReplyDTO r = new ReplyDTO();
		
		r.setWriterId(logIn.getId());
		r.setBoardId(boardId);
		
		r.setContent(ScannerUtil.nextLine(sc, "댓글을 입력해주세요."));
		
		ReplyController con = new ReplyController(conn);
		
		con.insert(r);
	}
}
