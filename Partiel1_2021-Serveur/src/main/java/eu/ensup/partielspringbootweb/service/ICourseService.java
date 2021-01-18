package eu.ensup.partielspringbootweb.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import eu.ensup.partielspringbootweb.config.ResourceNotFoundException;
import eu.ensup.partielspringbootweb.entities.Course;
import eu.ensup.partielspringbootweb.entities.Course;


public interface ICourseService
{

	/**
	 * Crée un cours en base de données.
	 * 
	 * @param course Cours à créer.
	 * @return 
	 */
	Course createCourse(Course course);
	
	/**
	 * Retourne un cours en fonction de son id.
	 * 
	 * @param id L'id du cours à chercher.
	 * @return Le cours dont l'id correspond.
	 * @throws ResourceNotFoundException 
	 */
	Course getCourse(Long id) throws ResourceNotFoundException;

	

	/**
	 * Retourne tous les cours de la base de données.
	 * 
	 * @return La liste de tous les cours de la base de données.
	 */
	List<Course> getAllCourses();

	

	/**
	 * Met à jour les données d'un cours.
	 * 
	 * @param course      Un objet cours avec les nouvelles données.
	 * @return 
	 */
	Course updateCourse(Long id,Course course);
	
	/**
	 * Supprime un cours de la base de données en fonction de son id.
	 * 
	 * @param id L'id du cours à supprimer.
	 */
	void deleteCourse(Long id);

	
}