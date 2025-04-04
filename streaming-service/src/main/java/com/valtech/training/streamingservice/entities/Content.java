package com.valtech.training.streamingservice.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;

@MappedSuperclass
public class Content {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "contentSeq")
	@SequenceGenerator(name = "contentSeq",sequenceName = "content_seq",allocationSize = 1)
	private long id;
	private String name;
	private String genre;
	private String language;
	private long costPerView;
	
	
	public Content() {}
	public Content(String name, String genre, String language,long costPerView) {
		this.name=name;
		this.genre = genre;
		this.language = language;
		this.costPerView=costPerView;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setCostPerView(long costPerView) {
		this.costPerView = costPerView;
	}
	public long getCostPerView() {
		return costPerView;
	}
	
}
