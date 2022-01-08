package com.lt.crs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lt.crs.exception.ApprovalPendingException;
import com.lt.crs.exception.CourseAlreadyExistException;
import com.lt.crs.exception.CourseAlreadyRegisterException;
import com.lt.crs.exception.CourseAlreadySelectedException;
import com.lt.crs.exception.CourseIdNotFoundException;
import com.lt.crs.exception.CourseNotAddedException;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.GradeNotFoundException;
import com.lt.crs.exception.InvalidStudentIdException;
import com.lt.crs.exception.InvalidUserException;
import com.lt.crs.exception.NoCoursesAddedException;
import com.lt.crs.exception.NoPendingApprovalException;
import com.lt.crs.exception.NoUserLoggedInException;
import com.lt.crs.exception.ProfessorIdNotFoundException;
import com.lt.crs.exception.ProfessorNotFoundException;
import com.lt.crs.exception.UnauthorizedAccessException;
import com.lt.crs.exception.WrongCourseSelectionException;


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
	
	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Already selected course")
	@ExceptionHandler(value = CourseAlreadySelectedException.class)
	public void CourseAlreadySelectedException(CourseAlreadySelectedException e) {
    }
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Selected Course not availabe in course catalog")
	@ExceptionHandler(value = WrongCourseSelectionException.class)
	public void WrongCourseSelectionException(WrongCourseSelectionException e) {
    }
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Course not added to delete")
	@ExceptionHandler(value = CourseNotAddedException.class)
	public void CourseNotAddedException(CourseNotAddedException e) {
    }
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No Courses Added")
	@ExceptionHandler(value = NoCoursesAddedException.class)
	public void NoCoursesAddedException(NoCoursesAddedException e) {
    }
	
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Course Already Registered")
	@ExceptionHandler(value = CourseAlreadyRegisterException.class)
	public void CourseAlreadyRegisterException(CourseAlreadyRegisterException e) {
    }
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "No Student is pending for approval")
	@ExceptionHandler(value = NoPendingApprovalException.class)
	public void NoPendingApprovalException(NoPendingApprovalException e) {	
	}
	
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Course Already Exists!!")
	@ExceptionHandler(value = CourseAlreadyExistException.class)
	public void CourseAlreadyExistException(CourseAlreadyExistException e) {	
	}
	
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Invalid Credentials!!")
	@ExceptionHandler(value = InvalidUserException.class)
	public void InvalidUserException(InvalidUserException e) {	
	}
	
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Approval Pending!!")
	@ExceptionHandler(value = ApprovalPendingException.class)
	public void ApprovalPendingException(ApprovalPendingException e) {	
	}
	
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Unauthorized Access!!")
	@ExceptionHandler(value = UnauthorizedAccessException.class)
	public void UnauthorizedAccessException(UnauthorizedAccessException e) {	
	}
	
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "No user logged in!!")
	@ExceptionHandler(value = NoUserLoggedInException.class)
	public void NoUserLoggedInException(NoUserLoggedInException e) {	
	}
	
}