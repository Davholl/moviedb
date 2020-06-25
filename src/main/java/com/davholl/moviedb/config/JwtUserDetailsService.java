package com.davholl.moviedb.config;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.davholl.moviedb.model.Movie;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public MovieDBUser loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("joaocouve".equals(username)) {
			MovieDBUser user = new MovieDBUser("joaocouve", "$2a$10$CcKGa8P5VhGJVM3KBtHbVO9IRJSIaW7t5HQ3qJvFqlFB4KwqM4Oz2",
					new ArrayList<>());
			user.adicionarFilmeFavorito(new Movie());
			return user;
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
