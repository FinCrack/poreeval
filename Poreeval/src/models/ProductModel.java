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
    
    
    public void CreateProduct(long ean, String name,
        BufferedImage picture) throws SQLException {

        Product product = new Product(ean, name, picture);

        this.productDataAccess.InsertProduct(product);

    }
    
    public void UpdateProduct(int id, long ean, String name,
        BufferedImage picture) throws SQLException {

        Product product = new Product(id, ean, name, picture);

        this.productDataAccess.UpdateProduct(product);

    }

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
    
    public Product GetProductWithReviews(int id) throws SQLException {
    	Product product = this.productDataAccess.GetProductById(id);
    	List<Review> reviews = this.reviewDataAccess.GetReviewsForProductId(id);
    	product.setReviews(reviews);
    	
    	return product;
    }
   
    
    public List<Product> GetAllProducts() throws SQLException {
    	return this.productDataAccess.GetAllProducts();
    }
    
    public List<Product> GetBestRatedProducts() throws SQLException {
    	return this.productDataAccess.GetBestRatedProducts();
    }
    
    public List<Product> GetRecentlyRatedProducts() throws SQLException {
    	return this.productDataAccess.GetRecentlyRatedProducts();
    }
    
}
