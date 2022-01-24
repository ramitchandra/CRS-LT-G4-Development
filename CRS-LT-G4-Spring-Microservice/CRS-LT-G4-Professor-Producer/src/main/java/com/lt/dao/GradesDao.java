package com.lt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Grades;

@Repository
public interface GradesDao extends CrudRepository<Grades, Integer> {

	public Grades save(Grades grades);

}