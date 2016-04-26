package com.taimeng.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taimeng.model.Person;

/**
 * Person的dao接口
 * @author gaoyong
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long>{

}
