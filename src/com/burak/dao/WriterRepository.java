package com.burak.dao;

import java.util.List;

import com.burak.model.Movie;
import com.burak.model.Writer;

public interface WriterRepository {
  List<Writer> writers(Movie movie);
}
