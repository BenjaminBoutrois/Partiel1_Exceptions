package eu.ensup.partielspringbootweb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import eu.ensup.partielspringbootweb.entities.User;
import eu.ensup.partielspringbootweb.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService
{
	@Autowired
	private UserRepository userRepo;

	/**
	 * @param userRepo
	 */
	public UserServiceImpl(UserRepository userRepo)
	{
		this.userRepo = userRepo;
	}

	/**
	 * Methode de connexion
	 * 
	 * @param user
	 * @return renvoi l'utilisateur trouver
	 */
	@Override
	public User getUser(User user)
	{
		User userResult = userRepo.findByLoginAndPassword(user.getLogin(), user.getPassword());

		if (userResult == null)
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found.");
		else
			return userResult;
		// return null;
	}

	/**
	 * Methode de connexion
	 * 
	 * @param user
	 * @return renvoi l'utilisateur trouver
	 */
	@Override
	public User getUser(Long id)
	{
		Optional<User> userResult = userRepo.findById(id);
		User user = null;

		if (userResult.isPresent())
		{
			user = userResult.get();
		}

		return user;

		/*
		 * if (userResult == null) throw new
		 * ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found."); else
		 * return userResult;
		 */
		// return null;
	}

	/**
	 * Methoode de creation d'utilisateur
	 * 
	 * @param login
	 * @param password
	 * @return renvoi l'utilisateur créer
	 */
	@Override
	public User create(String login, String password)
	{
		User user = new User(login, password);

		return userRepo.save(user);
	}

	/**
	 * Methoode de creation d'utilisateur
	 * 
	 * @param login
	 * @param password
	 * @return renvoi l'utilisateur créer
	 */
	@Override
	public User create(User u)
	{
		// User user = new User(u.getLogin(), u.getPassword());

		return userRepo.save(u);
	}
}
