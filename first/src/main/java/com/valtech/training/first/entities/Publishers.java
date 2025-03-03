package com.valtech.training.first.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publishers {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pidseq")
	@SequenceGenerator(name = "pidseq",sequenceName = "pub_seq",allocationSize = 1)
	private int id;
	private String name;
	
	@OneToMany(targetEntity = Book.class,mappedBy = "publisher",cascade = CascadeType.ALL) 
	private List<Book> books;

	
	
	public Publishers() {
	}

	public Publishers(String name, List<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBooks(Book book) {
		if(books == null)
			books = new ArrayList<>();
			books.add(book);
			book.setPublisher(this);
	}
	public void removeBooks(Book book) {
			books.remove(book);
			book.setPublisher(null);
	}
	
	
}
