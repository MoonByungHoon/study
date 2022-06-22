package controller;

import java.util.ArrayList;

import model.UserDTO;
import viewer.MovieViewer;

public class UserController {
	private ArrayList<UserDTO> list;
	private int nextId;
	private BoardController boardController;
	private MovieInformationController movieInformationController;
	private CinemaController cinemaController;
	private MovieController movieController;

	public UserController() {
		this.list = new ArrayList<>();
	}

	public void insert(UserDTO user) {
		user.setId(nextId++);
		list.add(user);
	}

	public boolean validateUsername(String st) {
		for (UserDTO u : list) {
			if (u.getUserId().equalsIgnoreCase(st)) {
				return true;
			}
		}

		return false;
	}

	public void admin() {
		UserDTO user = new UserDTO();

		user.setId(nextId++);
		user.setName("관리자");
		user.setUserId("admin");
		user.setUserPw("1024");
		user.setUserRank("관리자");

		list.add(user);
	}

	public boolean usercheck(UserDTO user) {
		for(UserDTO u : list) {
			if(u.getUserId().equals(user.getUserId())) {
				if(u.getUserPw().equals(user.getUserPw())) {
					
					return true;
				}
			}
		}
		
		return false;
	}
}