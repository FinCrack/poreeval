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
		String createProductForm = "<div class='container'><form action='CreateProductServlet' method='post'>"
					+ "<div class='form-group'>"
					+ "<label>Produktname</label> <input type='text' class='form-control' placeholder='Namen hinzufügen' name='productname'>"
					+ "</div>"
					+ "<div class='form-group'>	<label>EAN-Code</label> <input type='number' class='form-control' placeholder='EAN ist optional' name='ean'> </div>"
					+ "<div class='form-group'> <label>Notiz</label> <textarea class='form-control' placeholder='Notiz hinzufügen' name='note'> </textarea> </div>"
					+ "<div class='form-group'>"
					+ "<label>Bewertung</label>"
					+ "<select class='form-control' name='rating' id='rating'>"
					+ "<option value='1 Star'>1 Stern</option>"
					+ "<option value='2 Star'>2 Stern</option>"
					+ "<option value='3 Star'>3 Stern</option>"
					+ "<option value='4 Star'>4 Stern</option>"
					+ "<option value='5 Star'>5 Stern</option>"
					+ "</select>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<label>Bild</label> <label>Datei hochladen</label> <input type='file' name='image'>"
					+ "<p class='help-block'>Nur .png und .jpg erlaubt</p>"
					+ "</div>"
					+ "<button class='btn-default' type='submit'>Produkt erstellen</button>"
					+ "</form>"
					+ "</div>";
		
		return createProductForm;
	}
}
