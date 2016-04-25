package com.taimeng.service;

import com.taimeng.dao.PersonDao;
import com.taimeng.model.Person;

public class PersonService {
	
	private PersonDao personDao=new PersonDao();
	
	public void savePerson(Person person){
		personDao.save(person);
	}

}
