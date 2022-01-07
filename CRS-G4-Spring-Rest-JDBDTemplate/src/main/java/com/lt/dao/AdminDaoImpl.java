package com.lt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.config.JDBCConfiguration;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.InvalidStudentIdException;
import com.lt.mapper.CourseMapper;
import com.lt.mapper.ProfessorMapper;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Override
	@Transactional
	public List<Course> getAllCourse() {

		String SQL = "select * from course";
		List <Course> courseList = jdbcConfiguration.jdbcTemplate().query(SQL, 
				new CourseMapper());
//		if(courseList.isEmpty())
//			throw new CourseNotFoundException();
		return courseList;
	}

	@Override
	@Transactional
	public void addCourse(Course course) {
		String SQL= "insert into course (courseId,courseName,courseAvailable,offlineAmount,onlineAmount) values (?,?,?,?,?)";
		jdbcConfiguration.jdbcTemplate().update( SQL, course.getCourseId(),course.getCourseName(),course.isCourseAvailable(),course.getOfflieFees(),course.getOnlineFees());
		
	}

	@Override
	public int deleteCourse(int id) {
		String SQL= "delete from course where courseId = ?";
		return jdbcConfiguration.jdbcTemplate().update(SQL,id);
		
	}
	
	@Override
	public List<Professor> getProfessorList() {
		String SQL = "select * from professor";
		List <Professor> professorList = jdbcConfiguration.jdbcTemplate().query(SQL, 
				new ProfessorMapper());
		return professorList;
	}

	@Override
	public void addProfessor(Professor professor) {
		String SQL= "insert into professor (professorId,professorName,professorPassword) values (?,?,?)";	
		jdbcConfiguration.jdbcTemplate().update(SQL,professor.getProfessorId(),professor.getProfessorName(),professor.getProfessorPass());
	}

	@Override
	public int deleteProfessor(int id) {
		String SQL= "delete from professor where professorId=?";
		return jdbcConfiguration.jdbcTemplate().update(SQL,id);		
	}

	@Override
	public int approveStudent(int id) {
		String SQL= "update user set isApproved = true where userId = ?";
		return jdbcConfiguration.jdbcTemplate().update(SQL,id);
	}
}
