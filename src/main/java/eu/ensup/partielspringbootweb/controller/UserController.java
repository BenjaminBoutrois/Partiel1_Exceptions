package eu.ensup.partielspringbootweb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ensup.partielspringbootweb.entities.User;
import eu.ensup.partielspringbootweb.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	
	
	/**
	 * @param userService
	 */
	public UserController(IUserService userService) {
		System.out.println("+++++++++++++++++++ Init user controller+++++++++++++++++");

		this.userService = userService;
	}




	@PostMapping("/login")
	public Map<String,User> getUser(@Valid @RequestBody User user) {
		System.out.println(user.toString());
		Map<String,User> map = new HashMap<String, User>();
 		User u = userService.getUser(user);
 		String message = "user";
		
		map.put(message,u);
		
		
		return map;
	}
	
	

}
