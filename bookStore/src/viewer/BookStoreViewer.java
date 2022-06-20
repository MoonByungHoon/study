package viewer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import controller.BookStoreController;
import model.BookStoreDTO;
import util.ScannerUtil;

public class BookStoreViewer {
	BookStoreController controller;
	Scanner sc;

	public BookStoreViewer() {
		controller = new BookStoreController();
		sc = new Scanner(System.in);
	}

	public void mainMenu() {
		while (true) {
			String message = "1.서적 등록 2.서적 목록 3.종료";
			int pick = ScannerUtil.nextInt(sc, message);

			switch (pick) {
			case 1:
				bookRegister();
				break;
			case 2:
				bookList();
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}
	}

	private void bookRegister() {
		BookStoreDTO bk = new BookStoreDTO();

		String message = "책 이름을 입력해주세요.";
		bk.setName(ScannerUtil.nextLine(sc, message));

		message = "책 저자를 입력해주세요.";
		bk.setAuthor(ScannerUtil.nextLine(sc, message));

		message = "책 수량을 입력해주세요.";
		bk.setAmount(ScannerUtil.nextInt(sc, message));

		message = "책 가격을 입력해주세요.";
		bk.setPrice(ScannerUtil.nextInt(sc, message));

		controller.insert(bk);
	}

	private void bookList() {
		ArrayList<BookStoreDTO> bk = controller.bookStoreAll();

		if (bk.isEmpty()) {
			System.out.println("저장된 책이 없습니다.");
		} else {
			Collections.reverse(bk);

			for (BookStoreDTO book : bk) {
				System.out.printf("%d. 책 이름 : %s 책 가격 : %d 책 수량 : %d 책 저자 : %s\n", book.getId(), book.getName(),
						book.getPrice(), book.getAmount(), book.getAuthor());
			}

			String message = "수행 할 동작을 선택해주세요.\n 1.수정 2.삭제 3.되돌아가기";
			int pick = ScannerUtil.nextInt(sc, message);

			switch (pick) {
			case 1:
				updateBookStore();
				break;
			case 2:
				deleteBookStore();
				break;
			case 3:
				mainMenu();
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}
	}

	private void deleteBookStore() {
		String message = "삭제할 책을 선택해주세요.";
		int pick = ScannerUtil.nextInt(sc, message);
		message = "정말로 해당 책에 대한 정보를 삭제하시겠습니까? Y/N";
		String yesOrNo = ScannerUtil.nextLine(sc, message);

		if (yesOrNo.equalsIgnoreCase("Y")) {
			controller.delete(pick);
			mainMenu();
		} else {
			bookList();
		}
	}

	private void updateBookStore() {
		String message = "수정할 책을 선택해주세요.";
		int pick = ScannerUtil.nextInt(sc, message);
		BookStoreDTO bk = controller.selectOne(pick);
		
		while (true) {
			System.out.printf("%d. 책 이름 : %s 책 가격 : %d 책 수량 : %d 책 저자 : %s\n", bk.getId(), bk.getName(),
					bk.getPrice(), bk.getAmount(), bk.getAuthor());
			
			message = "수정하실 내용을 정해주세요.\n1.책 이름 2.책 저자 3.책 가격 4.책 수량 5.되돌아가기";
			pick = ScannerUtil.nextInt(sc, message);

			switch (pick) {
			case 1:
				message = "책 이름을 입력해주세요.";
				bk.setName(ScannerUtil.nextLine(sc, message));
//				controller.update(bk);
				break;
			case 2:
				message = "책 저자를 입력해주세요.";
				bk.setAuthor(ScannerUtil.nextLine(sc, message));
//				controller.update(bk);
				break;
			case 3:
				message = "책 가격을 입력해주세요.";
				bk.setPrice(ScannerUtil.nextInt(sc, message));
//				controller.update(bk);
				break;
			case 4:
				message = "책 수량을 입력해주세요.";
				bk.setAmount(ScannerUtil.nextInt(sc, message));
//				controller.update(bk);
				break;
			case 5:
				controller.update(bk);
				bookList();
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
}