package eu.ensup.partielspringbootweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.partielspringbootweb.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	

	public List<Student> findAllByFirstNameAndLastName(String firstName, String lastName);
	public Student findByMail(String mail);

}
