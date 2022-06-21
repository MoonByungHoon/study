package controller;

import java.util.ArrayList;

import model.BoardDTO;

public class BoardController {
	ArrayList<BoardDTO> board;
	int nextId;

	public BoardController() {
		board = new ArrayList<>();
		nextId = 1;
	}
}
