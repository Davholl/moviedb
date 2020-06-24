package com.davholl.moviedb.service;

import org.springframework.http.ResponseEntity;

public interface MovieService {
	
	ResponseEntity<?> getDetails(Integer movieId);

}
