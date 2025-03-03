package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.entities.Publishers;

public interface PublisherService {

	Publishers savePublisher(Publishers publisher);

	Publishers updatePublisher(Publishers publisher);

	void deletePublisher(Publishers publisher);
	
	Publishers getPublisher(int id);

	List<Publishers> getAllPublishers();

	long getCountAllPublishers();
	
}