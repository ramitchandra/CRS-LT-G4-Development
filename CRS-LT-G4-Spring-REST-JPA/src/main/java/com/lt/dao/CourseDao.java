/**
 * 
 */
package com.lt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.crs.constants.SqlConstants;
import com.lt.entity.Course;


/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@Repository
public interface CourseDao extends CrudRepository<Course,Integer> {
	
	@Query(value = SqlConstants.select_CourseName,nativeQuery = true)
	Course findByName(String name);
	
	List<Course> findByCourseNameIn(List<String> coursename);
}
