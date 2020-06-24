package com.davholl.moviedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country {
	@Id
	@GeneratedValue
	private Integer id;

	private String iso_3166_1;
	
	private String name;
	
	public Integer getId() {
		return id;
	}

	public String getIso_3166_1() {
		return iso_3166_1;
	}

	public String getName() {
		return name;
	}
}
