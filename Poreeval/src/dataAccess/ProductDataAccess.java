package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Product;

public class ProductDataAccess {

<<<<<<< HEAD
	private Connection connection = DatabaseConnection.getConnection();
=======
    public void InsertProduct(Product product) throws SQLException {
        PreparedStatement psmt = this.connection.prepareStatement(
            "INSERT INTO PRODUCTS (EAN, NAME, DESCRIPTION, PICTURE) "
                + "VALUES (?, ?, ?, ?)");
>>>>>>> branch 'master' of ssh://git@github.com/FinCrack/poreeval.git

	public void InsertProduct(Product product) throws SQLException {
		PreparedStatement psmt = connection
				.prepareStatement("INSERT INTO PRODUCTS (EAN, NAME, DESCRIPTION, PICTURE) " + "VALUES (?, ?, ?, ?)");

		psmt.setLong(1, product.getEan());
		psmt.setString(2, product.getProductname());
		psmt.setString(3, product.getDescription());
		psmt.setBytes(4, null);
		// TODO image speichern recherchieren
		// psmt.setBinaryStream(parameterIndex, x);

<<<<<<< HEAD
		psmt.executeUpdate();
	}
=======
    public void UpdateProduct(Product product) throws SQLException {
        PreparedStatement psmt =
        		this.connection.prepareStatement(
                "UPDATE PRODUCTS SET EAN = ?, NAME = ?, DESCRIPTION = ?, PICTURE = ?)");
>>>>>>> branch 'master' of ssh://git@github.com/FinCrack/poreeval.git

	public void UpdateProduct(Product product) throws SQLException {
		PreparedStatement psmt = connection
				.prepareStatement("UPDATE PRODUCTS SET EAN = ?, NAME = ?, DESCRIPTION = ?, PICTURE = ?)");

		psmt.setLong(1, product.getEan());
		psmt.setString(2, product.getProductname());
		psmt.setString(3, product.getDescription());
		psmt.setBytes(4, null);
		// TODO image speichern recherchieren
		// psmt.setBinaryStream(parameterIndex, x);

		psmt.executeUpdate();
	}

<<<<<<< HEAD
	public List<Product> GetProductByEan(long ean) throws SQLException {
=======
        PreparedStatement psmt =
        		this.connection.prepareStatement(
                "SELECT EAN, NAME, DESCRIPTION, PICTURE, AVG_RATING(EAN) FROM PRODUCTS WHERE EAN = ?");
>>>>>>> branch 'master' of ssh://git@github.com/FinCrack/poreeval.git

		PreparedStatement psmt = connection.prepareStatement(
				"SELECT EAN, NAME, DESCRIPTION, PICTURE, AVG_RATING(EAN) FROM PRODUCTS WHERE EAN = ?");

		psmt.setLong(1, ean);

		ResultSet rs = psmt.executeQuery();

		return this.GetProductsFromResultSet(rs);
	}

<<<<<<< HEAD
	public List<Product> GetProductsByName(String name) throws SQLException {
=======
        PreparedStatement psmt =
            this.connection.prepareStatement(
                "SELECT EAN, NAME, DESCRIPTION, PICTURE, AVG_RATING(EAN) FROM PRODUCTS WHERE NAME LIKE ?");
>>>>>>> branch 'master' of ssh://git@github.com/FinCrack/poreeval.git

		PreparedStatement psmt = DatabaseConnection.getConnection().prepareStatement(
				"SELECT EAN, NAME, DESCRIPTION, PICTURE, AVG_RATING(EAN) FROM PRODUCTS WHERE NAME LIKE ?");

		psmt.setString(1, "%" + name + "%");

<<<<<<< HEAD
		ResultSet rs = psmt.executeQuery();
=======
        return this.GetProductsFromResultSet(rs);
    }
    
    public List<Product> GetAllProducts() throws SQLException {
        PreparedStatement psmt =
            this.connection.prepareStatement(
                "SELECT EAN, NAME, DESCRIPTION, PICTURE, AVG_RATING(EAN) FROM PRODUCTS");

        ResultSet rs = psmt.executeQuery();

        return this.GetProductsFromResultSet(rs);
    }
>>>>>>> branch 'master' of ssh://git@github.com/FinCrack/poreeval.git

		return this.GetProductsFromResultSet(rs);
	}

	private List<Product> GetProductsFromResultSet(ResultSet rs) throws SQLException {

		List<Product> productList = new ArrayList<Product>();

		while (rs.next()) {
			long ean = rs.getLong(1);
			String name = rs.getString(2);
			String description = rs.getString(3);
			int rating = rs.getInt(4);
			Product product = new Product(ean, name, description, null);
			product.setRating(rating);
			// TODO picture
			productList.add(product);
		}
		return productList;
	}


}
