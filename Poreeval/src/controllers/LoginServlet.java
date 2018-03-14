package controllers;

import java.io.IOException;
import java.sql.SQLException;
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
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */


    protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

        String message = "";
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        UserModel model = new UserModel();

        User user = null;
        try {
            user = model.LoginUser(userName, password);
        } catch (SQLException exc) {
            // TODO Auto-generated catch block
            exc.printStackTrace();
        }

        if (user == null) {
            
            message = "Name oder Password falsch";
            
        } else {

            session.setAttribute("user", user);
            message = "Hallo " + user.getUserName();
        }
        
        session.setAttribute("message", message);
        request.getRequestDispatcher("welcome.jsp").forward(request,
            response);

    }

}
