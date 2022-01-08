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
import com.lt.crs.exception.EmptyStudentListException;
import com.lt.crs.exception.AlreadyGradeAssignedException;


/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@ControllerAdvice
public class ExceptionController {
	
	/**
	 * @param e
	 * CourseNotFound Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Course was not found on the server")
	@ExceptionHandler(value = CourseNotFoundException.class)
	public void courseNotFoundException(CourseNotFoundException e) {
    }
	
	/**
	 * @param e
	 * InvalidStudentId Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid Student ID")
	@ExceptionHandler(value = InvalidStudentIdException.class)
	public void InvalidStudentIdException(InvalidStudentIdException e) {
    }
	
	/**
	 * @param e
	 * CourseIdNotFound Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Course you want to delete does not exists!!")
	@ExceptionHandler(value = CourseIdNotFoundException.class)
	public void CourseIdNotFoundException(CourseIdNotFoundException e) {
    }
	
	/**
	 * @param e
	 * ProfessorNotFound Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Professor was not found")
	@ExceptionHandler(value = ProfessorNotFoundException.class)
	public void ProfessorNotFoundException(ProfessorNotFoundException e) {
    }
	
	/**
	 * @param e
	 * ProfessorIdNotFound Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Professor you want to delete does not exists!!")
	@ExceptionHandler(value = ProfessorIdNotFoundException.class)
	public void ProfessorIdNotFoundException(ProfessorIdNotFoundException e) {
    }
	
	/**
	 * @param e
	 * gradeNotFound Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Grade was not found on the server")
	@ExceptionHandler(value = GradeNotFoundException.class)
	public void gradeNotFoundException(GradeNotFoundException e) {
		
	}
	
	/**
	 * @param e
	 * CourseAlreadySelected Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Already selected course")
	@ExceptionHandler(value = CourseAlreadySelectedException.class)
	public void CourseAlreadySelectedException(CourseAlreadySelectedException e) {
    }
	
	/**
	 * @param e
	 * WrongCourseSelection Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Selected Course not availabe in course catalog")
	@ExceptionHandler(value = WrongCourseSelectionException.class)
	public void WrongCourseSelectionException(WrongCourseSelectionException e) {
    }
	
	/**
	 * @param e
	 * CourseNotAdded Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Course not added to delete")
	@ExceptionHandler(value = CourseNotAddedException.class)
	public void CourseNotAddedException(CourseNotAddedException e) {
    }
	
	/**
	 * @param e
	 * NoCoursesAdded Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No Courses Added")
	@ExceptionHandler(value = NoCoursesAddedException.class)
	public void NoCoursesAddedException(NoCoursesAddedException e) {
    }
	
	/**
	 * @param e
	 * CourseAlreadyRegister Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Course Already Registered")
	@ExceptionHandler(value = CourseAlreadyRegisterException.class)
	public void CourseAlreadyRegisterException(CourseAlreadyRegisterException e) {
    }
	
	/**
	 * @param e
	 * NoPendingApproval Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "No Student is pending for approval")
	@ExceptionHandler(value = NoPendingApprovalException.class)
	public void NoPendingApprovalException(NoPendingApprovalException e) {	
	}
	
	/**
	 * @param e
	 * CourseAlreadyExist Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Course Already Exists!!")
	@ExceptionHandler(value = CourseAlreadyExistException.class)
	public void CourseAlreadyExistException(CourseAlreadyExistException e) {	
	}
	
	/**
	 * @param e
	 * InvalidUser Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Invalid Credentials!!")
	@ExceptionHandler(value = InvalidUserException.class)
	public void InvalidUserException(InvalidUserException e) {	
	}
	
	/**
	 * @param e
	 * ApprovalPending Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Approval Pending!!")
	@ExceptionHandler(value = ApprovalPendingException.class)
	public void ApprovalPendingException(ApprovalPendingException e) {	
	}
	
	/**
	 * @param e
	 * UnauthorizedAccess Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Unauthorized Access!!")
	@ExceptionHandler(value = UnauthorizedAccessException.class)
	public void UnauthorizedAccessException(UnauthorizedAccessException e) {	
	}
	
	/**
	 * @param e
	 * NoUserLoggedIn Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "No user logged in!!")
	@ExceptionHandler(value = NoUserLoggedInException.class)
	public void NoUserLoggedInException(NoUserLoggedInException e) {	
	}
	
	/**
	 * @param e
	 * EmptyStudentListException Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "All Students are already assigned with Grades")
	@ExceptionHandler(value = EmptyStudentListException.class)
	public void EmptyStudentListException(EmptyStudentListException e) {	
	}
	
	/**
	 * @param e
	 * AlreadyGradeAssignedException Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Student is already assigned with a Grade")
	@ExceptionHandler(value = AlreadyGradeAssignedException.class)
	public void AlreadyGradeAssignedException(AlreadyGradeAssignedException e) {	
	}
	
	
	
}