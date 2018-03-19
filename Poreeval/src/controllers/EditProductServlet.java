package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ")
            .append(request.getContextPath());
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        try {
            
            String name = request.getParameter("name");
            if(name.isEmpty()) throw new Exception("Bitte Namen eingeben.");
            long ean = Long.parseUnsignedLong(request.getParameter("ean"));
            if(request.getParameter("ean").isEmpty()) throw new Exception("Bitte EAN eingeben.");
            String description = request.getParameter("description");
            if(description.isEmpty()) throw new Exception("Bitte Beschreibung eingeben.");

            ProductModel model = new ProductModel();
            
            if(!CheckUserPrivilege.CheckPrivilege(request, 2)) {
                
                throw new Exception("Nicht genuegend Rechte!");
            }
            
            model.UpdateProduct(ean, name, description, null);
             
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("editProduct.jsp").forward(request, response);
        }
	}

}
