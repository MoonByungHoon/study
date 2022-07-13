package com.mbh.blog.model;

import java.sql.Timestamp;
import java.util.Calendar;

import lombok.Data;

@Data
public class BoardDTO {
	private int id, writerId;
	private String title, content;
	private Calendar writtenDate, updatedDate;

	public void setWrittenDate(Timestamp writtenDate) {
		this.writtenDate = Calendar.getInstance();
		this.writtenDate.setTime(writtenDate);
	}

	public void setupdatedDate(Timestamp updatedDate) {
		this.updatedDate = Calendar.getInstance();
		this.updatedDate.setTime(updatedDate);
	}

	public boolean equals(Object o) {
		if (o instanceof BoardDTO) {
			BoardDTO b = (BoardDTO) o;

			return id == b.id;
		}

		return false;
	}
}
