import java.util.Scanner;

class PutMessage {
	Scanner sc = new Scanner(System.in);

	public int menu() {
		System.out.println("원하는 서비스를 선택해주세요.");
		System.out.println("1.입차 2.출차 0.종료");
		System.out.print("입력 : ");

		return sc.nextInt();
	}

	public String in_Car() {
		Scanner sc = new Scanner(System.in);
		String result;
		char st;
		int num;
		
		System.out.println("입차할 차량 번호를 입력해주세요.");
		System.out.println("차량의 앞자리를 입력해주세요.");
		System.out.print("입력 : ");
		
		while(true) {
			num = sc.nextInt();
			
			if(num > 0 && Integer.toString(num).length() <= 3 && Integer.toString(num).length() >= 2) {
				result = Integer.toString(num);
				
				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
				System.out.println("차량의 앞자리를 입력해주세요.");
				System.out.print("입력 : ");
			}
		}

		System.out.println("차량의 문자를 입력해주세요.");
		System.out.print("입력 : ");

		Loop: while(true) {
			String num_kor_list = "가나다라마바사아자차카타파하";
			st = sc.next().charAt(0);
			
			for(int i = 0; i < num_kor_list.length(); i++) {
				if(st == num_kor_list.charAt(i)) {
					result += st;
					
					break Loop;
				}
				if (i == num_kor_list.length()-1) {
					System.out.println("잘못 입력하였습니다.");
					System.out.println("차량의 문자를 입력해주세요.");
					System.out.print("입력 : ");
				}
			}
		}

		System.out.println("차량의 뒷자리를 입력해주세요.");
		System.out.print("입력 : ");
		
		while(true) {
			num = sc.nextInt();
			
			if(num > 0 && Integer.toString(num).length() == 4) {
				result += Integer.toString(num);

				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
				System.out.println("차량의 뒷자리를 입력해주세요.");
				System.out.print("입력 : ");
			}
		}

		return result;
	}

	public String out_Car() {
		Scanner sc = new Scanner(System.in);
		String result;
		char st;
		int num;
		
		System.out.println("출차할 차량 번호를 입력해주세요.");
		System.out.println("차량의 앞자리를 입력해주세요.");
		System.out.print("입력 : ");
		
		while(true) {
			num = sc.nextInt();
			
			if(num > 0 && Integer.toString(num).length() <= 3 && Integer.toString(num).length() >= 2) {
				result = Integer.toString(num);
				
				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
				System.out.println("차량의 앞자리를 입력해주세요.");
				System.out.print("입력 : ");
			}
		}
		
		System.out.println("차량의 문자를 입력해주세요.");
		System.out.print("입력 : ");

		Loop: while(true) {
			String num_kor_list = "가나다라마바사아자차카타파하";
			st = sc.next().charAt(0);
			
			for(int i = 0; i < num_kor_list.length(); i++) {
				if(st == num_kor_list.charAt(i)) {
					result += st;
					
					break Loop;
				}
				if (i == num_kor_list.length()-1) {
					System.out.println("잘못 입력하였습니다.");
					System.out.println("차량의 문자를 입력해주세요.");
					System.out.print("입력 : ");
				}
			}
		}

		System.out.println("차량의 뒷자리를 입력해주세요.");
		System.out.print("입력 : ");
		
		while(true) {
			num = sc.nextInt();
			
			if(num > 0 && Integer.toString(num).length() == 4) {
				result += Integer.toString(num);

				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
				System.out.println("차량의 뒷자리를 입력해주세요.");
				System.out.print("입력 : ");
			}
		}

		return result;
	}
}