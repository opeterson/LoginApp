package ca.owenpeterson.loginapp.exception;

import java.io.IOException;

public class ClientException extends IOException
{
	private static final long serialVersionUID = 7918382633882490679L;
	
	public ClientException(String message)
	{
		super(message);
	}
}
