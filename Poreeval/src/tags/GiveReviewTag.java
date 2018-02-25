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
		
		String createReviewForm = "<h1>Hier k�nnen Sie Reviews abgeben</h1>"
				+ "<form action='CreateReviewServlet' method='post'  style='text-align: center;'>"
				+ "<div class='form-group'>"
				+ "<label>W�hlen Sie ein Produkt</label>"
				+ "<select class='form-control'>"
				+ "<option value='prodA'>Produkt A</option>"
				+ "<option value='prodB'>Produkt B</option>"
				+ "<option value='prodC'>Produkt C</option>"
				+ "</select>"
				+ "</div>"
				+ "<div class='form-group'>"
				+ "<label>Beschreibung</label>"
				+ "<input type='text' class='form-control'	placeholder='Bewertungstext hinzuf�gen' name='note'>"
				+ "</div>"
				+ "<div class='chechbox'>"
				+ "<label><input type='radio' name='star' id='0s'>0 Sterne </label>"
				+ "<label><input type='radio' name='star' id='1s'>1 Stern  </label>"
				+ "<label><input type='radio' name='star' id='2s'>2 Sterne </label>"
				+ "<label><input type='radio' name='star' id='3s'>3 Sterne </label>"
				+ "<label><input type='radio' name='star' id='4s'>4 Sterne </label>"
				+ "<label><input type='radio' name='star' id='5s'>5 Sterne </label>"
				+ "</div>"
				+ "<button type='submit' class='btn-default'>Bewertung abgeben</button>"
				+ "</form>";
		
		return createReviewForm;
	}
}
