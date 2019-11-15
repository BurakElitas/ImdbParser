package com.burak.service;

import java.util.List;

import com.burak.dao.WriterRepository;
import com.burak.dao.WriterRepositoryImpl;
import com.burak.model.Movie;
import com.burak.model.Writer;

public class WriterServiceImpl implements WriterService {

	private WriterRepository writerRepository=new WriterRepositoryImpl();
	@Override
	public List<Writer> getWriters(Movie movie) {
		return writerRepository.writers(movie);
	}

}
