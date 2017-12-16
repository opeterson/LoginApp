package ca.owenpeterson.loginapp.exception;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler
{
	private static final Logger LOGGER = LogManager.getLogger(RestTemplateErrorHandler.class);
	
	@Autowired
	private ClientErrorHandler clientErrorHandler;
	
	@Autowired
	private ServerErrorHandler serverErrorHandler;
	
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
		HttpStatus reponseStatus = response.getStatusCode();
		
		if (reponseStatus.series().equals(HttpStatus.Series.CLIENT_ERROR))
		{
			LOGGER.debug("Handling a client error.");
			clientErrorHandler.handleError(response);
		}
		else if (reponseStatus.series().equals(HttpStatus.Series.SERVER_ERROR))
		{
			LOGGER.debug("Handling a server error.");
			serverErrorHandler.handleError(response);
		}
	}
}
