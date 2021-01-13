package eu.ensup.partielspringbootweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ensup.partielspringbootweb.config.ResourceNotFoundException;
import eu.ensup.partielspringbootweb.entities.Course;
import eu.ensup.partielspringbootweb.service.ICourseService;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {

	
	@Autowired 
	private ICourseService courseService;

	/**
	 * @param courseService
	 */
	public CourseController(ICourseService courseService) {
		System.out.println("+++++++++++++++++++ Init course controller+++++++++++++++++");

		this.courseService = courseService;
	}
	
	@GetMapping(value="/getAll",produces = {"application/json"})
	public List<Course> getAllCourses(){
		System.out.println("+++++++++++++++ GetAll +++++++++++++");
		
		return courseService.getAllCourses();
		
	}
	
	@GetMapping(value="/detail/{id}")
	public Course getCourseById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
		return courseService.getCourse(id);
	}
	
	

	
	@PostMapping("/create")
	public void createCourse(@Valid @RequestBody Course course) {
		System.out.println("++++++++++++ REquestBody +++++++++++: "+ course);
		
		courseService.createCourse(course);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCourse(@PathVariable(value = "id") Long id) {
		
		courseService.deleteCourse(id);
		
	}
	
	@PutMapping("/update/{id}")
	public void updateCourse(@PathVariable(value = "id") Long id, @Valid @RequestBody Course course) throws ResourceNotFoundException {
		
		courseService.updateCourse(id, course);
	}
	
	
	
	
	
}
