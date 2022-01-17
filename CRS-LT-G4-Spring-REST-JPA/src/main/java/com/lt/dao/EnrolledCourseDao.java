package com.lt.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.EnrolledCourse;
import com.lt.entity.Student;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@Repository
public interface EnrolledCourseDao extends CrudRepository<EnrolledCourse, Integer>  {
	
	
	
//	public List<EnrolledCourse> findById(int studentid);


}
