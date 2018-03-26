package tags;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

import data.Product;

/**
 *@author Lennard Brunke
 */
public class EditProductTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	public int doStartTag() {
		try {
			this.pageContext.getOut().append(getEditProductForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	private String getEditProductForm() {
		Product product = (Product) this.pageContext.getSession().getAttribute("product");
		
		String editProductForm = 
					  "<div class='container'>"
							+ "<form action='EditProductServlet' method='post'>"
					+ "<div class='form-group'>"
							+ "<label>Produktname</label> "
							+ "<input type='text' class='form-control' placeholder='Namen hinzufuegen' name='name' value='" + product.getProductname() + "'> "
					+ "</div>"
					+ "<div class='form-group'>	"
							+ "<label>EAN-Code</label> "
							+ "<input type='number' class='form-control' placeholder='EAN eingeben' name='ean' value='" + product.getEan() + "'> "
					+ "</div>"
					+ "<div class='form-group'>"
					+ "</div>"
					+ "<div class='form-group'>"
                        + "<label>Bild</label> "
                        + "<label>Bitte eine gueltige URL zu jpg oder img angeben</label> "
                        + "<input type='text' name='picture' value='" + product.getPicture() + "'>"
                        + "<p class='help-block'>Nur .png und .jpg erlaubt</p>"
                    + "</div>"
						+ "<button class='btn-default' type='submit'>Produkt editieren</button>"
						+ "</form>"
					+ "</div>";
		
		return editProductForm;
	}
}
