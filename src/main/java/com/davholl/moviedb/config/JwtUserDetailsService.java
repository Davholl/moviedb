package com.davholl.moviedb.config;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.davholl.moviedb.model.Movie;
import com.davholl.moviedb.model.MovieDBUserEntity;
import com.davholl.moviedb.repository.MovieDBUserEntityRepository;
import com.davholl.moviedb.util.Mensagem;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	MovieDBUserEntityRepository userRepository;

	@Override
	public MovieDBUser loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<MovieDBUserEntity> optionalUser = userRepository.findById(username);
		
		if (optionalUser.isEmpty()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		MovieDBUserEntity userEntity = optionalUser.get();
		
		MovieDBUser user = new MovieDBUser(userEntity.getUsername(), userEntity.getPassword(), new ArrayList<>());
		user.adicionarFilmesFavoritos(userEntity.getFavoritos());
		
		return user;
		
	}
	
	public ResponseEntity<?> addFavoriteMovie(String username, Movie movie)  {
		Optional<MovieDBUserEntity> optionalUser = userRepository.findById(username);
		
		if (optionalUser.isEmpty()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
		MovieDBUserEntity userEntity = optionalUser.get();
		
		userEntity.adicionarFilmeFavorito(movie);
		
		userRepository.save(userEntity);
		
		return new ResponseEntity<Mensagem>(new Mensagem(HttpStatus.CREATED), HttpStatus.CREATED);
	}

}
