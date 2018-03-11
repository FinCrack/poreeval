package tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TagSupport;

import data.Product;
import helper.ResultToTable;

public class RecentlyRatedTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> recentlyRatedProducts = new ArrayList<Product>();
	
	public int doStartTag() {
		String recentlyHeader = 
				"<h3>Zuletzt bewertete Produkte</h3>";
		try {
			pageContext.getOut().append(recentlyHeader);
			pageContext.getOut().append(this.getRecentlyRatedProduct());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	@SuppressWarnings("unchecked")
	private String getRecentlyRatedProduct() {
		HttpSession session = this.pageContext.getSession();
		recentlyRatedProducts = (List<Product>) session.getAttribute("recentlyRatedProducts");
		
		return ResultToTable.ToTable(recentlyRatedProducts);
	}
}
