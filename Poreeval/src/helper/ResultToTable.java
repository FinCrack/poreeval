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
			table += "<tr><td style='width: 75%'; text-align: center;>" + GetStars(product) + "</td></tr>";
			table += "</table>";
		}
		return table;
	}
	
	@SuppressWarnings("deprecation")
	public static String ProductWithReviewsToTable(Product product){
		String table = "";
		
		//Table der das Produkt anzeigt
			table += "<p><img src='https://www.spirulina.pl/wp-content/uploads/2015/07/naturalny-produkt.jpg' width='200' height='200' /></p>";
			table += "<table class='table table-striped tabled-bordered table-condensed' style='margin-bottom: 100px;'>";
			table += GetEditForm(product);
			table += "<tr>";
					table += "<td>" + product.getProductname() + "</td>";
				table += "</tr>";

				table += "<tr>";
					table += "<td>" + GetStars(product) + "</td>";
				table += "</tr>";
			table += "</table>";
			
			
			//Table der die Reviews zu einem Produkt anzeigt
			table += "<h3 style='font-weight: bold;'>Kundenrezensionen:</h3>";
			for(Review review : product.getReviews()){
			table += "<table class='table table-striped tabled-bordered table-condensed'>";
				table += "<tr>";
					table += "<td style='font-weight: bold;'>" + GetStars(product) +  " " + review.getTitle() + "</td>";
				table += "</tr>";
					table += "<td style='font-size: 18px; font-weight: bold;'>Von " + review.getUser_name() + " am " + review.getReview_date().toGMTString() + "</td>";
				table += "</tr>";
			table += "</table>";
			table += "<p>" + review.getText() + "</p>";
			}
		return table;
	}
	
	public static String GetStars(Product product){
		String starRating = "";
		
		switch(product.getRating()){
			case 0: starRating = "resources/0 Sterne.png";
				break;
			case 1: starRating = "resources/1 Stern.png";
				break;
			case 2: starRating = "resources/2 Sterne.png";
				break;
			case 3: starRating = "resources/3 Sterne.png";
				break;
			case 4: starRating = "resources/4 Sterne.png";
				break;
			case 5: starRating = "resources/5 Sterne.png";
				break;
			default: starRating = "resources/0 Sterne.png";
				break;
		}
		String imageCont = "<img src='" + starRating + "' style='max-height: 35px;'></img>";
		return imageCont;
	}
	
	public static String GetEditForm(Product product){
		String editForm = "<form action='EditProductServlet' method='post'>"
				+ "<input type='hidden' name='ean' value='" + product.getEan() + "'>"
				+ "<button type='submit' class='btn btn-primary'>Produckt bearbeiten</button>"
				+ "</form>";
		return editForm;
	}
}

