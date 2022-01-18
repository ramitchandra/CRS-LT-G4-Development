package com.lt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.User;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	
	@Query(value="Select * from user where isApproved=0",nativeQuery=true)
	List<User> findUnapproved();
	
}
