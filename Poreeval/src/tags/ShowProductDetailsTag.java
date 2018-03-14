package tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import data.Product;
import helper.ResultToTable;

public class ShowProductDetailsTag extends TagSupport {

	private static final long serialVersionUID = 1L;
//	private List<Product> showProductDetails = new ArrayList<Product>();
//
//	@Override
//	public int doStartTag() throws JspException {
//		String detailHeader = 
//				"<h3 style='text-align: center;'>Produktdetails: </h3>";
//		try {
//			pageContext.getOut().append(detailHeader);
//			pageContext.getOut().append(this.showProductDetails());
//		} catch(Exception e){
//			e.printStackTrace();
//		}
//		return EVAL_BODY_INCLUDE;
//	}
//
//	@SuppressWarnings("unchecked")
//	private String showProductDetails() {
//		HttpSession session = this.pageContext.getSession();
//		showProductDetails = (List<Product>) session.getAttribute("showProductDetails");
//		return ResultToTable.ToTable(showProductDetails);
//	}
}
