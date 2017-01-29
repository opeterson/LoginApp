package ca.owenpeterson.loginapp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ca.owenpeterson.loginapp.models.AuthenticatedUser;
import ca.owenpeterson.loginapp.models.UserDto;

/**
 * @author owen
 *
 */
@Component
public class UserService {
	
	public boolean createUser(UserDto newUser)
	{
		RestTemplate restTemplate = new RestTemplate();
		AuthenticatedUser createdUser = restTemplate.postForObject(URIConstants.CREATE_USER_URI, newUser, AuthenticatedUser.class);
		
		return null != createdUser;
	}
}
