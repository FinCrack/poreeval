package helper;

import java.util.List;

import data.Product;
import data.Review;

/**
 * @author Jannik Bukowski, 235502
 */

public class ResultToTable {

	/*
	 * Zeigt Produkte auf welcome.jsp und allProducts.jsp in Tabellenform an
	 */
	public static String ProductsToTable(List<Product> products) {
		String table = "";
		for (Product product : products) {
			table += "<table class='table table-striped tabled-bordered table-condensed'>";
			table += "<td rowspan='3' style='width: 15%; height: 150px;' ><img src='" + product.getPicture() + "' style='max-width: 70px; max-height: 100px;'/></td>";
			table += "<form action='ShowProductDetailsServlet' method='get'>";
			table += "<input type='hidden' name='id' value='" + product.getId() + "'>";
			table += "<button type='submit' class='btn btn-primary' style='width: 90%;'>" + product.getProductname()+ "</button>";
			table += "</form>";
			table += "<tr><td style='width: 75%'>" + GetStars(product.getRating()) + "</td></tr>";
			table += "</table>";
		}
		return table;
	}
	
	/*
	 * Zeigt Produkte mit den dazugeh�rigen Reviews in Tabellenform an
	 */
	public static String ProductWithReviewsToTable(Product product){
		String table = "";
		
		//Table der das Produkt anzeigt
			table += "<p><img src='" + product.getPicture() + "' width='200' height='200' /></p>";
			table += "<table class='table table-striped tabled-bordered table-condensed' style='margin-bottom: 100px;'>";
			table += GetEditForm(product) + GetReviewForm(product) + GetDeleteForm(product);
			table += "<tr>";
					table += "<td>" + product.getProductname() + "</td>";
				table += "</tr>";

				table += "<tr>";
					table += "<td>" + GetStars(product.getRating()) + "</td>";
				table += "</tr>";
			table += "</table>";
			
			
			//Table der die Reviews zu einem Produkt anzeigt
			table += "<h3 style='font-weight: bold;'>Kundenrezensionen:</h3>";
			for(Review review : product.getReviews()){
			table += "<table class='table table-striped tabled-bordered table-condensed'>";
				table += "<tr>";
					table += "<td style='font-weight: bold; font-size: 24px; width: 50%;'>" + GetStars(review.getRating()) +  " " + review.getTitle() + "</td><td style='width: 50%;'>" + DeleteReview(review) + "</td>";
				table += "</tr>";
					table += "<td style='font-size: 18px; font-weight: bold;'>Von " + review.getUser_name() + " am " + review.getReview_date().toString() + "</td>";
				table += "</tr>";
			table += "</table>";
			table += "<p>" + review.getText() + "</p>";
			}
		return table;
	}

	
	/*
	 * Holt f�r das jeweilige Produkt das Rating und erstellt damit einen Link zu dem jeweiligen Bild
	 */
	public static String GetStars(int rating){
		String starRating = "";
		
		switch(rating){
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
		String imageCont = "<img src='" + starRating + "' style='max-height: 35px; align: center;'></img>";
		return imageCont; 
	}
	
	/*
	 * Erstellt ein Formular zum editieren eines Produkts, dem dem die ProduktID an das EditProductServlet �bergeben wird
	 */
	public static String GetEditForm(Product product){
		String editForm = 
				"<form action='EditProductServlet' method='get'>"
						+ "<input type='hidden' name='id' value='" + product.getId() + "'>"
						+ "<button type='submit' class='btn btn-primary'>Produkt bearbeiten</button>"
				+ "</form>";
		return editForm;
	}
	
	/*
	 * Erstellt ein Formular zum Review erstellen, dem dem die ProduktID an das GiveReviewServlet �bergeben wird
	 */
	private static String GetReviewForm(Product product) {
		String reviewForm = 
				"<form action='GiveReviewServlet' method='get'>"
						+ "<input type='hidden' name='id' value='" + product.getId() + "'>"
						+ "<button type='submit' class='btn btn-primary' >Review erstellen</button>"
				+ "</form>";
		return reviewForm;
	}
	
	
	/*
	 * Erstellt ein Formular zum L�schen eines Produkts, dem dem die ProduktID an das DeleteProductServlet �bergeben wird
	 */
	private static String GetDeleteForm(Product product){
		String deleteProductForm = 
				"<form action='DeleteProductServlet' method='post'>"
						+ "<input type='hidden' name='id' value='" + product.getId() + "'>"
						+ "<button type='submit' class='btn btn-primary' >Produkt loeschen</button>"
				+ "</form>";
		return deleteProductForm;
	}
	
	/*
	 * Erstellt ein Formular zum L�schen eines Produkts, dem dem die ReviewID an das DeleteReviewServlet �bergeben wird
	 */
	private static String DeleteReview(Review review) {
		String deleteReviewForm = 
				"<form action='DeleteReviewServlet' method='post'>"
						+ "<input type='hidden' name='id' value='" + review.getId() + "'>"
						+ "<button type='submit' class='btn btn-primary' >Review loeschen</button>"
				+ "</form>";
		
		return deleteReviewForm;
	}
}

