package com.valtech.training.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment.entities.Item;


@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {

}
