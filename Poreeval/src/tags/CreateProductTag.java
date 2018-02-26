package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class CreateProductTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		try {
			pageContext.getOut().append(getCreateProductForm());
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
					+ "<input type='text' class='form-control' placeholder='Namen hinzufügen' name='name'>"
					+ "</div>"
					+ "<div class='form-group'>	"
					+ "<label>EAN-Code</label> "
					+ "<input type='number' class='form-control' placeholder='EAN ist optional' name='ean'> "
					+ "</div>"
					+ "<div class='form-group'> "
					+ "<label>Notiz</label> "
					+ "<input type='text' class='form-control' placeholder='Notiz hinzufügen' name='description'> "
					+ "</div>"
					+ "<div class='form-group'>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<label>Bild</label> "
					+ "<label>Datei hochladen</label> "
					+ "<input type='file' name='image'>"
					+ "<p class='help-block'>Nur .png und .jpg erlaubt</p>"
					+ "</div>"
					+ "<div class='chechbox'>"
					+ "<label><input type='radio' name='rating'>0 Sterne</label>"
					+ "<label><input type='radio' name='rating'>1 Stern</label>"
					+ "<label><input type='radio' name='rating'>2 Sterne</label>"
					+ "<label><input type='radio' name='rating'>3 Sterne</label>"
					+ "<label><input type='radio' name='rating'>4 Sterne</label>"
					+ "</div>"
					+ "<button class='btn-default' type='submit'>Produkt erstellen</button>"
					+ "</form>"
					+ "</div>";
		
		return createProductForm;
	}
}
