package com.davholl.moviedb.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Boolean adult;

	private String backdropPath;

	private Boolean belongsToCollection;
	
	private Integer budget;
	
	@ManyToMany
	private Set<Genre> genres;
	
	private String homepage;
	
//	to_do
//	minLength: 9
//	maxLength: 9
//	pattern: ^tt[0-9]{7}
	private String imdb_id;
	
	private String originalLanguage;

	private String originalTitle;
	
	private String overview;
	
	private Long popularity;
	
	private String posterPath;
	
	@ManyToMany
	private Set<Company> productionCompanies;
	
	@ManyToMany
	private Set<Country> productionCountries;
	
	private Date releaseDate;
	
	private Integer revenue;
	
	private Integer runtime;
	
	@ManyToMany
	private Set<Language> spokenLanguages;
	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	private String tagline;
	
	private String title;
	
	private Boolean video;
	
	private Long voteAverage = 0L;
	
	private Integer voteCount = 0;

	public Integer getId() {
		return id;
	}

	public Boolean getAdult() {
		return adult;
	}

	public String getBackdropPath() {
		return backdropPath;
	}

	public Object getBelongsToCollection() {
		return belongsToCollection;
	}

	public Integer getBudget() {
		return budget;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public String getOriginalLanguage() {
		return originalLanguage;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public String getOverview() {
		return overview;
	}

	public Long getPopularity() {
		return popularity;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public Set<Company> getProductionCompanies() {
		return productionCompanies;
	}

	public Set<Country> getProductionCountries() {
		return productionCountries;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public Integer getRevenue() {
		return revenue;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public Set<Language> getSpokenLanguages() {
		return spokenLanguages;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public String getTagline() {
		return tagline;
	}

	public String getTitle() {
		return title;
	}

	public Boolean getVideo() {
		return video;
	}

	public Long getVoteAverage() {
		return voteAverage;
	}

	public Integer getVoteCount() {
		return voteCount;
	}

	public void setVoteAverage(Long voteAverage) {
		this.voteAverage = voteAverage;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	
}
