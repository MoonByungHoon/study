package main;

import java.util.Scanner;

import controller.CinemaController;
import controller.MovieController;
import viewer.BoardViewer;
import viewer.CinemaViewer;
import viewer.MovieInformationViewer;
import viewer.MovieViewer;
import viewer.UserViewer;

public class MovieMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		UserViewer uv = new UserViewer(sc);
		BoardViewer bv = new BoardViewer(sc);
		MovieInformationViewer miv = new MovieInformationViewer(sc);
		MovieViewer mv = new MovieViewer(sc);
		CinemaViewer cv = new CinemaViewer(sc);
		
		uv.setViewerAll(bv, miv, mv, cv);
		bv.setViewerAll(uv, miv, mv, cv);
		miv.setViewerAll(uv, bv, mv, cv);
		mv.setViewerAll(uv, bv, miv, cv);
		cv.setViewerAll(uv, bv, miv, mv);
		

		uv.showMain();
	}

}
