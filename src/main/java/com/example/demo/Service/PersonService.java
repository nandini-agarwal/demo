package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Person;
import com.example.demo.Repository.PersonRepository;

@Service
public class PersonService {

	public final PersonRepository personRepository;
	Logger logger = LoggerFactory.getLogger(getClass());

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Transactional
	public Boolean createPerson(Person person) {
		try {
			Person newPerson = new Person();
			newPerson.setId(UUID.randomUUID());
			newPerson.setName(person.getName());
			newPerson.setDob(person.getDob());
			newPerson.setEmailId(person.getEmailId());
			newPerson.setNumber(person.getNumber());
			Person result = personRepository.save(newPerson);
			logger.info("Successfully created Person:" + result);
			return true;
		} catch (Exception e) {
			logger.error("Error occurred: " + e);
			return false;
		}
	}

	public Optional<Person> getPersonById(UUID id) {
		try {
			if (id == null) {
				throw new RuntimeException("Person does not exist.");
			} else {
				Optional<Person> result = personRepository.findById(id);
				logger.info("Successfully fetched Person by id:" + result);
				return result;
			}
		} catch (Exception e) {
			logger.error("Error occurred: " + e);
			return Optional.empty();
		}
	}

	public List<Person> getAllPersons() {
		try {
			List<Person> result = personRepository.findAll();
			logger.info("Successfully fetched all persons");
			return result;
		} catch (Exception e) {
			logger.error("Error occurred: " + e);
			return new ArrayList<>();
		}
	}

	@Transactional
	public Boolean removePersonById(UUID id) {
		try {
			if (id == null) {
				throw new RuntimeException("Person does not exist.");
			} else {
				personRepository.deleteById(id);
				return true;
			}
		} catch (Exception e) {
			logger.error("Error occurred: " + e);
			return false;
		}
	}

	@Transactional
	public Optional<Person> updatePerson(Person person) {
		try {
			if ((person.getId() == null) || (!(personRepository.findById(person.getId()).isPresent()))) {
				throw new RuntimeException("Person does not exist.");
			}
			Optional<Person> result = personRepository.findById(person.getId());
			Person newPerson = new Person();
			newPerson.setId(person.getId());
			newPerson.setName(person.getName());
			newPerson.setDob(person.getDob());
			newPerson.setEmailId(person.getEmailId());
			newPerson.setNumber(person.getNumber());
			personRepository.deleteById(person.getId());
			personRepository.save(newPerson);
			return Optional.of(newPerson);
		} catch (Exception e) {
			logger.error("Error occurred: " + e);
			return Optional.empty();
		}
	}
}

