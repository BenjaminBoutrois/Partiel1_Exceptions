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
import eu.ensup.partielspringbootweb.entities.Student;
import eu.ensup.partielspringbootweb.service.IStudentService;

@RestController
@CrossOrigin
@RequestMapping("/Student")
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
	public Student getStudentById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
		
		return studentService.getStudent(id);
	}
	
	
	@GetMapping("/research/{firstName}/{lastName}")
	public List<Student> getStudentBySearch(@PathVariable(value = "firstName") String firstName, @PathVariable(value = "lastName") String lastName){
		
		return studentService.searchStudent(firstName, lastName);
		
	}
	
	@PostMapping("/create")
	public void createStudent(@Valid @RequestBody Student student) {
		System.out.println("++++++++++++ REquestBody +++++++++++: "+ student);
		
		studentService.createStudent(student);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable(value = "id") Integer id) {
		
		studentService.deleteStudent(id);
		
	}
	
	@PutMapping("/update/{id}")
	public void updateStudent(@PathVariable(value = "id") Integer id, @Valid @RequestBody Student student) throws ResourceNotFoundException {
		
		studentService.updateStudent(id, student);
	}
	
	

}
