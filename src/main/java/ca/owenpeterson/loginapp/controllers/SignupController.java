package ca.owenpeterson.loginapp.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ca.owenpeterson.loginapp.models.signup.SignupError;
import ca.owenpeterson.loginapp.models.signup.SignupForm;

@Controller
public class SignupController {
	private static final Logger logger = LogManager.getLogger(SignupController.class);
	
	private static final String SIGNUP = "/views/signup/signup.jsp";
	private static final String SUCCESS = "/views/signup/signupSuccess.jsp";
	
	@ModelAttribute("signupForm")
	public SignupForm getForm() {
		logger.debug("getForm: Begin/End");
		return new SignupForm();
	}
	
	@ModelAttribute("errors")
	public SignupError getErrors() {
		logger.debug("getErrors: Begin/End");
		return new SignupError();
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ModelAndView getView(@ModelAttribute("errors") SignupError errors) {
		logger.debug("getView: Begin");
		ModelAndView view = new ModelAndView(SIGNUP, "errors", errors);
		logger.debug("getView: End");
		return view;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ModelAndView doSignup(@ModelAttribute("signupForm") SignupForm signupForm, @ModelAttribute("errors") SignupError errors)
	{
		logger.debug("doSignup: begin");
		ModelAndView view = null;
		view = new ModelAndView(SUCCESS, "errors", errors);
		logger.debug("doSignup: end");
		return view;
	}
}
