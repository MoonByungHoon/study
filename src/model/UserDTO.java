package model;

import java.sql.Date;

public class UserDTO {
	private int id, age, rank;
	private String name, loginId, password;
	private Date joinDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public boolean equals(Object o) {
		if (o instanceof UserDTO) {
			UserDTO u = (UserDTO) o;

			return id == u.id;
		}

		return false;
	}

	public String getrating(int rank) {
		if (rank == 1) {

			return "학생";
		} else if (rank == 2) {

			return "강사";
		} else {

			return "관리자";
		}
	}
}
