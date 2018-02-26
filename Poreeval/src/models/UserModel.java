package models;

import java.sql.SQLException;
import java.util.InputMismatchException;

import data.User;
import dataAccess.UserDataAccess;

public class UserModel {

    private UserDataAccess userDataAccess = new UserDataAccess();

    public void CreateUser(String userName, String password, String password2, int privilege,
        String email) throws SQLException {

        if (!password.equals(password2)) {
            throw new InputMismatchException("Passwörter stimmen nicht überein.");
        }
        
        User user = new User(userName, password, privilege, email);

        this.userDataAccess.InsertUser(user);
    }

    public User LoginUser(String userName, String password) throws SQLException {

        return this.userDataAccess.GetUser(userName, password);
    }
}
