package models;
/**
 * @author Christian Lindenberg, 235372
 */
import java.sql.SQLException;
import java.util.InputMismatchException;

import data.User;
import dataAccess.UserDataAccess;

public class UserModel {

    private UserDataAccess userDataAccess = new UserDataAccess();

    public void CreateUser(String userName, String password, String password2, int privilege,
        String email) throws SQLException {

    	if(!userName.matches("^[a-zA-Z0-9]+$")){
    		throw new InputMismatchException("Nur Buchstaben und Zahlen bei dem Usernamen zul�ssig!");
    	}
    	if (password.length() < 6) {
        	throw new StringIndexOutOfBoundsException("Passwort zu kurz.");
        }
        if (!password.equals(password2)) {
            throw new InputMismatchException("Passw�rter stimmen nicht �berein.");
        }
        
        
        User user = new User(userName, password, privilege, email);

        this.userDataAccess.InsertUser(user);
    }

    public User LoginUser(String userName, String password) throws SQLException {

        return this.userDataAccess.GetUser(userName, password);
    }
}
