package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccess.DatabaseConnection;

/**
 * Servlet implementation class AllProductServlet
 */
@WebServlet("/AllProductServlet")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		Connection con = DatabaseConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM PRODUCTS");
			ResultSet rs = pstmt.executeQuery();
			request.setAttribute("rs", rs);
			request.getRequestDispatcher("allProducts.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("result", e.getMessage());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
	}

}
