package eu.ensup.partielspringbootweb;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import eu.ensup.partielspringbootweb.config.ResourceNotFoundException;
import eu.ensup.partielspringbootweb.entities.Course;
import eu.ensup.partielspringbootweb.entities.Student;
import eu.ensup.partielspringbootweb.repositories.StudentRepository;
import eu.ensup.partielspringbootweb.repositories.UserRepository;
import eu.ensup.partielspringbootweb.service.StudentServiceImpl;

@SpringBootTest
class PartielspringbootwebApplicationTests {

	
	@Mock
	private StudentRepository studentRepository;
	
	@InjectMocks
	private StudentServiceImpl studentService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	
	
	Course coursTest = new Course();
	Course math = new Course("math",12);
	Course francais = new Course("francais",6);
	
	
	/////ETUDIANT////////////////////////////////////////////////
	
	@Test
	public void testGetByIdStudent() throws ResourceNotFoundException {
		
		Student gio = new Student(1L, "SIMON","GIOVANNI","giovanni.simon@free.fr","Paris", "0123456789", new Date());
	
		Mockito.when(studentRepository.findById(1L).get()).thenReturn(gio);
		Student  result = studentService.getStudent(1L);
		if(result != null) {
			assertEquals(Long.valueOf(1L), result.getId());

		}
		
	}
	
	@Test
	public void testDeleteStudent() throws ResourceNotFoundException {
		
		Student gio = new Student(1L, "SIMON","GIOVANNI","giovanni.simon@free.fr","Paris", "0123456789", new Date());
		studentRepository.delete(gio);
		studentService.deleteStudent(gio.getId());
        Mockito.verify(studentRepository, Mockito.times(1)).delete(gio);
	}	
	
	@Test
	public void saveStudent(){
		Student gio = new Student(1L, "SIMON","TIMA","giovanni.simon@free.fr","Paris", "0123456789", new Date());
		when(studentRepository.save(gio)).thenReturn(gio);
		Student result = studentService.createStudent(gio);
		assertEquals(Long.valueOf(1L), result.getId());
		
	}
	
	@Test
	public void testGetAllStudent(){
		List<Student> list = new ArrayList<Student>();
	
		list.add(new Student(1L, "SIMON","TIMA","giovanni.simon@free.fr","Paris", "0123456789", new Date()));
		list.add(new Student(2L, "SIMON","GIIIIII","giovanni.simon@free.fr","Paris", "0123456789", new Date()));
		when(studentRepository.findAll()).thenReturn(list);
		
		List<Student> result = studentService.getAllStudents();
		assertEquals(2, result.size());
	}
	
	
	@Test
	public void studentUpdateCheck() {
		Student gio = new Student(1L, "SIMON","TIMA","giovanni.simon@free.fr","Paris", "0123456789", new Date());

		Mockito.when(studentRepository.save(gio)).thenReturn(gio);
		
		Student result = studentService.updateStudent(gio);
		Mockito.verify(studentRepository).save(result);
	}
	
	
}
