package com.lt.crs.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lt.crs.bean.Course;

@Component
public class CourseHandlerImpl implements CourseHandler {

		public List<Course> courseList = new ArrayList<>();

		/**
		 * @return the courseList
		 */
		@Override
		public List<Course> getCourseList() {
			return courseList;
		}

		@Override
		public void addCourse(Course course) {
			Course newCourse = new Course();
			newCourse.setCourseId(course.getCourseId());
			newCourse.setCourseName(course.getCourseName());
			newCourse.setCourseAvailable(true);
			newCourse.setOfflieFees(course.getOfflieFees());
			newCourse.setOnlineFees(course.getOnlineFees());
			courseList.add(newCourse);
		}

		@Override
		public Course deleteCourse(int courseId) {
			Course deletedCourse = null;
			for(Course course : courseList) {
				if(course.getCourseId() == courseId) {
					deletedCourse = course;
					courseList.remove(course);
					break;
				}
			}
			return deletedCourse;
		}
		
		
}
