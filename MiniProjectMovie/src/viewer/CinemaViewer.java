package viewer;

import java.util.Scanner;

import controller.CinemaController;
import model.CinemaDTO;
import model.UserDTO;

public class CinemaViewer {
	private CinemaController cinemaController;
	private Scanner sc;
	private UserViewer userViewer;
	private BoardViewer boardViewer;
	private MovieInformationViewer movieInformationViewer;
	private MovieViewer movieViewer;
	private UserDTO login;
	
	public CinemaViewer(Scanner sc) {
		cinemaController = new CinemaController();
		this.sc = sc;
	}

	public void setViewerAll(UserViewer uv, BoardViewer bv, MovieInformationViewer miv, MovieViewer mv) {
		this.userViewer = uv;
		this.boardViewer = bv;
		this.movieInformationViewer = miv;
		this.movieViewer = mv;
	}

}
