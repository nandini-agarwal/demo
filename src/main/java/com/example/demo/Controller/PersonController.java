package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Person;
import com.example.demo.Service.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	public final PersonService personService;

	Logger logger = LoggerFactory.getLogger(getClass());

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addPerson(@RequestBody Person person) {
		Boolean response = personService.createPerson(person);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Optional<Person>> getPersonById(@PathVariable UUID id) {
		Optional<Person> result = personService.getPersonById(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> result = personService.getAllPersons();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Person>> updatePersonById(@RequestBody Person person) {
		Optional<Person> result = personService.updatePerson(person);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Boolean> deletePersonById(@PathVariable UUID id) {
		Boolean result = personService.removePersonById(id);
		return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
	}
}