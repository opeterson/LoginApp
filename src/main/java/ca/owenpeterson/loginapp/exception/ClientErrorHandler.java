package ca.owenpeterson.loginapp.exception;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ca.owenpeterson.loginapp.enums.ErrorCode;

@Component
public class ClientErrorHandler implements ErrorHandler 
{
	private static final Logger LOGGER = LogManager.getLogger(ClientErrorHandler.class);

	@Override
	public void handleError(ClientHttpResponse response) throws IOException, ClientException
	{		
		String responseString = IOUtils.toString(response.getBody(), Charset.defaultCharset());
		List<ErrorCode> errorCodes = null;
		try
		{
			errorCodes = parseErrorCodes(responseString);
		}
		catch (IOException e)
		{
			LOGGER.error("Could not parse ErrorCodes from response.");
			LOGGER.error(e);
		}
		
		if (!CollectionUtils.isEmpty(errorCodes))
		{
			determineAndThrowAppropriateException(errorCodes);
		}
	}

	private void determineAndThrowAppropriateException(List<ErrorCode> errorCodes) throws ClientException 
	{
		if (errorCodes.size() == 1)
		{
			throwSingleException(errorCodes.get(0));
		}
		else
		{
			throwMultiCauseException(errorCodes);
		}
	}

	private void throwMultiCauseException(List<ErrorCode> errorCodes) throws ClientException 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Server returned multiple error codes. Causes: ");
		
		for (ErrorCode errorCode : errorCodes)
		{
			sb.append(errorCode.getMessage() + " : ");
		}
		
		String causes = sb.toString();
		sb.setLength(0);
		
		throw new ClientException(causes);
		
	}

	private void throwSingleException(ErrorCode errorCode) throws EmailAlreadyInUseException, UserAlreadyExistsException 
	{
		if (errorCode.getCode().equals(ErrorCode.EMAIL_IN_USE.getCode()))
		{
			throw new EmailAlreadyInUseException(errorCode.getMessage());
		}
		
		if (errorCode.getCode().equals(ErrorCode.USERNAME_EXISTS.getCode()))
		{
			throw new UserAlreadyExistsException(errorCode.getMessage());
		}		
	}

	private List<ErrorCode> parseErrorCodes(String responseString) throws JsonParseException, JsonMappingException, IOException 
	{
		List<ErrorCode> errorCodes = new ArrayList<ErrorCode>();
		if (null != responseString)
		{
			LOGGER.debug(responseString);
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode responseObject = mapper.readValue(responseString, ObjectNode.class);		
			
			if (responseObject.has("httpStatus"))
			{
				JsonNode node = responseObject.get("httpStatus");
				LOGGER.debug(node.asText());
			}
			
			if (responseObject.has("errorMessages"))
			{
				LOGGER.debug("Response contained error messages.");
				JsonNode errorMessages = responseObject.get("errorMessages");
				
				if (errorMessages.isArray())
				{
					for (JsonNode errorMessageNode : errorMessages)
					{
						if (errorMessageNode.has("errorCode"))
						{
							JsonNode errorCodeNode = errorMessageNode.get("errorCode");
							String code = errorCodeNode.get("code").textValue();
							String message = errorCodeNode.get("message").textValue();
							LOGGER.debug("CODE: " + code);
							LOGGER.debug("MESSAGE: " + message);
							errorCodes.add(ErrorCode.fromCode(code));
							
						}
					}
				}
			}
		}
		
		return errorCodes;
	}	
}
