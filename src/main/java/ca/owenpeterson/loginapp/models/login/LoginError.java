package ca.owenpeterson.loginapp.models.login;

public class LoginError {

	private String errorMessage;
	private String cssClass;
			
	public LoginError() 
	{
	}
	
	public LoginError(String errorMessage, String cssClass) 
	{
		super();
		this.errorMessage = errorMessage;
		this.cssClass = cssClass;
	}
	
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
