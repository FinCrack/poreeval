package data;

import java.awt.Image;
import java.util.List;

/** @author Lennard Brunke 259315
 * Datenklasse für Produkte.
 */
public class Product {
    
    private int id;

    private long ean;

    private String name;


    private String picture;
    
    private int rating;
    
    private List<Review> reviews;
    
    

    public Product(long ean, String name,
        String picture) {
        this.name = name;
        this.ean = ean;
        this.picture = picture;
    }
    
    public Product(int id, long ean, String name,
        String picture) {
        this.setId(id);
        this.name = name;
        this.ean = ean;
        this.picture = picture;
    }

    public String getProductname() {
        return name;
    }

    public void setProductname(String productname) {
        this.name = productname;
    }

    public long getEan() {
        return ean;
    }

    public void setEan(long ean) {
        this.ean = ean;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
