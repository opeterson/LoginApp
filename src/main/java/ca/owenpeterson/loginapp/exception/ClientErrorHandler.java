package ca.owenpeterson.loginapp.exception;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class ClientErrorHandler implements ErrorHandler 
{
	private static final Logger LOGGER = LogManager.getLogger(ClientErrorHandler.class);

	@Override
	public void handleError(ClientHttpResponse response) throws IOException
	{		
		String responseString = IOUtils.toString(response.getBody(), Charset.defaultCharset());
		
		if (null != responseString)
		{
			LOGGER.debug(responseString);
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode responseObject = mapper.readValue(responseString, ObjectNode.class);		
			
			if (responseObject.has("errorCode"))
			{
				JsonNode node = responseObject.get("httpStatus");
				LOGGER.debug(node.asText());
			}
		}

	}	
}
