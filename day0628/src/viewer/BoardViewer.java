package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import connector.DBConnector;
import controller.BoardController;
import controller.UserController;
import model.BoardDTO;
import model.UserDTO;
import util.ScannerUtil;

public class BoardViewer {
	private Scanner sc;
	private UserDTO logIn;
	private DBConnector conn;

	public BoardViewer(Scanner sc, DBConnector conn, UserDTO logIn) {
		this.sc = sc;
		this.conn = conn;
		this.logIn = logIn;
	}

	public void showMenu() {
		while (logIn != null) {
			int userChoice = ScannerUtil.nextInt(sc, "1.새 글 작성 2.글 목록보기 3.뒤로가기");

			switch (userChoice) {
			case 1:
				write();
			case 2:
				printList();
			case 3:
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}
	}

	private void write() {
		BoardDTO b = new BoardDTO();

		b.setWriterId(logIn.getId());
		b.setTitle(ScannerUtil.nextLine(sc, "제목을 입력해주세요."));
		b.setContent(ScannerUtil.nextLine(sc, "내용을 입력해주세요."));
		
		BoardController con = new BoardController(conn);
		
		con.insert(b);
	}

	private void printList() {
		BoardController con = new BoardController(conn);
		ArrayList<BoardDTO> list = con.selectAll();

		if (list.isEmpty()) {
			System.out.println("작성된 글이 없습니다.");
		} else {
			for (BoardDTO b : list) {
				System.out.printf("%d. %s\n", b.getId(), b.getTitle());
			}

			int userChoice = ScannerUtil.nextInt(sc, "상세보기할 글의 번호를 입력해주세요. 뒤로가시려면 0를 입력해주세요.");

			while (userChoice != 0 && con.selectOne(userChoice) == null) {
				System.out.println("잘못 입력하였습니다.");
				userChoice = ScannerUtil.nextInt(sc, "상세보기할 글의 번호를 입력해주세요. 뒤로가시려면 0를 입력해주세요.");
			}

			if (userChoice != 0) {
				printOne(userChoice);
			}
		}
	}

	private void printOne(int id) {
		BoardController bcon = new BoardController(conn);
		UserController ucon = new UserController(conn);
		BoardDTO b = bcon.selectOne(id);

		System.out.println("제목 : " + b.getTitle());
		System.out.println("글 번호 : " + b.getId());
		System.out.println("글 작성자 : " + ucon.selectOne(b.getWriterId()).getNickname());
		System.out.println("글 내용 : " + b.getContent());

		ReplyViewer rv = new ReplyViewer(sc, conn, logIn);

		rv.printList(id);

		if (logIn.getId() == b.getWriterId()) {
			int userChoice = ScannerUtil.nextInt(sc, "1.글 수정하기 2.글 삭제하기 3.댓글 작성 4.뒤로가기");

			switch (userChoice) {
			case 1:
				update(id);
			case 2:
				delete(id);
			case 3:
				rv.write(id);
			case 4:
				printList();
			default:
				System.out.println("잘못 입력하였습니다.");
				printOne(id);
			}
		} else {
			int userChoice = ScannerUtil.nextInt(sc, "1.댓글 작성 2.뒤로가기");

			switch (userChoice) {
			case 1:
				rv.write(id);
			case 2:
				printList();
			default:
				System.out.println("잘못 입력하였습니다.");
				printOne(id);
			}
		}
	}

	private void update(int id) {
		BoardController con = new BoardController(conn);
		BoardDTO b = con.selectOne(id);

		b.setTitle(ScannerUtil.nextLine(sc, "새로운 제목을 입력해주세요."));
		b.setContent(ScannerUtil.nextLine(sc, "새로운 내용을 입력해주세요."));

		con.update(b);
	}

	private void delete(int id) {
		BoardController con = new BoardController(conn);
		String yesNo = ScannerUtil.nextLine(sc, "정말로 삭제하겠습니까? Y/N");

		if (yesNo.equalsIgnoreCase("Y")) {
			con.delete(id);
			printList();
		} else {
			printOne(id);
		}
	}
}