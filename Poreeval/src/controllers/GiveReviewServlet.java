package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import helper.CheckUserPrivilege;

/**
 * @author Lennard Brunke
 * Servlet implementation class GiveReviewServlet
 */
@WebServlet("/GiveReviewServlet")
public class GiveReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
		    HttpSession session = request.getSession();
		    int id = Integer.parseInt(request.getParameter("id"));
		    User user = (User) session.getAttribute("user");
		    
		    if(!CheckUserPrivilege.CheckPrivilege(user, 3)) {
	            throw new Exception("Bitte einloggen, um ein Review zu erstellen.");
	        }
		    
		    session.setAttribute("id", id);
	        
		    request.getRequestDispatcher("giveReview.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("showProductDetails.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
