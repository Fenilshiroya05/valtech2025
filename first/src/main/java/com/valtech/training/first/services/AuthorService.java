package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Author;
import com.valtech.training.first.entities.Question;

public interface AuthorService {

	Author saveAuthor(Author author);

	Author updateAuthor(Author author);

	void deleteAuthor(Author author);
	
	Author getAuthor(int id);

	List<Author> getAllAuthors();

	long getCountAllAuthors();
	

}