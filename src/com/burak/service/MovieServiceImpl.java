package com.burak.service;

import java.util.List;

import com.burak.dao.MovieRepository;
import com.burak.dao.MovieRepositoyImpl;
import com.burak.model.Movie;

public class MovieServiceImpl implements MovieService {

	MovieRepository movieRepositoy = new MovieRepositoyImpl();

	@Override
	public List<Movie> findMovies(String word) {

		return movieRepositoy.findMovies(word);
	}

	@Override
	public String getDescription(Movie movie) {
		return movieRepositoy.getDescrption(movie);

	}

}
