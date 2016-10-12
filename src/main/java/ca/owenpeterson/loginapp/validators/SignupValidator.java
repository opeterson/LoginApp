package ca.owenpeterson.loginapp.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ca.owenpeterson.loginapp.models.signup.SignupForm;

@Component
public class SignupValidator implements Validator{

	@Override
	public boolean supports(Class<?> signupForm) {
		return SignupForm.class.equals(signupForm);
	}

	@Override
	public void validate(Object signupForm, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "valid.signupForm.username");		
	}

}
