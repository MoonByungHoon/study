package model;

import java.util.Calendar;
import java.util.Date;

public class StudentDTO {
	private int id, kor, eng, math;
	private String name;
	private Calendar entryDate, updatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = Calendar.getInstance();
		this.entryDate.setTime(entryDate);
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = Calendar.getInstance();
		this.updatedDate.setTime(updatedDate);
		;
	}

	public boolean equals(Object o) {
		if (o instanceof StudentDTO) {
			StudentDTO s = (StudentDTO) o;

			return id == s.id;
		}

		return false;
	}
}
