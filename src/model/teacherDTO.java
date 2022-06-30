package model;

public class teacherDTO {
	int teacherId, inClass;

	public int getteacherId() {
		return teacherId;
	}

	public void setProfessorId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getInClass() {
		return inClass;
	}

	public void setInClass(int inClass) {
		this.inClass = inClass;
	}

	public boolean equals(Object o) {
		if (o instanceof teacherDTO) {
			teacherDTO p = (teacherDTO) o;

			return teacherId == p.teacherId;
		}

		return false;
	}
}
