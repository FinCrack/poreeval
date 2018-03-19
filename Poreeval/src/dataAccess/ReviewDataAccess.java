package dataAccess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Product;
import data.Review;

/** @author Lennard Brunke 259315
 * 
 */
public class ReviewDataAccess {
    
    private Connection connection = DatabaseConnection.getConnection();
    
    public void InsertReview(Review review) throws SQLException {
        
        PreparedStatement psmt = this.connection.prepareStatement(
            "INSERT INTO REVIEWS (ID, RATING, TITLE, TEXT, EAN, USER_ID)"
            + " VALUES (NEXTVAL('SEQ_REVIEWS'), ?, ?, ?, ?)");
        
        psmt.setInt(1, review.getRating());
        psmt.setString(2, review.getTitle());
        psmt.setString(3, review.getText());
        psmt.setLong(4, review.getEan());
        psmt.setInt(5, review.getUser_id());
        
        psmt.executeUpdate();
    }
    
    public void UpdateReview(Review review) throws SQLException {
        
        PreparedStatement psmt = this.connection.prepareStatement(
            "UPDATE REVIEWS"
            + " SET RATING = ?, TITLE = ?, TEXT = ?, EAN = ?"
            + " WHERE ID = ?) ");
        
        psmt.setInt(1, review.getRating());
        psmt.setString(2, review.getTitle());
        psmt.setString(3, review.getText());
        psmt.setLong(4, review.getEan());
        psmt.setInt(5, review.getId());
        
        psmt.executeUpdate();
    }
    
    
    public void DeleteReview(int id) throws SQLException {
        
        PreparedStatement psmt = this.connection.prepareStatement(
            "DELETE FROM REVIEWS WHERE ID = ?");
        
        psmt.setInt(1, id);
        
        psmt.executeUpdate();
    }
    
    
    public Review GetReview(int id) throws SQLException {
        
        PreparedStatement psmt = this.connection.prepareStatement(
            "SELECT ID, RATING, TITLE, TEXT, EAN, REVIEWS.USER_ID, USER_NAME, REVIEW_DATE"
            + " FROM REVIEWS"
            + " JOIN USERS ON REVIEWS.USER_ID = USERS.ID"
            + " WHERE REVIEWS.ID = ?");
        
        psmt.setInt(1, id);
        ResultSet rs = psmt.executeQuery();
        
        return this.ResultSetToReviewList(rs).get(0);
    }
    
    public List<Review> GetReviewsForEan(long ean) throws SQLException {
        
        PreparedStatement psmt = this.connection.prepareStatement(
            "SELECT ID, RATING, TITLE, TEXT, EAN, REVIEWS.USER_ID, USER_NAME, REVIEW_DATE"
                + " FROM REVIEWS"
                + " JOIN USERS ON REVIEWS.USER_ID = USERS.ID"
                + " WHERE REVIEWS.EAN = ?");
        
        psmt.setLong(1, ean);
        ResultSet rs = psmt.executeQuery();
        
        return this.ResultSetToReviewList(rs);
    }

    private List<Review> ResultSetToReviewList(ResultSet rs) throws SQLException {
        List<Review> reviewList = new ArrayList<Review>();

        while (rs.next()) {
            
            int id = rs.getInt(1);
            int rating = rs.getInt(2);
            String title = rs.getString(3);
            String text = rs.getString(4);
            long ean = rs.getLong(5);
            int user_id = rs.getInt(6);
            Date review_date = rs.getDate(7);
            String user_name = rs.getString(8);
            
            Review review = new Review(id, rating, title, text, ean, user_id, review_date);

            review.setUser_name(user_name);
            reviewList.add(review);
        }
        
        return reviewList;
    }
}
