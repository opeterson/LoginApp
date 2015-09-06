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

import ca.owenpeterson.loginapp.models.LoginForm;

@Controller
public class LoginController {
	
	Logger logger = LogManager.getLogger(LoginController.class);

	@RequestMapping(value="/login", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ModelAndView getView() {
		logger.debug("LoginController: getView: Begin");
		ModelAndView view = new ModelAndView("views/login/login.jsp");
		logger.debug("LoginController: getView: End");
		return view;
	}
	
	@ModelAttribute("loginForm")
	public LoginForm getForm() {
		logger.debug("LoginController: getForm: Begin/End");
		return new LoginForm();
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody ModelAndView doLogin(@ModelAttribute("loginForm") LoginForm loginForm) {
		logger.debug("LoginController: doLogin: Begin");
		logger.debug("LoginController: doLogin: User logged in with username: " + loginForm.getUsername());
		logger.debug("LoginController: doLogin: User logged in with password: " + loginForm.getPassword());
		ModelAndView view = new ModelAndView("views/login/success.jsp", "loginForm", loginForm);
		//view.addObject("loginForm", loginForm);
		logger.debug("LoginController: doLogin: End");
		return view;
	}
}
