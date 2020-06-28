package com.justinsmith.relationships.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.justinsmith.relationships.models.Person;
import com.justinsmith.relationships.services.LicenseService;

@Controller
public class PersonController {

	@Autowired
	LicenseService personService;
	
	
	@RequestMapping("persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/relationships/newPerson.jsp";
	}
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person")Person person,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/relationships/newPerson.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping("/delete/person/{id}")
		public void deletePerson(Long id) {
			personService.deletePerson(id);
		}
}
