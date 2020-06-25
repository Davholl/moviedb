package com.davholl.moviedb.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.davholl.moviedb.model.Movie;
import com.davholl.moviedb.repository.MovieRepository;
import com.davholl.moviedb.service.MovieService;
import com.davholl.moviedb.util.Mensagem;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepository repository;

	@Override
	public ResponseEntity<?> getDetails(Integer movieId) {
		Movie movienew = new Movie();
		repository.save(movienew);
		Optional<Movie> movie = repository.findById(movieId);
		
		if (movie.isPresent()) {
			return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<Mensagem>(new Mensagem(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
		}
	}

}
