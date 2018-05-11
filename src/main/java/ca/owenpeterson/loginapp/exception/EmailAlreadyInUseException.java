package ca.owenpeterson.loginapp.exception;

public class EmailAlreadyInUseException extends ClientException 
{
	private static final long serialVersionUID = -2696859060943119573L;

	public EmailAlreadyInUseException(String message) 
	{
		super(message);
	}
}
