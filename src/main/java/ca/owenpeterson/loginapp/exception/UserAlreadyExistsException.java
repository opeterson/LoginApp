package ca.owenpeterson.loginapp.exception;

public class UserAlreadyExistsException extends ClientException 
{
	private static final long serialVersionUID = -2870453151940691207L;
	
	public UserAlreadyExistsException(String message)
	{
		super(message);
	}
}
