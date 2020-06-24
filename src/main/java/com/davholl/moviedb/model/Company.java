package com.davholl.moviedb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String logoPath;
	
	private String originCountry;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public String getOriginCountry() {
		return originCountry;
	}
}
