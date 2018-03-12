package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
/**
 * @author Christian Lindenberg, 235372
 */
/**
 * Servlet implementation class CheckUserPrivilegeServlet
 */
@WebServlet("/CheckUserPrivilegeServlet")
public class CheckUserPrivilegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUserPrivilegeServlet() {
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
		
		HttpSession session = request.getSession();
		String target = request.getParameter("target");
		int requiredPrivilege = Integer.parseInt(request.getParameter("requiredPrivilege"));
		User user = (User) session.getAttribute("user");
		boolean allowEdit;
		boolean allowDelete;
		
		
		if(user.getPrivilege() == requiredPrivilege)
		
		switch (user.getPrivilege()) {
		case 1: allowEdit = true;
				allowDelete = true;
			break;
		case 2:	allowEdit = true;
				allowDelete = true;
			break;
		case 3:	allowEdit = false;
				allowDelete = false;
			break;
		default:
			break;
		}
	}

}
