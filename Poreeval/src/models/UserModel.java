package models;

import java.sql.SQLException;

import data.User;
import dataAccess.UserDataAccess;

public class UserModel {

	private UserDataAccess userDataAccess = new UserDataAccess();

	public void CreateUser(int id, String username, String email, String role, String password) {

		User user = new User(id, username, email, role, password);

		try {
			this.userDataAccess.InsertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
