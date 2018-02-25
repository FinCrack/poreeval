package data;

import java.awt.Image;

public class Product {

    private int ean;

    private String name;

    private String description;

    private Image picture;
    
    

    public Product(String name, Integer ean, String description,
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

    public Integer getEan() {
        return ean;
    }

    public void setEan(Integer ean) {
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

}
