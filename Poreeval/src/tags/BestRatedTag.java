package tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TagSupport;

import data.Product;
import helper.ResultToTable;

public class BestRatedTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private List<Product> bestRatedProducts = new ArrayList<Product>();
	
	public int doStartTag() {
		try {
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
