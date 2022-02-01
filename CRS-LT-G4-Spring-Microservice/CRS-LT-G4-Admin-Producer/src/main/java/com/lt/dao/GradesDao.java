package com.lt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Grades;

/**
 * @author Naman, Radha, Ramit, Purnima, Sai, Vignesh
 *
 */
@Repository
public interface GradesDao extends CrudRepository<Grades, String>{
	/**
	 * @param studentId
	 * @return
	 * Query to fetch selective student grade on basis of studID.
	 */
	@Query(value = "select * from grades where studentId =?", nativeQuery = true)
	List<Grades> findById(int studentId);
	
	/**
	 * @param id
	 * @return
	 * Query use to approve the report card.
	 */
	@Modifying
	@Query(value="update grades set isApproved=true where studentId= ?1", nativeQuery = true)
	public void approveById(int id);

	/**
	 * @return
	 * Query use to get details of unapproved grades.
	 */
	@Query(value = "select * from grades where isApproved='false'", nativeQuery = true)
	public List<Grades> findUnapprooved();
}
