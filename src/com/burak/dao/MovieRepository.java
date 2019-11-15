package com.burak.dao;

import java.util.List;

import com.burak.model.Movie;

public interface MovieRepository {
	List<Movie> findMovies(String word);
	String getDescrption(Movie movie);
	
}
