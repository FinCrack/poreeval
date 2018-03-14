package helper;

import java.util.List;

import data.Product;

/*
 * @author Jannik Bukowski, 235502
 */

public class ResultToTable {

	public static String ToTable(List<Product> products) {
		String table = "";
		for (Product product : products) {
			table += "<table class='table table-striped tabled-bordered table-hover table-condensed'>";
			table += "<td rowspan='3'><img src='https://www.spirulina.pl/wp-content/uploads/2015/07/naturalny-produkt.jpg'/></td>";
			table += "<td><a href='showProductDetails.jsp' class='list-group-item active'>" + product.getProductname() + "</a></td>";
			table += "<tr><td>" + product.getDescription() + "</td></tr>";
			table += "<tr><td>" + product.getRating() + "</td></tr>";
			table += "</table>";
		}
		return table;
	}
}
