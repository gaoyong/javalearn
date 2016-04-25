package com.taimeng.test;

import org.junit.Test;

import com.taimeng.model.Person;
import com.taimeng.service.PersonService;

public class PersonServiceTest {
	
	
	
	
	@Test
	public void testSave(){
		PersonService personService=new PersonService();
		Person p=new Person();
		p.setName("testPerson");
		personService.savePerson(p);
	}

}
