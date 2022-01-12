/**
 * 
 */
package com.lt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Course;
import com.lt.entity.CourseId;

/**
 * @author user115
 *
 */
@Repository
public interface AdminDao extends CrudRepository<Course, CourseId>  {

}
