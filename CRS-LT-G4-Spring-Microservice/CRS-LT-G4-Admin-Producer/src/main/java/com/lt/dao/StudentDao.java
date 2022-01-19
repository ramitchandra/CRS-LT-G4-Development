/**
 * 
 */
package com.lt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lt.entity.Student;

/**
 * @author user112
 *
 */
@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {

}
