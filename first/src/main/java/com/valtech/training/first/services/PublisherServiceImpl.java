package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.entities.Author;
import com.valtech.training.first.entities.Publishers;
import com.valtech.training.first.repos.PublisherRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PublisherServiceImpl implements PublisherService {
	
	@Autowired
	private PublisherRepo publisherRepo;

	@Override
	public Publishers savePublisher(Publishers publisher) {
		return publisherRepo.save(publisher);
	}

	@Override
	public Publishers updatePublisher(Publishers publisher) {
		return publisherRepo.save(publisher);
	}

	@Override
	public void deletePublisher(Publishers publisher) {
		publisherRepo.delete(publisher);
	}

	@Override
	public Publishers getPublisher(int id) {
		return publisherRepo.getReferenceById(id);
	}
	
	@Override
	public List<Publishers> getAllPublishers(){
		return publisherRepo.findAll();
	}
	
	@Override
	public long getCountAllPublishers() {
		return publisherRepo.count();
	}
}
