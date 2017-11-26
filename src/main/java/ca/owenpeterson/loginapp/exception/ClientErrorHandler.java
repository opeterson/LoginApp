package ca.owenpeterson.loginapp.exception;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class ClientErrorHandler implements ResponseErrorHandler
{
	private static final Logger LOGGER = LogManager.getLogger(ClientErrorHandler.class);
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
		String responseString = IOUtils.toString(response.getBody(), Charset.defaultCharset());
		if (null != responseString)
		{
			LOGGER.debug(responseString);
		}
		
		//TODO: Look at the HttpStatus. If its one that I'm expecting, parse it, look at the error code and throw an appropriate exception.
	}
}
