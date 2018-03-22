package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Product;


/** @author Lennard Brunke 259315
 * 
 */
public class ProductDataAccess {

	private Connection connection = DatabaseConnection.getConnection();



	public void InsertProduct(Product product) throws SQLException {
		PreparedStatement psmt = this.connection
				.prepareStatement("INSERT INTO PRODUCTS (EAN, NAME, DESCRIPTION, PICTURE) " + "VALUES (?, ?, ?)");

		psmt.setLong(1, product.getEan());
		psmt.setString(2, product.getProductname());
		psmt.setBytes(3, null);
		// TODO image speichern recherchieren
		// psmt.setBinaryStream(parameterIndex, x);

		psmt.executeUpdate();
	}

	public void UpdateProduct(Product product) throws SQLException {
		PreparedStatement psmt = this.connection
				.prepareStatement("UPDATE PRODUCTS SET EAN = ?, NAME = ?, PICTURE = ?");

		psmt.setLong(1, product.getEan());
		psmt.setString(2, product.getProductname());
		psmt.setBytes(3, null);
		// TODO image speichern recherchieren
		// psmt.setBinaryStream(parameterIndex, x);

		psmt.executeUpdate();
	}

	public Product GetProductByEan(long ean) throws SQLException {

		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT EAN, NAME, PICTURE, AVG_RATING(EAN) FROM PRODUCTS WHERE EAN = ?");

		psmt.setLong(1, ean);

		ResultSet rs = psmt.executeQuery();

		return this.GetProductsFromResultSet(rs).get(0);
	}
	
	public void DeleteProductByEan(long ean) throws SQLException {
		
		PreparedStatement psmt = this.connection.prepareStatement(
				"DELETE FROM REVIEWS WHERE EAN = " + ean + "; DELETE FROM PRODUCTS WHERE EAN = " + ean + ";");
		
		psmt.executeUpdate();

	}

	public List<Product> GetProductsByName(String name) throws SQLException {

		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT EAN, NAME, PICTURE, AVG_RATING(EAN) FROM PRODUCTS WHERE NAME ILIKE ?");

		psmt.setString(1, "%" + name + "%");

		ResultSet rs = psmt.executeQuery();

		return this.GetProductsFromResultSet(rs);
	}

	public List<Product> GetAllProducts() throws SQLException {
        PreparedStatement psmt =
            this.connection.prepareStatement(
                "SELECT EAN, NAME, PICTURE, AVG_RATING(EAN) FROM PRODUCTS");

        ResultSet rs = psmt.executeQuery();

        return this.GetProductsFromResultSet(rs);

	}
	
	public List<Product> GetBestRatedProducts() throws SQLException {
		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT P.EAN, NAME, PICTURE, AVG_RATING(P.EAN) AS AVERAGE_RATING "
				+ "FROM PRODUCTS P INNER JOIN REVIEWS R ON P.EAN = R.EAN "
				+ "GROUP BY P.EAN, P.NAME, P.PICTURE ORDER BY AVERAGE_RATING DESC");
		
		ResultSet rs = psmt.executeQuery();
		
		return this.GetProductsFromResultSet(rs);
	}
	
	public List<Product> GetRecentlyRatedProducts() throws SQLException {
		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT P.EAN, P.NAME, P.PICTURE, AVG_RATING(P.EAN) "
				+ "FROM PRODUCTS P "
				+ "INNER JOIN REVIEWS R ON P.EAN = R.EAN  "
				+ "ORDER BY R.REVIEW_DATE DESC");
		
		ResultSet rs = psmt.executeQuery();
		
		return this.GetProductsFromResultSet(rs);
	}
	
	private List<Product> GetProductsFromResultSet(ResultSet rs) throws SQLException {

		List<Product> productList = new ArrayList<Product>();

		while (rs.next()) {
			long ean = rs.getLong(1);
			String name = rs.getString(2);

			int rating = rs.getInt(4);
			Product product = new Product(ean, name, null);
			product.setRating(rating);
			// TODO picture
			productList.add(product);
		}
		return productList;
	}

}
