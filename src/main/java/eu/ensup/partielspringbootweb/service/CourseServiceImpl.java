package eu.ensup.partielspringbootweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.node.ObjectNode;

import eu.ensup.partielspringbootweb.config.ResourceNotFoundException;
import eu.ensup.partielspringbootweb.entities.Course;
import eu.ensup.partielspringbootweb.repositories.CourseRepository;

@Service
public class CourseServiceImpl  implements ICourseService{
	
	@Autowired
	private CourseRepository courseRepo;
	
	

	/**
	 * @param courseRepo
	 */
	public CourseServiceImpl(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}

	

	@Override
	public List<Course> getAllCourses() {
		return (List<Course>) courseRepo.findAll();
	}



	@Override
	public void createCourse(Course course) {
		courseRepo.save(course);		
	}



	@Override
	public Course getCourse(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return courseRepo.findById(id).get();
	}



	@Override
	public void updateCourse(Long id, Course course) {
		// TODO Auto-generated method stub
		Course c = courseRepo.findById(id).get();
		c.setNumberHours(course.getNumberHours());
		c.setThemeCourse(course.getThemeCourse());
		courseRepo.save(c);	
		
	}


	@Override
	public void deleteCourse(Long id) {
		// TODO Auto-generated method stub
		courseRepo.deleteById(id);	
		
	}

}
