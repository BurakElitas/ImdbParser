package com.burak.dao;

import java.util.List;

import com.burak.model.Director;
import com.burak.model.Movie;

public interface DirectorRepository {
	List<Director> getDirector(Movie movie);
}
