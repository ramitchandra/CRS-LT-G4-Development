package com.lt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.crs.constants.StringConstants;
import com.lt.dao.GradesDao;
import com.lt.dao.StudentDao;
import com.lt.entity.Grades;
import com.lt.entity.Student;

@Service
public class ProfessorService {

	/**
	 * This is used to autowire studentDao bean
	 */
	@Autowired
	StudentDao studentDao;

	/**
	 * This is used to autowire gradesDao bean
	 */
	@Autowired
	GradesDao gradesDao;

	/**
	 * @return This method is to call the DAO Layer to fetch the List of students
	 *         from DB
	 */
	public List<Student> listStudent() {
		List<Student> studentList = (List<Student>) studentDao.findAll();
		return studentList;
	}

	/**
	 * @param grades This method is to call the DAO Layer to add the Grades in the
	 *               DB
	 * @return 
	 */
	public String addGrades(Grades grades) {
		//get StudentName
		Optional<Student> optional = studentDao.findById(grades.getStudentId());
		if (optional != null && optional.isEmpty()) {
			// throw error msg or exception
			return StringConstants.STU_NOTFOUND + grades.getStudentId();
		}
		Student student = optional.get();
		String studentName = "";
		//get StudentName
		if (student != null) {
			studentName = student.getStudentName();
		}
		//save grade
		Grades assignGrades = gradesDao.save(grades);
		//return grades assigned
		return assignGrades != null ? StringConstants.ASSIGN_GRADES + studentName + " :" + assignGrades.getGrade() : StringConstants.GRADE_NOTASSIGNED;
	}

}
