package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.CheckUserPrivilege;
import models.ProductModel;

/*
 * @author Jannik Bukowski, 235502
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProductServlet() {
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

		try {
			long ean = Long.parseUnsignedLong(request.getParameter("ean"));

			ProductModel model = new ProductModel();

			if (!CheckUserPrivilege.CheckPrivilege(request, 2)) {

				throw new Exception("Nicht genuegend Rechte!");
			}
			
			model.DeleteProductByEan(ean);
			request.setAttribute("message", "Produkt erfolgreich gelöscht!");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} catch (Exception ex) {
			request.setAttribute("message", ex.getMessage());
			request.getRequestDispatcher("showProductDetails.jsp").forward(request, response);
			
		}
		
		
	}

}
