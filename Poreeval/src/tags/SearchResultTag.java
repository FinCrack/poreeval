package tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TagSupport;

import data.Product;
import helper.ResultToTable;

/** 
 * 
 * @author Lennard Brunke 259315
 * 
 * 
 */
public class SearchResultTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	private List<Product> searchResults = new ArrayList<Product>();
	
	public int doStartTag() {
		
	    if (this.pageContext.getSession().getAttribute("searchResults") == null) {
	        return EVAL_BODY_AGAIN;
	    }
	    String searchHeader =
				"<h3 style='text-align: center;'>Suchergebniss(e):</h3>";
		try {
			pageContext.getOut().append(searchHeader);
			pageContext.getOut().append(this.getSearchResult());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}


	@SuppressWarnings("unchecked")
	private String getSearchResult() {
		HttpSession session = this.pageContext.getSession();
		searchResults = (List<Product>) session.getAttribute("searchResults");
		
		return ResultToTable.ProductsToTable(searchResults);
	}
}
