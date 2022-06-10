package Study_2;

import java.util.Scanner;

public class Study {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int SCORE_MIN = 0;
		final int SCORE_MAX = 100;
		final int SUBJECT_SIZE = 3;
		
		Scanner sc = new Scanner(System.in);

		int math, kor, eng, num;
		String name;

		System.out.print("수험번호 : ");
		num = sc.nextInt();

		System.out.print("이름 : ");
		sc.nextLine();
		name = sc.nextLine();

		System.out.print("국어 점수 : ");
		kor = sc.nextInt();

		System.out.print("영어 점수 : ");
		eng = sc.nextInt();

		System.out.print("수학 점수 : ");
		math = sc.nextInt();

		while(!(kor <= SCORE_MAX && kor >= SCORE_MIN)) {
			System.out.println("잘못입력하셨습니다.");
			System.out.print("국어 점수 : ");
			kor = sc.nextInt();		
		}
		
		while(!(eng <= SCORE_MAX && eng >= SCORE_MIN)) {
			System.out.println("잘못입력하셨습니다.");
			System.out.print("영어 점수 : ");
			eng = sc.nextInt();			
		}
		
		while(!(math <= SCORE_MAX && math >= SCORE_MIN)) {
			System.out.println("잘못입력하셨습니다.");
			System.out.print("수학 점수 : ");
			math = sc.nextInt();	
		}
		
		sc.close();
		
		System.out.printf("번호 : %d 이름 : %s\n", num, name);
		System.out.printf("국어 : %03d점 영어 : %03d점 수학 : %03d점\n", kor, eng, math);
		System.out.printf("총점 : %03d점 평균 : %06.2f점", (kor + eng + math), (double)((kor + eng + math) / SUBJECT_SIZE));
	}
}