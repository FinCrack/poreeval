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

/*
 * Methode, um einen neuen Benutzer in die Tabellen Users & Passwoerter einzutragen
 */
    public void InsertUser(User user) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "INSERT INTO USERS (ID, USERNAME, PRIVILEGE, EMAIL) "
                + "VALUES (NEXTVAL('SEQ_USERS'), ?, ?, ?)");

        psmt.setString(1, user.getUserName());
        psmt.setInt(2, 3);
        psmt.setString(3, user.getEmail());

        PreparedStatement psmtPW = connection.prepareStatement(
        		"INSERT INTO PASSWOERTER SELECT CURRVAL('SEQ_USERS'), ? FROM USERS WHERE ID = CURRVAL('SEQ_USERS')");
        psmtPW.setString(1, user.getPassword());
        
        psmt.executeUpdate();
        psmtPW.executeUpdate();
        
        connection.close();
    }
/*
 * Methode, um die User & Passwoerter Datenbanken nach den eingegebenen Strings zu durchsuchen und diesen dann als neuen User zu setzen.
 */
    public User GetUser(String userName, String password) throws SQLException {

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
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
            
            connection.close();
            return user;
        }
        
        connection.close();
        return null;
    }
}
