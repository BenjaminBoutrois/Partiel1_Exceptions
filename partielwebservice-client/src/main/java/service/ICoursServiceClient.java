package service;

import java.util.List;

import javax.ws.rs.core.Response;

import domaine.Course;

public interface ICoursServiceClient {

	/**
	 * Methode pour recupere la liste des cours
	 * @return
	 */
	List<Course> getAllCours();

	/**
	 * Methode pour rechercher un cours par son id
	 * @param id
	 * @return
	 */
	Course getCoursById(Long id);

	/**
	 * Methode pour créer un cours
	 * @param cours
	 * @return
	 */
	Response createCours(Course cours);

	/**
	 * Methode pour modifie un cours
	 * @param id
	 * @param cours
	 * @return
	 */
	Response updateCours(Long id, Course cours);

	/**
	 * Methode pour supprimer un cours
	 * @param id
	 * @return
	 */
	Response deleteCours(Long id);

}