package dataAccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.User;

public class UserDataAccess {

	public void InsertUser(User user) throws SQLException
    {
        PreparedStatement psmt = DatabaseConnection.instance.prepareStatement(
            "INSERT INTO USERS (ID, USERNAME, PRIVILEGE, PASSWORD, EMAIL) "
            + "VALUES (?, ?, ?, ?, ?)");
        
        psmt.setInt(1, user.getId());
        psmt.setString(2, user.getUsername());
        psmt.setString(3, user.getRole());
        psmt.setString(4, user.getPassword());
        psmt.setString(5, user.getEmail());

        psmt.executeUpdate();
    }
}
