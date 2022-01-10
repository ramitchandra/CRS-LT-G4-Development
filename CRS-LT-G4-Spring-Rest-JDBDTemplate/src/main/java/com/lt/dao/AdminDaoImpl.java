package com.lt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.config.JDBCConfiguration;
import com.lt.crs.constants.SqlConstants;
import com.lt.mapper.CourseMapper;
import com.lt.mapper.ProfessorMapper;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	/**
	 * This is used to autowire  JDBCConfiguration bean
	 */
	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Override
	@Transactional
	public List<Course> getAllCourse() {

		String SQL = SqlConstants.selectCourse;
		List <Course> courseList = jdbcConfiguration.jdbcTemplate().query(SQL, new CourseMapper());
		return courseList;
	}

	@Override
	@Transactional
	public int addCourse(Course course) {
		String existingCourse = SqlConstants.selectCourseParameterized;
		List<Course> courseList = jdbcConfiguration.jdbcTemplate().query(existingCourse, new CourseMapper(),course.getCourseId(),course.getCourseName());
		if(!courseList.isEmpty())
			return -1;
		String SQL= SqlConstants.insertCourse;
		return jdbcConfiguration.jdbcTemplate().update( SQL, course.getCourseId(),course.getCourseName(),course.isCourseAvailable(),course.getOfflieFees(),course.getOnlineFees());
		
	}

	@Override
	@Transactional
	public int deleteCourse(int id) {
		String SQL= SqlConstants.deleteCourseParameterized;
		return jdbcConfiguration.jdbcTemplate().update(SQL,id);
		
	}
	
	@Override
	@Transactional
	public List<Professor> getProfessorList() {
		String SQL = SqlConstants.selectProfessor;
		List <Professor> professorList = jdbcConfiguration.jdbcTemplate().query(SQL, new ProfessorMapper());
		return professorList;
	}

	@Override
	@Transactional
	public void addProfessor(Professor professor) {
		String SQL= SqlConstants.insertProfessor;	
		jdbcConfiguration.jdbcTemplate().update(SQL,professor.getProfessorId(),professor.getProfessorName(),professor.getProfessorPass());
	}

	@Override
	@Transactional
	public int deleteProfessor(int id) {
		String SQL= SqlConstants.deleteProfessorParameterized;
		return jdbcConfiguration.jdbcTemplate().update(SQL,id);		
	}

	@Override
	@Transactional
	public int approveStudent(int id) {
		String SQL= SqlConstants.studentApproval;
		return jdbcConfiguration.jdbcTemplate().update(SQL,id);
	}
}
