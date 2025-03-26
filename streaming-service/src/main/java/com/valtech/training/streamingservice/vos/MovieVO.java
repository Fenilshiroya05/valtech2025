package com.valtech.training.streamingservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.streamingservice.entities.Movie;

public record MovieVO(String name, String genre,String language,long costPerView,long duration) {

	public static MovieVO from(Movie m) {
		return new MovieVO(m.getName(),m.getGenre(),m.getLanguage(),m.getCostPerView(),m.getDuration());
	}
	
	public Movie to() {
		return new Movie(name,genre,language,duration,costPerView);
	}
	
	public static List<MovieVO> from(List<Movie> m){
		return m.stream().map(ms-> MovieVO.from(ms)).collect(Collectors.toList());
	}
}
