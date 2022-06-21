package model;

public class MovieDTO {
	private int movieNum;
//	영화 넘버
	private String movieName;
//	영화 제목
	private String movieStory;
//	영화 줄거리
	private int movieRank;
//	영화 등급

	public int getMovieNum() {
		return movieNum;
	}

	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieStory() {
		return movieStory;
	}

	public void setMovieStory(String movieStory) {
		this.movieStory = movieStory;
	}

	public int getMovieRank() {
		return movieRank;
	}

	public void setMovieRank(int movieRank) {
		this.movieRank = movieRank;
	}

	public MovieDTO() {
		this.movieName = new String();
		this.movieStory = new String();
	}

	public MovieDTO(MovieDTO movie) {
		this.movieName = movie.movieName;
		this.movieNum = movie.movieNum;
		this.movieRank = movie.movieRank;
		this.movieStory = movie.movieStory;
	}
}
