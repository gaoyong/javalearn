package com.taimeng.dao;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.taimeng.Application4EmbedTomcat;
import com.taimeng.model.Person;


/**
 * 
 * @author gaoyong
 *
 */
@SpringApplicationConfiguration(classes = Application4EmbedTomcat.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest("server.port:8080")
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonRepositoryTest {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void findAllPerson_success(){
		List<Person> personList = personRepository.findAll();
		System.out.println("" + personList);
	}
	
	//TODO 这里还有问题，无法正常插入数据
	/**
	 *
	 */
	@Test
	public void saveOnePerson_success(){
		Person person = new Person();
		person.setName("testGaoyong");

		person = personRepository.save(person);
		
		personRepository.flush();
		System.out.println("=======" + person);
		List<Person> personList = personRepository.findAll();
		System.out.println("" + personList);
	}

}
