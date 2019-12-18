package com.softtek.academia.model;

public class City {
	
	private Integer id;
	private String description;
	private State state;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "City [id=" + id + ", description=" + description + ", state=" + state + "]";
	}
	
	
	
//	
	

}
