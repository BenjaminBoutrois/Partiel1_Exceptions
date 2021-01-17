package eu.ensup.partielspringbootweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import eu.ensup.partielspringbootweb.entities.User;
import eu.ensup.partielspringbootweb.repositories.UserRepository;


@Service
public class UserServiceImpl  implements IUserService{
	
	@Autowired
	private UserRepository userRepo;
	
	

	/**
	 * @param userRepo
	 */
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}



	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.findByLoginAndPassword(user.getLogin(), user.getPassword());
		//return null;
	}
	
	@Override
	public User create(String login , String password) {
		
		User user = new User(login, password);
		
		return userRepo.save(user);
	}

}
