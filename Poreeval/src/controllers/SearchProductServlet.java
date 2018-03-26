package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Product;
import models.ProductModel;

/**
 * @author Christian Lindenberg, 235372
 */
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String searchStringName = request.getParameter("searchStringName");
	    long ean = 0;
	    
	    try 
	    {
	        ean = Long.parseUnsignedLong(searchStringName);
	    } catch (NumberFormatException ex) {
	        //nix
	    }
	    
	    ProductModel model = new ProductModel();
	    
	    List<Product> searchResults = new ArrayList<Product>();
	    
        try {
            searchResults = model.SearchProducts(ean, searchStringName);
        } catch (SQLException exc) {
            // TODO Auto-generated catch block
            exc.printStackTrace();
        }
	    
	    HttpSession session = request.getSession();
	    session.setAttribute("searchResults", searchResults);
	    
	    request.getRequestDispatcher("showSearchResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	    
	}

}
