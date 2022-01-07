/**
 * 
 */
package com.lt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.lt.bean.Grades;

import java.util.List;

/**
 * @author user116
 *
 */
public interface GradesDAO {
	//public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
	public List<Grades> viewGrades();

	public List<Grades> viewGradeOnId(int studentId);
}
