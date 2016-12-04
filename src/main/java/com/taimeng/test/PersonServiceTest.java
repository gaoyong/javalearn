package com.taimeng.test;

import org.junit.Test;

import com.taimeng.model.Person;
import com.taimeng.service.PersonService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonServiceTest {

	@Test
	public void dateParse(){
		String dateStr = "2000-10-1 00:00:00";
		Date date = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = df.parse(dateStr);
			System.out.println("输出日期:" + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}


	@Test
	public void testSave(){
		PersonService personService=new PersonService();
		Person p=new Person();
		p.setName("testPerson");
		personService.savePerson(p);
	}

}
