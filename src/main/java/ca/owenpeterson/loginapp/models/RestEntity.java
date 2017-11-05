package ca.owenpeterson.loginapp.models;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class RestEntity implements Serializable
{
	private static final long serialVersionUID = -3012302853236147170L;
	
	private String errorMessage;
	private HttpStatus httpStatus;
	
	public String getErrorMessage() 
	{
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) 
	{
		this.errorMessage = errorMessage;
	}
	
	public HttpStatus getHttpStatus() 
	{
		return httpStatus;
	}
	
	public void setHttpStatus(HttpStatus httpStatus) 
	{
		this.httpStatus = httpStatus;
	}
}
