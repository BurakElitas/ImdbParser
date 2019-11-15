package com.burak.model;

import java.util.ArrayList;
import java.util.List;

public class Writer extends Cast {
	
	private List<Movie> movies;
	

	public Writer(String id, String name, String link) {
		super(id, name, link);
		super.setType(Cast_Type.Writer);
		movies=new ArrayList<Movie>();
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Movie movie) {
		this.movies.add(movie);
	}

	@Override
	public String toString() {
		return "Writer [getMovies()=" + getMovies() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getLink()=" + getLink() + ", getType()=" + getType() + "]";
	}
	
	

}
	