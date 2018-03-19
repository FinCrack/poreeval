package models;

import java.sql.SQLException;
import java.util.List;

import data.Review;
import dataAccess.ReviewDataAccess;

public class ReviewModel {
    
    private ReviewDataAccess reviewDataAccess = new ReviewDataAccess();
    
    public void CreateReview(int rating, String title, String text, long ean, int user_Id) throws SQLException {
        
        this.reviewDataAccess.InsertReview(new Review(rating, title, text, ean, user_Id));
    }
    
    
    public void UpdateReview(Review review) throws SQLException {
        
        this.reviewDataAccess.UpdateReview(review);
    }
    
    
    public void DeleteReview(int id) throws SQLException {
        
        this.reviewDataAccess.DeleteReview(id);
    }
    
    public Review GetReview(int id) throws SQLException {
        
        return this.reviewDataAccess.GetReview(id);
    }
    
    
    public List<Review> GetReviewList(long ean) throws SQLException {
        
        return this.reviewDataAccess.GetReviewsForEan(ean);
    }
    
}
