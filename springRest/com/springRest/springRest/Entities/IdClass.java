package com.springRest.springRest.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;


public class IdClass {

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Id [id=" + id + "]";
	}
}
