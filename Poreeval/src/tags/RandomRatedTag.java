package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class RandomRatedTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		try {
			pageContext.getOut().append(getRandomRatedProduct());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String getRandomRatedProduct() {
		String randomRatedProduct = 
				"<div>"
				+ "<table class='table table-striped tabled-bordered table-hover table-condensed'>" 
				+ "<tr>"
				+ "<th class='danger'>Zufälliges Produkt</th>" 
				+ "</tr>" 
				+ "<tr>" 
				+ "<td>Milchkaffee</td>" 
				+ "</tr>"
				+ "<tr>" 
				+ "<td>Coca Cola</td>" 
				+ "</tr>" 
				+ "<tr>" 
				+ "<td>Pommes</td>" 
				+ "</tr>" 
				+ "</table>"
				+ "</div>";
		return randomRatedProduct;
	}
}
