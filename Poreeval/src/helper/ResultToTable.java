package helper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import data.Product;

/*
 * @author Jannik Bukowski, 235502
 */

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
			table += "<table class='table table-striped tabled-bordered table-hover table-condensed'>";
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


// Zu verbessernde Variante, TD in der der Produktname steht, soll oncklick die Detailansicht eines Produkts anzeigen
// 
//
//
//	public static String ToTable(List<Product> products) {
//		String table = "";
//		for (Product product : products) {
//			table += "<div class='container'>";
//			table += "<table class='table table-striped tabled-bordered table-hover table-condensed'>";
//			table += "<td rowspan='3' >TODO Bild</td>";
//	
//			table += "<td class='success' onclick='showProductDetails(this)'>" + product.getProductname() + "</td>";
//
//			table += "<tr><td>" + product.getDescription() + "</td></tr>";
//			table += "<tr><td>" + product.getRating() + "</td></tr>";
//			table += "</table>";
//			table += "</div>";
//		}
//		return table;
//	}
//	
//	<script>
//		function showProductDetails() {
//			window.location.href = "showProductDetails.jsp"
//			
//		}
//		
//  </script>
//	
//	
//	
