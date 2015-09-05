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
}
