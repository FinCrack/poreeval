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
						+ "<label><input type='radio' name='rating'>0 <img src='http://dl1.cbsistatic.com/i/r/2017/03/01/a1782cc2-68f7-43c2-8e18-6f804cffac13/thumbnail/64x64/0054bcef793491da81b766ca7dc2f349/imgingest-4280020025168993376.png'></label>"
						+ "<label><input type='radio' name='rating'>1 <img src='http://dl1.cbsistatic.com/i/r/2017/03/01/a1782cc2-68f7-43c2-8e18-6f804cffac13/thumbnail/64x64/0054bcef793491da81b766ca7dc2f349/imgingest-4280020025168993376.png'></label>"
						+ "<label><input type='radio' name='rating'>2 <img src='http://dl1.cbsistatic.com/i/r/2017/03/01/a1782cc2-68f7-43c2-8e18-6f804cffac13/thumbnail/64x64/0054bcef793491da81b766ca7dc2f349/imgingest-4280020025168993376.png'></label>"
						+ "<label><input type='radio' name='rating'>3 <img src='http://dl1.cbsistatic.com/i/r/2017/03/01/a1782cc2-68f7-43c2-8e18-6f804cffac13/thumbnail/64x64/0054bcef793491da81b766ca7dc2f349/imgingest-4280020025168993376.png'></label>"
						+ "<label><input type='radio' name='rating'>4 <img src='http://dl1.cbsistatic.com/i/r/2017/03/01/a1782cc2-68f7-43c2-8e18-6f804cffac13/thumbnail/64x64/0054bcef793491da81b766ca7dc2f349/imgingest-4280020025168993376.png'></label>"
						+ "<label><input type='radio' name='rating'>5 <img src='http://dl1.cbsistatic.com/i/r/2017/03/01/a1782cc2-68f7-43c2-8e18-6f804cffac13/thumbnail/64x64/0054bcef793491da81b766ca7dc2f349/imgingest-4280020025168993376.png'></label>"
					+ "</div>"
						+ "<button class='btn-default' type='submit'>Produkt erstellen</button>"
						+ "</form>"
					+ "</div>";
		
		return createProductForm;
	}
}
