/**
 * 
 */
package com.lt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Course;


/**
 * @author user115
 *
 */
@Repository
public interface CourseDao extends CrudRepository<Course,Integer> {
	@Query(value = "select * from Course where coursename =?1",nativeQuery = true)
	Course findByName(String name);
}
