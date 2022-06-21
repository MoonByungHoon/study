package model;

public class BoardDTO {
	private int boardNum;
//	평점 글 넘버
	private int movieNum;
//	영화 넘버
	private int id;
//	리뷰 작성자 넘버
	private int movieScore;
//	영화 점수 받는 변수
	private double movieRateScore;
//	영화 평점
	private String review;
//	영화 평론

	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getMovieNum() {
		return movieNum;
	}
	public void setMovieNum(int movieNum) {
		this.movieNum = movieNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieScore() {
		return movieScore;
	}
	public void setMovieScore(int movieScore) {
		this.movieScore = movieScore;
	}
	public double getMovieRateScore() {
		return movieRateScore;
	}
	public void setMovieRateScore(double movieRateScore) {
		this.movieRateScore = movieRateScore;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	public BoardDTO() {
		this.review = new String();
	}
	
	public BoardDTO(BoardDTO board) {
		this.id = board.id;
		this.movieNum = board.movieNum;
		this.movieRateScore = board.movieRateScore;
		this.movieScore = board.movieScore;
		this.review = board.review;
		this.boardNum = board.boardNum;
	}
}
