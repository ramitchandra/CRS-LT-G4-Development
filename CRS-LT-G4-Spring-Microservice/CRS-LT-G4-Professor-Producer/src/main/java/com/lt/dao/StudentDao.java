/**
 * 
 */
package com.lt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Student;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@Repository
public interface StudentDao extends CrudRepository<Student, Integer>  {

}
