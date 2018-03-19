package tags;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TagSupport;

import data.Product;
import helper.ResultToTable;

public class ShowProductDetailsTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;

	@Override
	public int doStartTag() {
		try {
			
			pageContext.getOut().append(this.getProductReviews());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  EVAL_BODY_INCLUDE;
	}
	
	
	private String getProductReviews() {
		HttpSession session = this.pageContext.getSession();
		this.product = (Product) session.getAttribute("product");

		String table = "<h3>Detailansicht: " + product.getProductname() + "</h3>";
		table += ResultToTable.ProductWithReviewsToTable(product);
		return table;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
