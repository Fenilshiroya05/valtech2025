package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.MovieVO;

public interface MovieService {

	MovieVO createOrUpdateMovie(MovieVO vo);

	List<MovieVO> getAllMovies();

	MovieVO getMovieById(long id);

	List<MovieVO> getAllMoviesByGenre(String genre);

	List<MovieVO> getAllMoviesByGenreAndLanguage(String genre, String language);

}