package viewer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import controller.StudentController;
import model.StudentDTO;
import util.ScannerUtil;

public class StudentViewer {
	private StudentController controller;
	private Scanner sc;

	public StudentViewer() {
		controller = new StudentController();
		sc = new Scanner(System.in);
	}

	public void showStudent() {
		while (true) {
			String message = "1.학생 성적 등록 2.학생 목록 출력 3.종료";
			int choise = ScannerUtil.nextInt(sc, message);

			switch (choise) {
			case 1:
				addStudent();
				break;
			case 2:
				printStudentList();
				break;
			case 3:
				System.out.println("사용해주셔서 감사합니다.");
				System.exit(0);
			default:
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}
	}

	private void addStudent() {
		StudentDTO st = new StudentDTO();
		
		String message = "학생의 이름을 입력해주세요.";
		st.setName(ScannerUtil.nextLine(sc, message));
		
		message = "학생의 국어 성적을 입력해주세요.";
		st.setKor(ScannerUtil.nextInt(sc, message));
		
		message = "학생의 영어 성적을 입력해주세요.";
		st.setEng(ScannerUtil.nextInt(sc, message));
		
		message = "학생의 수학 성적을 입력해주세요.";
		st.setMath(ScannerUtil.nextInt(sc, message));
//	새로운 인스턴스를 선언해서 해당 인스턴스에 값을 받아 안전하게 원본을 지키고
//	이후 해당 값을 controller클래스에 있는 insert함수를 통해서 값을 전달한다.
		controller.insert(st);
	}

	private void printStudentList() {
		ArrayList<StudentDTO> list = controller.selectAll();
//		새로운 ArrayList를 선언하고 그 안에 현재 구성된 list를 전부 집어 넣음.

		if (list.isEmpty()) {
//			배열의 크기가 0 이라면 트루가 나옴.
			System.out.println("등록된 학생이 없습니다.");
		} else {
			Collections.reverse(list);
//			리스트의 순서를 뒤집어서 역순으로 출력.
			for (StudentDTO st : list) {
				System.out.printf("%d. %s\n", st.getId(), st.getName());
			}

			String message = "상세보기를 할 학생의 번호를 선택해주세요. \n 뒤로 가시려면 '0'을 입력해주세요.";
			int choise = ScannerUtil.nextInt(sc, message);

			while (choise != 0 && controller.selectOne(choise) == null) {
				System.out.println("잘못 입력하였습니다.");
				choise = ScannerUtil.nextInt(sc, message);
			}

			if (choise != 0) {
				printOne(choise);
			}
		}
	}

	private void printOne(int id) {
		StudentDTO st = controller.selectOne(id);

		System.out.println("\n============================================");
		System.out.println(st.getName());
		System.out.println("--------------------------------------------");
		System.out.printf("국어점수 : %d 영어점수 : %d 수학점수 : %d\n", st.getKor(), st.getEng(), st.getMath());
		System.out.println("--------------------------------------------");
		System.out.println("총점 : " + (st.getKor() + st.getEng() + st.getMath()));
		System.out.println("--------------------------------------------");
		System.out.println("평균 : " + (double) (st.getKor() + st.getEng() + st.getMath()) / st.getSUBJECK_SIZE());
		System.out.println("--------------------------------------------");
		System.out.println("============================================\n");

		String message = "1.수정 2.삭제 3.뒤로가기";
		int choise = ScannerUtil.nextInt(sc, message);

		switch (choise) {
		case 1:
			updateStudent(id);
			break;
		case 2:
			deleteStudent(id);
			break;
		case 3:
			printStudentList();
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
			break;
		}
	}

	private void deleteStudent(int id) {
		String message = "정말로 삭제하시겠습니까? Y/N";
		String yesNo = ScannerUtil.nextLine(sc, message);
		
		if(yesNo.equalsIgnoreCase("Y")) {
			controller.delete(id);
			printStudentList();
		} else {
			printOne(id);
		}
	}

	private void updateStudent(int id) {
		StudentDTO st = controller.selectOne(id);
//		이 부분에서 넘겨 받은 해당 학생의 id값을 받아서 새로운 st에 저장한다.
		
		String message = "새로운 국어 성적을 입력해주세요.";
		st.setKor(ScannerUtil.nextInt(sc, message));
		
		message = "새로운 영어 성적을 입력해주세요.";
		st.setEng(ScannerUtil.nextInt(sc, message));
		
		message = "새로운 수학 성적을 입력해주세요.";
		st.setMath(ScannerUtil.nextInt(sc, message));
		
		controller.update(st);
//		수정된 점수에 대한 값을 넘겨주는데 id값으 위에서 이미 받아왔기 떄문에 넘길때에
//		해당 아이디 값에 저장된 인덱스 위치에 점수들을 수정하게 된다.
		printOne(id);
//		이후 얕은 복사이므로 저장된 값의 주소값이 옮겨간다 생각하면 된다. 
	}
}