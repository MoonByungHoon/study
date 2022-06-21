package controller;

import java.util.ArrayList;

import model.MovieInformationDTO;

public class MovieInformationController {
	ArrayList<MovieInformationDTO> mic;
	int nextId;

	public MovieInformationController() {
		mic = new ArrayList<>();
		nextId = 1;
	}
}
