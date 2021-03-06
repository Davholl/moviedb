package com.davholl.moviedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
