package util;

import java.util.Scanner;
import struct.Student;

public class ScannerUtil {
	// 0. 입력 받을 내용을 출력하는 printMessage()
	public static void printMessage(String message) {
	    System.out.println("--------------------------");
	    System.out.println(message);
	    System.out.println("--------------------------");
	    System.out.print("> ");
	}
	
	// 1. 스캐너 버그를 미리 해결한 nextLine()
	public static String nextLine(Scanner scanner, String message) {
	    printMessage(message);
	    String temp = scanner.nextLine();
	    // String 변수/상수 혹은 값의 경우
	    // isEmpty() 메소드를 실행시키면
	    // 아무런 값도 없으면 true, 아무 글자가 하나라도 있으면 false가 리턴된다.
	    if (temp.isEmpty()) {
	        temp = scanner.nextLine();
	    }
	
	    return temp;
	}
	
	// 2. int 를 처리하는 nextInt()
	public static int nextInt(Scanner scanner, String message) {
	    printMessage(message);
	    int temp = scanner.nextInt();
	    return temp;
	}
	
	// 3. 특정 범위안의 int를 리턴하는 nextInt()
	public static int nextInt(Scanner scanner, String message, int min, int max) {
	    int temp = nextInt(scanner, message);
	    while (temp < min || temp > max) {
	        System.out.println("잘못 입력하셨습니다.");
	        temp = nextInt(scanner, message);
	    }
	
	    return temp;
	}
	
	public static Student Studentinput(Student st) {
		Scanner sc = new Scanner(System.in);
		Student stu = st;
		
		System.out.println("학생의 정보를 입력해주세요.");
		System.out.print("번호 : ");
		
		stu.id = sc.nextInt();
		
		System.out.print("이름 : ");
		
		sc.nextLine();
		stu.name = sc.nextLine();
		
		System.out.print("한글 : ");
		
		stu.kor = sc.nextInt();
		
		System.out.print("영어 : ");
		
		stu.eng = sc.nextInt();
		
		System.out.print("수학 : ");
		
		stu.math = sc.nextInt();
		
		return stu;
	}
}