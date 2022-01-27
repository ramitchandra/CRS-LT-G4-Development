package com.lt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.EnrolledCourse;
import com.lt.entity.User;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh 
 * 
 * Interface for enrolledcoursedao operations
 */
@Repository
public interface EnrolledCourseDao extends CrudRepository<EnrolledCourse, Integer> {
	
	@Query(value="Select * from enrolledcourses where id = ?1",nativeQuery=true)
	EnrolledCourse findcourses(int id);
	
	
	@Query(value="Delete from enrolledcourses where id = ?1",nativeQuery=true)
	EnrolledCourse updatecourse(int id);
}
