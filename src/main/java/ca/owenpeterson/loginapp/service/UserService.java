package ca.owenpeterson.loginapp.service;

import org.springframework.stereotype.Component;

import ca.owenpeterson.loginapp.models.UserDto;

/**
 * TODO: Have this class post to http://localhost:8080/userservice/user/create to create a new user. 
 * @author owen
 *
 */
@Component
public class UserService {
	
	public boolean createUser(UserDto newUser)
	{
		return newUser.getUsername().equals("owenpeterson");
	}
}
