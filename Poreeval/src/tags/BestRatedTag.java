package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class BestRatedTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		try {
			pageContext.getOut().append(getBestRatedProduct());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return  EVAL_BODY_INCLUDE;
	}
	
	private String getBestRatedProduct() {
		String bestRatedProduct = 
				"<div>"
				+ "<table class='table table-striped tabled-bordered table-hover table-condensed'>" 
				+ "<tr>"
				+ "<th class='success'>Am besten Bewertet</th>" 
				+ "</tr>" 
				+ "<tr>" 
				+ "<td>Mio Mio Ginger + Rating</td>"
				+ "</tr>" 
				+ "<tr>" 
				+ "<td>Pueblo Tabak + Rating</td>" 
				+ "</tr>" 
				+ "<tr>"
				+ "<td>Erdinger Weiﬂbier + Rating</td>"
				+ "</tr>" 
				+ "</table>" 
				+ "</div>";
		return bestRatedProduct;
	}
}
