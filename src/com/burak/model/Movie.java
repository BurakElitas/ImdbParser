package com.burak.model;

import java.util.ArrayList;
import java.util.List;

public class Movie extends Cast{

	private String imageUrl;
	private List<Director> directors;
	private List<Writer> writers;
	private List<Star> stars;
	public Movie(String id, String name, String link,String imageUrl) {
		super(id, name, link);
		super.setType(Cast_Type.Movie);
		this.imageUrl=imageUrl;
		directors=new ArrayList<Director>();
		writers=new ArrayList<Writer>();
		stars=new ArrayList<Star>();
	}
	public List<Director> getDirectors() {
		return directors;
	}
	public void setDirectors(Director director) {
		this.directors.add(director);
	}
	public List<Writer> getWriters() {
		return writers;
	}
	public void setWriters(Writer writer) {
		this.writers.add(writer);
	}
	public List<Star> getStars() {
		return stars;
	}
	public void setStars(Star star) {
		this.stars.add(star);
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Movie [getDirectors()=" + getDirectors() + ", getWriters()=" + getWriters() + ", getStars()="
				+ getStars() + ", getImageUrl()=" + getImageUrl() + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getLink()=" + getLink() + ", getType()=" + getType() + "]";
	}
	
	
	

}
