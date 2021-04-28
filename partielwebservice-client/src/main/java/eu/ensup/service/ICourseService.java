package eu.ensup.service;

import java.util.List;

import javax.ws.rs.core.Response;

import eu.ensup.domaine.Course;

public interface ICourseService
{
	/**
	 * Methode pour recupere la liste des cours
	 * 
	 * @return
	 */
	List<Course> getAllCourses();

	/**
	 * Methode pour rechercher un cours par son id
	 * 
	 * @param id
	 * @return
	 */
	Course getCourseById(Long id);

	/**
	 * Methode pour créer un cours
	 * 
	 * @param cours
	 * @return
	 */
	Response createCourse(Course cours);

	/**
	 * Methode pour modifie un cours
	 * 
	 * @param id
	 * @param cours
	 * @return
	 */
	Response updateCourse(Long id, Course cours);

	/**
	 * Methode pour supprimer un cours
	 * 
	 * @param id
	 * @return
	 */
	Response deleteCourse(Long id);
}