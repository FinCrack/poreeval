package data;

import java.util.Date;

/** @author Lennard Brunke 259315
 * Datenklasse für Reviews.
 */
public class Review {

    private int id;

    private int rating;
    
    private String title;

    private String text;

    private int product_id;

    private int user_id;
    private String user_name;

    private Date review_date;

    public Review(int id, int rating, String title, String text, int product_id, int user_id,
        Date review_date) {
        this.id = id;
        this.rating = rating;
        this.title = title;
        this.text = text;
        this.product_id = product_id;
        this.user_id = user_id;
        this.review_date = review_date;
    }
    
    public Review(int rating, String title, String text, int product_id, int user_id) {
        this.rating = rating;
        this.title = title;
        this.text = text;
        this.product_id = product_id;
        this.user_id = user_id;
        this.review_date = new Date();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getReview_date() {
        return review_date;
    }

    public void setReview_date(Date review_date) {
        this.review_date = review_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
