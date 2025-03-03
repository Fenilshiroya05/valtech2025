package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Author;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.BookRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public void deleteBook(Book book) {
		bookRepo.delete(book);
	}

	@Override
	public Book getBook(int id) {
		return bookRepo.getReferenceById(id);
	}
	@Override
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	@Override
	public long getCountAllBooks() {
		return bookRepo.count();
	}

	@Override
	public List<Book> findAllByYearBetween(int i, int j) {
		return bookRepo.findAllByYearBetween(i,j);
	}

	@Override
	public List<Book> findAllByPriceGreaterThan(int i) {
		return bookRepo.findAllByPriceGreaterThan(i);
	}
	
//	@Override
//	public List<Book> findAllAuthorsId(int i){
//		return bookRepo.findAllAuthorsId(i);
//	}

	@Override
	public List<Integer> findAllPriceByAuthorsId(int i) {
		// TODO Auto-generated method stub
		return bookRepo.findAllPriceByAuthorsId(i);
	}

	@Override
	public List<BookInfoDTO> getBookInfoByAuthor(int i) {
		return bookRepo.getBookInfoByAuthor(i);
	}
}
