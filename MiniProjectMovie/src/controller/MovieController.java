package controller;

import java.util.ArrayList;

import model.MovieDTO;
import model.UserDTO;

public class MovieController {
	ArrayList<MovieDTO> movie;
	UserDTO user;
	int nextId;
	
	public MovieController() {
		movie = new ArrayList<>();
		nextId = 1;
	}

	public void login(UserDTO user) {
		this.user = user;
	}
}
