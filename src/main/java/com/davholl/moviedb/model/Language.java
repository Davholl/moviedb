package com.davholl.moviedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Language {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String iso_639_1;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public String getIso_639_1() {
		return iso_639_1;
	}

	public String getName() {
		return name;
	}
}
