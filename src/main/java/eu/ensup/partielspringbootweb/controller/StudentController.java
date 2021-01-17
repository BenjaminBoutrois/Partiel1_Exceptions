package eu.ensup.partielspringbootweb.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import eu.ensup.partielspringbootweb.entities.Student;
import eu.ensup.partielspringbootweb.service.IStudentService;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	
	
	
	/**
	 * @param studentService
	 */
	public StudentController(IStudentService studentService) {
		System.out.println("+++++++++++++++++++ Init student controller+++++++++++++++++");
		this.studentService = studentService;
	}

	@GetMapping("/getAll")
	public List<Student> getAllStudents(){
		System.out.println("+++++++++++++++ GetAll +++++++++++++");
		
		return studentService.getAllStudents();
		
	}
	
	@GetMapping("/detail/{id}")
	public Student getStudentById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
		return studentService.getStudent(id);
	}
	
	
	@GetMapping(value="/search/{mail}")
	public Student getStudentByMail(@PathVariable(value = "mail") String mail) throws ResourceNotFoundException {
		
		return studentService.getStudentByMail(mail);
	}
	
	
	@GetMapping("/research/{firstName}/{lastName}")
	public List<Student> getStudentBySearch(@PathVariable(value = "firstName") String firstName, @PathVariable(value = "lastName") String lastName){
		
		return studentService.searchStudent(firstName, lastName);
		
	}
	
	@PostMapping("/create")
	public Student createStudent(@Valid @RequestBody Student student) {
		System.out.println("++++++++++++ REquestBody +++++++++++: "+ student);
		
		return studentService.createStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		
		studentService.deleteStudent(id);
		
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable(value = "id") Long id, @Valid @RequestBody Student student) throws ResourceNotFoundException {
		
		Student studentFound = studentService.getStudent(id);
		System.out.println("le student found"+studentFound.getId());
		Set<Course> studentCourses = studentFound.getCourses();
		studentCourses.addAll(student.getCourses());
		studentFound.setCourses(studentCourses);
		studentFound.setFirstName(student.getFirstName());
		studentFound.setLastName(student.getLastName());
		studentFound.setMail(student.getMail());
		studentFound.setPhone(student.getPhone());
		studentFound.setDob(student.getDob());
		studentFound.setAddress(student.getAddress());
		return  studentService.updateStudent(studentFound);
		
	}
	
	

}
