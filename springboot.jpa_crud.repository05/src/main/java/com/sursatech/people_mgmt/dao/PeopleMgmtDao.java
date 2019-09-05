package com.sursatech.people_mgmt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sursatech.people_mgmt.entities.Person;

public interface PeopleMgmtDao extends CrudRepository<Person, Integer> {

	@Query(value="SELECT p from Person p WHERE p.lastName=?1")
	List<Person> findByLastName(String lastName);
	
	@Query(value="SELECT p from Person p WHERE p.lastName=?1 AND email=?2")
	List<Person> findByLastNameAndEmail(String lastName, String email);
}
