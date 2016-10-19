package ca.owenpeterson.loginapp.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ca.owenpeterson.loginapp.models.UserDto;
import ca.owenpeterson.loginapp.models.signup.SignupForm;
import ca.owenpeterson.loginapp.service.UserService;

@Controller
public class SignupController {
	private static final Logger logger = LogManager.getLogger(SignupController.class);
	
	private static final String SIGNUP = "/views/signup/signup.jsp";
	private static final String SUCCESS = "/views/signup/signupSuccess.jsp";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("signupValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(validator);
	}
	
	@ModelAttribute("signupForm")
	public SignupForm getForm() {
		logger.debug("getForm: Begin/End");
		return new SignupForm();
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ModelAndView getView() {
		logger.debug("getView: Begin");
		ModelAndView view = new ModelAndView(SIGNUP);
		logger.debug("getView: End");
		return view;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ModelAndView doSignup(@Validated @ModelAttribute("signupForm") SignupForm signupForm, BindingResult result)
	{
		logger.debug("doSignup: begin");
		ModelAndView view = null;
		if (result.hasErrors())
		{
			view = new ModelAndView(SIGNUP);
		}
		else
		{
			UserDto user = new UserDto();
			user.setUsername(signupForm.getUsername());
			user.setPassword(signupForm.getPassword());
			user.setEmail(signupForm.getEmail());
			boolean userCreated = userService.createUser(user);
			
			if (userCreated)
			{
				signupForm.setPassword("");
				signupForm.setConfirmPassword("");
				view = new ModelAndView(SUCCESS, "signupForm", signupForm);
			}
			else
			{
				view = new ModelAndView(SIGNUP);
			}
		}
		
		logger.debug("doSignup: end");
		return view;
	}
}
