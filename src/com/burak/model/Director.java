package com.burak.model;

import java.util.ArrayList;
import java.util.List;

public class Director extends Cast {
	private List<Movie> movies;
	public Director(String id, String name, String link) {
		super(id, name, link);
		super.setType(Cast_Type.Director);
		this.movies=new ArrayList<Movie>();
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Movie movie) {
		this.movies.add(movie);
	}
	@Override
	public String toString() {
		return "Director [getMovies()=" + getMovies() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getLink()=" + getLink() + ", getType()=" + getType() + "]";
	}
	
	
}
