package dataAccess;
/**
 * @author Christian Lindenberg, 235372
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.User;

public class UserDataAccess {

    private Connection connection = DatabaseConnection.getConnection();

    public void InsertUser(User user) throws SQLException {
        PreparedStatement psmt = this.connection.prepareStatement(
            "INSERT INTO USERS (ID, USERNAME, PRIVILEGE, EMAIL) "
                + "VALUES (NEXTVAL('SEQ_USERS'), ?, ?, ?)");

        psmt.setString(1, user.getUserName());
        psmt.setInt(2, 3);
        psmt.setString(3, user.getEmail());

        PreparedStatement psmtPW = this.connection.prepareStatement(
        		"INSERT INTO PASSWOERTER SELECT CURRVAL('SEQ_USERS'), ? FROM USERS WHERE ID = CURRVAL('SEQ_USERS')");
        psmtPW.setString(1, user.getPassword());
        
        psmt.executeUpdate();
        psmtPW.executeUpdate();
    }

    public User GetUser(String userName, String password) throws SQLException {

        PreparedStatement psmt = this.connection.prepareStatement(
            "SELECT U.ID, USERNAME, PRIVILEGE, PASSWORD, EMAIL FROM USERS U INNER JOIN PASSWOERTER P ON U.ID = P.ID WHERE USERNAME = ? AND PASSWORD = ?");
    
        psmt.setString(1, userName);
        psmt.setString(2, password);
        
        ResultSet rs = psmt.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setId(rs.getInt(1));
            user.setUserName(rs.getString(2));
            user.setPrivilege(rs.getInt(3));
            user.setPassword(rs.getString(4));
            user.setEmail(rs.getString(5));
            
            return user;
        }
        
        return null;
    }
}
