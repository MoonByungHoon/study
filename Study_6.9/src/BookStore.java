import java.util.ArrayList;

public class BookStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Book> book = new ArrayList<>();
		
		int menu;
		
		while((menu = BookStoreSystem.menu()) != 0){
			switch (menu) {
			case 1:
				book.add(BookStoreSystem.bookReceiving());
				break;
			case 2:
				BookStoreSystem.bookForwarding();
				break;
			case 3:
				BookStoreSystem.bookList();
				break;
			case 0:
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu);
			}
		}
	}

}
