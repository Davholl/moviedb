package com.davholl.moviedb.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.davholl.moviedb.MoviedbApplication;
import com.davholl.moviedb.model.Movie;
import com.davholl.moviedb.util.Mensagem;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoviedbApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerITest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void getDetails() {
		Integer movieId = 1;
		assertTrue(
                this.restTemplate
                    .getForObject("http://localhost:" + port + "/movie/{movie_id}", Movie.class, movieId)
                    .getId().equals(1));
	}
	
	@Test
	public void rateMovie() {
		Integer movieId = 1;
		ResponseEntity<Mensagem> responseEntity = this.restTemplate.postForEntity("http://localhost:" + port + "/movie/{movie_id}/rating", null, Mensagem.class, movieId);
		assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
	}
}
