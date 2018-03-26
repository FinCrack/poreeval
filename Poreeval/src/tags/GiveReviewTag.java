package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author Lennard Brunke
 */
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
				"<h1>Hier koennen Sie Reviews abgeben</h1>"
				+ "<form action='CreateReviewServlet' method='post'  style='text-align: center;'>"
					+ "<div class='form-group'>"
						+ "<label>Ueberschrift</label>"
						+ "<input type='text' class='form-control' placeholder='Titel hinzufuegen' name='title'></textarea>"
					+ "</div>"
					+ "</div>"
					+ "<div class='form-group'>"
						+ "<label>Beschreibung</label>"
						+ "<textarea rows='10' type='text' class='form-control' placeholder='Bewertungstext hinzufuegen' name='text'></textarea>"
					+ "</div>"
					+ "<div class='checkbox'>"
						+ "<input type='radio' name='rating' value='0'><img src='resources/0 Sterne.png' style='max-height: 35px;'/><br>"
						+ "<input type='radio' name='rating' value='1'><img src='resources/1 Stern.png' style='max-height: 35px;'/><br>"
						+ "<input type='radio' name='rating' value='2'><img src='resources/2 Sterne.png' style='max-height: 35px;'/><br>"
						+ "<input type='radio' name='rating' value='3'><img src='resources/3 Sterne.png' style='max-height: 35px;'/><br>"
						+ "<input type='radio' name='rating' value='4'><img src='resources/4 Sterne.png' style='max-height: 35px;'/><br>"
						+ "<input type='radio' name='rating' value='5'><img src='resources/5 Sterne.png' style='max-height: 35px;'/>"
					+ "</div>"
						+ "<button type='submit' class='btn-default'>Bewertung abgeben</button>"
				+ "</form>";
		
		return createReviewForm;
	}
}
