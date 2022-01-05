package com.lt.crs.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lt.crs.bean.Grades;
import com.lt.crs.bean.Student;

@Component
public class StudentHandlerImpl implements StudentHandler {
	
	public List<Student> studentList = new ArrayList<>();
	public Map<Integer,List<String>> addedCourses = new HashMap<>();

	public Map<Integer, List<String>> getAddedCourses() {

		return addedCourses;
	}
	
	/**
	 * @return the studentList
	 */
	public List<Student> getStudentList() {
		return studentList;
	}
	
	@Override
	public void createDummyStudent() {
		Student student1 = new Student();
		student1.setStudentId(0001);
		student1.setStudentEmail("student1@gmail.com");
		student1.setStudentName("Stud1");
		student1.setStudentPassword("0001");
		student1.setStudentUsername("Stud1");
		student1.setApproved(false);
		studentList.add(student1);
		
		Student student2 = new Student();
		student2.setStudentId(0002);
		student2.setStudentEmail("student2@gmail.com");
		student2.setStudentName("Stud2");
		student2.setStudentPassword("0002");
		student2.setStudentUsername("Stud2");
		student2.setApproved(false);
		studentList.add(student2);
		
	}

	@Override
	public Student addStudent(Student student) {
		Student newStudent = new Student();
		newStudent.setStudentId(student.getStudentId());
		newStudent.setStudentEmail(student.getStudentEmail());
		newStudent.setStudentName(student.getStudentName());
		newStudent.setStudentPassword(student.getStudentPassword());
		newStudent.setStudentUsername(student.getStudentUsername());
		newStudent.setApproved(student.isApproved());
		studentList.add(newStudent);
		return newStudent;
	}
	
	@Override
	public void viewGrade() {
		// TODO Auto-generated method stub
		ProfessorHandler ph = new ProfessorHandlerImpl();
		List<Grades> gradeResult = ph.insertGrade();	
		
	}

}
