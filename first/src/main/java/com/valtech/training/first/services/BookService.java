package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Question;

public interface BookService {

	Book saveBook(Book book);

	Book updateBook(Book book);

	void deleteBook(Book book);
	
	Book getBook(int id);

	List<Book> getAllBooks();

	long getCountAllBooks();

	List<Book> findAllByYearBetween(int i, int j);

	List<Book> findAllByPriceGreaterThan(int i);

//	List<Book> findAllAuthorsId(int i);

	List<Integer> findAllPriceByAuthorsId(int i);

	List<BookInfoDTO> getBookInfoByAuthor(int i);


}