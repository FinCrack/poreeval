package tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TagSupport;

import data.Product;
import helper.ResultToTable;

/*
 * @author Jannik Bukowski, 235502
 */

public class BestRatedTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private List<Product> bestRatedProducts = new ArrayList<Product>();
	
	public int doStartTag() {
		String bestHeader = 
				"<h3>Am besten bewertete Produkte</h3>";
		try {
			pageContext.getOut().append(bestHeader);
			pageContext.getOut().append(this.getBestRatedProduct());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  EVAL_BODY_INCLUDE;
	}
	
	@SuppressWarnings("unchecked")
	private String getBestRatedProduct() {
		HttpSession session = this.pageContext.getSession();
		bestRatedProducts = (List<Product>) session.getAttribute("bestRatedProducts");
		
		return ResultToTable.ToTable(bestRatedProducts);
	}
}
