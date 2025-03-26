package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.MovieService;
import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.vos.MovieVO;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@RestController
@RequestMapping("/api/v1/contents")
public class ContentController {

	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private WebSeriesService webSeriesService;
	
	@PostMapping("/movies/")
	public MovieVO addMovie(@RequestBody MovieVO vo) {
		return movieService.createOrUpdateMovie(vo);
	}
	@GetMapping("/movies/")
	public List<MovieVO> getAllMovies(){
		return movieService.getAllMovies();
	}
	@GetMapping("/movies/genre/{genre}")
	public List<MovieVO> getMoviesByGenre(@PathVariable("genre") String genre){
		return movieService.getAllMoviesByGenre(genre);
	}
	@GetMapping("/movies/genre/{genre}/language/{language}")
	public List<MovieVO> getMoviesByGenreAndLanguage(@PathVariable("genre") String genre,@PathVariable("language") String language){
		return movieService.getAllMoviesByGenreAndLanguage(genre,language);
	}
	@GetMapping("/movies/{id}")
	public MovieVO getMovieById(@PathVariable("id") long id) {
		return movieService.getMovieById(id);
	}
	
	@PostMapping("/webseries/")
	public WebSeriesVO addWebSeries(@RequestBody WebSeriesVO vo) {
		return webSeriesService.createOrUpdateWebSeries(vo);
	}
	@GetMapping("/webseries/webseries/")
	public List<WebSeriesVO> getAllWebSeries(){
		return webSeriesService.getAllWebSeries();
	}
	@GetMapping("/webseries/episodeCount/{count}")
	public List<WebSeriesVO> getWebSeriesByEpisodeCount(@PathVariable("count") int count){
		return webSeriesService.getAllWebSeriesByEpisodeCount(count);
	}
	@GetMapping("/webseries/duration/{duration}")
	public List<WebSeriesVO> getWebSeriesByEpisodeDuration(@PathVariable("duration") long duration){
		return webSeriesService.getAllWebSeriesByEpisodeDuration(duration);
	}
	@GetMapping("/webseries/{id}")
	public WebSeriesVO getWebSeriesById(@PathVariable("id") long id) {
		return webSeriesService.getWebSeriesById(id);
	}
}
