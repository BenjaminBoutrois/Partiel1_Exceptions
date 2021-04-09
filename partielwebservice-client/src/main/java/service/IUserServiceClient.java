package service;

import domaine.User;
import exceptions.UserNotFoundException;

public interface IUserServiceClient
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