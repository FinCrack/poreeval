package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

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
		String navbar = "<nav class='navbar navbar-default'>" 
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
				+ "<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>Login <span class='caret'></span></a>"
				+ "<ul class='dropdown-menu'>"
				+ "<li>"
				+ "<form action='LoginServlet' method='post'>"
				+ "<label>Username:</label><input type='text' name='userName'>"
				+ "<label>Password:</label><input type='password' name='password'>"
				+ "<button type='submit'>Login</button>"
				+ "</form>"
				+ "</li>"
				+ "</ul>"
				+ "</li>"
				+ "<li>"
				+ "<a href='createUser.jsp' role='button' aria-haspopup='true' aria-expanded='false'>Registrieren</a>"
				+ "<ul class='dropdown-menu'></ul>"
				+ "</li>"
				+ "<li class='dropdown'>"
				+ "<a href='#' class='dropdown-toggle'	data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>Produktsuche <span class='caret'></span>"
				+ "</a>"
				+ "<ul class='dropdown-menu'>"
				+ "<li>"
				+ "<form action='SearchProductServlet' method='post'>"
				+ "<label>Produktname</label>"
				+ "<input type='text' name='searchStringName'>"
				+ "<button type='submit'>Suchen</button>"
				+ "</form>"
				+ "</li>"
				+ "</ul>"
				+ "</li>"
				+ "<li>"
				+ "<a href='createProduct.jsp'>Produkterstellung</a>"
				+ "</li>"
				+ "<li>"
				+ "<a href='editProduct.jsp'>Produkte editieren</a>"
				+ "</li>"
				+ "<li>"
				+ "<a href='giveReview.jsp'>Review abgeben</a>"
				+ "</li>"
				+ "<li>"
				+ "<a href='allProducts.jsp'>Alle Produkte</a>"
				+ "</li>"
				+ "</ul>"
				+ "</div>"
				+ "</div>"
				+ "</nav>"
				+ "<script "
				+ "src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script><script src='js/bootstrap.min.js'>"
				+ "</script>";
		return navbar;
	}
}
