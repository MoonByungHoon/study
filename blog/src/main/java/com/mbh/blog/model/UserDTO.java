package com.mbh.blog.model;

import lombok.Data;

@Data
public class UserDTO {
	private int id, supportCash, rank;
	private String username, password, nickname;

	public boolean equals(Object o) {
		if (o instanceof UserDTO) {
			UserDTO u = (UserDTO) o;

			return id == u.id;
		}

		return false;
	}
}
