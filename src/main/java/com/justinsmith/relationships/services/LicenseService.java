package com.justinsmith.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.justinsmith.relationships.models.License;
import com.justinsmith.relationships.models.Person;
import com.justinsmith.relationships.repositories.LicenseRepository;
import com.justinsmith.relationships.repositories.PersonRepository;

@Service
public class LicenseService {

	@Autowired
	private LicenseRepository licenseRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	//return all persons
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	
	//create a person
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person findPersonById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		if(person.isPresent()) {
			return person.get();
		} else {
			return null;
		}
	}
	
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
	
	
	
	//returns all licenses
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	
	//create a license
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
	
	public License findLicenseById(Long id) {
		Optional<License> license = licenseRepository.findById(id);
		if(license.isPresent()) {
			return license.get();
		} else {
			return null;
		}
	}
	
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
	}
	
}
