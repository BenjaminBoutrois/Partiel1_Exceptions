package eu.ensup.partielspringbootweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.partielspringbootweb.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	//@EntityGraph(attributePaths = {"courses"})
    @EntityGraph(value = "Student.courses")
	public List<Student> findAllByFirstNameAndLastName(String firstName, String lastName);
    @EntityGraph(value = "Student.courses")
	public Student findByMail(String mail);

}
