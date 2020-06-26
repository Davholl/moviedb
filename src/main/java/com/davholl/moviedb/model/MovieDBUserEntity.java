package com.davholl.moviedb.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MovieDBUserEntity {
	
	@Id
	private String username;
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Movie> favoriteMovies;
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public Set<Movie> getFavoritos(){
		return Set.copyOf(this.favoriteMovies);
	}
	
	public void adicionarFilmeFavorito(Movie movie) {
		this.favoriteMovies.add(movie);
	}
	
	public void adicionarFilmesFavoritos(Set<Movie> movies) {
		this.favoriteMovies.addAll(movies);
	}
	
	public void removerFilmeFavorito(Movie movie) {
		this.favoriteMovies.remove(movie);
	}

}
