package com.lt.crs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lt.crs.exception.CourseNotFoundException;

@ControllerAdvice
public class ExceptionController {
	@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Course was not found on the server")
	@ExceptionHandler(value = CourseNotFoundException.class)
	public void courseNotFoundException(CourseNotFoundException e) {
    }

}
