package ca.owenpeterson.loginapp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.owenpeterson.loginapp.models.AuthenticatedUser;
import ca.owenpeterson.loginapp.models.Credentials;

public class CredentialService {

	private static final Logger logger = LogManager.getLogger(CredentialService.class.getName());
	
	public AuthenticatedUser authenticateUser(Credentials credentials) throws IllegalArgumentException {
		if (null ==  credentials || null == credentials.getUsername() || null == credentials.getPassword()) {
			throw new IllegalArgumentException("CredentialService: authenticateUser: Credentials, username or password cannot be null!");
		}
		
		AuthenticatedUser user = new AuthenticatedUser();
		if ("oapdev".equals(credentials.getUsername()) && "qwerty123".equals(credentials.getPassword())) {
			user.setUsername("oapdev");
			user.setEmail("oapdev@oapdev.ca");
			logger.debug("CredentialService: authenticateUser: User logged in with valid credentials");
		}
	
		return user;
	}
}
