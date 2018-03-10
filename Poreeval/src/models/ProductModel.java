package models;

import java.awt.image.BufferedImage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Product;
import dataAccess.ProductDataAccess;

public class ProductModel {

    private ProductDataAccess productDataAccess = new ProductDataAccess();

    public void CreateProduct(long ean, String name, String description,
        BufferedImage picture) throws SQLException {

        Product product = new Product(ean, name, description, picture);

        this.productDataAccess.InsertProduct(product);

    }

    public void UpdateProduct(long ean, String name, String description,
        BufferedImage picture) throws SQLException {

        Product product = new Product(ean, name, description, picture);

        this.productDataAccess.UpdateProduct(product);

    }

    public List<Product> SearchProducts(long ean, String name)
        throws SQLException {

        List<Product> productList = new ArrayList<Product>();

        if (ean > 0) {
            
            productList = this.productDataAccess.GetProductByEan(ean);
        } 
        else {

            productList = this.productDataAccess.GetProductsByName(name);
        }

        return productList;
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
