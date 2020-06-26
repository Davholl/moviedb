package com.davholl.moviedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "testando se a página sobre";
	}
	
	@RequestMapping(value={"/movie/{movie_id}"}, method = RequestMethod.GET)
	public ResponseEntity<?> getDetails(@PathVariable("movie_id") Integer movieId) {
		return service.getDetails(movieId);
	}
	
	
}
