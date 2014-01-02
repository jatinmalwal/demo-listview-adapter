package com.jm.adapters;

public class DataModel {

	private int id;
	private boolean isLike;

	public DataModel(int id, boolean isLike) {
		this.id = id;
		this.isLike = isLike;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}
}
