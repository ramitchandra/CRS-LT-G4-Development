package com.lt.dao;

import org.springframework.data.repository.CrudRepository;

import com.lt.entity.Login;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 *
 */
public interface LoginDao extends CrudRepository<Login, String> {

}
