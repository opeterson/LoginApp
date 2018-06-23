package ca.owenpeterson.loginapp.models.signup;

public class SignupError 
{
	private String errorMessage;
	private String cssClass;
	
	public String getErrorMessage() 
	{
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) 
	{
		this.errorMessage = errorMessage;
	}
	
	public String getCssClass() 
	{
		return cssClass;
	}
	
	public void setCssClass(String cssClass) 
	{
		this.cssClass = cssClass;
	}
}
