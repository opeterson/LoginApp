package ca.owenpeterson.loginapp.exception;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ServerErrorHandler implements ErrorHandler 
{

	@Override
	public void handleError(ClientHttpResponse response) 
	{
		//TODO redirect to error page somehow.
	}	
}
