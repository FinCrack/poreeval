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
import models.ReviewModel;

/** 
 * @author Lennard Brunke 259315
 * 
 */
@WebServlet("/CreateReviewServlet")
public class CreateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReviewServlet() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    try {
	        HttpSession session = request.getSession();
	        int rating = Integer.parseInt(request.getParameter("rating"));
	        
	        String title = request.getParameter("title");
	        if (title.isEmpty()) {
	            throw new Exception("Bitte einen Titel angeben.");
	        }
	        
	        String text = request.getParameter("text");
	        
	        int product_id = (int) session.getAttribute("id");
	        
	        User user = (User) request.getSession().getAttribute("user");
	        
	        if(!CheckUserPrivilege.CheckPrivilege(user, 3)) {
	            throw new Exception("Bitte einloggen, um ein Review zu erstellen.");
	        }
	        
	        ReviewModel model = new ReviewModel();
	        
	        model.CreateReview(rating, title, text, product_id, user.getId());
	        request.setAttribute("message", "Review erfolgreich erstellt!");
	        request.getRequestDispatcher("showProductDetails.jsp").forward(request, response);
	        
        } catch (Exception exc) {
            request.setAttribute("message", exc.getMessage());
            request.getRequestDispatcher("giveReview.jsp").forward(request, response);
        }
	    
	}

}
