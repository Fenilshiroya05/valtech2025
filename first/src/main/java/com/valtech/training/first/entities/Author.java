package com.valtech.training.first.entities;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
public class Author {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "auidseq")
	@SequenceGenerator(name = "auidseq",sequenceName = "author_seq",allocationSize = 1)
	private int id ;
	private String name;
	private String address;
	
	@ManyToMany(targetEntity = Book.class,mappedBy = "authors")
	private List<Book> books;
	
	public Author() {}

	public Author(String name, String address) {
		this.name = name;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
