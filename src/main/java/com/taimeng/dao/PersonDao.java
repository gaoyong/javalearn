package com.taimeng.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.taimeng.model.Person;


public class PersonDao {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA"); 
	
	
	public void save(Person person){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(person); //持久化实体
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
