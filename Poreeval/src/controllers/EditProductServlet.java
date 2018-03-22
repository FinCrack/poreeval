package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Product;
import helper.CheckUserPrivilege;
import models.ProductModel;

/**
 * @author Lennard Brunke 259315
 * 
 */
@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			ProductModel model = new ProductModel();
			long ean = Long.parseUnsignedLong(request.getParameter("ean"));
			Product product = model.GetProductWithReviews(ean);

			request.getSession().setAttribute("product", product);

		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("showProductDetails.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("editProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String name = request.getParameter("name");
			if (name.isEmpty()) {
				throw new Exception("Bitte Namen eingeben.");
			}
			
			if (request.getParameter("ean").isEmpty()) {
				throw new Exception("Bitte EAN eingeben.");
			}
			long ean = Long.parseUnsignedLong(request.getParameter("ean"));

			ProductModel model = new ProductModel();

			if (!CheckUserPrivilege.CheckPrivilege(request, 2)) {

				throw new Exception("Nicht genuegend Rechte!");
			}

			model.UpdateProduct(ean, name, null);
			request.setAttribute("message", "Produkt erfolgreich editiert");
			request.getRequestDispatcher("showProductDetails.jsp").forward(request, response);

		} catch (Exception ex) {
			request.setAttribute("message", ex.getMessage());
			request.getRequestDispatcher("editProduct.jsp").forward(request, response);
		}
	}

}
