package eu.ensup.partielspringbootweb;

import static org.junit.Assert.assertEquals;

import java.util.Date;

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

	
	Student gio = new Student("SIMON","GIOVANNI","giovanni.simon@free.fr","Paris","0123456789",new Date());
	Student ahmadou = new Student("LO","AHMADOU","lodou@free.fr","Montigny","1020304050",new Date());

	
	Course coursTest = new Course();
	Course math = new Course("math",12);
	Course francais = new Course("francais",6);
	
	
	/////ETUDIANT////////////////////////////////////////////////
	
	@Test
	public void testGetByIdStudent() throws ResourceNotFoundException {
		
		Long id = 1L;
		Student gio = new Student("SIMON","GIOVANNI","giovanni.simon@free.fr","Paris","0123456789",new Date(),id);
		//studentService.getStudent(gio.getId());
        //Mockito.verify(studentRepository, Mockito.times(1)).getOne(gio.getId());	
		Mockito.when(studentRepository.findById(1L).get()).thenReturn(gio);
		Student result = studentService.getStudent(1L);
		assertEquals(Long.valueOf(1L), result.getId());
		//assertEquals("Todo Sample 1", result.getText());
		//assertEquals(true, result.isCompleted());
	}
	
	@Test
	public void testDeleteStudent() {
		
		Long id = 1L;
		Student gio = new Student("SIMON","GIOVANNI","giovanni.simon@free.fr","Paris","0123456789",new Date());
		gio.setId(id);
		studentService.deleteStudent(gio.getId());
        Mockito.verify(studentRepository, Mockito.times(1)).delete(gio);	
	}	
	
	
}
