package com.davholl.moviedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davholl.moviedb.model.MovieDBUserEntity;

@Repository
public interface MovieDBUserEntityRepository extends JpaRepository<MovieDBUserEntity, String>{


}
