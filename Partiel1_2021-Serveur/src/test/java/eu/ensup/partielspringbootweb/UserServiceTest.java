package eu.ensup.partielspringbootweb;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import eu.ensup.partielspringbootweb.entities.User;
import eu.ensup.partielspringbootweb.repositories.CourseRepository;
import eu.ensup.partielspringbootweb.repositories.StudentRepository;
import eu.ensup.partielspringbootweb.repositories.UserRepository;
import eu.ensup.partielspringbootweb.service.CourseServiceImpl;
import eu.ensup.partielspringbootweb.service.StudentServiceImpl;
import eu.ensup.partielspringbootweb.service.UserServiceImpl;

@SpringBootTest
public class UserServiceTest {
	
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
	
	User gio;
	
	@BeforeEach
	public void setupForEach(){
		User gio = new User(1L, "adm","adm");
	}
	
/////USER////////////////////////////////////////////////
	
	@Test
	public void testGetByIdUser(){
	
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
		
		when(userRepository.save(gio)).thenReturn(gio);
		User result = userService.create(gio);
		
		assertEquals(Long.valueOf(1L), result.getId());
		
		Mockito.verify(userRepository).save(gio);
		
	}

}
