package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Product;

public class ProductDataAccess {

	private Connection connection = DatabaseConnection.getConnection();



	public void InsertProduct(Product product) throws SQLException {
		PreparedStatement psmt = this.connection
				.prepareStatement("INSERT INTO PRODUCTS (EAN, NAME, DESCRIPTION, PICTURE) " + "VALUES (?, ?, ?, ?)");

		psmt.setLong(1, product.getEan());
		psmt.setString(2, product.getProductname());
		psmt.setString(3, product.getDescription());
		psmt.setBytes(4, null);
		// TODO image speichern recherchieren
		// psmt.setBinaryStream(parameterIndex, x);

		psmt.executeUpdate();
	}

	public void UpdateProduct(Product product) throws SQLException {
		PreparedStatement psmt = this.connection
				.prepareStatement("UPDATE PRODUCTS SET EAN = ?, NAME = ?, DESCRIPTION = ?, PICTURE = ?)");

		psmt.setLong(1, product.getEan());
		psmt.setString(2, product.getProductname());
		psmt.setString(3, product.getDescription());
		psmt.setBytes(4, null);
		// TODO image speichern recherchieren
		// psmt.setBinaryStream(parameterIndex, x);

		psmt.executeUpdate();
	}

	public List<Product> GetProductByEan(long ean) throws SQLException {

		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT EAN, NAME, DESCRIPTION, PICTURE, AVG_RATING(EAN) FROM PRODUCTS WHERE EAN = ?");

		psmt.setLong(1, ean);

		ResultSet rs = psmt.executeQuery();

		return this.GetProductsFromResultSet(rs);
	}

	public List<Product> GetProductsByName(String name) throws SQLException {

		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT EAN, NAME, DESCRIPTION, PICTURE, AVG_RATING(EAN) FROM PRODUCTS WHERE NAME LIKE ?");

		psmt.setString(1, "%" + name + "%");

		ResultSet rs = psmt.executeQuery();

		return this.GetProductsFromResultSet(rs);
	}

	public List<Product> GetAllProducts() throws SQLException {
        PreparedStatement psmt =
            this.connection.prepareStatement(
                "SELECT EAN, NAME, DESCRIPTION, PICTURE, AVG_RATING(EAN) FROM PRODUCTS");

        ResultSet rs = psmt.executeQuery();

        return this.GetProductsFromResultSet(rs);

	}
	
	public List<Product> GetBestRatedProducts() throws SQLException {
		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT EAN, NAME, DESCRIPTION, PICTURE, AVG_RATING(EAN) FROM PRODUCTS ORDER BY RATING DESC");
		
		ResultSet rs = psmt.executeQuery();
		
		return this.GetProductsFromResultSet(rs);
	}
	
	public List<Product> GetRecentlyRatedProducts() throws SQLException {
		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT EAN, NAME, DESCRIPTION, PICTURE, AVG_RATING(EAN) FROM PRODUCTS ORDER BY RATING DESC");
	
		//TODO Datum einbauen und darüber selektieren 
		
		ResultSet rs = psmt.executeQuery();
		
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
