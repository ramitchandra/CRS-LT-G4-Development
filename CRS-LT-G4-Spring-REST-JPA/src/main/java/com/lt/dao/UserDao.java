package com.lt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.lt.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

}
