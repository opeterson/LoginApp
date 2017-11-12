package ca.owenpeterson.loginapp.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ca.owenpeterson.loginapp.exception.ClientErrorHandler;
import ca.owenpeterson.loginapp.models.AuthenticatedUser;
import ca.owenpeterson.loginapp.models.UserDto;

/**
 * @author owen
 *
 */
@Component
public class UserService {
	
	public AuthenticatedUser createUser(UserDto newUser)
	{
		RestTemplate restTemplate = new RestTemplate();
		ClientErrorHandler clientErrorHandler = new ClientErrorHandler();
		restTemplate.setErrorHandler(clientErrorHandler);
		HttpEntity<UserDto> entity = new HttpEntity<UserDto>(newUser);
		ResponseEntity<AuthenticatedUser> response = null;
		
		//TODO: Figure out how to get different responses from a service. If there is an error, and Userservice returns an error response,
		//this still creates an AuthenticatedUser with null properties. This won't work for proper error handling.
		response = restTemplate.exchange(URIConstants.CREATE_USER_URI, HttpMethod.POST, entity, AuthenticatedUser.class);
		
		AuthenticatedUser user = response.getBody();
		
		return user;
	}
}
