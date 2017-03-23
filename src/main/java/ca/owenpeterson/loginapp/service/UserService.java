package ca.owenpeterson.loginapp.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		RestTemplate restTemplate = new RestTemplate();;
		HttpEntity<UserDto> entity = new HttpEntity<UserDto>(newUser);
		
		ResponseEntity<AuthenticatedUser> response = restTemplate.exchange(URIConstants.CREATE_USER_URI, HttpMethod.POST, entity, AuthenticatedUser.class);
		
		HttpStatus responseCode = response.getStatusCode();
		
		return responseCode.equals(HttpStatus.CREATED);
	}
}
