package com.davholl.moviedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davholl.moviedb.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
