package com.valtech.training.streamingservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.streamingservice.entities.WebSeries;

public record WebSeriesVO(String name, String genre,String language,long costPerView,int episodeCount,long episodeDuration) {

	public static  WebSeriesVO from(WebSeries w) {
		return new WebSeriesVO(w.getName(), w.getGenre(), w.getLanguage(), w.getCostPerView(), w.getEpisodeCount(), w.getEpisodeDuration());
	}
	
	public WebSeries to() {
		return new WebSeries(name, genre, language, costPerView, episodeCount, episodeDuration);
	}
	
	public static List<WebSeriesVO> from(List<WebSeries> w){
		return w.stream().map(ws-> WebSeriesVO.from(ws)).collect(Collectors.toList());
	}
}
