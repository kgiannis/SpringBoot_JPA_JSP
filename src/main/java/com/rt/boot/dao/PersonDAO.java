package com.rt.boot.dao;

import org.springframework.stereotype.Repository;

import com.rt.boot.model.Person;

/**
 * DAO of Person Entity
 * 
 * @author ykarav
 *
 */
@Repository
public class PersonDAO extends GenericDAO<Person> {

	public PersonDAO() {
		setClazz(Person.class);
	}
	
}
