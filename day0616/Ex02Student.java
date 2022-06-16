package day0616;

import java.util.Scanner;

public class Ex02Student {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		Student s2 = new Student();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(s2.equals(s1));
		System.out.println(s1.equals(sc));
		
		System.out.println(s1.id);
		System.out.println(s1.name);
		
		s1.id = 1;
		s1.name = "문병훈";
		s1.kor = 80;
		s1.eng = 81;
		s1.math = 81;
		
		System.out.println("s1 총점 : " + s1.calculateSum());
		System.out.println("s1 총점 : " + s1.calculateAverage());
		
		Student2 s3 = new Student2(4, "도우너", 50, 50, 51);
		
		s3.setId(40);
		s3.setName("마이콜");
		s3.setKor(80);
		s3.setEng(80);
		s3.setMath(81);
		
		System.out.println("s3의 이름 : " + s3.getName());
		
		s3.printInfo();
		
		System.out.println(s3);
	}
}
