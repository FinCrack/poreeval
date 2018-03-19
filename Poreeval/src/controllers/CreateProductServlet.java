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

		String name = request.getParameter("name");
		long ean = Long.parseLong(request.getParameter("ean"));
		String description = request.getParameter("description");
		ProductModel model = new ProductModel();
		
		
		try {
			
			 if(!CheckUserPrivilege.CheckPrivilege(request, 3)) {
	                
	                throw new Exception("Nicht genuegend Rechte!");
	            }
            model.CreateProduct(ean, name, description, null);
		 } catch (Exception ex) {
	            request.setAttribute("message", ex.toString());
	            request.getRequestDispatcher("createProduct.jsp").forward(request, response);
	        }
		
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}

}
