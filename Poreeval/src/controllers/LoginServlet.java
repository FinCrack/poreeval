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
import javax.servlet.http.HttpSession;

import dataAccess.DatabaseConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	
	private boolean authenticate(String username, String password) {
		boolean validate = false;
		Connection con = DatabaseConnection.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement("SELECT * from USERS where username= ? AND password = ?");
			psmt.setString(1, username);
			psmt.setString(2, password);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				validate = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validate;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String errormsg = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		boolean isValid = false;
		isValid = authenticate(username, password);
		if(isValid) {
			session.setAttribute("username", username);
		} else {
		errormsg = "Username oder Passwort sind falsch.";
		}
		session.setAttribute("errormsg", errormsg);
	
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}

}
