package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import models.UserModel;

/**
 * @author Christian Lindenberg, 235372
 */
/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateUserServlet() {
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

		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		int privilege = Integer.parseInt(request.getParameter("privilege"));
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");

		UserModel model = new UserModel();
		HttpSession session = request.getSession();
		String createUserMessage;

		try {
			model.CreateUser(userName, password, password2, privilege, email);
			createUserMessage = "Benutzer wurde erfolgreich angelegt...";
			User user = model.LoginUser(userName, password);
			session.setAttribute("user", user);
			session.setAttribute("message", createUserMessage);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);

		} catch (SQLException exc) {
			createUserMessage = "Fehler beim Erstellen des Benutzers: \n" + exc.getMessage();
			session.setAttribute("message", createUserMessage);
			request.getRequestDispatcher("createUser.jsp").forward(request, response);
		} catch (Exception exc) {
			createUserMessage = exc.getMessage();
			session.setAttribute("message", createUserMessage);
			request.getRequestDispatcher("createUser.jsp").forward(request, response);
		}

		
	}

}
