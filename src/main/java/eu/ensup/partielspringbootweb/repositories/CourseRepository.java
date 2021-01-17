package eu.ensup.partielspringbootweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.partielspringbootweb.entities.Course;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long>{

}
