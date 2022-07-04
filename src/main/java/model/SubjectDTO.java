package model;

import java.sql.Date;

public class SubjectDTO {
	private int id, teacherId;
	private String name, subjectInfo;
	private Date firstDay, finishDay;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getSubjectInfo() {
		return subjectInfo;
	}

	public void setSubjectInfo(String subjectInfo) {
		this.subjectInfo = subjectInfo;
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
		if (o instanceof SubjectDTO) {
			SubjectDTO c = (SubjectDTO) o;

			return id == c.id;
		}

		return false;
	}
}
