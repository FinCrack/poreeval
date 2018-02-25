package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class WelcomeTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	public int doStartTag() {
		try {
			pageContext.getOut().append(getWelcomeContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String getWelcomeContent() {
		String welcomeContent = "<div class='jumbotron text-center'>"
				+ "<div class='container'>"
				+ "<h1>Willkommen bei Poreeval!</h1>"
				+ "</div>"
				+ "</div>"
				+ "<div class='container'>"
				+ "<table class='table table-striped tabled-bordered table-hover table-condensed'>"
				+ "<tr>"
				+ "<th>Zuletzt bewertet</th>"
				+ "<th class='success'>Am besten bewertet</th>"
				+ "<th class='danger'>Zuf‰lliges Produkt</th>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Sahnejoghut</td>"
				+ "<td>Mio Mio Ginger + Rating</td>"
				+ "<td>Milchkaffee</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Kartoffelchips</td>"
				+ "<td>Pueblo Tabak + Rating</td>"
				+ "<td>Coca Cola</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Humus</td>"
				+ "<td>Erdinger Weiﬂbier + Rating</td>"
				+ "<td>Pommes</td>"
				+ "</tr>"
				+ "</table>"
				+ "</div>"
				+ "<table><br>";
		
		return welcomeContent;
	}
}
