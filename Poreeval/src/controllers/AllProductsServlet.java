package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Product;
import models.ProductModel;

/*
 * @author Jannik Bukowski, 235502
 */
@WebServlet("/AllProductsServlet")
public class AllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllProductsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductModel model = new ProductModel();
		
		List<Product> products;
		try {
			products = model.GetAllProducts();
			
			HttpSession session = request.getSession();
			
			session.setAttribute("products", products);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			request.setAttribute("message", e.getMessage());;
		}
		
		request.getRequestDispatcher("allProducts.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
	}
}
