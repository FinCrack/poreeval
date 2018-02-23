package data;

public class User {

	private String userName;
	private String email;
	private String role;
	private String password;

	public User(String userName, String email, String role, String password) {
		super();
		this.setUserName(userName);
		this.email = email;
		this.role = role;
		this.setPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
