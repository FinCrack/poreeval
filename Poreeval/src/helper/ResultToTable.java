package helper;

import java.util.List;

import data.Product;
import data.Review;

/*
 * @author Jannik Bukowski, 235502
 */

public class ResultToTable {

	public static String ProductsToTable(List<Product> products) {
		String table = "";
		for (Product product : products) {
			table += "<table class='table table-striped tabled-bordered table-hover table-condensed'>";
			table += "<td rowspan='3' style='width: 25%'><img src='https://www.spirulina.pl/wp-content/uploads/2015/07/naturalny-produkt.jpg'/></td>";
			table += "<form action='ShowProductDetailsServlet' method='get'>";
			table += "<input type='hidden' name='ean' value='" + product.getEan() + "'>";
			table += "<button type='submit' class='btn btn-primary'>" + product.getProductname()+ "</button>";
			table += "</form>";
			table += "<tr><td style='width: 75%'>" + product.getDescription() + "</td></tr>";
			table += "<tr><td style='width: 75%'; text-align: center;>" + product.getRating() + "</td></tr>";
			table += "</table>";
		}
		return table;
	}
	
	public static String ProductWithReviewsToTable(Product product){
		String table= "";
		
		//Table der das Produkt anzeigt
			table += "<p><img src='https://www.spirulina.pl/wp-content/uploads/2015/07/naturalny-produkt.jpg' width='200' height='200' /></p>";
			table += "<table class='table table-striped tabled-bordered table-hover table-condensed'>";
				table += "<tr>";
					table += "<td>" + product.getProductname() + "</td>";
				table += "</tr>";
				table += "<tr>";
					table += "<td>" + product.getRating() + "</td>";
				table += "</tr>";
			table += "</table>";
			
			//Table der die Reviews zu einem Produkt anzeigt
			for(Review review : product.getReviews()){
			table += "<table>";
				table += "<tr>";
					table += "<td>" + review.getRating() +  "</td><td>" + review.getTitle() + "</td>";
				table += "</tr>";
					table += "<td>" + review.getUser_name() + "</td><td>" + review.getReview_date() + "</td>";
				table += "</tr>";
			table += "</table>";
			table += "<p>text</p>";
			}
		return table;
	}
	
	/*
	 * <p><img src="https://www.spirulina.pl/wp-content/uploads/2015/07/naturalny-produkt.jpg" width="135" height="135" /></p>
<table class="table table-striped tabled-bordered table-hover table-condensed" style="width: 257px; height: 78px;">
<tbody>
<tr>
<td style="width: 247px;">Name</td>
</tr>
<tr>
<td style="width: 247px;">Durchschnittliches Rating</td>
</tr>
</tbody>
</table>
<table>
<tbody>
<tr>
<td>Rating</td>
<td>&Uuml;berschrift</td>
</tr>
<tr>
<td>Username</td>
<td>Date</td>
</tr>
</tbody>
</table>
<p>text</p>
	 * */
}

