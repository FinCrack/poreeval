package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

/*
 * @author Jannik Bukowski, 235502
 */

public class NavigationTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		try {
			pageContext.getOut().append(getNavbarHtml());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	private String getNavbarHtml() {
		String navbar = 
				"<nav class='navbar navbar-default'>" 
						+ "<div class='container'>"
						+ "<div class='navbar-header'>"
							+ "<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1' aria-expanded='true'>"
								+ "<span class='sr-only'>Toggle navigation</span>"
								+ "<span class='icon-bar'></span>"
								+ "<span class='icon-bar'></span>"
								+ "<span class='icon-bar'></span>"
								+ "<span class='sr-only'>Toggle navigation</span>"
								+ "<span class='icon-bar'></span>"
								+ "<span class='icon-bar'></span>"
								+ "<span class='icon-bar'></span>"
							+ "</button>" 
							+ "<a class='navbar-brand' href='welcome.jsp'>Home</a>" 
						+ "</div>"
						+ "<div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>"
							+ "<ul class='nav navbar-nav'>"
								+ "<li class='dropdown'>"
								+ "<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>${ user.userName ?? 'Login'}<span class='caret'></span></a>"
								+ "<ul class='dropdown-menu'>"
									+ "<li>"
										+ "<form action='LoginServlet' method='post'>"
											+ "<label>Username:</label><input type='text' name='userName'>"
											+ "<label>Password:</label><input type='password' name='password'>"
											+ "<button type='submit' onclick='showUser()'>Login</button>"
										+ "</form>"
									+ "</li>"
								+ "</ul>"
								+ "</li>"
								+ "<li>"
									+ "<a href='welcome.jsp' role='button'>Logout</a>"
								+ "<li>"
								+ "<li>"
									+ "<a href='createUser.jsp' role='button' aria-haspopup='true' aria-expanded='false'>Registrieren</a>"
								+ "</li>"
								+ "<li>"
									+ "<a href='createProduct.jsp' role='button'>Produkterstellung</a>"
								+ "</li>"
								+ "<li>"
									+ "<a href='editProduct.jsp' role='button'>Produkte bearbeiten</a>"
								+ "</li>"
								+ "<li>"
									+ "<a href='giveReview.jsp' role='button'>Review abgeben</a>"
								+ "</li>"
								+ "<li>"
									+ "<a href='http://localhost:8080/Poreeval/AllProductsServlet'>Alle Produkte</a>"
								+ "</li>"
								+ "<li>"
								+ "<form class='navbar-form navbar-left' action='SearchProductServlet'>"
									+ "<input type='text' class='form-control' placeholder='Produktnamen eingeben' name='searchStringName'>"
									+ "<button type='submit' class='btn btn-default'>Suchen</button>"	
								+ "</form>"
								+ "</li>"
								+ "</ul>"	
							+ "</div>"
						+ "</div>"	
				+ "</nav>"
				+ "<script "
				+ "src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>"
				+ "<script src='js/bootstrap.min.js'></script>";
		return navbar;
	}
}
