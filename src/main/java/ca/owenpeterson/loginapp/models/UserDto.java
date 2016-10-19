package ca.owenpeterson.loginapp.models;

/**
 * This class is used for creating a new User in the database.
 * TODO: Better documentation.
 * @author owen
 *
 */
public class UserDto {
	
	private String username;
	private String password;
	private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
