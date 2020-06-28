package com.justinsmith.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.justinsmith.relationships.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
	//retrieves all licenses from database
	List<License> findAll();
	
	//finds licenses by state containing search string
	List<License> findByStateContaining(String search);
}
