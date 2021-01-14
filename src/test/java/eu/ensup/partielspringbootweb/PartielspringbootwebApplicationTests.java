package eu.ensup.partielspringbootweb;

import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import eu.ensup.partielspringbootweb.entities.Course;
import eu.ensup.partielspringbootweb.entities.Student;
import eu.ensup.partielspringbootweb.repositories.StudentRepository;
import eu.ensup.partielspringbootweb.repositories.UserRepository;
import eu.ensup.partielspringbootweb.service.StudentServiceImpl;

@SpringBootTest
class PartielspringbootwebApplicationTests {

	
	@Mock
	StudentRepository mock = Mockito.mock(StudentRepository.class);
	
	@InjectMocks
	StudentServiceImpl studentService = new StudentServiceImpl(mock);

	
	Student gio = new Student("SIMON","GIOVANNI","giovanni.simon@free.fr","Paris","0123456789",new Date());
	Student ahmadou = new Student("LO","AHMADOU","lodou@free.fr","Montigny","1020304050",new Date());

	
	Course coursTest = new Course();
	Course math = new Course("math",12);
	Course francais = new Course("francais",6);
	
	
	/////ETUDIANT////////////////////////////////////////////////
	
	
	@Test
	public void testCreateStudent() {
		
		Mockito.doNothing().when(mock).save(gio);
		studentService.createStudent(gio);
		Mockito.verify(mock,Mockito.times(1)).save(gio);
				
	}
	
	@Test
	public void testDeleteStudent() {
		Mockito.doNothing().when(mock).delete(gio);
		studentService.deleteStudent(gio.getId());
		Mockito.verify(mock,Mockito.times(1)).delete(gio);
				
	}
	
	
	
}
