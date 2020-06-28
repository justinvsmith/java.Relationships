package com.justinsmith.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.justinsmith.relationships.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	
	//retrieves all the persons from the database
	List<Person> findAll();
	
	//finds people with firstName containing search string
	List<Person> findByFirstNameContaining(String search);
	
	
}
