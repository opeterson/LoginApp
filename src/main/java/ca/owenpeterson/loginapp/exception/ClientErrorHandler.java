package ca.owenpeterson.loginapp.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class ClientErrorHandler implements ResponseErrorHandler
{
	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException 
	{
		boolean hasError = false;
		Series httpStatusCodeSeries = response.getStatusCode().series();
		if (httpStatusCodeSeries == HttpStatus.Series.CLIENT_ERROR || httpStatusCodeSeries == HttpStatus.Series.SERVER_ERROR)
		{
			hasError = true;
		}
		
		return hasError;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException
	{
		//response.close();
	}
}
