package com.burak.service;

import java.util.List;

import com.burak.dao.DirectorRepository;
import com.burak.dao.DirectorRepositoryImpl;
import com.burak.model.Director;
import com.burak.model.Movie;

public class DirectorServiceImpl implements DirectorService {

	private DirectorRepository directorRepository=new DirectorRepositoryImpl();
	@Override
	public List<Director> getDirectors(Movie movie) {
		
		return directorRepository.getDirector(movie);
	}
	

}
