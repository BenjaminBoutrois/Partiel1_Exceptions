package eu.ensup.partielspringbootweb;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import eu.ensup.partielspringbootweb.config.ResourceNotFoundException;
import eu.ensup.partielspringbootweb.entities.Course;
import eu.ensup.partielspringbootweb.repositories.CourseRepository;
import eu.ensup.partielspringbootweb.service.CourseServiceImpl;

@SpringBootTest
public class CourseServiceTest {
	
	
	@Mock
	private CourseRepository courseRepository;
	
	@InjectMocks
	private CourseServiceImpl courseService;
	
	

	
	@BeforeEach
	void beforeEach() {
		
	
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void saveCours(){
		Course math = new Course("math",12,1L);
		when(courseRepository.save(math)).thenReturn(math);
		Course result = courseService.createCourse(math);
		
		assertEquals(math.getIdCourse(), result.getIdCourse());
		
		verify(courseRepository).save(math);
		
		
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
		assertEquals(list.size(), result.size());
		
		verify(courseRepository).findAll();
	}
	
	@Test
	public void testDeleteCourse()  {
		
		Course math = new Course("math",12,1L);
		//doNothing().when(courseRepository).delete(math);
		when(courseRepository.findById(math.getIdCourse())).thenReturn(Optional.of(math));
		courseService.deleteCourse(math.getIdCourse());
		
        verify(courseRepository).delete(math);
		verify(courseRepository).findById(math.getIdCourse());

	}
	
	
	@Test
	public void courseUpdateCheck() {
		Course math = new Course("math",12,1L);

		when(courseRepository.save(math)).thenReturn(math);
		when(courseRepository.findById(math.getIdCourse())).thenReturn(Optional.of(math));
		
		Course result = courseService.updateCourse(math.getIdCourse(), math);
		 assumingThat(result != null,
		            () -> {
		        		assertEquals(math.getNumberHours(), result.getNumberHours());

		            });
		
	
		verify(courseRepository).save(math);
		verify(courseRepository).findById(math.getIdCourse());
	}
	
	@Test
	public void testGetCourse() throws ResourceNotFoundException {
		
		Long id = 1L;
		Course math = new Course("math",12,id);
		Optional<Course> optional = Optional.of(math);
	
		when(courseRepository.findById(id)).thenReturn(optional);
		Course  result = courseService.getCourse(1L);
	
			assertEquals(Long.valueOf(1L), result.getIdCourse());
			verify(courseRepository).findById(id);

		
		
	}

}
