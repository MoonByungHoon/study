package model;

public class MovieInformationDTO {
	private int informationNum;
//	영화 상영 정보 넘버
	private int movieNum;
//	영화 넘버
	private int cinemaNum;
//	영화관 넘버
	private String movieDate;
//	영화 상영 시간

	public int getInformationNum() {
		return informationNum;
	}

	public void setInformationNum(int informationNum) {
		this.informationNum = informationNum;
	}

	public int getMovieNum() {
		return movieNum;
	}

	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public int getCinemaNum() {
		return cinemaNum;
	}

	public void setCinemaNum(int cinemaNum) {
		this.cinemaNum = cinemaNum;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public MovieInformationDTO() {
		this.movieDate = new String();
	}

	public MovieInformationDTO(MovieInformationDTO info) {
		this.movieDate = info.movieDate;
		this.cinemaNum = info.cinemaNum;
		this.informationNum = info.informationNum;
		this.movieNum = info.movieNum;
	}
}
