package com.lt.crs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lt.crs.exception.CourseIdNotFoundException;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.GradeNotFoundException;
import com.lt.crs.exception.InvalidStudentIdException;
import com.lt.crs.exception.ProfessorIdNotFoundException;
import com.lt.crs.exception.ProfessorNotFoundException;

@ControllerAdvice
public class ExceptionController {
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Course was not found on the server")
	@ExceptionHandler(value = CourseNotFoundException.class)
	public void courseNotFoundException(CourseNotFoundException e) {
    }
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid Student ID")
	@ExceptionHandler(value = InvalidStudentIdException.class)
	public void InvalidStudentIdException(InvalidStudentIdException e) {
    }
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Course you want to delete does not exists!!")
	@ExceptionHandler(value = CourseIdNotFoundException.class)
	public void CourseIdNotFoundException(CourseIdNotFoundException e) {
    }
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Professor was not found")
	@ExceptionHandler(value = ProfessorNotFoundException.class)
	public void ProfessorNotFoundException(ProfessorNotFoundException e) {
    }
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Professor you want to delete does not exists!!")
	@ExceptionHandler(value = ProfessorIdNotFoundException.class)
	public void ProfessorIdNotFoundException(ProfessorIdNotFoundException e) {
    }
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Grade was not found on the server")
	@ExceptionHandler(value = GradeNotFoundException.class)
	public void gradeNotFoundException(GradeNotFoundException e) {
		
	}
	
}
