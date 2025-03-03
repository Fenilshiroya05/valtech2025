package com.valtech.training.first.entities;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
public class Book {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookidseq")
	@SequenceGenerator(name = "bookidseq",sequenceName = "book_seq",allocationSize = 1)
	private int id;
	private String name;
	private int price;
	private int year;
	
	@ManyToOne(targetEntity = Publishers.class) 
	@JoinColumn(name = "publisher_id",referencedColumnName = "id") // foreign key always write where ManyToOne define 
	private Publishers publisher;


	@ManyToMany(targetEntity = Author.class,fetch = FetchType.LAZY)
	@JoinTable(name="book_author",
	joinColumns = @JoinColumn(name="author_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="book_id",referencedColumnName = "id")) // for join table , also write in author class rather than here
	private List<Author> authors;
	
	
	public Book() {
	}

	public Book(String name, int price, int year) {
		super();
		this.name = name;
		this.price = price;
		this.year = year;
	}

	public void addAuthors(Author author) {
		if(authors == null)authors = new ArrayList<>();
			authors.add(author);
		if(author.getBooks()==null)author.setBooks(new ArrayList<>());
		author.getBooks().add(this);
	}
	public void removeAuthors(Author author) {
		authors.remove(author);
		author.getBooks().remove(this);
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Publishers getPublisher() {
		return publisher;
	}

	public void setPublisher(Publishers publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	

	
}
