package tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import data.Product;
import helper.ResultToTable;

/**
 * @author Jannik Bukowski, 235502
 */

public class AllProductsTag extends TagSupport {

	private static final long serialVersionUID = 1L;;
	private List<Product> products = new ArrayList<Product>();
	

	@Override
	public int doStartTag() throws JspException {
		
		try {
			this.pageContext.getOut().append(this.GetAllProducts());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
	@SuppressWarnings("unchecked")
	public String GetAllProducts() {
		HttpSession session = this.pageContext.getSession();
		products = (List<Product>) session.getAttribute("products");
		
		return ResultToTable.ProductsToTable(products);
	}
}
