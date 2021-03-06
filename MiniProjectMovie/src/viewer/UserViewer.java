package viewer;

import java.util.Scanner;

import controller.BoardController;
import controller.CinemaController;
import controller.MovieController;
import controller.MovieInformationController;
import controller.UserController;
import model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
	private UserController usercontroller;
	private Scanner sc;
	private UserDTO login;
	private MovieViewer movieViewer;
	private MovieInformationViewer movieInformationViewer;
	private CinemaViewer cinemaViewer;
	private BoardViewer boardViewer;
	private BoardController boardController;
	private MovieController movieController;
	private MovieInformationController movieInformationController;
	private CinemaController cinemaController;

	public UserViewer(Scanner sc) {
		usercontroller = new UserController();
		this.sc = sc;
	}

	public void showMain() {
		usercontroller.admin();
		int pick = ScannerUtil.nextInt(sc, "1.로그인 2.회원가입 3.종료");

		switch (pick) {
		case 1:
			userLogin();
			break;
		case 2:
			userJoin();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("잘못 입력하였습니다.");
			break;
		}
	}

	private void userLogin() {
		UserDTO user = new UserDTO();
		
		user.setUserId(ScannerUtil.nextLine(sc, "로그인하실 아이디를 입력해주세요."));
		user.setUserPw(ScannerUtil.nextLine(sc, "패스워드를 입력해주세요."));
		
		if(usercontroller.usercheck(user)){
			boardController.login(user);
			cinemaController.login(user);
			movieController.login(user);
			movieInformationController.login(user);
			
			System.out.println("로그인이 완료되었습니다.");
			movieViewer.viewerMain();
		}
	}

	private void userJoin() {
		UserDTO user = new UserDTO();

		user.setUserId(ScannerUtil.nextLine(sc, "사용하실 아이디를 입력해주세요."));

		while (usercontroller.validateUsername(user.getUserId())) {
			System.out.println("잘못 입력하였습니다.");
			user.setUserId(ScannerUtil.nextLine(sc, "사용하실 아이디를 입력해주세요."));
		}

		user.setUserPw(ScannerUtil.nextLine(sc, "사용하실 비밀번호를 입력해주세요."));
		user.setName(ScannerUtil.nextLine(sc, "사용하실 닉네임을 입력해주세요."));

		while (usercontroller.validateUsername(user.getName())) {
			System.out.println("잘못 입력하였습니다.");
			user.setName(ScannerUtil.nextLine(sc, "사용하실 닉네임을 입력해주세요."));
		}

		usercontroller.insert(user);
	}

	public void setViewerAll(BoardViewer bv, MovieInformationViewer miv, MovieViewer mv, CinemaViewer cv) {
		this.boardViewer = bv;
		this.movieInformationViewer = miv;
		this.movieViewer = mv;
		this.cinemaViewer = cv;
	}
}
