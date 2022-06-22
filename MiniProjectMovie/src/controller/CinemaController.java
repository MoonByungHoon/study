package controller;

import java.util.ArrayList;

import model.CinemaDTO;
import model.UserDTO;

public class CinemaController {
	ArrayList<CinemaDTO> cinema;
	UserDTO user;
	int nextId;

	public CinemaController() {
		cinema = new ArrayList<>();
		nextId = 1;
	}

	public void login(UserDTO user) {
		this.user = user;
	}
}
