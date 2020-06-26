package com.davholl.moviedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.davholl.moviedb.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@RequestMapping("/")
	public String index() {
		return "testando se a página sobe";
	}
	
	@RequestMapping(value={"/movie/{movie_id}"}, method = RequestMethod.GET)
	public ResponseEntity<?> getDetails(@PathVariable("movie_id") Integer movieId) {
		return service.getDetails(movieId);
	}
	
	@RequestMapping(value={"/search/movie/{keyword}"}, method = RequestMethod.GET)
	public ResponseEntity<?> searchMoviesByTitle(@PathVariable("keyword") String keyword) {
		return service.searchMoviesByTitle(keyword);
	}
	
	@RequestMapping(value={"/movie/{movie_id}/rating"}, method = RequestMethod.POST)
	public ResponseEntity<?> rateMovie(@PathVariable("movie_id") Integer movieId, @RequestBody Long rate) {
		return service.rateMovie(movieId, rate);
	}
	
	@RequestMapping(value={"/movie/{movie_id}/favorite"}, method = RequestMethod.POST)
	public ResponseEntity<?> addFavoriteMovie(@PathVariable("movie_id") Integer movieId) {
		return service.addFavoriteMovie(movieId);
	}

}
