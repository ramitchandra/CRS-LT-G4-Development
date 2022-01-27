package com.lt.crs.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lt.crs.constants.StringConstants;
import com.lt.crs.exception.AlreadyGradeAssignedException;
import com.lt.crs.exception.ApprovalPendingException;
import com.lt.crs.exception.CourseAlreadyExistException;
import com.lt.crs.exception.CourseAlreadyRegisterException;
import com.lt.crs.exception.CourseAlreadySelectedException;
import com.lt.crs.exception.CourseIdNotFoundException;
import com.lt.crs.exception.CourseNotAddedException;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.EmptyStudentListException;
import com.lt.crs.exception.EnrollCoursesNotFoundException;
import com.lt.crs.exception.GradeNotFoundException;
import com.lt.crs.exception.InvalidStudentIdException;
import com.lt.crs.exception.InvalidUserException;
import com.lt.crs.exception.NoCoursesAddedException;
import com.lt.crs.exception.NoPendingApprovalException;
import com.lt.crs.exception.NoUserLoggedInException;
import com.lt.crs.exception.PaymentDeclinedException;
import com.lt.crs.exception.ProfessorIdNotFoundException;
import com.lt.crs.exception.ProfessorNotFoundException;
import com.lt.crs.exception.UnauthorizedAccessException;
import com.lt.crs.exception.WrongCourseSelectionException;


/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@ControllerAdvice
public class ExceptionAdvice {
	
	/**
	 * @param e
	 * CourseNotFound Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.COURSE_NOTFOUND)
	@ExceptionHandler(value = CourseNotFoundException.class)
	public void courseNotFoundException(CourseNotFoundException e) {
    }
	
	/**
	 * @param e
	 * InvalidStudentId Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.STUDENTID_NOTVALID)
	@ExceptionHandler(value = InvalidStudentIdException.class)
	public void InvalidStudentIdException(InvalidStudentIdException e) {
    }
	
	/**
	 * @param e
	 * CourseIdNotFound Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.COURSE_NOTEXIST_TODELETE)
	@ExceptionHandler(value = CourseIdNotFoundException.class)
	public void CourseIdNotFoundException(CourseIdNotFoundException e) {
    }
	
	/**
	 * @param e
	 * ProfessorNotFound Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.PROFESSOR_NOTFOUND)
	@ExceptionHandler(value = ProfessorNotFoundException.class)
	public void ProfessorNotFoundException(ProfessorNotFoundException e) {
    }
	
	/**
	 * @param e
	 * ProfessorIdNotFound Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.PROFESSOR_NOTEXIST_TODELETE)
	@ExceptionHandler(value = ProfessorIdNotFoundException.class)
	public void ProfessorIdNotFoundException(ProfessorIdNotFoundException e) {
    }
	
	/**
	 * @param e
	 * gradeNotFound Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.GRADE_NOTFOUND)
	@ExceptionHandler(value = GradeNotFoundException.class)
	public void gradeNotFoundException(GradeNotFoundException e) {
		
	}
	
	/**
	 * @param e
	 * CourseAlreadySelected Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = StringConstants.COURSE_SELECTEDALREADY)
	@ExceptionHandler(value = CourseAlreadySelectedException.class)
	public void CourseAlreadySelectedException(CourseAlreadySelectedException e) {
    }
	
	/**
	 * @param e
	 * WrongCourseSelection Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.COURSE_NOTAVAILABLE)
	@ExceptionHandler(value = WrongCourseSelectionException.class)
	public void WrongCourseSelectionException(WrongCourseSelectionException e) {
    }
	
	/**
	 * @param e
	 * CourseNotAdded Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.COURSE_NOTADDED_TODELETE)
	@ExceptionHandler(value = CourseNotAddedException.class)
	public void CourseNotAddedException(CourseNotAddedException e) {
    }
	
	/**
	 * @param e
	 * NoCoursesAdded Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.COURSE_NOTADDED)
	@ExceptionHandler(value = NoCoursesAddedException.class)
	public void NoCoursesAddedException(NoCoursesAddedException e) {
    }
	
	/**
	 * @param e
	 * CourseAlreadyRegister Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = StringConstants.COURSE_AlREADYREG)
	@ExceptionHandler(value = CourseAlreadyRegisterException.class)
	public void CourseAlreadyRegisterException(CourseAlreadyRegisterException e) {
    }
	
	/**
	 * @param e
	 * NoPendingApproval Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = StringConstants.STUDENTAPPR_NOTPENDING)
	@ExceptionHandler(value = NoPendingApprovalException.class)
	public void NoPendingApprovalException(NoPendingApprovalException e) {	
	}
	
	/**
	 * @param e
	 * CourseAlreadyExist Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = StringConstants.COURSE_EXISTS)
	@ExceptionHandler(value = CourseAlreadyExistException.class)
	public void CourseAlreadyExistException(CourseAlreadyExistException e) {	
	}
	
	/**
	 * @param e
	 * InvalidUser Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = StringConstants.CREDENTIALS_NOTVALID)
	@ExceptionHandler(value = InvalidUserException.class)
	public void InvalidUserException(InvalidUserException e) {	
	}
	
	/**
	 * @param e
	 * ApprovalPending Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = StringConstants.APPROVAL_PENDING)
	@ExceptionHandler(value = ApprovalPendingException.class)
	public void ApprovalPendingException(ApprovalPendingException e) {	
	}
	
	/**
	 * @param e
	 * UnauthorizedAccess Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = StringConstants.ACCESS_NOTAUTHORISED)
	@ExceptionHandler(value = UnauthorizedAccessException.class)
	public void UnauthorizedAccessException(UnauthorizedAccessException e) {	
	}
	
	/**
	 * @param e
	 * NoUserLoggedIn Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = StringConstants.USER_NOTLOGGED)
	@ExceptionHandler(value = NoUserLoggedInException.class)
	public void NoUserLoggedInException(NoUserLoggedInException e) {	
	}
	
	/**
	 * @param e
	 * EmptyStudentListException Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.GRADES_ALREADYASSIGNED)
	@ExceptionHandler(value = EmptyStudentListException.class)
	public void EmptyStudentListException(EmptyStudentListException e) {	
	}
	
	/**
	 * @param e
	 * AlreadyGradeAssignedException Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.GRADE_ALREADYASSIGNED_TOSTUDENT)
	@ExceptionHandler(value = AlreadyGradeAssignedException.class)
	public void AlreadyGradeAssignedException(AlreadyGradeAssignedException e) {	
	}
	
	/**
	 * @param e
	 * EnrollCoursesNotFoundException Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = StringConstants.ENROLLEDCOURSE_NOTAVAILABLE)
	@ExceptionHandler(value = EnrollCoursesNotFoundException.class)
	public void EnrollCoursesNotFoundException(EnrollCoursesNotFoundException e) {	
	}
	
	/**
	 * @param e
	 * PaymentDeclinedException Exception Handling
	 */
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = StringConstants.PAYMENT_DECLINED)
	@ExceptionHandler(value = PaymentDeclinedException.class)
	public void PaymentDeclinedException(PaymentDeclinedException e) {	
	}
	
}