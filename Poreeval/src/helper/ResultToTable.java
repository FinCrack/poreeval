package helper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import data.Product;

public class ResultToTable {

	public static String ToTable(ResultSet rs) {
		String table = "<table>";
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int col = rsmd.getColumnCount();
			table += "<tr>";
			for (int i = 1; i != col; i++) {
				table += "<th>" + rsmd.getColumnName(i) + "</th>";
			}
			table += "<tr>";
			do {
				table += "<tr>";
				for (int i = 1; i != col; i++) {
					table += "<td>" + rs.getString(i) + "</td>";
				}
				table += "</tr>";
			} while (rs.next());
		} catch (SQLException e) {
			table = "Keine Ergebnisse";
		}
		return table;
	}
	
	
	public static String ToTable(List<Product> products) {
		String table = "";
		for (Product product : products) {
			table += "<div class='container'>";
			table += "<table class='table'>";
			table += "<td rowspan='3' >TODO Bild</td>";
			table += "<td class='success'>" + product.getProductname() + "</td>";
			table += "<tr><td>" + product.getDescription() + "</td></tr>";
			table += "<tr><td>" + product.getRating() + "</td></tr>";
			table += "</table>";
			table += "</div>";
		}
		
		return table;
	}
}