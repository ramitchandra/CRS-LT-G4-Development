/**
 * 
 */
package com.lt.crs.business;

import java.util.List;

import com.lt.crs.bean.Course;

/**
 * @author user112
 *
 */
public interface CourseHandler {
	
	public List<Course> getCourseList();
	public Course addCourse(Course course);
	public Course deleteCourse(int courseId);
	
}
