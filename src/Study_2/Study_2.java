package Study_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Study_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> st_list = new ArrayList<>();

		while (true) {
			int menu;
			Student st = new Student(null, 0);

			Message.mainMessage();

			menu = sc.nextInt();

			switch (menu) {
			case 1:
				
				Message.nameMessage();
				sc.nextLine();
				st.setName(sc.nextLine());

				Message.ageMessage();
				st.setAge(sc.nextInt());

				st_list.add(st);

				break;
			case 2:
				if (st_list.size() == 0) {
					System.out.println("저장된 학생 정보가 없습니다.");
					break;
				}

				for (int i = 0; i < st_list.size(); i++) {
					System.out.printf("번호 : %d \n이름 : %s \n나이 : %d\n\n", i + 1, st_list.get(i).getName(),
							st_list.get(i).getAge());
				}

				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}

	}
}

class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
}

class Message {
	public static void mainMessage() {
		System.out.println("실행할 명령을 선택해주세요.");
		System.out.println("1.입력 2.출력 3.종료");
		System.out.print("> ");
	}

	public static void nameMessage() {
		System.out.println("이름을 입력하세요.");
		System.out.print("> ");
	}

	public static void ageMessage() {
		System.out.println("나이를 입력하세요.");
		System.out.print("> ");
	}
}