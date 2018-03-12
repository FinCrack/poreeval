package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

/*
 * @author Jannik Bukowski, 235502
 */

public class WelcomeTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	public int doStartTag() {
		try {
			pageContext.getOut().append(getWelcomeContent());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

	private String getWelcomeContent() {
		String welcomeContent = 
			   	  "<div class='text-center h1'>"
			   		  + "<h1> Poreeval - Ihr Portal f�r Lebensmittelevaluation </h1>"
				+ "</div>";
		return welcomeContent;
	}
}
