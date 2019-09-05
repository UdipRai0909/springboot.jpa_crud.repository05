package com.sursatech.people_mgmt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sursatech.people_mgmt.entities.Person;
import com.sursatech.people_mgmt.service.PeopleMgmtService;


@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private PeopleMgmtService peopleMgmtService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		getPersonsInfoByLastName();		
		getPersonsInfoByLastNameAndEmail();
	}

	private void getPersonsInfoByLastNameAndEmail() {
		List<Person> personList = peopleMgmtService.getPersonsInfoByLastNameAndEmail("Rai", "hmm@gmail.com");
		personList.forEach(System.out::println);;
	}

	private void getPersonsInfoByLastName() {
		List<Person> personList = peopleMgmtService.getPersonsInfoByLastName("Rai");
		personList.forEach(System.out::println);
	}	
}
