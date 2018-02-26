package data;

import java.awt.Image;

public class Product {

    private long ean;

    private String name;

    private String description;

    private Image picture;
    
    private int rating;
    
    

    public Product(long ean, String name, String description,
        Image picture) {
        this.name = name;
        this.ean = ean;
        this.description = description;
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

    public String getNote() {
        return description;
    }

    public void setNote(String note) {
        this.description = note;
    }

    public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
