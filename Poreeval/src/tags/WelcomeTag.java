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
		String welcomeContent = 
				"<div class='jumbotron text-center'>"
				+ "<div class='container'>"
				+ "<h1> Poreeval </h1>"
				+ "</div>"
				+ "</div>";		
		return welcomeContent;
	}
}
