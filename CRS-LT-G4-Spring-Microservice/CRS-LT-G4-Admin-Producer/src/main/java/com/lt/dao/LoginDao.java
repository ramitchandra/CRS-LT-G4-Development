package com.lt.dao;

import org.springframework.data.repository.CrudRepository;

import com.lt.entity.Login;

public interface LoginDao extends CrudRepository<Login, String> {

}
