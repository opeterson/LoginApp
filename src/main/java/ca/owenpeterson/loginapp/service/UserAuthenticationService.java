package ca.owenpeterson.loginapp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ca.owenpeterson.loginapp.models.AuthenticatedUser;
import ca.owenpeterson.loginapp.models.Credentials;
import ca.owenpeterson.loginapp.models.UserDto;

@Component
public class UserAuthenticationService 
{
	private static final Logger LOGGER = LogManager.getLogger(UserAuthenticationService.class);
	
	public AuthenticatedUser authenticateUser(Credentials credentials) throws IllegalArgumentException {
		if (null ==  credentials || null == credentials.getUsername() || null == credentials.getPassword()) {
			throw new IllegalArgumentException("CredentialService: authenticateUser: Credentials, username or password cannot be null!");
		}
		
		AuthenticatedUser user = new AuthenticatedUser();
		UserDto userDto = new UserDto();
		userDto.setUsername(credentials.getUsername());
		userDto.setPassword(credentials.getPassword());
		
		RestTemplate restTemplate = new RestTemplate();
		user = restTemplate.postForObject(URIConstants.AUTHENTICATE_USER_URI, userDto, AuthenticatedUser.class);
	
		LOGGER.debug("User was authenticated successfully. Returning user.");
		return user;
	}
}