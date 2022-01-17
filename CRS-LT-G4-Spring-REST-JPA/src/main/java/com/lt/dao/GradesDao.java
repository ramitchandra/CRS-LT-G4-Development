package com.lt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Grades;

@Repository
public interface GradesDao extends CrudRepository<Grades, String>{
	@Query(value = "select * from grades where studentId =?", nativeQuery = true)
	List<Grades> findById(int studentId);
	

}
