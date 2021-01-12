package eu.ensup.partielspringbootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ensup.partielspringbootweb.entities.User;
import eu.ensup.partielspringbootweb.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	
	
	/**
	 * @param userService
	 */
	public UserController(IUserService userService) {
		this.userService = userService;
	}




	@GetMapping("/login")
	public User getUser(User user) {
		
		return userService.getUser(user);
	}
	
	

}
