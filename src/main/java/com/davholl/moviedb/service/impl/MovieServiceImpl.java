package com.davholl.moviedb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.davholl.moviedb.config.JwtUserDetailsService;
import com.davholl.moviedb.config.MovieDBUser;
import com.davholl.moviedb.model.Movie;
import com.davholl.moviedb.model.MovieDBUserEntity;
import com.davholl.moviedb.repository.MovieDBUserEntityRepository;
import com.davholl.moviedb.repository.MovieRepository;
import com.davholl.moviedb.service.MovieService;
import com.davholl.moviedb.util.Mensagem;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	JwtUserDetailsService userService;

	@Override
	public ResponseEntity<?> getDetails(Integer movieId) {
		Optional<Movie> movie = movieRepository.findById(movieId);
		
		if (movie.isPresent()) {
			return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<Mensagem>(new Mensagem(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public ResponseEntity<?> searchMoviesByTitle(String keyword) {
		List<Movie> movies = movieRepository.findByTitleContaining(keyword);
		
		if (!movies.isEmpty()) {
			return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
		}else {
			return new ResponseEntity<Mensagem>(new Mensagem(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public ResponseEntity<?> rateMovie(Integer movieId, Long rate) {
		Optional<Movie> optionalMovie = movieRepository.findById(movieId);

		if (optionalMovie.isPresent()) {
			
			Movie movie = optionalMovie.get();
			
			movie.setVoteCount(movie.getVoteCount() + 1);
			movie.setVoteAverage(calculateNewAverage(movie.getVoteAverage(), movie.getVoteCount(), rate));
			
			movieRepository.save(movie);
			
			return new ResponseEntity<Mensagem>(new Mensagem(HttpStatus.CREATED), HttpStatus.CREATED);
			
		}else {
			return new ResponseEntity<Mensagem>(new Mensagem(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
		}
	}
	
	@Override
	public ResponseEntity<?> addFavoriteMovie(Integer movieId) {
		Optional<Movie> optionalMovie = movieRepository.findById(movieId);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		if (optionalMovie.isPresent()) {
			
			Movie movie = optionalMovie.get();
			
			return userService.addFavoriteMovie(username, movie);
			
		}else {
			return new ResponseEntity<Mensagem>(new Mensagem(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
		}
	}
	
	private Long calculateNewAverage(Long average, Integer voteCount, Long rate)
	{
	    return (voteCount * average + rate) / (voteCount + 1);
	}

}
