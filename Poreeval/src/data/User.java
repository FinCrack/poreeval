package data;
/**
 * @author Christian Lindenberg, 235372
 */
public class User {

	private int id;
	private String userName;
	private String email;
	private int privilege;
	private String password;
	
	public User() {
	    
	}

	public User(String userName, String password, int privilege, String email) {
		this.userName = userName;
		this.email = email;
		this.privilege = privilege;
		this.password = password;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPrivilege() {
		return privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
