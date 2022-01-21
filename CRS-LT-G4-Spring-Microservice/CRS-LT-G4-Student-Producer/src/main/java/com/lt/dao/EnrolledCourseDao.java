package com.lt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.EnrolledCourse;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh 
 * 
 * Interface for enrolledcoursedao operations
 */
@Repository
public interface EnrolledCourseDao extends CrudRepository<EnrolledCourse, Integer> {

}
