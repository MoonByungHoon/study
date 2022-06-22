package controller;

import java.util.ArrayList;

import model.BoardDTO;
import model.UserDTO;

public class BoardController {
	ArrayList<BoardDTO> board;
	UserDTO user;
	int nextId;

	public BoardController() {
		board = new ArrayList<>();
		nextId = 1;
	}

	public void login(UserDTO user) {
		this.user = user;
	}
}
