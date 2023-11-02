package com.springRest.springRest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Courses {

	@Id
	private long id;
	private String title;
	private String description;
	private int fees;
	private String tutorName;

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(long id, String title, String description,int fees, String tutorName) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.fees = fees;
		this.tutorName = tutorName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	@Override
	public String toString() {
		return "Courses [id=" + id + ", title=" + title + ", description=" + description + ", fees=" + fees
				+ ", tutorName=" + tutorName + "]";
	}

	
	
}
