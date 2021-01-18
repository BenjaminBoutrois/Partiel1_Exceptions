package service;

import domaine.User;

public interface IUserServiceClient {

	/**
	 * Methode de connexion d'un utilisateur
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * Methode pour recuperer un user
	 * @return
	 */
	User getUser();

}