package model;

public class CinemaDTO {
	private String cinemaName;
//	영화관 이름
	private int cinemaNum;
//	영화관 넘버
	private String cinemaLocal;
//	영화관 주소
	private int cinemaCallNum;
//	영화관 전화번호
	
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public int getCinemaNum() {
		return cinemaNum;
	}
	public void setCinemaNum(int cinemaNum) {
		this.cinemaNum = cinemaNum;
	}
	public String getCinemaLocal() {
		return cinemaLocal;
	}
	public void setCinemaLocal(String cinemaLocal) {
		this.cinemaLocal = cinemaLocal;
	}
	public int getCinemaCallNum() {
		return cinemaCallNum;
	}
	public void setCinemaCallNum(int cinemaCallNum) {
		this.cinemaCallNum = cinemaCallNum;
	}
	
	public CinemaDTO() {
		this.cinemaLocal = new String();
		this.cinemaName = new String();
	}
	
	public CinemaDTO(CinemaDTO cinema) {
		this.cinemaCallNum = cinema.cinemaCallNum;
		this.cinemaNum = cinema.cinemaNum;
		this.cinemaLocal = cinema.cinemaLocal;
		this.cinemaName = cinema.cinemaName;
	}
}
