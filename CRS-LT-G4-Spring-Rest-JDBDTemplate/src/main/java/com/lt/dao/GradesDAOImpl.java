package com.lt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.bean.Grades;
import com.lt.config.JDBCConfiguration;
import com.lt.mapper.GradeMapper;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */


@Repository
public class GradesDAOImpl implements GradesDAO {
	@Autowired
	JDBCConfiguration jdbcConfiguration;
	
	
	/**
	 * @return
	 * This method is to return all the Grades of available students to view.
	 */
	@Override
	@Transactional
	public List<Grades> viewGrades() {
		String sql = "select * from grades";
		List<Grades> gradeList = jdbcConfiguration.jdbcTemplate().query(sql, new GradeMapper());
		
		return gradeList;
		
	}
	
	/**
	 * @return
	 * This method is to return the Grade of the student based on his/her Id.
	 */
	@Override
	@Transactional	
	public List<Grades> viewGradeOnId(int studentId) {
		String sql = "select * from grades where studentId=" + studentId;
		//List<Grades> gradeList = jdbcConfiguration.jdbcTemplate().query(sql, new GradeMapper());
		List<Grades> gradeList = jdbcConfiguration.jdbcTemplate().query(sql, new GradeMapper());
		return gradeList;
	}
}
