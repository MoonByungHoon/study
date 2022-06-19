package viewer;
//뷰어는 사용자가 직접적으로 보게되는 화면이다. 즉 프론트 엔드 부분이라 보면 된다.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import controller.BoardController;
import model.BoardDTO;
import util.ScannerUtil;

//원칙적으로는 데이터 베이스가 존재하기 때문에 필요하면 그 즉시 해당 메소드에서
//controller 객체를 생성해서 해당 객체에 필요한 메소드를 실행시키는게 맞지만
//없기 때문에 BoardController를 만들고자 한다.

public class BoardViewer {
	private BoardController controller;
	private Scanner sc;

	public BoardViewer() {
		controller = new BoardController();
		sc = new Scanner(System.in);
	}

//	게시글 관련 메뉴 메소드
	public void showMenu() {
		while (true) {
			String message = "1.새 글 작성 2.글 목록 보기 3.종료";
			int userChoise = ScannerUtil.nextInt(sc, message);

			if (userChoise == 1) {
//				새 글 작성
				writeBoard();
			} else if (userChoise == 2) {
//				글 목록 보기
				printList();
			} else if (userChoise == 3) {
//				종료
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}
	}

	private void printList() {
		ArrayList<BoardDTO> list = controller.selectAll();
		
		if (list.isEmpty()) {
			System.out.println("아직 등록된 글이 존재하지 앉습니다.");
		} else {
			Collections.reverse(list);

			for (BoardDTO b : list) {
				System.out.printf("%d. %s\n", b.getId(), b.getTitle());
			}

			String message = "상세보기할 글의 번호나 뒤로가시려면 0을 입력해주세요.";
			int userChoise = ScannerUtil.nextInt(sc, message);

			while (userChoise != 0 && controller.selectOne(userChoise) == null) {
				System.out.println("잘못 입력하였습니다.");
				userChoise = ScannerUtil.nextInt(sc, message);
			}

			if (userChoise != 0) {
				printOne(userChoise);
			}
		}
	}

	private void printOne(int id) {
		BoardDTO b = controller.selectOne(id);

		System.out.println("\n============================================");
		System.out.println(b.getTitle());
		System.out.println("--------------------------------------------");
		System.out.println("글번호 : " + id);
		System.out.println("작성자 : " + b.getWriter());
		System.out.println("--------------------------------------------");
		System.out.println(b.getContent());
		System.out.println("============================================\n");

		String message = "1.수정 2.삭제 3.뒤로가기";
		int userChoise = ScannerUtil.nextInt(sc, message);

		if (userChoise == 1) {
			updateBoard(id);
		} else if (userChoise == 2) {
			deleteBoard(id);
		} else {
			printList();
		}
	}

	private void deleteBoard(int id) {
		String message = "정말로 삭제하시겠습니까? Y/N";
		String yesNo = ScannerUtil.nextLine(sc, message);

		if (yesNo.equalsIgnoreCase("Y")) {
			controller.delete(id);
			printList();
		} else {
			printOne(id);
		}
	}

	private void updateBoard(int id) {
		BoardDTO b = controller.selectOne(id);

		String message = "새로운 제목을 입력해주세요.";
		b.setTitle(ScannerUtil.nextLine(sc, message));

		message = "새로운 내용을 입력해주세요.";
		b.setContent(ScannerUtil.nextLine(sc, message));

		controller.update(b);

		printOne(id);
	}

	private void writeBoard() {
		BoardDTO b = new BoardDTO();

		String message = "글의 제목을 입력해주세요.";
		b.setTitle(ScannerUtil.nextLine(sc, message));

		message = "글의 작성자를 입력해주세요.";
		b.setWriter(ScannerUtil.nextLine(sc, message));

		message = "글의 내용을 입력해주세요.";
		b.setContent(ScannerUtil.nextLine(sc, message));

		controller.insert(b);
	}
}
