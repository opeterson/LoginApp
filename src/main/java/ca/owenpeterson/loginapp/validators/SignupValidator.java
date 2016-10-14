package ca.owenpeterson.loginapp.validators;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "valid.signupForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.signupForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "valid.signupForm.confirmPassword");
		
		SignupForm form = (SignupForm) signupForm;
		String password = form.getPassword();
		String confirmPassword = form.getConfirmPassword();
		if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(confirmPassword))
		{
			if (!password.equals(confirmPassword))
			{
				errors.rejectValue("confirmPassword", "valid.signupForm.passwordMatch");
			}
		}
	}
}
