package com.burak.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.burak.model.Movie;

public class MovieRepositoyImpl extends ImdbHelper implements MovieRepository {

	@Override
	public List<Movie> findMovies(String word) {

		try {

			List<String> links = new ArrayList<String>();
			List<String> ids = new ArrayList<String>();
			List<String> names = new ArrayList<String>();
			List<String> imgUrls = new ArrayList<String>();
			List<Movie> movies = new ArrayList<Movie>();
			String page = super.getPage("https://www.imdb.com/find?ref_=nv_sr_fn&q=" + word + "&s=all");
			String result = super.getSource(page, "\" ><img src=\"", "</table>");
			String linkRegex = "[t]{2}[0-9]{7}[/?]{2}[a-z]{3}[_=]{2}[a-z]{2}[_]{1}[a-z]{2}[_]{1}[a-z]{2}[_]{1}[0-9]{1}";
			String idRegex = "[0-9]{7}";

			String imgRegex = "[/M]{2}[/]{1}[a-zA-Z,0-9,@]*";

			String nameRegex = "[>]{1}[a-zA-Z,:]{4,}";
			// String nameRegex = "[>]{1}[a-zA-Z]*{2,}[ ]{1}[a-zA-Z]*[<]{1}";
			Pattern linkPattern = Pattern.compile(linkRegex);
			Matcher linkMatcher = linkPattern.matcher(result);
			Pattern namePattern = Pattern.compile(nameRegex);
			Matcher nameMatcher = namePattern.matcher(result);

			Pattern idPattern = Pattern.compile(idRegex);
			Matcher idMatcher = idPattern.matcher(result);

			Pattern imgPattern = Pattern.compile(imgRegex);
			Matcher imgMatcher = imgPattern.matcher(result);
			while (linkMatcher.find()) {

				if (links.contains("https://www.imdb.com/title/" + linkMatcher.group()))
					continue;
				links.add("https://www.imdb.com/title/" + linkMatcher.group());
			}

			while (idMatcher.find()) {

				if (ids.contains(idMatcher.group()))
					continue;
				ids.add(idMatcher.group());
			}

			while (nameMatcher.find()) {
				names.add(nameMatcher.group().replaceAll(">", ""));
				// System.out.println(nameMatcher.group());
			}
			while (imgMatcher.find()) {
				imgUrls.add("https://m.media-amazon.com/images" + imgMatcher.group() + "._V1_UX32_CR0,0,32,44_AL_.jpg");

			}
			for (int i = 0; i < names.size(); i++) {
				Movie movie = new Movie(ids.get(i), names.get(i), links.get(i), imgUrls.get(i));
				movies.add(movie);
			}

			return movies;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public String getDescrption(Movie movie) {
		String description = "";
		String url = movie.getLink();
		String page = super.getPage(url);
		String result = super.getSource(page, "summary_text\">                    ",
				"</div>    <div class=\"credit_summary_item\">");
		String descriptionRegex = "[a-zA-Z]*";

		Pattern descriptionPattern = Pattern.compile(descriptionRegex);
		Matcher descriptionMatcher = descriptionPattern.matcher(result);
		while (descriptionMatcher.find()) {

			description += " " + descriptionMatcher.group();
		}

		return description;
	}

}
