package ca.owenpeterson.loginapp.exception;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;

public interface ErrorHandler 
{
	public void handleError(ClientHttpResponse response) throws IOException;
}
