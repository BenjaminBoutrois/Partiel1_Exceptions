package eu.ensup.service;

import eu.ensup.domaine.User;
import eu.ensup.exceptions.UserNotFoundException;

public interface IUserService
{
	/**
	 * Methode de connexion d'un utilisateur
	 * 
	 * @param user
	 * @return
	 */
	User login(User user) throws UserNotFoundException;

	/**
	 * Methode pour recuperer un user
	 * 
	 * @return
	 */
	User getUser();
}