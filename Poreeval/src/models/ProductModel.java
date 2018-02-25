package models;

import java.awt.image.BufferedImage;
import java.sql.SQLException;

import data.Product;
import dataAccess.ProductDataAccess;

public class ProductModel {

    private ProductDataAccess productDataAccess = new ProductDataAccess();

    public void CreateProduct(int ean, String name, String description,
        BufferedImage picture) {

        Product product = new Product(name, ean, description, picture);

        try {
            this.productDataAccess.InsertProduct(product);
        } catch (SQLException exc) {

            exc.printStackTrace();
        }
    }
}
