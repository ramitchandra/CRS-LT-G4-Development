/**
 * 
 */
package com.lt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.lt.bean.Grades;

import java.util.List;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
public interface GradesDAO {
	/**
	 * @return
	 * This method is to return all the Grades of available students to view.
	 */
	public List<Grades> viewGrades();
	
	/**
	 * @param studentId
	 * @return
	 * This method is to return the Grade of the student based on his/her Id.
	 */
	public List<Grades> viewGradeOnId(int studentId);
}
