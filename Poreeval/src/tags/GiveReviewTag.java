package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class GiveReviewTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		try {
			pageContext.getOut().append(getCreateReviewForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String getCreateReviewForm() {
		
		String createReviewForm = 
				"<h1>Hier können Sie Reviews abgeben</h1>"
				+ "<form action='CreateReviewServlet' method='post'  style='text-align: center;'>"
					+ "<div class='form-group'>"
						+ "<label>Wählen Sie ein Produkt</label>"
							+ "<select class='form-control'>"
								+ "<option value='prodA'>Produkt A</option>"
								+ "<option value='prodB'>Produkt B</option>"
								+ "<option value='prodC'>Produkt C</option>"
							+ "</select>"
					+ "</div>"
					+ "<div class='form-group'>"
						+ "<label>Überschrift</label>"
						+ "<input type='text' class='form-control' placeholder='Titel hinzufügen' name='descriptionHeader'></textarea>"
					+ "</div>"
					+ "</div>"
					+ "<div class='form-group'>"
						+ "<label>Beschreibung</label>"
						+ "<textarea rows='10' type='text' class='form-control' placeholder='Bewertungstext hinzufügen' name='description'></textarea>"
					+ "</div>"
					+ "<div class='chechbox'>"
						+ "<input type='image' name='rating' id='0' src='resources/0 Sterne.png' style='max-height: 35px;'><br>"
						+ "<input type='image' name='rating' id='1' src='resources/1 Stern.png' style='max-height: 35px;'><br>"
						+ "<input type='image' name='rating' id='2' src='resources/2 Sterne.png' style='max-height: 35px;'><br>"
						+ "<input type='image' name='rating' id='3' src='resources/3 Sterne.png' style='max-height: 35px;'><br>"
						+ "<input type='image' name='rating' id='4' src='resources/4 Sterne.png' style='max-height: 35px;'><br>"
						+ "<input type='image' name='rating' id='5' src='resources/5 Sterne.png' style='max-height: 35px;'>"
					+ "</div>"
						+ "<button type='submit' class='btn-default'>Bewertung abgeben</button>"
				+ "</form>";
		
		return createReviewForm;
	}
}
