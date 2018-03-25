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
				.prepareStatement("INSERT INTO PRODUCTS (EAN, NAME, PICTURE) " + "VALUES (?, ?, ?)");

		psmt.setLong(1, product.getEan());
		psmt.setString(2, product.getProductname());
		psmt.setString(3, product.getPicture());

		psmt.executeUpdate();
	}

	public void UpdateProduct(Product product) throws SQLException {
		PreparedStatement psmt = this.connection
				.prepareStatement("UPDATE PRODUCTS SET EAN = ?, NAME = ?, PICTURE = ? WHERE ID = ?;");

		psmt.setLong(1, product.getEan());
		psmt.setString(2, product.getProductname());
		psmt.setString(3, product.getPicture());
		psmt.setInt(4, product.getId());

		psmt.executeUpdate();
	}

	public Product GetProductById(int id) throws SQLException {

		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT EAN, NAME, PICTURE, AVG_RATING(ID), ID FROM PRODUCTS WHERE ID = ?;");

		psmt.setLong(1, id);

		ResultSet rs = psmt.executeQuery();

		return this.GetProductsFromResultSet(rs).get(0);
	}
	
	
	public Product GetProductByEan(long ean) throws SQLException {

        PreparedStatement psmt = this.connection.prepareStatement(
                "SELECT EAN, NAME, PICTURE, AVG_RATING(ID), ID FROM PRODUCTS WHERE EAN = ?");

        psmt.setLong(1, ean);

        ResultSet rs = psmt.executeQuery();

        return this.GetProductsFromResultSet(rs).get(0);
    }
	
	public void DeleteProductById(int id) throws SQLException {
		
		PreparedStatement psmt = this.connection.prepareStatement(
				"DELETE FROM REVIEWS WHERE PRODUCT_ID = ?; DELETE FROM PRODUCTS WHERE ID = ?;");
		
		psmt.setInt(1, id);
		psmt.setInt(2, id);
		
		psmt.executeUpdate();

	}

	public List<Product> GetProductsByName(String name) throws SQLException {

		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT EAN, NAME, PICTURE, AVG_RATING(ID), ID FROM PRODUCTS WHERE NAME ILIKE ?");

		psmt.setString(1, "%" + name + "%");

		ResultSet rs = psmt.executeQuery();

		return this.GetProductsFromResultSet(rs);
	}

	public List<Product> GetAllProducts() throws SQLException {
        PreparedStatement psmt =
            this.connection.prepareStatement(
                "SELECT EAN, NAME, PICTURE, AVG_RATING(ID), ID FROM PRODUCTS ORDER BY NAME ASC");

        ResultSet rs = psmt.executeQuery();

        return this.GetProductsFromResultSet(rs);

	}
	
	public List<Product> GetBestRatedProducts() throws SQLException {
		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT P.EAN, NAME, PICTURE, AVG_RATING(P.ID) AS AVERAGE_RATING, P.ID "
				+ "FROM PRODUCTS P INNER JOIN REVIEWS R ON P.ID = R.PRODUCT_ID "
				+ "GROUP BY P.EAN, P.NAME, P.PICTURE, P.ID ORDER BY AVERAGE_RATING DESC LIMIT 5");
		
		ResultSet rs = psmt.executeQuery();
		
		return this.GetProductsFromResultSet(rs);
	}
	
	public List<Product> GetRecentlyRatedProducts() throws SQLException {
		PreparedStatement psmt = this.connection.prepareStatement(
				"SELECT P.EAN, P.NAME, P.PICTURE, AVG_RATING(P.ID), P.ID "
				+ "FROM PRODUCTS P "
				+ "INNER JOIN REVIEWS R ON P.ID = R.PRODUCT_ID "
				+ "GROUP BY P.EAN, P.NAME, P.PICTURE, P.ID, R.REVIEW_DATE ORDER BY R.REVIEW_DATE DESC LIMIT 5");
		
		ResultSet rs = psmt.executeQuery();
		
		return this.GetProductsFromResultSet(rs);
	}
	
	private List<Product> GetProductsFromResultSet(ResultSet rs) throws SQLException {

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
