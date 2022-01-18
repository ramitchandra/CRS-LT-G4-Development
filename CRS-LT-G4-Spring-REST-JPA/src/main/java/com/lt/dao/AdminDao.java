/**
 * 
 */
package com.lt.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
	@Modifying
	@Query(value="update user set isApproved=true where userId= ?1",nativeQuery = true)
	public void approveById(int id);	
	

}
