package dataAccess;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.Product;

public class ProductDataAccess {

    
    
    public void InsertProduct(Product product) throws SQLException
    {
        PreparedStatement psmt = DatabaseConnection.instance.prepareStatement(
            "INSERT INTO PRODUCTS (EAN, NAME, DESCRIPTION, PICTURE) "
            + "VALUES (?, ?, ?, ?)");
        
        psmt.setInt(1, product.getEan());
        psmt.setString(2, product.getProductname());
        psmt.setString(3, product.getNote());
        // TODO image speichern recherchieren
        //psmt.setBinaryStream(parameterIndex, x);
        
        psmt.executeUpdate();
    }
}
