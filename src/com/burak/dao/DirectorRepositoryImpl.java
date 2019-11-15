package com.burak.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.burak.model.Director;
import com.burak.model.Movie;

public class DirectorRepositoryImpl  extends ImdbHelper implements DirectorRepository {

	@Override
	public List<Director> getDirector(Movie movie) {
		try {
			
		
		List<String> links = new ArrayList<String>();
		List<String> ids = new ArrayList<String>();
		List<String> names = new ArrayList<String>();
		String page=super.getPage(movie.getLink());
		String source=super.getSource(page, "<div class=\"credit_summary_item\">", "<div class=\"credit_summary_item\">");
		System.out.println(source);
		String linkRegex = "[nm]{2}[0-9]{7}[/?]{2}[a-z]{3}[_=]{2}[a-z]{2}[_]{1}[a-z]{2}[_]{1}[a-z]{2}";
		String idRegex = "[0-9]{7}";
		String nameRegex = "[>]{1}[a-zA-Z]*{2,}[ ]{1}[a-zA-Z]*[<]{1}";
		
		Pattern linkPattern = Pattern.compile(linkRegex);
		Matcher linkMatcher = linkPattern.matcher(source);
		
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(source);
		
		Pattern idPattern = Pattern.compile(idRegex);
		Matcher idMatcher = idPattern.matcher(source);
		
		while(linkMatcher.find()) {
			links.add("https://www.imdb.com/name/"+linkMatcher.group());
		}
		while(nameMatcher.find()) {
			names.add(nameMatcher.group().replaceAll("<","").replaceAll(">",""));
			System.out.println(nameMatcher.group());
		}
		while(idMatcher.find()) {
			ids.add(idMatcher.group());
			
		}
		for (int i = 0; i < names.size(); i++) {
			Director director = new Director(ids.get(i), names.get(i), links.get(i));
			director.setMovies(movie);
			movie.setDirectors(director);
		}
		return movie.getDirectors();
		}
		catch (Exception e) {
			return null;
		}
	}

}
