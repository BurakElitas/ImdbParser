package com.burak.model;

import java.util.ArrayList;
import java.util.List;

public class Star extends Cast {
	
	private List<Movie> movies;

	public Star(String id, String name, String link) {
		super(id, name, link);
		super.setType(Cast_Type.Star);
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
		return "Star [getMovies()=" + getMovies() + ", getId()=" + getId() + ", getName()=" + getName() + ", getLink()="
				+ getLink() + ", getType()=" + getType() + "]";
	}
	
	

}
