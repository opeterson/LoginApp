package ca.owenpeterson.loginapp.service;

public class URIConstants {
	public static final String LOCALHOST = "http://localhost:8080";
	public static final String USER_SERVICE_ROOT = "/userservice";
	public static final String USER = "/user";
	public static final String CREATE = "/create";
	public static final String AUTHENTICATE = "/authenticate";
	public static final String USER_SERVICE = LOCALHOST + USER_SERVICE_ROOT;
	public static final String CREATE_USER_URI = USER_SERVICE + USER + CREATE;
	public static final String AUTHENTICATE_USER_URI = USER_SERVICE + USER + AUTHENTICATE;
}
