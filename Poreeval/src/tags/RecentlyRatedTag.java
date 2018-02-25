package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class RecentlyRatedTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		try {
			pageContext.getOut().append(getRecentlyRatedProduct());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String getRecentlyRatedProduct() {
		String recentlyRatedProduct = "<div class='container'>"
				+ "<table class='table table-striped tabled-bordered table-hover table-condensed'>" + "<tr>"
				+ "<th class='success'>Zuletzt bewertet</th>" + "</tr>" + "<tr>" + "<td>Sahnejoghut</td>" + "</tr>"
				+ "<tr>" + "<td>Kartoffelchips</td>" + "</tr>" + "<tr>" + "<td>Humus</td>" + "</tr>" + "</table>"
				+ "</div>";
		return recentlyRatedProduct;
	}
}
