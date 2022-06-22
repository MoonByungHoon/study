package viewer;

import java.util.Scanner;

import controller.BoardController;
import model.UserDTO;

public class BoardViewer {
	private Scanner sc;
	private BoardController boardController;
	private UserViewer userViewer;
	private MovieInformationViewer movieInformationViewer;
	private MovieViewer movieViewer;
	private CinemaViewer cinemaViewer;
	private UserDTO login;

	public BoardViewer(Scanner sc) {
		boardController = new BoardController();
		this.sc = sc;
	}

	public void setViewerAll(UserViewer uv, MovieInformationViewer miv, MovieViewer mv, CinemaViewer cv) {
		this.userViewer = uv;
		this.movieInformationViewer = miv;
		this.movieViewer = mv;
		this.cinemaViewer = cv;
	}
}
