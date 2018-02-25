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
		
		String createReviewForm = "<h1>Hier können Sie Reviews abgeben</h1>"
				+ "<form action='CreateReviewServlet' method='post'>"
				+ "<div class='form-group'>"
				+ "<label>Wählen Sie ein Produkt</label>"
				+ "<select class='form-control'>"
				+ "<option value='prodA'>Produkt A</option>"
				+ "<option value='prodB'>Produkt B</option>"
				+ "<option value='prodC'>Produkt C</option>"
				+ "</select>"
				+ "</div>"
				+ "<div class='form-group'>"
				+ "<label>Beschreibung</label>"
				+ "<input type='text' class='form-control'	placeholder='Bewertungstext hinzufügen' name='note'>"
				+ "</div>"
				+ "<div class='chechbox'>"
				+ "<label>0 Sterne <input type='radio' name='star' id='0s'></label>"
				+ "<label>1 Stern  <input type='radio' name='star' id='1s'></label>"
				+ "<label>2 Sterne <input type='radio' name='star' id='2s'></label>"
				+ "<label>3 Sterne <input type='radio' name='star' id='3s'></label>"
				+ "<label>4 Sterne <input type='radio' name='star' id='4s'></label>"
				+ "<label>5 Sterne <input type='radio' name='star' id='5s'></label>"
				+ "</div>"
				+ "<button type='submit' class='btn-default'>Bewertung abgeben</button>"
				+ "</form>";
		
		return createReviewForm;
	}
}
