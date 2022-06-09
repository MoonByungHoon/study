import java.util.Scanner;

public class BookStoreSystem {
	static Scanner sc = new Scanner(System.in);
	
	public static int menu() {
		System.out.println("이용할 서비스를 선택해주세요.");
		System.out.println("1.입고 2.출고 3.품목 0.종료");
		System.out.print("입력 : ");
		
		return sc.nextInt(); 
	}
	
	
	public static Book bookReceiving() {
		String name;
		int amount, price;
		System.out.println("입고할 책에 대한 정보를 입력해주세요.");
		System.out.println("제목 : ");
		name = sc.next();
		System.out.println("수량 : ");
		amount = sc.nextInt();
		System.out.println("가격 : ");
		price = sc.nextInt();
		
		return new Book(name, amount, price);
	}
	
	public static void bookForwarding() {
		
	}
	
	public static void bookList() {
		
	}
}
