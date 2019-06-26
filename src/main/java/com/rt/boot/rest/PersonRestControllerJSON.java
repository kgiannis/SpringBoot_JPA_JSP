package com.rt.boot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rt.boot.model.Person;
import com.rt.boot.service.PersonService;

/**
 * REST Controller for Person Entity
 * JSON Examples
 * 
 * @author ykarav
 *
 */
@RestController
public class PersonRestControllerJSON {

	@Autowired
	private PersonService personService;
	
	
	//-------------- GET --------------//
	
	//USE: http://localhost:8080/persons
	@RequestMapping(value = {"/persons"}, method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> restListPersons(){
		return personService.findAll();
	}
	
	//USE: http://localhost:8080/person?name=qaz&surname=wsx
	@RequestMapping(value = {"/person"}, method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void restPersonParams(@RequestParam String name, @RequestParam String surname){
		System.out.println("1. Name: " + name);
		System.out.println("1. Surname: " + surname);
	}
	
	//USE: http://localhost:8080/person/qaz/wsx
	@RequestMapping(value = {"/person/{name}/{surname}"}, method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void restPersonVars(@PathVariable String name, @PathVariable String surname){
		System.out.println("2. Name: " + name);
		System.out.println("2. Surname: " + surname);
	}
	
	//USE: http://localhost:8080/v2/persons
	@RequestMapping(value = "/v2/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    	public ResponseEntity<List<Person>> listAllPersons() {
        	List<Person> users = personService.findAll();
        	if(users.isEmpty()){
            		return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
        	}
        	return new ResponseEntity<List<Person>>(users, HttpStatus.OK);
    	}
	
	//USE: http://localhost:8080/person/1
	@RequestMapping(value = {"/person/{id}"}, method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> jsonFindById(@PathVariable Long id){
		if ( personService.findById(id) == null ){
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Person>(personService.findById(id), HttpStatus.OK);
		}
	}
	
	
	//-------------- POST --------------//
	
	//USE: http://localhost:8080/person?name=qaz&surname=wsx
	@RequestMapping(value = {"/person"}, method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void restAddPersonParams(@RequestParam String name, @RequestParam String surname){
		Person p = new Person();
		p.setName(name);
		p.setSurname(surname);
		p.setAge(10);
		personService.save(p);
	}
	
	//USE: http://localhost:8080/person/qaz/wsx
	@RequestMapping(value = {"/person/{name}/{surname}"}, method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void restAddPersonVars(@PathVariable String name, @PathVariable String surname){
		Person p = new Person();
		p.setName(name);
		p.setSurname(surname);
		p.setAge(10);
		personService.save(p);
	}
	
	//USE: http://localhost:8080/v2/person/qaz/wsx
	@RequestMapping(value = {"/v2/person/{name}/{surname}"}, method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> restAddPersonVars2(@PathVariable String name, @PathVariable String surname){
		Person p = new Person();
		p.setName(name);
		p.setSurname(surname);
		p.setAge(10);
		personService.save(p);
		return new ResponseEntity<Person>(HttpStatus.OK);
	}
	
}
