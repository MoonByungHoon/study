package viewer;

import java.util.Scanner;

import controller.MovieInformationController;
import model.MovieInformationDTO;
import model.UserDTO;

public class MovieInformationViewer {
	private MovieInformationController movieInformationController;
	private Scanner sc;
	private	UserViewer userViewer;
	private BoardViewer boardViewer;
	private MovieViewer movieViewer;
	private CinemaViewer cinemaViewer;
	private UserDTO login;
	
	public MovieInformationViewer(Scanner sc) {
		movieInformationController = new MovieInformationController();
		this.sc = sc;
	}

	public void setViewerAll(UserViewer uv, BoardViewer bv, MovieViewer mv, CinemaViewer cv) {
		this.userViewer = uv;
		this.boardViewer = bv;
		this.movieViewer = mv;
		this.cinemaViewer = cv;
	}

}
