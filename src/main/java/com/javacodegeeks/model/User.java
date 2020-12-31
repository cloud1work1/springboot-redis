package com.javacodegeeks.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private long followers;
	
	public User() {}
	public User(String name, long followers) {
		super();
		this.name = name;
		this.followers = followers;
	}

	public long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getFollowers() {
		return followers;
	}

	public void setFollowers(long followers) {
		this.followers = followers;
	}
	
	
}
