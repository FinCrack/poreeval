package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Product;
import models.ProductModel;

/**
 * Servlet implementation class ShowProductDetailsServlet
 */
@WebServlet("/ShowProductDetailsServlet")
public class ShowProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			ProductModel model = new ProductModel();
			long ean = Long.parseLong(request.getParameter("ean"));
			Product product = model.GetProductWithReviews(ean);
			
			request.getSession().setAttribute("product", product);
			
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());	
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("showProductDetails.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
