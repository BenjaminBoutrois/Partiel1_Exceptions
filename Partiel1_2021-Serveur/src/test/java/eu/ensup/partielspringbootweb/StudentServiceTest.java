package eu.ensup.partielspringbootweb;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import eu.ensup.partielspringbootweb.config.ResourceNotFoundException;
import eu.ensup.partielspringbootweb.entities.Course;
import eu.ensup.partielspringbootweb.entities.Student;
import eu.ensup.partielspringbootweb.repositories.StudentRepository;
import eu.ensup.partielspringbootweb.service.StudentServiceImpl;

@SpringBootTest
class StudentServiceTest
{
	@Mock
	private StudentRepository studentRepository;

	@InjectMocks
	private StudentServiceImpl studentService;

	@Before
	public void setup()
	{
		MockitoAnnotations.openMocks(this);
	}

	Course coursTest = new Course();

	///// ETUDIANT////////////////////////////////////////////////

	@Test
	public void testGetByIdStudent() throws ResourceNotFoundException
	{
		Student gio = new Student(1L, "SIMON", "GIOVANNI", "giovanni.simon@free.fr", "Paris", "0123456789", new Date());

		Optional<Student> optional = Optional.of(gio);
		
		when(studentRepository.findById(1L)).thenReturn(optional);
		
		Student result = studentService.getStudent(1L);
		
		if (result != null)
		{
			assertEquals(Long.valueOf(1L), result.getId());

		}
		
		verify(studentRepository).findById(1L);
	}

	@Test
	public void testDeleteStudent()
	{
		Student gio = new Student(1L, "SIMON", "GIOVANNI", "giovanni.simon@free.fr", "Paris", "0123456789", new Date());
		
		when(studentRepository.findById(gio.getId())).thenReturn(Optional.of(gio));
		
		studentService.deleteStudent(gio.getId());
		
		verify(studentRepository).delete(gio);
	}

	@Test
	public void saveStudent()
	{
		Student gio = new Student(1L, "SIMON", "TIMA", "giovanni.simon@free.fr", "Paris", "0123456789", new Date());
		
		when(studentRepository.save(gio)).thenReturn(gio);
		
		Student result = studentService.createStudent(gio);
		
		assertEquals(Long.valueOf(1L), result.getId());
		
		verify(studentRepository).save(gio);
	}

	@Test
	public void testGetAllStudent()
	{
		List<Student> list = new ArrayList<Student>();

		list.add(new Student(1L, "SIMON", "TIMA", "giovanni.simon@free.fr", "Paris", "0123456789", new Date()));
		list.add(new Student(2L, "SIMON", "GIIIIII", "giovanni.simon@free.fr", "Paris", "0123456789", new Date()));
		
		when(studentRepository.findAll()).thenReturn(list);

		List<Student> result = studentService.getAllStudents();
		
		assertEquals(2, result.size());
		
		verify(studentRepository).findAll();
	}

	@Test
	public void studentUpdateCheck()
	{
		Student gio = new Student(1L, "SIMON", "TIMA", "giovanni.simon@free.fr", "Paris", "0123456789", new Date());

		when(studentRepository.findById(gio.getId())).thenReturn(Optional.of(gio));
		
		Student result = studentService.updateStudent(gio);
		
		Assumptions.assumingThat(result != null, () ->
		{
			assertEquals(result, gio);
		});
		
		verify(studentRepository).save(gio);
	}
}
