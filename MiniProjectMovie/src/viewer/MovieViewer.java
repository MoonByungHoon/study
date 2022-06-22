package viewer;


import java.util.Scanner;

import controller.MovieController;
import model.MovieDTO;
import model.UserDTO;

public class MovieViewer {
	private MovieController movieController;
	private Scanner sc;
	private	UserViewer userViewer;
	private BoardViewer boardViewer;
	private MovieInformationViewer movieInformationViewer;
	private CinemaViewer cinemaViewer;
	private UserDTO login;
	
	public MovieViewer(Scanner sc) {
		movieController = new MovieController();
		this.sc = sc;
	}

	public void setViewerAll(UserViewer uv, BoardViewer bv, MovieInformationViewer miv, CinemaViewer cv) {
		this.userViewer = uv;
		this.boardViewer = bv;
		this.movieInformationViewer = miv;
		this.cinemaViewer = cv;
	}

	public void viewerMain() {
		// TODO Auto-generated method stub
		
	}

}
