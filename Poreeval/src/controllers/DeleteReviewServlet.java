package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.CheckUserPrivilege;
import models.ReviewModel;

/**
 * @author Jannik Bukowski, 235502
 */
@WebServlet("/DeleteReviewServlet")
public class DeleteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReviewServlet() {
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
		
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			ReviewModel model = new ReviewModel();
			
			if (!CheckUserPrivilege.CheckPrivilege(request, 2)) {

				throw new Exception("Nicht genuegend Rechte!");
			}
			
			model.DeleteReview(id);
			request.setAttribute("message", "Review erfolgreich gel�scht");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} catch (Exception ex) {
			request.setAttribute("message", ex.getMessage());
			request.getRequestDispatcher("showProductDetails.jsp").forward(request, response);
		}
	}

}
