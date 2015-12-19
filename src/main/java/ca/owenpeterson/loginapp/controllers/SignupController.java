package ca.owenpeterson.loginapp.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {
	private static final Logger logger = LogManager.getLogger(SignupController.class);
	
	private static final String SIGNUP = "/views/signup/signup.jsp";
	
	@RequestMapping(value="/createaccount", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ModelAndView getView() {
		logger.debug("getView: Begin");
		ModelAndView view = new ModelAndView(SIGNUP);
		logger.debug("getView: End");
		return view;
	}
}
