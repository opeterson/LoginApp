package ca.owenpeterson.loginapp.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
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
	
	public boolean createUser(UserDto newUser)
	{
		boolean created = false;
		RestTemplate restTemplate = new RestTemplate();
		ClientErrorHandler clientErrorHandler = new ClientErrorHandler();
		restTemplate.setErrorHandler(clientErrorHandler);
		HttpEntity<UserDto> entity = new HttpEntity<UserDto>(newUser);
		ResponseEntity<AuthenticatedUser> response = null;
		
		try
		{
			response = restTemplate.exchange(URIConstants.CREATE_USER_URI, HttpMethod.POST, entity, AuthenticatedUser.class);
			//response = restTemplate.postForEntity(URIConstants.CREATE_USER_URI, entity, AuthenticatedUser.class);
			
		}
		catch (HttpClientErrorException e)
		{
			//TODO: Probably dont' need this try-catch anymore.
		}
		
		//TODO: Much better error handling. Headers? Different response body? How do I get more information back from the userservice?
		//TODO: Display an error to the user.
		if (response.getStatusCode() == HttpStatus.CREATED)
		{
			created = true;
		}
		
		return created;
	}
}
