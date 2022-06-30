package model;

public class ScoreDTO {
	int studentId, classId, score;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
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
