package com.burak.service;

import java.util.List;

import com.burak.model.Movie;
import com.burak.model.Star;

public interface StarService {
	List<Star> getStars(Movie movie);
}
