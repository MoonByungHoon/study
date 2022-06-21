package model;

public class UserDTO {
	private int id;
//	회원 키값 넘버
	private String userId;
//	유저 아이디
	private String userPw;
//	유저 패스워드
	private String name;
//	유저 닉네임
	private String userRank;
//	유저 등급
	private int writeCount;
//	유저 작성한 글 수

	public int getWriteCount() {
		return writeCount;
	}

	public void setWriteCount(int writeCount) {
		this.writeCount = writeCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserRank() {
		return userRank;
	}

	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}

	public UserDTO() {
		this.userId = new String();
		this.name = new String();
		this.userPw = new String();
	}

	public boolean equals(Object o) {
		if (o instanceof UserDTO) {
			UserDTO u = (UserDTO) o;
			if (id == u.id) {
				return true;
			}
		}
		return false;
	}

	public UserDTO(int id) {
		this.id = id;
		this.userId = new String();
		this.name = new String();
		this.userPw = new String();
	}

	public UserDTO(int id, String userRank) {
		this.id = id;
		this.userRank = userRank;
		this.userId = new String();
		this.name = new String();
		this.userPw = new String();
	}

	public UserDTO(UserDTO user) {
		this.id = user.id;
		this.userRank = user.userRank;
		this.userId = user.userId;
		this.name = user.name;
		this.userPw = user.userPw;
		this.writeCount = user.writeCount;
	}
}
