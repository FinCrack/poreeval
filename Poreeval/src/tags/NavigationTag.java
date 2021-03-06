package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import data.User;

/**
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
	
	/**
	 * 
	 *  Ist ein Benutzer noch nioht eingeloggt, wird Ihm das Loginformular angezeigt, sobald er sich eingeloggt hat wird ihm sein Benutzname angezeigt
	 */
	private String getLoginControl() {
	    
	    User user = (User) this.pageContext.getSession().getAttribute("user");
        
        String loginControl = "";
        
        if (user != null) {
            
            loginControl = "<li class='dropdown'>"
                + "<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>" + user.getUserName()  + "<span class='caret'></span></a>"
                + "<ul class='dropdown-menu'>"
                    + "<li>"
                        + "<form class='navbar-form navbar-left' action='LogoutServlet' method='post'>"
                            + "<button type='submit' class='btn btn-default'>Logout</button>"
                        + "</form>"
                    + "</li>";
            
        } else {
            loginControl = "<li class='dropdown'>"
                + "<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expanded='false'>Login<span class='caret'></span></a>"
                + "<ul class='dropdown-menu'>"
                    + "<li>"
                        + "<form class='navbar-form navbar-left' action='LoginServlet' method='post'>"
                            + "<label>Username:</label><input type='text' name='userName'>"
                            + "<label>Password:</label><input type='password' name='password'><br>"
                            + "<button type='submit' class='btn btn-default'>Login</button>"
                            + "<a href='createUser.jsp' role='button' type='button' class='btn btn-default'>Registrieren</a>"
                        + "</form>"
                    + "</li>";
        }
        
        return loginControl;
	}
	
	private String getNavbarHtml() {
	    
	    String loginControl = this.getLoginControl();
	    
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
							+ loginControl
						    + "</ul>"
								+ "<li>"
									+ "<form class='navbar-form navbar-left' action='AllProductsServlet'>"
										+ "<button type='submit' class='btn btn-default'>Alle Produkte</button>"	
									+ "</form>"
								+ "</li>"
								+ "<li>"
									+ "<form class='navbar-form navbar-left'>"
										+ "<a href='createProduct.jsp' role='button' class='btn btn-default'>Produkterstellung</a>"
									+ "</form>"
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
				+ "<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>"
				+ "<script src='js/bootstrap.min.js'></script>";
		return navbar;
	}
}
