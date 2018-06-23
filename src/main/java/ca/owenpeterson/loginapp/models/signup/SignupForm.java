package ca.owenpeterson.loginapp.models.signup;

import java.util.List;

/**
 * A Model object used by the signup.jsp page to contain user information when creating a new account.
 * @author owen
 *
 */
public class SignupForm 
{
	
	private String username;
	private String password;
	private String confirmPassword;
	private String email;
	private List<SignupError> signupErrors;
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}	
	
	public String getConfirmPassword() 
	{
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) 
	{
		this.confirmPassword = confirmPassword;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public List<SignupError> getSignupErrors() 
	{
		return signupErrors;
	}

	public void setSignupErrors(List<SignupError> messages) 
	{
		this.signupErrors = messages;
	}
}
