package com.valtech.training.jaws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.jaws.Movie;
import com.valtech.training.jaws.repos.MovieRepo;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo movieReo;
	
	
	@Override
	public List<Movie> getAllMovies(){
		return movieReo.findAll();
	}
	
	@Override
	public Movie getMovie(long id) {
		return movieReo.getReferenceById(id);
	}
	
	@Override
	public Movie createMovie(Movie m) {
		return movieReo.save(m);
	}
}
