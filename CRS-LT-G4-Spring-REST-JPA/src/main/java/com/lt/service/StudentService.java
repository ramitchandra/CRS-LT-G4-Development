package com.lt.service;

import com.lt.crs.constants.EnumRole;
import com.lt.dao.CourseDao;
import com.lt.dao.EnrolledCourseDao;
import com.lt.dao.StudentDao;
import com.lt.dao.UserDao;
import com.lt.entity.Course;
import com.lt.entity.EnrolledCourse;
import com.lt.entity.Student;
import com.lt.entity.User;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentdao; 
	@Autowired
	UserDao userdao; 
	@Autowired
	CourseDao coursedao; 
	@Autowired
	EnrolledCourseDao enrolledcourses;
	
	
	EntityManager e;
	
	public void addStudent(Student Student)
	{  
		studentdao.save(Student); 
		User user = new User();
		user.setUserId(Student.getStudentId());
		user.setUserName(Student.getStudentName());
		user.setUserPassword(Student.getStudentPassword());
		user.setRoleId(EnumRole.Role);
		user.setApproved(false);
		userdao.save(user);
	}

	public void registerCourse(int id, List<String> courseList) {
		// TODO Auto-generated method stub
		String courseId = "";
		String courseName = "";
		EnrolledCourse courses = new EnrolledCourse();
		Student student = studentdao.findById(id).orElse(null);		
		String studentName="";
		if(student!=null)
			studentName = student.getStudentName();
		

		
		if(!studentName.isEmpty()) {
			for(String course: courseList) {
				Course c = coursedao.findByName(course);
				courseId = courseId.concat(String.valueOf( ","+c.getCourseId()));
				
				courseName = courseName+course;
			}
			courses.setStudentId(id);
			courses.setStudentName(studentName);
			courses.setCourseId(courseId);
			courses.setCourseName(courseName);
			
			enrolledcourses.save(courses);
		}
	}

}
