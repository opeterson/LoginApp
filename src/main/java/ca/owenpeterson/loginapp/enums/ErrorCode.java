package ca.owenpeterson.loginapp.enums;

import java.util.EnumSet;

public enum ErrorCode 
{
	USERNAME_EXISTS("1001", "The specified username already exists."),
	EMAIL_IN_USE("1002", "The specified email address is already in use.");
	
	private String code;
	private String message;
	
	private ErrorCode(String code, String message)
	{
		this.code = code;
		this.message = message;
	}

	public String getCode() 
	{
		return code;
	}

	public String getMessage() 
	{
		return message;
	}
	
	public static ErrorCode fromCode(String code)
	{
		ErrorCode errorCode = null;
		
		for (ErrorCode error : EnumSet.allOf(ErrorCode.class))
		{
			if (error.getCode().equals(code))
			{
				errorCode = error;
				break;
			}
		}
		
		return errorCode;
	}
}
