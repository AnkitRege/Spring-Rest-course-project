package com.springRest.springRest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.springRest.Entities.Courses;
import com.springRest.springRest.Entities.IdClass;
import com.springRest.springRest.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	private long courseId;

//	@GetMapping("/home")
	@RequestMapping(value = "/home", method= RequestMethod.GET)
	public String home() {
		return "this is home";
	}

	// get all the courses
	@GetMapping("/courses")
	public List<Courses> getAllCourses() {
		return this.courseService.getAllCourses();
	}
	
	// to get single course
	@GetMapping("/courseById/{courseId}")
	public Courses getCOurseById(@PathVariable long courseId) {
		return this.courseService.getCourseById(courseId);
	}
	
	// to save new course
	@PostMapping(path = "/courses/save", consumes = "application/json")
	public Courses addCourse(@RequestBody Courses course) {
		
		return this.courseService.addCourse(course);
	}
	
	// to update the course
	@PutMapping(path = "/courses/update", consumes = "application/json")
	public Courses updateCourse(@RequestBody Courses course) {
		System.out.println("in the controller update API");
		return this.courseService.updateCourse(course);
	}
	
	// to delete the course	
	@DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<HttpStatus> deleteCourseById(@PathVariable long id) {
		try { 
		this.courseService.deleteCourseById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//    public ResponseEntity<RestApiResponseHeader<List<Courses>>
	@RequestMapping(path = "/search", method=RequestMethod.POST)
	public ArrayList<Courses> searchCourse(@RequestBody List<IdClass> idList) {
		ArrayList<Courses> courseList = courseService.searchCoursesByGivingIdlist(idList);
		return courseList;
	}

}
