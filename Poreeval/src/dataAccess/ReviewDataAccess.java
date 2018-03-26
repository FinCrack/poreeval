package dataAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Review;

/** @author Lennard Brunke 259315
 * DataAccess für Reviews.
 */
public class ReviewDataAccess {
    
    /**
     * Fügt ein neues Review ein.
     */
    public void InsertReview(Review review) throws SQLException {
        
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "INSERT INTO REVIEWS (ID, RATING, TITLE, TEXT, PRODUCT_ID, USER_ID)"
            + " VALUES (NEXTVAL('SEQ_REVIEWS'), ?, ?, ?, ?, ?)");
        
        psmt.setInt(1, review.getRating());
        psmt.setString(2, review.getTitle());
        psmt.setString(3, review.getText());
        psmt.setInt(4, review.getProduct_id());
        psmt.setInt(5, review.getUser_id());
        
        psmt.executeUpdate();
        
        connection.close();
    }
    

    /**
     * Update auf ein vorhandenes Review.
     */
    public void UpdateReview(Review review) throws SQLException {
        
        Connection connection = DatabaseConnection.getConnection();
        
        PreparedStatement psmt = connection.prepareStatement(
            "UPDATE REVIEWS"
            + " SET RATING = ?, TITLE = ?, TEXT = ?"
            + " WHERE ID = ?");
        
        psmt.setInt(1, review.getRating());
        psmt.setString(2, review.getTitle());
        psmt.setString(3, review.getText());
        psmt.setInt(4, review.getId());
        
        psmt.executeUpdate();
        
        connection.close();
    }
    
    /**
     * Löscht ein Review anhand der ID.
     */
    public void DeleteReview(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "DELETE FROM REVIEWS WHERE ID = ?");
        
        psmt.setInt(1, id);
        
        psmt.executeUpdate();
        connection.close();
    }
    
    /**
     * Holt ein Review anhand der ID.
     */
    public Review GetReview(int id) throws SQLException {
        
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "SELECT REVIEWS.ID, RATING, TITLE, TEXT, PRODUCT_ID, USER_ID, USERNAME, REVIEW_DATE"
            + " FROM REVIEWS"
            + " JOIN USERS ON REVIEWS.USER_ID = USERS.ID"
            + " WHERE REVIEWS.ID = ?");
        
        psmt.setInt(1, id);
        ResultSet rs = psmt.executeQuery();
        
        Review review = this.ResultSetToReviewList(rs).get(0);
        
        connection.close();
        
        return review;
    }
    
    /**
     * Holt alle Reviews für ein Produkt anhand dessen ID.
     */
    public List<Review> GetReviewsForProductId(int id) throws SQLException {
        
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "SELECT REVIEWS.ID, RATING, TITLE, TEXT, PRODUCT_ID, USER_ID, USERNAME, REVIEW_DATE"
                + " FROM REVIEWS"
                + " JOIN USERS ON REVIEWS.USER_ID = USERS.ID"
                + " WHERE REVIEWS.PRODUCT_ID = ?");
        
        psmt.setInt(1, id);
        ResultSet rs = psmt.executeQuery();
        
        List<Review> reviews = this.ResultSetToReviewList(rs);
        
        connection.close();
        
        return reviews;
    }

    /**
     * Erstellt aus einem ResultSet eine List von Reviews.
     */
    private List<Review> ResultSetToReviewList(ResultSet rs) throws SQLException {
        List<Review> reviewList = new ArrayList<Review>();

        while (rs.next()) {
            
            int id = rs.getInt(1);
            int rating = rs.getInt(2);
            String title = rs.getString(3);
            String text = rs.getString(4);
            int product_id = rs.getInt(5);
            int user_id = rs.getInt(6);
            String user_name = rs.getString(7); 
            Date review_date = rs.getDate(8);
          
            
            Review review = new Review(id, rating, title, text, product_id, user_id, review_date);

            review.setUser_name(user_name);
            reviewList.add(review);
        }
        
        return reviewList;
    }
}
