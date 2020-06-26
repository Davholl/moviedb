package com.davholl.moviedb.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.davholl.moviedb.model.Movie;

public class MovieDBUser extends User{
	
	private Set<Movie> favoriteMovies = new HashSet<Movie>();
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3569883368919021222L;

	public MovieDBUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
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
