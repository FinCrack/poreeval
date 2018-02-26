package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class AllProductsTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	public int doStartTag() {
		try {
			pageContext.getOut().append(getAllProducts());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String getAllProducts() {
		String table =
				"<table class='table table-striped tabled-bordered table-hover table-condensed'>"
				+ "<tr class='danger'>"
				+ "<th>BILD</th><th>PRODUKTNAMEN</th><th>STERNE IM DURSCHNITT</th>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Bild A</td><td>Name A</td><td>Sterne A</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Bild B</td><td>Name B</td><td>Sterne B</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Bild C</td><td>Name C</td><td>Sterne C</td>"
				+ "</tr>"
				+ "</table>";
		return table;
	}	
}
