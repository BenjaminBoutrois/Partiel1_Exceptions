package eu.ensup.partielspringbootweb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.partielspringbootweb.entities.Course;

@Repository
public interface CourseRepository  extends CrudRepository<Course, Integer>{

}
