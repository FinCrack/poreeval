package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Christian Lindenberg
 */

public class CreateUserTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		try {
			pageContext.getOut().append(getCreateUserForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String getCreateUserForm() {
		String createUserForm = 
					"<h1 style='text-align: center'>Bitte geben Sie ihre Daten an!</h1>"
					+ "<div class='container'>"
					+ "<form action='CreateUserServlet' method='post'>"
					+ "<div class='form-group'>	"
					+ "<label>Username</label> "
					+ "<input type='text' class='form-control' placeholder='Username eingeben' name='userName'>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<label>E-Mail</label> "
					+ "<input type='email' class='form-control' placeholder='E-Mail eingeben' name='email'>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<label>Passwort</label> "
					+ "<input type='password' class='form-control' placeholder='Passwort eingeben (mindestens 6 zeichen)' name='password'>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<label>Passwort best�tigen</label> "
					+ "<input type='password' class='form-control' placeholder='Passwort bestaetigen' name='password2'>"
					+ "</div>"
					+ "<button class='btn-default' type='submit'>Registrieren</button>"
					+ "</form>"
					+ "</div>";
		return createUserForm;
	}
}
