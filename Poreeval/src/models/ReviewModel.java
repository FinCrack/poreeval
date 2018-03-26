package models;

import java.sql.SQLException;
import java.util.List;

import data.Review;
import dataAccess.ReviewDataAccess;

/**@author Lennard Brunke 259315
 * Model für Reviews.
 */
public class ReviewModel {
    
    private ReviewDataAccess reviewDataAccess = new ReviewDataAccess();
    
    /**
     * Erstellt ein neues Review.
     */
    public void CreateReview(int rating, String title, String text, int product_id, int user_Id) throws SQLException {
        
        this.reviewDataAccess.InsertReview(new Review(rating, title, text, product_id, user_Id));
    }
    
    /**
     * Update eines vorhandenen Reviews.
     */
    public void UpdateReview(Review review) throws SQLException {
        
        this.reviewDataAccess.UpdateReview(review);
    }
    
    /**
     * 
     */
    public void DeleteReview(int id) throws SQLException {
        
        this.reviewDataAccess.DeleteReview(id);
    }
    
    public Review GetReview(int id) throws SQLException {
        
        return this.reviewDataAccess.GetReview(id);
    }
    
    
    public List<Review> GetReviewList(int id) throws SQLException {
        
        return this.reviewDataAccess.GetReviewsForProductId(id);
    }
    
}
