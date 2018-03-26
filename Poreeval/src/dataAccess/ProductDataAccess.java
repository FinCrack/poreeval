package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Product;

/**
 * @author Lennard Brunke 259315 DataAccess für Produkte
 */
public class ProductDataAccess {

    /**
     * Fügt ein neues Produkt in die Datenbank ein.
     */
    public void InsertProduct(Product product) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "INSERT INTO PRODUCTS (EAN, NAME, PICTURE) " + "VALUES (?, ?, ?)");

        psmt.setLong(1, product.getEan());
        psmt.setString(2, product.getProductname());
        psmt.setString(3, product.getPicture());

        psmt.executeUpdate();

        connection.close();
    }

    /**
     * Führt ein Update auf einem Produkt aus
     */
    public void UpdateProduct(Product product) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "UPDATE PRODUCTS SET EAN = ?, NAME = ?, PICTURE = ? WHERE ID = ?;");

        psmt.setLong(1, product.getEan());
        psmt.setString(2, product.getProductname());
        psmt.setString(3, product.getPicture());
        psmt.setInt(4, product.getId());

        psmt.executeUpdate();
        connection.close();
    }

    /**
     * Holt ein Produkt anhand des Primärschlüssels.
     */
    public Product GetProductById(int id) throws SQLException {

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "SELECT EAN, NAME, PICTURE, AVG_RATING(ID), ID FROM PRODUCTS WHERE ID = ?;");

        psmt.setLong(1, id);

        ResultSet rs = psmt.executeQuery();

        Product product = this.GetProductsFromResultSet(rs).get(0);
        connection.close();

        return product;
    }

    /**
     * Holt ein Produkt anhand der EAN.
     */
    public Product GetProductByEan(long ean) throws SQLException {

        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement psmt = connection.prepareStatement(
            "SELECT EAN, NAME, PICTURE, AVG_RATING(ID), ID FROM PRODUCTS WHERE EAN = ?");

        psmt.setLong(1, ean);

        ResultSet rs = psmt.executeQuery();

        Product product = this.GetProductsFromResultSet(rs).get(0);

        connection.close();

        return product;
    }

    /**
     * Löscht ein Produkt anhand des Primärschlüssels.
     */
    public void DeleteProductById(int id) throws SQLException {

        Connection connection = DatabaseConnection.getConnection();

        PreparedStatement psmt = connection.prepareStatement(
            "DELETE FROM REVIEWS WHERE PRODUCT_ID = ?; DELETE FROM PRODUCTS WHERE ID = ?;");

        psmt.setInt(1, id);
        psmt.setInt(2, id);

        psmt.executeUpdate();

        connection.close();

    }

    /**
     * Holt alle Produkte, dessen Name den übergebenen Text beinhaltet.
     */
    public List<Product> GetProductsByName(String name) throws SQLException {

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "SELECT EAN, NAME, PICTURE, AVG_RATING(ID), ID FROM PRODUCTS WHERE NAME ILIKE ?");

        psmt.setString(1, "%" + name + "%");

        ResultSet rs = psmt.executeQuery();

        List<Product> products = this.GetProductsFromResultSet(rs);
        connection.close();

        return products;
    }

    /**
     * Holt alle Produkte.
     */
    public List<Product> GetAllProducts() throws SQLException {

        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "SELECT EAN, NAME, PICTURE, AVG_RATING(ID), ID FROM PRODUCTS ORDER BY NAME ASC");
        ResultSet rs = psmt.executeQuery();

        List<Product> products = this.GetProductsFromResultSet(rs);

        connection.close();

        return products;

    }

    /**
     * Holt die 5 am besten bewerteten Produkte.
     */
    public List<Product> GetBestRatedProducts() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "SELECT P.EAN, NAME, PICTURE, AVG_RATING(P.ID) AS AVERAGE_RATING, P.ID "
                + "FROM PRODUCTS P INNER JOIN REVIEWS R ON P.ID = R.PRODUCT_ID "
                + "GROUP BY P.EAN, P.NAME, P.PICTURE, P.ID ORDER BY AVERAGE_RATING DESC LIMIT 5");

        ResultSet rs = psmt.executeQuery();

        List<Product> products = this.GetProductsFromResultSet(rs);

        connection.close();

        return products;
    }
    
    

    /**
     * Holt die 5 zuletzt bewerteten Produkte.
     */
    public List<Product> GetRecentlyRatedProducts() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psmt = connection.prepareStatement(
            "SELECT P.EAN, P.NAME, P.PICTURE, AVG_RATING(P.ID), P.ID "
                + "FROM PRODUCTS P "
                + "INNER JOIN REVIEWS R ON P.ID = R.PRODUCT_ID "
                + "GROUP BY P.EAN, P.NAME, P.PICTURE, P.ID, R.REVIEW_DATE ORDER BY R.REVIEW_DATE DESC LIMIT 5");

        ResultSet rs = psmt.executeQuery();

        List<Product> products = this.GetProductsFromResultSet(rs);

        connection.close();

        return products;
    }

    /**
     * Erstellt aus einem ResulstSet eine Liste von Produkten.
     */
    private List<Product> GetProductsFromResultSet(ResultSet rs)
        throws SQLException {

        List<Product> productList = new ArrayList<Product>();

        while (rs.next()) {
            long ean = rs.getLong(1);
            String name = rs.getString(2);
            String picture = rs.getString(3);
            int rating = rs.getInt(4);
            int id = rs.getInt(5);
            Product product = new Product(id, ean, name, picture);
            product.setRating(rating);
            // TODO picture
            productList.add(product);
        }
        return productList;
    }

}
