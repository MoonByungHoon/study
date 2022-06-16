package student_main;

import java.security.PublicKey;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicScrollBarUI;

import struct.Student;
import util.ScannerUtil;

//	Student 데이터 타입의 배열을 사용하여서 5명의 학생을 관리하는 프로그램을 만들어보자.
public class StudentInfo {

	public static Student[] array;
	public static int nextIndex;
	public static Scanner sc;

	public static final int SUBJECK_SIZE = 3;
	public static final int STUDENT_SIZE = 5;
	public static final int SCORE_MIN = 0;
	public static final int SCORE_MAX = 100;

	public static void init() {
		array = new Student[STUDENT_SIZE];
		nextIndex = 1;
		sc = new Scanner(System.in);
	}

	public static void showMenu() {
		while (true) {
			String message = "1.입력 2.출력 3.종료";

			int userChoice = ScannerUtil.nextInt(sc, message);

			if (userChoice == 1) {

			} else if (userChoice == 2) {

			} else if (userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}
	}

	public static void insert() {
		if(nextIndex < STUDENT_SIZE) {
			Student s = new Student();
			
			
			String message = "학생의 번호를 입력해주세요.";
			s.id = ScannerUtil.nextInt(sc, message);
			
			message = "학생의 이름을 입력해주세요.";
			s.name = ScannerUtil.nextLine(sc, message);
			
			message = "학생의 국어 점수를 입력해주세요.";
			s.kor = ScannerUtil.nextInt(sc, message);
			
			message = "학생의 영어 점수를 입력해주세요.";
			s.eng = ScannerUtil.nextInt(sc, message);
			
			message = "학생의 수학 점수를 입력해주세요.";
			s.math = ScannerUtil.nextInt(sc, message);
			
			array[nextIndex] = s;
			
			nextIndex++;
		} else {
			System.out.println("더이상 입력할 수 없습니다.");
		}
	}
	
	public static void print() {
		if(nextIndex == 0) {
			System.out.println("아직 입력된 학생이 존재하지 않습니다.");
		} else {
//			일반적 for문
			for(int i = 0; i < nextIndex; i++) {
				Student s = array[i];
				int sum = s.kor + s.eng + s.math;
				Double average = (double)sum / SUBJECK_SIZE;
				
				System.out.printf("번호 : %d 이름 : %s \n", s.id, s.name);
				System.out.printf("국어 : %03d점 영어 : %03d점 수학 : %03d\n", s.kor, s.eng, s.math);
				System.out.printf("총점 : %03d점 평균 : %06.2f점\n", sum, average);
			}
//			for each문 상향된 for문
			for(Student s : array) {
				int sum = s.kor + s.eng + s.math;
				Double average = (double)sum / SUBJECK_SIZE;
				
				System.out.printf("번호 : %d 이름 : %s \n", s.id, s.name);
				System.out.printf("국어 : %03d점 영어 : %03d점 수학 : %03d\n", s.kor, s.eng, s.math);
				System.out.printf("총점 : %03d점 평균 : %06.2f점\n", sum, average);
			}
		}
	}
	
	public static void main(String[] args) {
		init();
		showMenu();
		sc.close();
	}
}
