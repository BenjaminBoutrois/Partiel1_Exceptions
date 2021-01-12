package eu.ensup.partielspringbootweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.node.ObjectNode;

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
	public void associateCourse(ObjectNode courseAssociation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return (List<Course>) courseRepo.findAll();
	}

}
