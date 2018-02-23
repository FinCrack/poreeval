package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Product;

/**
 * Servlet implementation class CreateProductServlet
 */
@WebServlet("/CreateProductServlet")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String productname = request.getParameter("productname");
		Integer ean = Integer.parseInt(request.getParameter("ean"));
		String note = request.getParameter("note");
		Integer rating = Integer.parseInt(request.getParameter("rating"));
		String date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());

		// hier müsste eigentlich noch das bild rein aber da hab ich kein plan
		// von
		// research sagte was von bild in bytearray packen und dann wieder
		// umdröseln wegen request - String zusammenhang etc

		Product product = new Product(productname, ean, note, rating, date);

		ArrayList<Product> productList = new ArrayList<Product>();
		productList.add(product);
	}

}
