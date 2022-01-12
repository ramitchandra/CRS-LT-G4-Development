/**
 * 
 */
package com.lt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Professor;

/**
 * @author user115
 *
 */
@Repository
public interface ProfessorDao extends CrudRepository<Professor, Integer>  {

}
