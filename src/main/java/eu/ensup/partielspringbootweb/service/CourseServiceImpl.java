package eu.ensup.partielspringbootweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.node.ObjectNode;

import eu.ensup.partielspringbootweb.config.ResourceNotFoundException;
import eu.ensup.partielspringbootweb.entities.Course;
import eu.ensup.partielspringbootweb.entities.Student;
import eu.ensup.partielspringbootweb.entities.Course;
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
	public Course createCourse(Course course) {
		return courseRepo.save(course);		
	}



	@Override
	public Course getCourse(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Course cours = null;
		Optional<Course> stuFound = courseRepo.findById(id);
		if(stuFound.isPresent()) {
			cours = stuFound.get();
		}
		
			return cours;

	}


	@Override
	public Course updateCourse(Long id, Course course) {
		// TODO Auto-generated method stub
		Optional<Course> c = courseRepo.findById(id);
		
		Course cours = null;
		Optional<Course> studentFound  = courseRepo.findById(id);
		if(studentFound.isPresent()) {
			cours = studentFound.get();
			cours.setNumberHours(course.getNumberHours());
			cours.setThemeCourse(course.getThemeCourse());
			
			}
		return courseRepo.save(cours);
		
	}


	@Override
	public void deleteCourse(Long id) {
		// TODO Auto-generated method stub
		Optional<Course>  studDel = courseRepo.findById(id);
		if(studDel.isPresent()) {
			courseRepo.delete(studDel.get());
		}
		
		
	}

}
