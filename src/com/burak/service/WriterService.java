package com.burak.service;

import java.util.List;

import com.burak.model.Movie;
import com.burak.model.Writer;

public interface WriterService {
	List<Writer> getWriters(Movie movie);
}
