package controller;

import java.util.ArrayList;

import model.MovieInformationDTO;
import model.UserDTO;

public class MovieInformationController {
	ArrayList<MovieInformationDTO> mic;
	UserDTO user;
	int nextId;

	public MovieInformationController() {
		mic = new ArrayList<>();
		nextId = 1;
	}

	public void login(UserDTO user) {
		this.user = user;
	}
}
