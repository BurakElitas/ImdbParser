package com.burak.dao;

import java.util.List;

import com.burak.model.Movie;
import com.burak.model.Star;

public interface StarRepository {
	List<Star> getStars(Movie movie);
}
