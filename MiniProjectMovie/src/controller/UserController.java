package controller;

import java.util.ArrayList;

import model.UserDTO;

public class UserController {
	ArrayList<UserDTO> list;
	int nextId;

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
}