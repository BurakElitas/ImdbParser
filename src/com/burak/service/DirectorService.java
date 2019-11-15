package com.burak.service;

import java.util.List;

import com.burak.model.Director;
import com.burak.model.Movie;

public interface DirectorService {
	List<Director> getDirectors(Movie movie);
}
