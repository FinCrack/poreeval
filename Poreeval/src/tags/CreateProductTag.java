package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;


/*
 * @author Jannik Bukowski, 235502
 */

public class CreateProductTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		try {
			this.pageContext.getOut().append(getCreateProductForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String getCreateProductForm() {
		String createProductForm = 
					  "<div class='container'>"
							+ "<form action='CreateProductServlet' method='post'>"
					+ "<div class='form-group'>"
							+ "<label>Produktname</label> "
							+ "<input type='text' class='form-control' placeholder='Namen hinzufuegen' name='name'>"
					+ "</div>"
					+ "<div class='form-group'>	"
							+ "<label>EAN-Code</label> "
							+ "<input type='number' class='form-control' placeholder='EAN eingeben' name='ean'> "
					+ "</div>"
					+ "<div class='form-group'>"
					+ "</div>"
					+ "<div class='form-group'>"
							+ "<label>Bild</label> "
							+ "<label>Bitte eine gueltige URL zu jpg oder img angeben</label> "
							+ "<input type='text' name='picture'>"
							+ "<p class='help-block'>Nur .png und .jpg erlaubt</p>"
					+ "</div>"
						+ "<button class='btn-default' type='submit'>Produkt erstellen</button>"
						+ "</form>"
					+ "</div>";
		
		return createProductForm;
	}
	

}
