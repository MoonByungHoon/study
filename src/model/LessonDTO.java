package model;

import java.sql.Date;

public class LessonDTO {
	private int id, teacherId, studentId;
	private String name, lessonInfo;
	private Date firstDay, finishDay;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getLessonInfo() {
		return lessonInfo;
	}

	public void setLessonInfo(String lessonInfo) {
		this.lessonInfo = lessonInfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getFirstDay() {
		return firstDay;
	}

	public void setFirstDay(Date firstDay) {
		this.firstDay = firstDay;
	}

	public Date getFinishDay() {
		return finishDay;
	}

	public void setFinishDay(Date finishDay) {
		this.finishDay = finishDay;
	}

	public boolean equals(Object o) {
		if (o instanceof LessonDTO) {
			LessonDTO c = (LessonDTO) o;

			return id == c.id;
		}

		return false;
	}
}
