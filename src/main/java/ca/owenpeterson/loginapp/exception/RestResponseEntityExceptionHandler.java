package ca.owenpeterson.loginapp.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
	private static final String SIGNUP = "/views/signup/signup.jsp";
	static Logger logger = LogManager.getLogger(RestResponseEntityExceptionHandler.class);

	@ExceptionHandler(RestClientException.class)
	protected void handleRestClientException(RuntimeException ex, WebRequest request)
	{
		logger.debug("Handling an exception!");
		logger.debug("REQUEST =======================================");
		logger.debug(request);
		logger.debug("EXCEPTION =====================================");
		logger.debug(ex);
	}

}
