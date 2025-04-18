package com.valtech.training.first.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.first.entities.Author;
import com.valtech.training.first.entities.Question;


@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer>{

	List<Question> findAllByName(String name);

}
