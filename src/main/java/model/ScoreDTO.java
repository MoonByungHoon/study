package model;

public class ScoreDTO {
	int studentId, subjectId, score;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean equals(Object o) {
		if (o instanceof ScoreDTO) {
			ScoreDTO s = (ScoreDTO) o;

			return studentId == s.studentId;
		}

		return false;
	}
}
