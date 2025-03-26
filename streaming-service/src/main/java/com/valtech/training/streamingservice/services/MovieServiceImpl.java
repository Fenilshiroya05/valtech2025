package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.entities.Movie;
import com.valtech.training.streamingservice.repos.MovieRepo;
import com.valtech.training.streamingservice.vos.MovieVO;



@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Override
	public MovieVO createOrUpdateMovie(MovieVO vo) {
		return MovieVO.from(movieRepo.save(vo.to()));
	}
	
	@Override
	public List<MovieVO> getAllMovies(){
		return MovieVO.from(movieRepo.findAll());
	}
	
	@Override
	public MovieVO getMovieById(long id) {
		return MovieVO.from(movieRepo.getReferenceById(id));
	}
	
	@Override
	public List<MovieVO> getAllMoviesByGenre(String genre){
		return MovieVO.from(movieRepo.findAllByGenre(genre));
	}
	
	@Override
	public List<MovieVO> getAllMoviesByGenreAndLanguage(String genre,String language){
		return MovieVO.from(movieRepo.findAllByGenreAndLanguage(genre, language));
	}
}
