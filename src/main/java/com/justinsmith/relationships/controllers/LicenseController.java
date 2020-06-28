package com.justinsmith.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.justinsmith.relationships.models.License;
import com.justinsmith.relationships.models.Person;
import com.justinsmith.relationships.services.LicenseService;

@Controller
public class LicenseController {

	Integer counter = 0;
	@Autowired
	private LicenseService licenseService;
	
	@Autowired
	private LicenseService personService;
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> people = personService.allPersons();
		model.addAttribute("people", people);
		return "/relationships/newLicense.jsp";
	}
	
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license")License license,BindingResult result, Model model,
								@RequestParam("number") String number) {
		if(result.hasErrors()) {
			return "/relationships/person.jsp";
		} else {
			counter = counter + 1;
			number = number + counter;
			license.setNumber(number);
			licenseService.createLicense(license);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping("/delete/license/{id}")
		public void deletePerson(Long id) {
			licenseService.deleteLicense(id);
		}
	
	@RequestMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		Person people = personService.findPersonById(id);
//		License license = licenseService.findLicenseById(id);
		model.addAttribute("people", people);
//		model.addAttribute("license", license);
		return "/relationships/person.jsp";
		
	}
}


