package com.springRest.springRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.springRest.springRest.Entities.Courses;
import com.springRest.springRest.Entities.IdClass;

public interface CourseService {

//	creating method to get all the courses from the DB
	public List<Courses> getAllCourses();
	
	public Courses getCourseById(long id);

	public Courses addCourse(Courses course);

	public Courses updateCourse(Courses course);
	
	public void deleteCourseById(long id);

	public ArrayList<Courses> searchCoursesByGivingIdlist(List<IdClass> idList);
	
//	public Map<String, String> searchCoursesByGivingTemplate();
	
}