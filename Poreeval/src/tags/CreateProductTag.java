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
							+ "<input type='text' class='form-control' placeholder='Namen hinzufügen' name='name'>"
					+ "</div>"
					+ "<div class='form-group'>	"
							+ "<label>EAN-Code</label> "
							+ "<input type='number' class='form-control' placeholder='EAN eingeben' name='ean'> "
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
						+ "<label><input type='image' name='rating' id='0' src='resources/0 Sterne.png' style='max-height: 35px;'></label><br>"
						+ "<label><input type='image' name='rating' id='1' src='resources/1 Stern.png' style='max-height: 35px;'></label><br>"
						+ "<label><input type='image' name='rating' id='2' src='resources/2 Sterne.png' style='max-height: 35px;'></label><br>"
						+ "<label><input type='image' name='rating' id='3' src='resources/3 Sterne.png' style='max-height: 35px;'></label><br>"
						+ "<label><input type='image' name='rating' id='4' src='resources/4 Sterne.png' style='max-height: 35px;'></label><br>"
						+ "<label><input type='image' name='rating' id='5' src='resources/5 Sterne.png' style='max-height: 35px;'></label>"
					+ "</div>"
						+ "<button class='btn-default' type='submit'>Produkt erstellen</button>"
						+ "</form>"
					+ "</div>";
		
		return createProductForm;
	}
}
