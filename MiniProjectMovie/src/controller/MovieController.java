package controller;

import java.util.ArrayList;

import model.MovieDTO;

public class MovieController {
	ArrayList<MovieDTO> movie;
	int nextId;
	
	public MovieController() {
		movie = new ArrayList<>();
		nextId = 1;
	}
}
