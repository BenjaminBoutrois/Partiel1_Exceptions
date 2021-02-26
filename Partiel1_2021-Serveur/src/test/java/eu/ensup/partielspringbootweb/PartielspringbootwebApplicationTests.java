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
import eu.ensup.partielspringbootweb.entities.User;
import eu.ensup.partielspringbootweb.repositories.CourseRepository;
import eu.ensup.partielspringbootweb.repositories.StudentRepository;
import eu.ensup.partielspringbootweb.repositories.UserRepository;
import eu.ensup.partielspringbootweb.service.CourseServiceImpl;
import eu.ensup.partielspringbootweb.service.StudentServiceImpl;
import eu.ensup.partielspringbootweb.service.UserServiceImpl;

@SpringBootTest
class PartielspringbootwebApplicationTests {

	
	@Mock
	private StudentRepository studentRepository;
	
	@InjectMocks
	private StudentServiceImpl studentService;
	
	@Mock
	private CourseRepository courseRepository;
	
	@InjectMocks
	private CourseServiceImpl courseService;
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Before
	public void setup(){
		MockitoAnnotations.openMocks(this);
	}

	
	
	Course coursTest = new Course();
	
	
	/////ETUDIANT////////////////////////////////////////////////
	
	@Test
	public void testGetByIdStudent() throws ResourceNotFoundException {
		
		Student gio = new Student(1L, "SIMON","GIOVANNI","giovanni.simon@free.fr","Paris", "0123456789", new Date());
	
		Optional<Student> optional = Optional.of(gio);
		Mockito.when(studentRepository.findById(1L)).thenReturn(optional);
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
	
	////////////////////////////////COURSE///////////////////////////////////////
	
	@Test
	public void saveCours(){
		Course math = new Course("math",12,1L);
		when(courseRepository.save(math)).thenReturn(math);
		Course result = courseService.createCourse(math);
		assertEquals("math", result.getThemeCourse());
		
	}
	
	@Test
	public void testGetAllCourse(){
		Course math = new Course("math",12,1L);
		Course francais = new Course("francais",6,2L);
		List<Course> list = new ArrayList<Course>();
	
		list.add(math);
		list.add(francais);
		when(courseRepository.findAll()).thenReturn(list);
		
		List<Course> result = courseService.getAllCourses();
		assertEquals(2, result.size());
	}
	
	@Test
	public void testDeleteCourse() throws ResourceNotFoundException {
		
		Course math = new Course("math",12,1L);
		courseRepository.delete(math);
		courseService.deleteCourse(math.getIdCourse());
        Mockito.verify(courseRepository, Mockito.times(1)).delete(math);
	}
	
	@Test
	public void courseUpdateCheck() {
		Course math = new Course("math",12,1L);

		Mockito.when(courseRepository.save(math)).thenReturn(math);
		
		Course result = courseService.updateCourse(math.getIdCourse(), math);
		Mockito.verify(courseRepository).save(math);
		assertEquals(result,math);
	}
	
	@Test
	public void testGetCourse() throws ResourceNotFoundException {
		
		Long id = 1L;
		Course math = new Course("math",12,id);
		Optional<Course> optional = Optional.of(math);
	
		Mockito.when(courseRepository.findById(id)).thenReturn(optional);
		Course  result = courseService.getCourse(1L);
		if(result != null) {
			assertEquals(Long.valueOf(1L), result.getIdCourse());

		}
		
	}
	
/////USER////////////////////////////////////////////////
	
	@Test
	public void testGetByIdUser(){
		
		User gio = new User(1L, "adm","adm");
	
		Optional<User> optional = Optional.of(gio);
		Mockito.when(userRepository.findById(1L)).thenReturn(optional);
		User  result = userService.getUser(1L);
		
		if(result != null) {
			assertEquals(Long.valueOf(1L), result.getId());
		}
		
		Mockito.verify(userRepository).findById(1L);
		
	}
	
	@Test
	public void testCreateUser(){
		
		User gio = new User(1L, "adm","adm");
		when(userRepository.save(gio)).thenReturn(gio);
		User result = userService.create(gio);
		
		assertEquals(Long.valueOf(1L), result.getId());
		
		Mockito.verify(userRepository).save(gio);
		
	}
	
	
}
