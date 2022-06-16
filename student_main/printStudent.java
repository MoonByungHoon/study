package student_main;

import java.util.Scanner;
import util.ArrayUtil;
import util.ScannerUtil;
import struct.Student;

public class printStudent {

	public static Scanner sc;
	public static Student[] array;
	public static int nextId;

	public static final int SUBJECT_SIZE = 3;
	public static final int SCORE_MIN = 0;
	public static final int SCORE_MAX = 100;

	public static void main(String[] args) {
		init();
		showMenu();

		sc.close();
	}

	public static void init() {
		sc = new Scanner(System.in);
		array = new Student[0];
		nextId = 1;
	}

	public static void showMenu() {
		while (true) {
			String message = "1.학생입력 2.목록출력 3.종료";

			int userChoice = ScannerUtil.nextInt(sc, message);

			if (userChoice == 1) {
				insert();
			} else if (userChoice == 2) {
				printAll();
			} else if (userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}
	}

	public static void insert() {
		Student s = new Student();

		String message;

		s.id = nextId++;

		message = "학생의 이름을 입력해주세요.";
		s.name = ScannerUtil.nextLine(sc, message);

		message = "학생의 국어 성적을 입력해주세요.";
		s.kor = ScannerUtil.nextInt(sc, message);

		message = "학생의 영어 성적을 입력해주세요.";
		s.eng = ScannerUtil.nextInt(sc, message);

		message = "학생의 수학 성적을 입력해주세요.";
		s.math = ScannerUtil.nextInt(sc, message);

		array = ArrayUtil.add(array, s);
	}

	public static void printAll() {
		if (ArrayUtil.isEmpty(array)) {
			System.out.println("아직 저장된 학생 정보가 없습니다.");
		} else {
			for (Student s : array) {
				System.out.printf("%d. %s\n", s.id, s.name);
			}

			String message = "상세보기할 학생의 번호를 입력해주시거나 종료하시려면 0을 입력해주세요.";

			int userChoice = ScannerUtil.nextInt(sc, message);

			Student temp = new Student();

			temp.id = userChoice;

			while (userChoice != 0 && !ArrayUtil.contains(array, temp)) {
				System.out.println("잘못 입력하였습니다.");
				
				userChoice = ScannerUtil.nextInt(sc, message);
				temp.id = userChoice;
			}

			if (userChoice != 0) {
				printOne(userChoice);
			}
		}
	}

	public static void printOne(int id) {
		Student temp = selectOne(id);
		
		int sum = temp.kor + temp.eng + temp.math;
		double average = (double) sum / SUBJECT_SIZE;

		System.out.printf("번호 : %d번 이름 : %s\n", temp.id, temp.name);
		System.out.printf("국어 : %03d점 영어 : %03d점 수학 : %03d점\n", temp.kor, temp.eng, temp.math);
		System.out.printf("총점 : %03d점 평균 %06.2f점\n", sum, average);

		String message = "1.수정 2.삭제 3.뒤로가기";
		
		int userChoice = ScannerUtil.nextInt(sc, message);

		if (userChoice == 1) {
			update(id);
		} else if (userChoice == 2) {
			delete(id);
		} else if (userChoice == 3) {
			printAll();
		}
	}
	
	public static void update(int id) {
		Student temp = selectOne(id);
		
		String message = "새로운 이름을 입력해주세요.";
		temp.name = ScannerUtil.nextLine(sc, message);
		
		message = "새로운 국어 점수를 입력해주세요.";
		temp.kor= ScannerUtil.nextInt(sc, message);
		
		message = "새로운 영어 점수를 입력해주세요.";
		temp.eng = ScannerUtil.nextInt(sc, message);
		
		message = "새로운 수학 점수를 입력해주세요.";
		temp.math = ScannerUtil.nextInt(sc, message);
		
		printOne(id);
	}
	
	public static Student selectOne(int id) {
		Student result = null;
		Student temp = new Student();
		
		temp.id = id;
		
		if(ArrayUtil.contains(array, temp)) {
			result = ArrayUtil.get(array, ArrayUtil.indexOf(array, temp));
		}
		
		return result;
	}
	
	public static void delete(int id) {
		Student temp =  selectOne(id);
		
		temp.id = id;
		
//		String 클래스에 정의 되어 있는 equalsIgnoreCase()란게 있다.
//		해당 클래스는 2개의 스트링이 대소문자 상관없이 스펠링이 같으면 true,
//		아니라면 false가 리턴된다.
		
		String message = "정말로 삭제하겠습니까? Y/N ";
		String yesNo = ScannerUtil.nextLine(sc, message);
		
		if(yesNo.equalsIgnoreCase("Y")) {
			array = ArrayUtil.remove(array, temp);
			
			printAll();
		} else {
			printOne(id);
		}
	}
}
