package com.lt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
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
	
	@Modifying
	@Query(value="update user set isApproved=true where userId= ?1", nativeQuery = true)
	public void approveById(int id);	
	
	@Query(value="select * from user where userName = ?1 and userPassword = ?2", nativeQuery = true)
	public List<User> loginValidation(String userName, String password);
	
}
