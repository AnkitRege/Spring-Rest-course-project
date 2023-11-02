package com.springRest.springRest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springRest.springRest.Entities.Courses;
import com.springRest.springRest.Entities.IdClass;
import com.springRest.springRest.dao.CourseDao;

@Service
public class CoursesServiceImpl implements CourseService {

	@Autowired
	CourseDao courseDao;
	
	ArrayList<Courses> coursesList = new ArrayList<Courses>();
	
	public CoursesServiceImpl() {
//		coursesList = new ArrayList<>();
//		coursesList.add(new Courses(10, "maths", "basic mathematics"));
//		coursesList.add(new Courses(20, "english", "basic english"));
//		coursesList.add(new Courses(30, "java", "learn core java"));
//		coursesList.add(new Courses(40, "spring", "learn basic spring"));
//		coursesList.add(new Courses(50, "physics", "basic physics"));
	}

	@Override
	public List<Courses> getAllCourses() {
		// TODO Auto-generated method stub
//		return coursesList;
		
		return courseDao.findAll();
	}

	@Override
	public Courses getCourseById(long id) {

//		Courses course = null;

//		for (Courses c : coursesList) {
//			if (id == c.getId()) {
//				course = c;
//				break;
//			}
//		}
//		return course;
		System.out.println();
		return courseDao.getReferenceById(id);
	}

	@Override
	public Courses addCourse(Courses course) {

		
//		coursesList.add(course);
//		return course;
		coursesList.add(course);
		courseDao.save(course);
		return course; 
	}

	@Override
	public Courses updateCourse(Courses course) {

//		System.out.println("value on input -->"+course);
//		Courses cou = new Courses();
		
//		for (int i =0;i<coursesList.size();i++) {
//			Courses c = coursesList.get(i);
//			try {
//				if (null != c) {	
//					if (c.getId() == course.getId()) {
//						System.out.println(" int the IF block");
//						c.setId(course.getId());
//						c.setTitle(course.getTitle());
//						c.setDescription(course.getDescription());
//
//						cou = c;
//						break;
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return cou;
		
//		it will automatically update the present data
		courseDao.save(course);
		return course;	
	}

	@Override
	public void deleteCourseById(long id) {

//		for (Courses c : coursesList) {
//			if (id == c.getId()) {
//				System.out.println("in the if block"+id+"c.getId()-->"+c.getId());
//				coursesList.remove(c);
//				break;
//			}
//		}
		
		Courses entity = courseDao.getOne(id); // to get the entity
		courseDao.delete(entity);
	}

	@Override
	public ArrayList<Courses> searchCoursesByGivingIdlist(List<IdClass> idList) {

		System.out.println("inside the method");
		List<Courses> course = courseDao.findAll();
		ArrayList<Courses> newCourseList = new ArrayList<Courses>();
		for(Courses c : course)
		{
			for(IdClass id : idList) 
			{
				if(c.getId()==id.getId()) 
				{
					newCourseList.add(c);
				}
			}
		}	
		return newCourseList;
	}

//	@Override
//	public Map<String, String> searchCoursesByGivingTemplate() {
//		
//		Map<String, String> result = null;
//		Template temp = new Template();
//		Map<String, String> extra = new HashMap<String, String>();
//		
//		SearchTemplate search
//		
//		return null;
//	}

}
