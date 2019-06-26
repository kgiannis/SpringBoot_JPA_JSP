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
 * XML examples
 * 
 * @author ykarav
 *
 */
@RestController
public class PersonRestControllerXML {

	@Autowired
	private PersonService personService;
	
	
	//-------------- GET --------------//
		
	// USE: http://localhost:8080/xml/person/1
	@RequestMapping(value = {"/xml/person/{id}"}, method=RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Person> xmlFindById(@PathVariable Long id){
		System.out.println("Inside: xfind");
		if ( personService.findById(id) == null ){
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Person>(personService.findById(id), HttpStatus.OK);
		}
	}
	
	// USE: http://localhost:8080/xml/persons
	@RequestMapping(value = "/xml/persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    	public ResponseEntity<List<Person>> xmlFindAll() {
		List<Person> users = personService.findAll();
		if(users.isEmpty()){
		    return new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Person>>(users, HttpStatus.OK);
    }	
	
	
	
	//-------------- POST --------------//
	
	//USE: http://localhost:8080/xml/person?name=qaz&surname=wsx
	@RequestMapping(value = {"/xml/person"}, method=RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	public void xmlAddPersonParams(@RequestParam String name, @RequestParam String surname){
		Person p = new Person();
		p.setName(name);
		p.setSurname(surname);
		p.setAge(10);
		personService.save(p);
	}
	
	//USE: http://localhost:8080/xml/person/qaz/wsx
	@RequestMapping(value = {"/xml/person/{name}/{surname}"}, method=RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Person> xmlAddPersonVars(@PathVariable String name, @PathVariable String surname){
		Person p = new Person();
		p.setName(name);
		p.setSurname(surname);
		p.setAge(10);
		personService.save(p);
		return new ResponseEntity<Person>(HttpStatus.OK);
	}
				
}
