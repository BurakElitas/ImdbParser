package com.burak.service;

import java.util.List;

import com.burak.dao.StarRepository;
import com.burak.dao.StarRepositoryImpl;
import com.burak.model.Movie;
import com.burak.model.Star;

public class StarServiceImpl implements StarService {

	private StarRepository starRepository = new StarRepositoryImpl();

	@Override
	public List<Star> getStars(Movie movie) {

		return starRepository.getStars(movie);
	}

}
