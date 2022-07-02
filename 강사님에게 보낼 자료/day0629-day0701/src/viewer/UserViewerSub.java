package viewer;

import java.util.Scanner;

import model.UserDTO;
import util.ScannerUtil;

public class UserViewerSub {
	Scanner sc;

	public UserViewerSub(Scanner sc) {
		this.sc = sc;
	}

	public static void systemDown(Scanner sc, UserDTO login) {
		System.out.println("이용해주셔서 감사합니다.");
		login = null;
		sc.close();
		System.exit(0);
	}

//아이디 입력 메소드
	public String registerIdInput() {

		String loginId = ScannerUtil.nextLine(sc, "사용할 아이디를 입력해주세요. 뒤로가려면 x를 입력해주세요.");

//아이디 널 체크
		while (loginId == "") {
			System.out.println("잘못 입력하였습니다.");

			loginId = ScannerUtil.nextLine(sc, "사용할 아이디를 입력해주세요.");
		}

		return loginId;
	}

//패스워드 체크 메소드
	public String registerPasswordInput() {
		String password1 = ScannerUtil.nextLine(sc, "사용할 패스워드를 입력해주세요.");

//	패스워드 널 체크
		while (password1 == "") {
			System.out.println("잘못 입력하였습니다.");

			password1 = ScannerUtil.nextLine(sc, "사용할 패스워드를 입력해주세요.");
		}

//	패스워드 재차 입력 및 널 체크
		String password2 = ScannerUtil.nextLine(sc, "패스워드를 한번 더 입력해주세요.");

		while (password2 == "") {
			System.out.println("잘못 입력하였습니다.");

			password2 = ScannerUtil.nextLine(sc, "패스워드를 한번 더 입력해주세요.");
		}

//	패스워드가 일치하지 않을 경우 재입력
		while (!password1.equals(password2)) {
			System.out.println("패스워드가 일치하지 않습니다.");

			password1 = ScannerUtil.nextLine(sc, "사용할 패스워드를 입력해주세요.");

			while (password1 == "") {
				System.out.println("잘못 입력하였습니다.");

				password1 = ScannerUtil.nextLine(sc, "사용할 패스워드를 입력해주세요.");
			}

			password2 = ScannerUtil.nextLine(sc, "패스워드를 한번 더 입력해주세요.");

			while (password2 == "") {
				System.out.println("잘못 입력하였습니다.");

				password2 = ScannerUtil.nextLine(sc, "패스워드를 한번 더 입력해주세요.");
			}
		}

		return password1;
	}

//이름 입력 메소드
	public String registerNameInput() {
		String name = ScannerUtil.nextLine(sc, "성함을 입력해주세요.");

//	이름 널 체크
		while (name == null) {
			System.out.println("잘못 입력하였습니다.");

			name = ScannerUtil.nextLine(sc, "성함을 입력해주세요.");
		}

		return name;
	}

//나이 입력 메소드
	public int registerAgeInput() {
		int age = ScannerUtil.nextInt(sc, "나이를 입력해주세요.");

//나이 설정 범위 체크
		while (age <= 0) {
			System.out.println("잘못 입력하였습니다.");

			age = ScannerUtil.nextInt(sc, "나이를 입력해주세요.");
		}

		return age;
	}

	// 로그인 아이디 입력 메소드
	public String loginIdInput() {
		String loginId = ScannerUtil.nextLine(sc, "아이디를 입력해주세요. 뒤로가시려면 x를 입력해주세요.");

		while (loginId == "") {
			System.out.println("잘못 입력하였습니다.");

			loginId = ScannerUtil.nextLine(sc, "아이디를 입력해주세요. 뒤로가시려면 x를 입력해주세요.");
		}

		return loginId;
	}

//	로그인 패스워드 입력 메소드
	public String loginPasswordInput() {
		String password = ScannerUtil.nextLine(sc, "해당 계정의 패스워드를 입력해주세요.");

		while (password == "") {
			System.out.println("잘못 입력하였습니다.");

			password = ScannerUtil.nextLine(sc, "해당 계정의 패스워드를 입력해주세요.");
		}

		return password;
	}
}
