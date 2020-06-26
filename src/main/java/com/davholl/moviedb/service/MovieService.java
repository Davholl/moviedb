package com.davholl.moviedb.service;

import org.springframework.http.ResponseEntity;

public interface MovieService {
	
	ResponseEntity<?> getDetails(Integer movieId);

	ResponseEntity<?> searchMoviesByTitle(String keyword);

	ResponseEntity<?> rateMovie(Integer movieId, Long rate);

	ResponseEntity<?> addFavoriteMovie(Integer movieId);

}
