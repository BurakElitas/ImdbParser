package com.burak.service;

import java.util.List;

import com.burak.model.Movie;

public interface MovieService {
   List<Movie> findMovies(String word);
   String getDescription(Movie movie);
}
