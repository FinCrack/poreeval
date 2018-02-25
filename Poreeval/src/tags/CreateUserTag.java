package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

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
		String createUserForm = "<h1 style='text-align: center'>Bitte geben Sie ihre Daten an!</h1>"
					+ "<div class='container'>"
					+ "<form action='CreateUserServlet' method='post'>"
					+ "<div class='form-group'>"
					+ "<label>Rolle</label>"
					+ "<select class='form-control' id='role' name='role'>"
					+ "<option value='RegUser'>Benutzer</option>"
					+ "<option value='Mod'>Moderator</option>"
					+ "</select>"
					+ "</div>"
					+ "<div class='form-group'>	"
					+ "<label>Username</label> "
					+ "<input type='text' class='form-control' placeholder='Username eingeben' name='username'>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<label>E-Mail</label> "
					+ "<input type='email' class='form-control' placeholder='E-Mail eingeben' name='email'>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<label>Passwort</label> "
					+ "<input type='password' class='form-control' placeholder='Passwort eingeben' name='password1'>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<label>Passwort bestätigen</label> "
					+ "<input type='password' class='form-control' placeholder='Passwort bestätigen' name='password2'>"
					+ "</div>"
					+ "<button class='btn-default' type='submit'>Registrieren</button>"
					+ "</form>"
					+ "</div>";
		return createUserForm;
	}
}
