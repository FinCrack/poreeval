package models;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Product;
import data.Review;
import dataAccess.ProductDataAccess;
import dataAccess.ReviewDataAccess;

/** @author Lennard Brunke 259315
 * Model Klasse für Produkte
 */
public class ProductModel {

    private ProductDataAccess productDataAccess = new ProductDataAccess();
    private ReviewDataAccess reviewDataAccess = new ReviewDataAccess();
 
    /**
     * Löscht ein Produkt anhand der EAN.
     */
    public void DeleteProductById(int id) throws SQLException {
    	
    	
    	
    	this.productDataAccess.DeleteProductById(id);
    }
    
    /**
     * Erstellt ein neues Produkt.
     */
    public void CreateProduct(long ean, String name,
        String picture) throws SQLException {

        Product product = new Product(ean, name, picture);

        this.productDataAccess.InsertProduct(product);

    }
    
    /**
     * Update eines vorhandenen Produkts.
     */
    public void UpdateProduct(int id, long ean, String name,
        String picture) throws SQLException {

        Product product = new Product(id, ean, name, picture);

        this.productDataAccess.UpdateProduct(product);

    }

    /**
     * Sucht Produkte anhand der übergebenen EAN oder des Namens.
     */
    public List<Product> SearchProducts(long ean, String name)
        throws SQLException {

        List<Product> productList = new ArrayList<Product>();

        if (ean > 0) {
            
            productList.add(this.productDataAccess.GetProductByEan(ean));
        } else {
            
            productList = this.productDataAccess.GetProductsByName(name);
        }

        return productList;
    }
    
    /**
     * Holt ein Produkt und alle dazugehörigen Reviews.
     */
    public Product GetProductWithReviews(int id) throws SQLException {
    	Product product = this.productDataAccess.GetProductById(id);
    	List<Review> reviews = this.reviewDataAccess.GetReviewsForProductId(id);
    	product.setReviews(reviews);
    	
    	return product;
    }
   
    /**
     * Holt alle Produkte.
     */
    public List<Product> GetAllProducts() throws SQLException {
    	return this.productDataAccess.GetAllProducts();
    }
    
    /**
     * Holt die 5 am besten bewerteten Produkte.
     */
    public List<Product> GetBestRatedProducts() throws SQLException {
    	return this.productDataAccess.GetBestRatedProducts();
    }
    
    
    /**
     * Holt die 5 zuletzt bewerteten Produkte.
     */
    public List<Product> GetRecentlyRatedProducts() throws SQLException {
    	return this.productDataAccess.GetRecentlyRatedProducts();
    }
    
}
