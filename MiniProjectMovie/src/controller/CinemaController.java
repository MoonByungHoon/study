package controller;

import java.util.ArrayList;

import model.CinemaDTO;

public class CinemaController {
	ArrayList<CinemaDTO> cinema;
	int nextId;

	public CinemaController() {
		cinema = new ArrayList<>();
		nextId = 1;
	}
}
