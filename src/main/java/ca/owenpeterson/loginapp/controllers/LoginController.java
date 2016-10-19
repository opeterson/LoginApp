package ca.owenpeterson.loginapp.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import ca.owenpeterson.loginapp.models.AuthenticatedUser;
import ca.owenpeterson.loginapp.models.Credentials;
import ca.owenpeterson.loginapp.models.login.LoginError;
import ca.owenpeterson.loginapp.models.login.LoginForm;
import ca.owenpeterson.loginapp.service.UserAuthenticationService;

@Controller
public class LoginController {
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	@Autowired
	private UserAuthenticationService authenticationService;
	
	private String SUCCESS = "views/login/success.jsp";
	private String LOGIN = "views/login/login.jsp";

	@ModelAttribute("loginForm")
	public LoginForm getForm() {
		logger.debug("getForm: Begin/End");
		return new LoginForm();
	}
	
	@ModelAttribute("errors")
	public LoginError getErrors() {
		logger.debug("getErrors: Begin/End");
		return new LoginError();
	}
		
	@RequestMapping(value="/login", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ModelAndView getView(@ModelAttribute("errors") LoginError errors) {
		logger.debug("getView: Begin");
		ModelAndView view = new ModelAndView(LOGIN, "errors", errors);
		logger.debug("getView: End");
		return view;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody ModelAndView doLogin(@ModelAttribute("loginForm") LoginForm loginForm, @ModelAttribute("errors") LoginError errors) {
		logger.debug("doLogin: Begin");
		logger.debug("doLogin: User logged in with username: " + loginForm.getUsername());
		logger.debug("doLogin: User logged in with password: " + loginForm.getPassword());
		
		ModelAndView view = null;
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if ("".equals(username) || "".equals(password)) {
			view = handleLoginError(errors);
		} else {
			Credentials credentials = new Credentials(username, password);
			AuthenticatedUser user = authenticationService.authenticateUser(credentials);
			
			if (null != user.getUsername()) {
				view = handleLoginSuccess(loginForm);
			} else {
				view = handleLoginError(errors);
			}
		}		
		
		logger.debug("doLogin: End");
		return view;
	}

	private ModelAndView handleLoginSuccess(LoginForm loginForm) {
		ModelAndView view;
		view = new ModelAndView(SUCCESS, "loginForm", loginForm);
		logger.debug("doLogin: Username or password entered. Sending user to success page.");
		return view;
	}

	private ModelAndView handleLoginError(LoginError errors) {
		ModelAndView view;
		errors.setCssClass("loginerror");
		errors.setErrorMessage("Invalid Username or Password.");
		view = new ModelAndView(LOGIN, "errors", errors);
		logger.debug("doLogin: Username or password was invalid. Sending user to login.");
		return view;
	}
}
